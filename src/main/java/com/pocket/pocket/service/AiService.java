package com.pocket.pocket.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pocket.pocket.model.Expense;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class AiService {

    private final ChatClient chatClient;
    @Autowired
    private UserService userService;

    public AiService(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    public String dataProcess(String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

    public Expense parseChatGptResponse(String jsonResponse, String senderNumber) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

            Expense expense = mapper.readValue(jsonResponse, Expense.class);
            expense.setUserId(userService.getUserIdByPhoneNo(senderNumber));
            return expense;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse ChatGPT response");
        }
    }
}
