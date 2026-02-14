package com.yash.genai.llm_basics.model;

public class OllamaRequest {

    private String model;
    private String prompt;
    private boolean stream;

    public OllamaRequest(String model, String prompt, boolean stream) {
        this.model = model;
        this.prompt = prompt;
        this.stream = stream;
    }

    public String getModel() {
        return model;
    }

    public String getPrompt() {
        return prompt;
    }

    public boolean isStream() {
        return stream;
    }
}