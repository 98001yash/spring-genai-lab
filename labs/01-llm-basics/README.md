
# Lab 01: LLM Basics with Spring Boot

## Objective
Understand how a Spring Boot application communicates with
a locally running Large Language Model (LLM).

## Architecture Flow
Client → Spring Boot → Ollama → CodeLlama

## What this lab demonstrates
- No LLM SDK or dependency required
- LLM accessed via HTTP API
- Clean separation of controller, service, and model layers

## Tech Stack
- Java 21
- Spring Boot 3.x
- Ollama
- CodeLlama

## API Endpoint

POST /api/chat

Request:
```json
{
  "prompt": "Explain JVM in simple words"
}
