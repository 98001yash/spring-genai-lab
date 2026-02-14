package com.yash.genai.llm_basics.service;


import com.yash.genai.llm_basics.config.OllamaProperties;
import com.yash.genai.llm_basics.model.OllamaRequest;
import com.yash.genai.llm_basics.model.OllamaResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OllamaService {

    private final WebClient webClient;
    private final OllamaProperties properties;

    public OllamaService(WebClient webClient, OllamaProperties properties) {
        this.webClient = webClient;
        this.properties = properties;
    }

    public String generate(String prompt) {
        try {
            OllamaRequest request = new OllamaRequest(
                    properties.getModel(),
                    prompt,
                    false
            );

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
            return "LLM service unavailable. Please check Ollama.";
        }
    }

}
