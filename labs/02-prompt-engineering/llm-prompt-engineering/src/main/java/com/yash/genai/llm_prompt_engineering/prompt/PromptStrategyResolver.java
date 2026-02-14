package com.yash.genai.llm_prompt_engineering.prompt;


import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PromptStrategyResolver {

    private final Map<String, PromptStrategy> strategies;

    public PromptStrategyResolver(Map<String, PromptStrategy> strategies) {
        this.strategies = strategies;
    }

    public PromptStrategy resolve(String mode) {
        return strategies.getOrDefault(mode, strategies.get("simple"));
    }
}
