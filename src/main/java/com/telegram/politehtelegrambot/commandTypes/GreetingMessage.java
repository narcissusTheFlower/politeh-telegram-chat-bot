package com.telegram.politehtelegrambot.commandTypes;

import com.telegram.politehtelegrambot.utils.EmojiFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class GreetingMessage {

    private final String START_MESSAGE = """
            %fire Привет студент Политеха! %fire
            Начни с команды /help, чтобы ознакомиться с функционалом!
            """.replace("%fire", EmojiFactory.getFire());

    public SendMessage sendGreetingMsg(String chatId) {
        SendMessage messageToBeSent = new SendMessage();
        messageToBeSent.setChatId(chatId);
        messageToBeSent.setText(START_MESSAGE);
        return messageToBeSent;
    }
}
