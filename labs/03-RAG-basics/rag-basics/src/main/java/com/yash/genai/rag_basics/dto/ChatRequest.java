package com.yash.genai.rag_basics.dto;

public class ChatRequest {

    private String prompt;

    public ChatRequest(){};

    public String getPrompt(){
        return prompt;}

    public void setPrompt(String prompt){
        this.prompt = prompt;
    }
}
