package com.yash.genai.llm_prompt_engineering.prompt;


import org.springframework.stereotype.Component;

@Component("simple")
public class SimplePrompt implements PromptStrategy{


    @Override
    public String buildPrompt(String userInput) {
        return userInput;
    }
}
