package com.telegram.politehtelegrambot.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("classpath:application.properties")
public class BotConfig {

    @Value("${bot.username}")
    private String botName;
    @Value("${bot.token}")
    private String botToken;

}
