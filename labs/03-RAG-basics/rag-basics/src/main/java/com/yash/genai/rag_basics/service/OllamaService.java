package com.yash.genai.rag_basics.service;


import com.yash.genai.rag_basics.config.OllamaProperties;
import com.yash.genai.rag_basics.model.OllamaRequest;
import com.yash.genai.rag_basics.model.OllamaResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class OllamaService {


    private final WebClient webClient;
    private final OllamaProperties properties;

    public OllamaService(WebClient webClient, OllamaProperties properties) {
        this.webClient = webClient;
        this.properties = properties;
    }

    public String ask(String question){

        OllamaRequest request = new OllamaRequest(
                properties.getModel(),
                question,
                false
        );

        try{
            OllamaResponse response = webClient.post()
                    .uri("/api/generate")
                    .bodyValue(request)
                    .retrieve()
                    .bodyToMono(OllamaResponse.class)
                    .block();

            return response !=null ? response.getResponse() : "No response from LLM";
        }catch(Exception e){
            return "LLM unavailable";
        }
    }

    public String askWithContext(String question, List<String> contextDocs) {

        String context = String.join("\n\n", contextDocs);

        String prompt = """
            You are a helpful assistant.
            Answer the question ONLY using the context below.
            If the answer is not in the context, say "I don't know".

            Context:
            %s

            Question:
            %s
            """.formatted(context, question);

        return ask(prompt);
    }

}
