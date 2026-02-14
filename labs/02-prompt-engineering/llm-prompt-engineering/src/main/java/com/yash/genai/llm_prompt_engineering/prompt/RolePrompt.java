package com.yash.genai.llm_prompt_engineering.prompt;


import org.springframework.stereotype.Component;

@Component("role")
public class RolePrompt implements PromptStrategy{


    @Override
    public String buildPrompt(String userInput) {
        return """
               You are an experienced Java instructor.
               Explain the following topic in simple terms for a beginner.

               Topic:
               %s
               """.formatted(userInput);
    }
}
