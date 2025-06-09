package com.pocket.pocket.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pocket.pocket.model.FinanceReport;
import com.pocket.pocket.model.Transaction;
import com.pocket.pocket.service.FileService;
import com.pocket.pocket.service.OpenAiService;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


@RestController
public class FileController {

    @Autowired
    private FileService fileService;
    @Autowired
    private OpenAiService openAiService;

    @PostMapping("/extract")
    public ResponseEntity<?> extractText(@RequestParam("file") MultipartFile file) {
        try {
            PDDocument document = Loader.loadPDF(file.getInputStream().readAllBytes());
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String pdfTxt = pdfTextStripper.getText(document);
            document.close();
            Object result = openAiService.statementAnalysis(file);
//            System.out.println(result);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            System.err.println("Error processing PDF: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Failed to extract text from PDF"));
        }
    }

}
