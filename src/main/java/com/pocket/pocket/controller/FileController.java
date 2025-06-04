package com.pocket.pocket.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pocket.pocket.model.FinanceReport;
import com.pocket.pocket.model.Transaction;
import com.pocket.pocket.service.FileService;
import com.pocket.pocket.service.OpenAiService;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
public class FileController {

    @Autowired
    private FileService fileService;
    @Autowired
    private OpenAiService openAiService;

    @PostMapping("/extract")
    public String extractText(@RequestParam("file") MultipartFile file) {
        try {
            PDDocument document = Loader.loadPDF(file.getInputStream().readAllBytes());
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String pdfTxt = pdfTextStripper.getText(document);
            document.close();
            return openAiService.statementAnalysis(pdfTxt);
        } catch (Exception e) {

            System.err.println("Error processing PDF: " + e.getMessage());
            return null;
        }
    }

}
