package com.pocket.pocket.model;

public class AIChatRequest {
    private String userMessage;
    private String token;

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AIChatRequest{" +
                "userMessage='" + userMessage + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
