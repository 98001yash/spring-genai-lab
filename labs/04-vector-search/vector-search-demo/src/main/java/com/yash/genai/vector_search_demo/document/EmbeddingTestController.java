package com.yash.genai.vector_search_demo.document;

import com.yash.genai.vector_search_demo.embedding.EmbeddingClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/embed")
public class EmbeddingTestController {

    private final EmbeddingClient client;

    public EmbeddingTestController(EmbeddingClient client) {
        this.client = client;
    }

    @PostMapping
    public int embed(@RequestBody String text) {
        return client.embed(text).length;
    }
}
