package com.telegram.politehtelegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages={"com.telegram.politehtelegrambot"})
public class PolitehTelegramBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolitehTelegramBotApplication.class, args);
        System.out.println("New gradle project");
    }

}
