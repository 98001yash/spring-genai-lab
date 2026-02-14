package com.yash.genai.llm_prompt_engineering.service;



import com.yash.genai.llm_prompt_engineering.config.OllamaProperties;
import com.yash.genai.llm_prompt_engineering.model.OllamaRequest;
import com.yash.genai.llm_prompt_engineering.model.OllamaResponse;
import com.yash.genai.llm_prompt_engineering.prompt.PromptStrategy;
import com.yash.genai.llm_prompt_engineering.prompt.PromptStrategyResolver;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OllamaService {

    private final WebClient webClient;
    private final OllamaProperties properties;
    private final PromptStrategyResolver resolver;

    public OllamaService(
            WebClient webClient,
            OllamaProperties properties,
            PromptStrategyResolver resolver
    ) {
        this.webClient = webClient;
        this.properties = properties;
        this.resolver = resolver;
    }

    public String generate(String userInput, String mode) {

        PromptStrategy strategy = resolver.resolve(mode);
        String finalPrompt = strategy.buildPrompt(userInput);

        OllamaRequest request = new OllamaRequest(
                properties.getModel(),
                finalPrompt,
                false
        );

        try {
            OllamaResponse response = webClient.post()
                    .uri("/api/generate")
                    .bodyValue(request)
                    .retrieve()
                    .bodyToMono(OllamaResponse.class)
                    .block();

            return response != null
                    ? response.getResponse()
                    : "Empty response from LLM";

        } catch (Exception e) {
            return "LLM service unavailable. Check Ollama.";
        }
    }

}
