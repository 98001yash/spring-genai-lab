package com.yash.genai.llm_basics.service;


import com.yash.genai.llm_basics.dtos.ChatRequest;
import com.yash.genai.llm_basics.dtos.ChatResponse;
import com.yash.genai.llm_basics.model.OllamaRequest;
import com.yash.genai.llm_basics.model.OllamaResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OllamaService {

    private final WebClient webClient;

    public OllamaService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String generate(String prompt) {

        OllamaRequest request = new OllamaRequest(
                "codellama",
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
                : "No response from LLM";
    }
}
