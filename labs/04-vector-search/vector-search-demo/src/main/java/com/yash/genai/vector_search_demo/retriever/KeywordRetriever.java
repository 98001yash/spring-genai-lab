package com.yash.genai.vector_search_demo.retriever;


import com.yash.genai.vector_search_demo.document.DocumentStore;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KeywordRetriever {

    private final DocumentStore documentStore;

    public KeywordRetriever(DocumentStore documentStore) {
        this.documentStore = documentStore;
    }

    public List<String> retrieve(String query){
        String lowerQuery = query.toLowerCase();

        return documentStore.documents().stream()
                .filter(doc->doc.toLowerCase().contains(lowerQuery))
                .toList();
    }
}
