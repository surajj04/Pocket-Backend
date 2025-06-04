package com.pocket.pocket.controller;

import com.pocket.pocket.model.AIChatRequest;
import com.pocket.pocket.model.UserDetail;
import com.pocket.pocket.service.UserService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {

    @Autowired
    private UserService userService;
    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @PostMapping("/chat-bot")
    public String chat(@RequestBody AIChatRequest request) {

        UserDetail userDetail = userService.getUserDetail(request.getToken());

        String message = "ROLE: Financial Assistant. Respond concisely based on user queries. If the query is finance-related, provide relevant financial tips. give the short response and response like that i can easily show on the screen and don't mention the conclusion. User details: " + userDetail +
                "USER QUERY: " + request.getUserMessage();

        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

}
