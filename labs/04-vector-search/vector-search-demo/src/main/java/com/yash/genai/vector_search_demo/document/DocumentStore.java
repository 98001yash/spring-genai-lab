package com.yash.genai.vector_search_demo.document;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentStore {

    public List<String> documents() {
        return List.of(
                """
                Spring GenAI Lab is a hands-on learning project.
                It demonstrates LLM integration, prompt engineering,
                and retrieval augmented generation using Spring Boot.
                """,

                """
                The project is organized into multiple labs.
                Lab 01 covers LLM basics.
                Lab 02 focuses on prompt engineering.
                Lab 03 introduces RAG concepts.
                Lab 04 explores vector search and embeddings.
                """,

                """
                All labs use local LLMs via Ollama.
                No external APIs or cloud services are required.
                The system is designed for backend engineers.
                """
        );
    }
}
