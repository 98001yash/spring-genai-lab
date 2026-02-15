package com.yash.genai.llm_prompt_engineering.prompt;


import org.springframework.stereotype.Component;

@Component("cot")
public class ChainOfThoughtPrompt implements PromptStrategy{



    @Override
    public String buildPrompt(String userInput) {
        return """
               You are a knowledgeable software engineer.

               Think step by step before answering.
               Explain your reasoning clearly, then provide the final answer.

               Question:
               %s
               """.formatted(userInput);
    }
}
