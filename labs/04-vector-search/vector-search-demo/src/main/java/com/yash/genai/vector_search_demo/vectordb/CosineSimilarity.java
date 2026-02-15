package com.yash.genai.vector_search_demo.vectordb;

public class CosineSimilarity {

    public static double calculate(double[] v1, double[] v2) {

        double dot = 0.0;
        double norm1 = 0.0;
        double norm2 = 0.0;

        for (int i = 0; i < v1.length; i++) {
            dot += v1[i] * v2[i];
            norm1 += v1[i] * v1[i];
            norm2 += v2[i] * v2[i];
        }

        return dot / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }
}
