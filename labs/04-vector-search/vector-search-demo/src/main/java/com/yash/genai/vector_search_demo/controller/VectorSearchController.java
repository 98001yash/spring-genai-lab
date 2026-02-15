package com.yash.genai.vector_search_demo.controller;

import com.yash.genai.vector_search_demo.embedding.EmbeddingClient;
import com.yash.genai.vector_search_demo.vectordb.InMemoryVectorStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/search")
public class VectorSearchController {

    private final EmbeddingClient embeddingClient;
    private final InMemoryVectorStore vectorStore;

    public VectorSearchController(
            EmbeddingClient embeddingClient,
            InMemoryVectorStore vectorStore
    ) {
        this.embeddingClient = embeddingClient;
        this.vectorStore = vectorStore;
    }

    @PostMapping("/vector")
    public String vectorSearch(@RequestBody String query) {

        double[] queryVector = embeddingClient.embed(query);

        return vectorStore.search(queryVector, 2).stream()
                .map(e -> e.getContent())
                .collect(Collectors.joining("\n---\n"));
    }
}
