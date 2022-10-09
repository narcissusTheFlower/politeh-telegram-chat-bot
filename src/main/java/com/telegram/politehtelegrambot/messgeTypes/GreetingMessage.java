package com.telegram.politehtelegrambot.messgeTypes;

import com.telegram.politehtelegrambot.telegram.bot.BotMenu;
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
        SendMessage messageToBeSent = new SendMessage();
        messageToBeSent.setChatId(chatId);
        messageToBeSent.setText(getGreetingMessage);
        return messageToBeSent;
    }
}
