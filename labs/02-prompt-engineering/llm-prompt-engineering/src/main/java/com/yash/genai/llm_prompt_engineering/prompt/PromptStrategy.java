package com.yash.genai.llm_prompt_engineering.prompt;

public interface PromptStrategy {

    String buildPrompt(String userInput);
}
