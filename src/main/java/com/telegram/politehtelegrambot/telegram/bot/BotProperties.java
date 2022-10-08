package com.telegram.politehtelegrambot.telegram.bot;

import lombok.Data;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("classpath:application.properties")
public class BotProperties {

    private final String botName = System.getenv("BOTUSERNAME");

    private final String botToken = System.getenv("BOTTOKEN");
}
