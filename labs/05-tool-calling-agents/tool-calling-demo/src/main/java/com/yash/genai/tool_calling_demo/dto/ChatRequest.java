package com.yash.genai.tool_calling_demo.dto;

public class ChatRequest {

    private String prompt;

    public ChatRequest(){};

    public String getPrompt(){
        return prompt;}

    public void setPrompt(String prompt){
        this.prompt = prompt;
    }
}
