package com.telegram.politehtelegrambot.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;

@Component
@Data
@PropertySource("classpath:application.properties")
public class BotProperties {

    private String botName = System.getenv("bot.username");

    private String botToken = System.getenv("bot.token");
}
