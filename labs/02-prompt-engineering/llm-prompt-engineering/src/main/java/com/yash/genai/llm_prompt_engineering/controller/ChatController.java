package com.yash.genai.llm_prompt_engineering.controller;


import com.yash.genai.llm_prompt_engineering.dtos.ChatRequest;
import com.yash.genai.llm_prompt_engineering.dtos.ChatResponse;
import com.yash.genai.llm_prompt_engineering.service.OllamaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final OllamaService ollamaService;

    public ChatController(OllamaService ollamaService){
        this.ollamaService = ollamaService;
    }

    @PostMapping
    public ChatResponse chat(
            @RequestParam(defaultValue = "simple") String mode,
            @RequestBody ChatRequest request
    ) {
        String response = ollamaService.generate(request.getPrompt(), mode);
        return new ChatResponse(response);
    }
}
