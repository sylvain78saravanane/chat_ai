package com.chatbot.chat_ai.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private final ChatClient chatClient;

    public MyController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/ai")
    String generate(String userInput) {
        return this.chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }

    // private final ChatClient chatClient;
    //
    // public MyController(ChatClient.Builder chatClientBuilder) {
    //     this.chatClient = chatClientBuilder.build();
    // }
//
    // @GetMapping("/ai")
    // String generation(String userInput) {
    //     return this.chatClient.prompt()
    //             .user(userInput)
    //             .call()
    //             .content();
    // }


}
