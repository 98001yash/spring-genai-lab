package com.yash.genai.rag_basics.controller;


import com.yash.genai.rag_basics.dto.ChatRequest;
import com.yash.genai.rag_basics.dto.ChatResponse;
import com.yash.genai.rag_basics.service.DocumentRetriever;
import com.yash.genai.rag_basics.service.OllamaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final OllamaService ollamaService;
    private final DocumentRetriever documentRetriever;

    public ChatController(OllamaService ollamaService, DocumentRetriever documentRetriever){
        this.ollamaService = ollamaService;
        this.documentRetriever = documentRetriever;

    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        return new ChatResponse(ollamaService.ask(request.getPrompt()));
    }

    @PostMapping("/rag")
    public ChatResponse chatWithRag(@RequestBody ChatRequest request) {

        var docs = documentRetriever.retrieve(request.getPrompt());
        String response = ollamaService.askWithContext(request.getPrompt(), docs);

        return new ChatResponse(response);
    }

}
