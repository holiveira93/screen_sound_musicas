package com.example.screen_sound_musicas;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ChatGPTQuery {

    public static String getDataAboutAnArtist(String texto) {
        OpenAiService service = new OpenAiService(System.getenv("OPENAI_API_KEY"));

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("Give me data about this artist: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var response = service.createCompletion(requisicao);
        return response.getChoices().get(0).getText();
    }
}
