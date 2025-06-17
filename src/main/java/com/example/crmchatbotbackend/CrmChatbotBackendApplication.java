package com.example.crmchatbotbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CrmChatbotBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmChatbotBackendApplication.class, args);
    }

}
