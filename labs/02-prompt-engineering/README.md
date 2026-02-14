# Lab 02: Prompt Engineering

## Objective
Understand how to **control the behavior of a Large Language Model (LLM)**
by changing how prompts are structured — without changing the model or code logic.

This lab focuses purely on **prompt design**, not infrastructure.

---

## What this lab is about
In Lab 01, we learned how to connect a Spring Boot application to a local LLM
using Ollama.

In this lab, we build on top of that and explore:
- Why the same LLM gives different answers
- How prompt structure affects output
- How to make LLM responses more predictable and controlled

---

## Core Idea
The LLM remains the same.
The model remains the same.
Only the **prompt structure changes**.


User Question → Prompt Strategy → LLM → Response


---

## Prompt Strategies Covered

This lab demonstrates the following prompt engineering techniques:

1. **Simple Prompt**
    - Direct question
    - Baseline behavior

2. **Role-Based Prompt**
    - Assign a role to the LLM
    - Controls tone and depth

3. **Constraint-Based Prompt**
    - Adds formatting and length rules
    - Useful for API responses

4. **Few-Shot Prompt**
    - Uses examples to guide output
    - Very powerful without training

5. **Chain-of-Thought Prompt**
    - Encourages step-by-step reasoning
    - Helps with complex explanations

---

## How This Lab Will Be Implemented
- Same Spring Boot setup as Lab 01
- Same `/api/chat` endpoint
- Prompt strategy selected using a query parameter

Example:


POST /api/chat?mode=role
POST /api/chat?mode=few-shot


Each mode applies a different prompt strategy internally.

---

## What This Lab Does NOT Cover
- Vector databases
- RAG (Retrieval Augmented Generation)
- Memory or chat history
- Streaming responses

Those topics are covered in later labs.

---

## Learning Outcome
After completing this lab, you will be able to:
- Control LLM output using prompt design
- Explain why prompt engineering is critical for GenAI systems
- Prepare for advanced topics like RAG and agents

---

## Pre-requisites
- Lab 01 completed
- Ollama running locally
- CodeLlama model available
