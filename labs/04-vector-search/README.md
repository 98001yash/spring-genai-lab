# Lab 04: Vector Search & Embeddings (Semantic RAG)

## Objective
Understand **why vector databases exist** and how **semantic search using embeddings**
is superior to keyword-based retrieval in GenAI systems.

This lab builds a **demo knowledge assistant** to clearly demonstrate the difference
between keyword search and vector search when used with RAG.

---

## Why this lab exists

In Lab 03, we implemented RAG using **keyword-based retrieval**.
While effective for simple cases, keyword search fails when:

- The user uses different words with the same meaning
- The question is indirect
- Synonyms or paraphrasing are involved

Example:

**Document text**

This project is built using Spring Boot and Ollama.


**User question**


What backend framework does this project use?


Keyword search ❌  
Vector search ✅

This lab solves that problem.

---

## Core Concepts Covered

- Text embeddings
- Semantic similarity
- Cosine similarity
- In-memory vector store
- Vector-based retrieval
- RAG with vector search

No cloud services.  
No paid APIs.  
Everything runs **locally**.

---

## Demo Application Overview

This lab builds a **Mini Knowledge Assistant** for the GenAI Labs project.

### What the demo can do
- Ingest project-related documents
- Convert documents into embeddings
- Store embeddings in an in-memory vector database
- Convert user queries into embeddings
- Retrieve semantically similar documents
- Use retrieved context in RAG prompts

---

## Architecture Flow



User Question
↓
Embedding Generator
↓
Vector Store (In-Memory)
↓
Top-K Similar Documents
↓
Context Builder
↓
LLM (Ollama)
↓
Grounded Answer


---

## Comparison: Keyword vs Vector Search

| Query | Keyword Search | Vector Search |
|------|----------------|---------------|
| "What backend is used?" | ❌ | ✅ |
| "How are labs structured?" | ❌ | ✅ |
| "How is hallucination reduced?" | ❌ | ✅ |

This contrast is the **key learning outcome** of this lab.

---

## What This Lab Covers

✅ Embedding generation using local models  
✅ Cosine similarity calculation  
✅ In-memory vector database  
✅ Semantic document retrieval  
✅ Vector-based RAG pipeline

---

## What This Lab Does NOT Cover

❌ Cloud vector databases (Pinecone, Weaviate, Milvus)  
❌ Spring AI abstractions  
❌ Distributed or persistent vector stores

Those topics are intentionally deferred to later labs.


## Tech Stack

- Java 21
- Spring Boot
- Ollama (local)
- Embedding model (e.g. `nomic-embed-text`)
- In-memory data structures



## Learning Outcome

After completing this lab, you will clearly understand:

- Why embeddings work
- Why semantic search outperforms keyword search
- How vector databases power modern RAG systems
- How to design explainable GenAI retrieval pipelines


## Next Labs

- **Lab 05**: Tool Calling & MCP (Agents)
- **Lab 06**: Production RAG Patterns
- **Lab 07**: Spring AI Integration

