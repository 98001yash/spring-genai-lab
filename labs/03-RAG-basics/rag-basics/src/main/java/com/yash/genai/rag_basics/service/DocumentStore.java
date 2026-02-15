package com.yash.genai.rag_basics.service;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentStore {

    public List<String> getDocuments() {
        return List.of(
                """
                Project Name: Spring GenAI Lab

                This project demonstrates how to build Generative AI systems
                using Spring Boot and locally running LLMs via Ollama.

                It is organized as multiple labs:
                Lab 01: LLM Basics
                Lab 02: Prompt Engineering
                Lab 03: RAG Basics

                Each lab is independent and focuses on one core GenAI concept.
                """,

                """
                Lab 03 focuses on Retrieval Augmented Generation (RAG).

                RAG works by retrieving relevant information
                and injecting it into the LLM prompt as context,
                reducing hallucinations and improving factual accuracy.
                """
        );
    }
}
