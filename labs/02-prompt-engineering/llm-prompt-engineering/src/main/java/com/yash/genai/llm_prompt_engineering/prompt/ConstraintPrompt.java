package com.yash.genai.llm_prompt_engineering.prompt;


import org.springframework.stereotype.Component;

@Component("constraint")
public class ConstraintPrompt implements PromptStrategy {

    @Override
    public String buildPrompt(String userInput) {
        return """
               SYSTEM INSTRUCTIONS (MANDATORY):
               You MUST follow ALL rules below.
               If you break any rule, the answer is invalid.

               RULES:
               1. Output EXACTLY 5 bullet points
               2. Each bullet point MUST be under 12 words
               3. Use '-' for bullet points
               4. NO introduction text
               5. NO conclusion text
               6. ONLY bullet points in output

               TOPIC:
               %s
               """.formatted(userInput);
    }
}
