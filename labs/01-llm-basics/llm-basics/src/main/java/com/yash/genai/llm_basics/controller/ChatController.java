package com.yash.genai.llm_basics.controller;


import com.yash.genai.llm_basics.dtos.ChatRequest;
import com.yash.genai.llm_basics.dtos.ChatResponse;
import com.yash.genai.llm_basics.service.OllamaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final OllamaService ollamaService;

    public ChatController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String response = ollamaService.generate(request.getPrompt());
        return new ChatResponse(response);
    }
}