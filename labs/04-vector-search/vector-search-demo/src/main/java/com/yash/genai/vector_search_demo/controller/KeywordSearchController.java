package com.yash.genai.vector_search_demo.controller;

import com.yash.genai.vector_search_demo.dto.ChatRequest;
import com.yash.genai.vector_search_demo.dto.ChatResponse;
import com.yash.genai.vector_search_demo.service.KeywordRagService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class KeywordSearchController {

    private final KeywordRagService service;

    public KeywordSearchController(KeywordRagService service) {
        this.service = service;
    }

    @PostMapping("/keyword")
    public ChatResponse keywordSearch(@RequestBody ChatRequest request) {

        List<String> docs = service.retrieveContext(request.getPrompt());
        if (docs.isEmpty()) {
            return new ChatResponse("No documents matched using keyword search.");
        }
        return new ChatResponse(String.join("\n---\n", docs));
    }

}
