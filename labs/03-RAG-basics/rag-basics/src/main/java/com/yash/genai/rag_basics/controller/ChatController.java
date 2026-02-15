package com.yash.genai.rag_basics.controller;


import com.yash.genai.rag_basics.dto.ChatRequest;
import com.yash.genai.rag_basics.dto.ChatResponse;
import com.yash.genai.rag_basics.service.OllamaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final OllamaService ollamaService;

    public ChatController(OllamaService ollamaService){
        this.ollamaService = ollamaService;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        return new ChatResponse(ollamaService.ask(request.getPrompt()));
    }
}
