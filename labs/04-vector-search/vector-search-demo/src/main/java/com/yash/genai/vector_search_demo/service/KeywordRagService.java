package com.yash.genai.vector_search_demo.service;


import com.yash.genai.vector_search_demo.retriever.KeywordRetriever;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordRagService {

    private final KeywordRetriever retriever;

    public KeywordRagService(KeywordRetriever retriever) {
        this.retriever = retriever;
    }

    public List<String> retrieveContext(String question) {
        return retriever.retrieve(question);
    }
}
