package com.yash.genai.vector_search_demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {


    @Bean
    public WebClient webClient(OllamaProperties props){
        return WebClient.builder()
                .baseUrl(props.getBaseUrl())
                .build();
    }
}
