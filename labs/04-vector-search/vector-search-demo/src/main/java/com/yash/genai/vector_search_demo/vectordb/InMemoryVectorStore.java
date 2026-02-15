package com.yash.genai.vector_search_demo.vectordb;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class InMemoryVectorStore {

    private final List<VectorEntry> store = new ArrayList<>();

    public void add(VectorEntry entry) {
        store.add(entry);
    }

    public List<VectorEntry> search(double[] queryVector, int topK) {

        return store.stream()
                .sorted(Comparator.comparingDouble(
                        e -> -CosineSimilarity.calculate(queryVector, e.getEmbedding())
                ))
                .limit(topK)
                .toList();
    }
}
