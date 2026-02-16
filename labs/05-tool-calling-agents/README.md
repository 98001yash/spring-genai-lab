# Lab 05: Tool Calling & Agents (MCP Basics)

## Objective
Understand how **LLMs can take actions**, not just generate text, by
introducing **tool calling** and **agent-style decision loops**.

This lab demonstrates how to design **controllable GenAI agents**
using Spring Boot — without external frameworks or cloud APIs.

---

## Why this lab exists

Up to Lab 04, the LLM could:
- answer questions
- reason over context
- retrieve knowledge using RAG

But it could **not**:
- call backend logic
- fetch real system data
- trigger application behavior

This leads to hallucinations like:
> “The status of your order is shipped”

Lab 05 solves this by teaching the LLM **when to call tools** instead
of guessing.

---

## Core Idea (Demystified)

Tool calling means:

> The LLM decides **what action is needed**  
> The backend executes **real code**  
> The LLM explains the result

The model never runs code.
It only returns **structured intent**.

## Agent Mental Model


User Query
↓
LLM (with tool descriptions)
↓
Decision:

answer directly

OR call a tool
↓
Backend executes tool
↓
Tool result returned to LLM
↓
Final answer to user


This is the foundation of **agents**.

---

## Demo Application Overview

### Demo Name
**GenAI Task Assistant**

### What the assistant can do
- List all labs in the project
- Get details of a specific lab
- Answer questions by calling backend tools
- Avoid hallucinating when data is unavailable

---

## Tools Implemented in This Lab

### Tool 1: `listLabs`
Returns all available labs.

Example output:
```json
["Lab 01", "Lab 02", "Lab 03", "Lab 04"]

Tool 2: getLabDetails

Fetches details for a specific lab.

Input:

{ "labNumber": 3 }


Output:

{
  "title": "RAG Basics",
  "focus": "Reducing hallucinations using retrieval"
}

What This Lab Covers

 Tool-aware prompting
 Structured JSON outputs from LLMs
 Backend tool execution
 Agent-style decision loop
 Preventing action hallucinations

What This Lab Does NOT Cover

 LangChain / AutoGen
 OpenAI function calling
Multi-agent planners
 External APIs

Those abstractions are intentionally avoided to
focus on first principles.

Architecture Overview
User
 ↓
Controller
 ↓
LLM (tool-aware prompt)
 ↓
Tool Decision (JSON)
 ↓
Backend Tool Execution
 ↓
LLM Final Response

Tech Stack

Java 21
Spring Boot
Ollama (local LLM)
JSON-based tool contracts
Everything runs locally.

Learning Outcome
After this lab, you will understand:
How GenAI agents really work
Why tool calling is safer than free text
How to design controllable AI systems
Why most “agent frameworks” are just abstractions over this pattern

Status

🚧 In Progress — Tool Calling & Agent Basics

### Why this README is strong
- Explains agents **without hype**
- Matches your lab-by-lab progression
- Recruiter-readable, engineer-approved
- Sets expectations clearly

---

When you’re ready, say:
👉 **“lab 05 setup done, start step 1”**

Next step we’ll:
- deliberately show **hallucination without tools**
- then fix it using tool calling

You’re now building **action-capable GenAI systems** 👊
