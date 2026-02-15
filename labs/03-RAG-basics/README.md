# Lab 03: RAG (Retrieval Augmented Generation) Basics

## Objective
Understand how to reduce LLM hallucinations by injecting
external knowledge into the prompt.

This lab demonstrates RAG from first principles,
without vector databases or frameworks.


## What this lab covers
- Manual retrieval of relevant documents
- Context injection into LLM prompts
- Comparing answers with and without RAG



## Core Idea
LLMs do not search or remember.
They only generate text based on input.

RAG works by retrieving relevant information
and providing it to the LLM as context.



## Architecture Flow
User Question → Retriever → Context → Prompt → LLM → Answer



## What this lab does NOT cover
- Vector databases
- Embeddings
- Semantic search
- Memory or chat history

Those topics are covered in later labs.


## Learning Outcome
After this lab, you will understand:
- Why hallucinations happen
- How RAG reduces hallucinations
- How GenAI systems ground answers in real data
