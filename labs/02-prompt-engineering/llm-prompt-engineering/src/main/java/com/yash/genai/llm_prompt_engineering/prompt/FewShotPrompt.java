package com.yash.genai.llm_prompt_engineering.prompt;


import org.springframework.stereotype.Component;

@Component("few-shot")
public class FewShotPrompt implements PromptStrategy{


    @Override
    public String buildPrompt(String userInput) {
        return """
               You are a concise technical assistant.

               Example:
               Q: What is JVM?
               A:
               - Executes Java bytecode
               - Enables platform independence
               - Manages application memory
               - Handles garbage collection
               - Provides runtime environment

               Now answer in the SAME FORMAT.

               Q: %s
               A:
               """.formatted(userInput);
    }
}
