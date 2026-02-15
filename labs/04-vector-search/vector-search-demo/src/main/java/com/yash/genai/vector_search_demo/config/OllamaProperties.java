package com.yash.genai.vector_search_demo.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="ollama")
public class OllamaProperties {

    private String baseUrl;
    private String model;

    public  String getBaseUrl(){
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl){
        this.baseUrl = baseUrl;
    }
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model = model;
    }

}
