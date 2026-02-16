package com.yash.genai.tool_calling_demo.dto;

public class ChatResponse {

    private String response;

    public ChatResponse(String response){
        this.response = response;
    }

    public String getResponse(){
        return response;
    }
}
