package com.yash.genai.llm_basics.dtos;

public class ChatRequest {

    private String prompt;

    private String getPrompt(){
        return prompt;
    }

    public void setPrompt(String prompt){
        this.prompt = prompt;
    }
}
