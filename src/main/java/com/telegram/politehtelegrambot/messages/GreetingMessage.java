package com.telegram.politehtelegrambot.messages;

import com.telegram.politehtelegrambot.utils.EmojiFactory;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;


@Component
@ToString
public class GreetingMessage extends SendMessage{

    private static final String START_MESSAGE = """
            %fire Привет студент Политеха! %fire
            Начни с команды /help, чтобы ознакомиться с функционалом!
            """.replace("%fire", EmojiFactory.getFire());

    public GreetingMessage() {
    }

    public GreetingMessage(String chatId) {
        super(chatId,START_MESSAGE);
    }


}
