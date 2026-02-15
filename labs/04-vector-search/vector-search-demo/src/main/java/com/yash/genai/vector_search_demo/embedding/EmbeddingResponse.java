package com.yash.genai.vector_search_demo.embedding;

import java.util.List;

public class EmbeddingResponse {

    private List<Double> embedding;

    public List<Double> getEmbedding(){
        return embedding;
    }

    public void setEmbedding(List<Double> embedding){
        this.embedding = embedding;
    }
}
