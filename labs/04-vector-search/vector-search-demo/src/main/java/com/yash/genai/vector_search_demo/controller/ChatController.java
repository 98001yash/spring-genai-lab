package com.yash.genai.vector_search_demo.controller;

import com.yash.genai.vector_search_demo.dto.ChatRequest;
import com.yash.genai.vector_search_demo.dto.ChatResponse;
import com.yash.genai.vector_search_demo.service.VectorRagService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final VectorRagService vectorRagService;

    public ChatController(VectorRagService vectorRagService) {
        this.vectorRagService = vectorRagService;
    }

    @PostMapping("/vector-rag")
    public ChatResponse vectorRag(@RequestBody ChatRequest request) {
        String answer =
                vectorRagService.askWithVectorRag(request.getPrompt());
        return new ChatResponse(answer);
    }
}
