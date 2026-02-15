package com.yash.genai.vector_search_demo.embedding;

public class EmbeddingRequest {

    private String model;
    private String prompt;

    public EmbeddingRequest(String model, String prompt){
        this.model  =model;
        this.prompt = prompt;
    }

    public String getModel(){
        return model;
    }
    public String getPrompt(){
        return prompt;
    }
}
