package com.yash.genai.vector_search_demo.embedding;


import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class EmbeddingClient {

    private final WebClient webClient;

    public EmbeddingClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public double[] embed(String text) {

        EmbeddingRequest request =
                new EmbeddingRequest("nomic-embed-text", text);

        EmbeddingResponse response = webClient.post()
                .uri("/api/embeddings")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(EmbeddingResponse.class)
                .block();

        if (response == null || response.getEmbedding() == null) {
            throw new IllegalStateException("Failed to generate embedding");
        }

        return response.getEmbedding()
                .stream()
                .mapToDouble(Double::doubleValue)
                .toArray();
    }
}
