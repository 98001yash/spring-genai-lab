package com.yash.genai.rag_basics.service;


import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DocumentRetriever {

    private final DocumentStore documentStore;

    public DocumentRetriever(DocumentStore documentStore){
        this.documentStore = documentStore;
    }

    public List<String> retrieve(String query) {

        var keywords = query.toLowerCase().split("\\s+");

        return documentStore.getDocuments().stream()
                .filter(doc -> {
                    String lowerDoc = doc.toLowerCase();
                    for (String keyword : keywords) {
                        if (lowerDoc.contains(keyword)) {
                            return true;
                        }
                    }
                    return false;
                })
                .toList();
    }
}
