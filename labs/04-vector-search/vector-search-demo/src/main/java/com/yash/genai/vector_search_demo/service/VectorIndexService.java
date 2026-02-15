package com.yash.genai.vector_search_demo.service;


import com.yash.genai.vector_search_demo.document.DocumentStore;
import com.yash.genai.vector_search_demo.embedding.EmbeddingClient;
import com.yash.genai.vector_search_demo.vectordb.InMemoryVectorStore;
import com.yash.genai.vector_search_demo.vectordb.VectorEntry;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class VectorIndexService {

    private final DocumentStore store;
    private final EmbeddingClient embeddingClient;
    private final InMemoryVectorStore vectorStore;

    public VectorIndexService(
            DocumentStore store,
            EmbeddingClient embeddingClient,
            InMemoryVectorStore vectorStore
    ) {
        this.store = store;
        this.embeddingClient = embeddingClient;
        this.vectorStore = vectorStore;
    }

    @PostConstruct
    public void indexDocuments(){

        for (String doc : store.documents()) {
            double[] embedding = embeddingClient.embed(doc);
            vectorStore.add(new VectorEntry(doc, embedding));
        }
        System.out.println("Documents indexed into vector store");
    }

}
