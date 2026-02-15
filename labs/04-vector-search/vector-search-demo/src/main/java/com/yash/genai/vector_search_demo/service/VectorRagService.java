package com.yash.genai.vector_search_demo.service;


import com.yash.genai.vector_search_demo.embedding.EmbeddingClient;
import com.yash.genai.vector_search_demo.vectordb.InMemoryVectorStore;
import com.yash.genai.vector_search_demo.vectordb.VectorEntry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VectorRagService {

    private static final int TOP_K = 2;
    private static final int MAX_CONTEXT_CHARS = 1500;


    private final EmbeddingClient embeddingClient;
    private final InMemoryVectorStore vectorStore;
    private final OllamaService ollamaService;

    public VectorRagService(
            EmbeddingClient embeddingClient,
            InMemoryVectorStore vectorStore,
            OllamaService ollamaService
    ) {
        this.embeddingClient = embeddingClient;
        this.vectorStore = vectorStore;
        this.ollamaService = ollamaService;
    }

    public String askWithVectorRag(String question) {

        double[] queryVector = embeddingClient.embed(question);

        List<VectorEntry> topDocs =
                vectorStore.search(queryVector, TOP_K);

        if (topDocs.isEmpty()) {
            return "I don't know";
        }

        String context = topDocs.stream()
                .map(VectorEntry::getContent)
                .reduce((a, b) -> a + "\n\n" + b)
                .orElse("");

        if (context.length() > MAX_CONTEXT_CHARS) {
            context = context.substring(0, MAX_CONTEXT_CHARS);
        }

        String prompt = """
                SYSTEM:
                You MUST answer only using the provided context.
                If the answer is not present, say "I don't know".

                Context:
                %s

                Question:
                %s
                """.formatted(context, question);

        return ollamaService.ask(prompt);
    }

}
