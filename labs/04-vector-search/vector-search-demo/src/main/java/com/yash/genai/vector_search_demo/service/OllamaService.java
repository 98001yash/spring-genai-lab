package com.yash.genai.vector_search_demo.service;

import com.yash.genai.vector_search_demo.model.OllamaRequest;
import com.yash.genai.vector_search_demo.model.OllamaResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OllamaService {

    private final WebClient webClient;

    public OllamaService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String ask(String prompt) {

        OllamaRequest request = new OllamaRequest(
                "codellama",
                prompt,
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
                    : "No response from LLM";

        } catch (Exception e) {
            return "LLM service unavailable";
        }
    }
}
