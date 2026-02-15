package com.yash.genai.rag_basics.service;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DocumentRetriever {

    private final DocumentStore documentStore;

    public DocumentRetriever(DocumentStore documentStore){
        this.documentStore = documentStore;
    }

    public List<String>  retrieve(String query){
        return documentStore.getDocuments().stream()
                .filter(doc->
                        doc.toLowerCase().contains(query.toLowerCase())
                )
                .collect(Collectors.toList());
    }
}
