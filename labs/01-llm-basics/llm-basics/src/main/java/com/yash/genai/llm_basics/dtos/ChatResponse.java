package com.yash.genai.llm_basics.dtos;


    public class ChatResponse {

        private String response;

        public ChatResponse(String response) {
            this.response = response;
        }

        public String getResponse() {
            return response;
        }
    }