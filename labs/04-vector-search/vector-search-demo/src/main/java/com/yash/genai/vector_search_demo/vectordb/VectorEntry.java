package com.yash.genai.vector_search_demo.vectordb;

public class VectorEntry {

    private final String content;
    private final double[] embedding;

    public VectorEntry(String content, double[] embedding) {
        this.content = content;
        this.embedding = embedding;
    }

    public String getContent() {
        return content;
    }

    public double[] getEmbedding() {
        return embedding;
    }
}
