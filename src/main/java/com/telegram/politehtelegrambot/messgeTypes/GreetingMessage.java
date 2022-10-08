package com.telegram.politehtelegrambot.messgeTypes;

import com.telegram.politehtelegrambot.utils.EmojiFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class GreetingMessage {

    private String getGreetingMessage = """
            %fire Привет студент Политеха! %fire
            Начни с команды /help, чтобы ознакомиться с функционалом!
            """.replace("%fire", EmojiFactory.getFire());

    public SendMessage sendGreetingMsg(String chatId) {
        SendMessage message_to_be_sent = new SendMessage();
        message_to_be_sent.setChatId(chatId);
        message_to_be_sent.setText(getGreetingMessage);
        return message_to_be_sent;
    }
}
