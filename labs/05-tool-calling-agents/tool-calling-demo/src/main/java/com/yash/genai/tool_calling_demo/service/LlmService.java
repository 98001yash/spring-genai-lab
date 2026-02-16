package com.yash.genai.tool_calling_demo.service;


import com.yash.genai.tool_calling_demo.model.OllamaRequest;
import com.yash.genai.tool_calling_demo.model.OllamaResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class LlmService {

    private final WebClient webClient;

    public LlmService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String ask(String prompt){

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

        return response != null ? response.getResponse() : "no response from LLM";
    }
}
