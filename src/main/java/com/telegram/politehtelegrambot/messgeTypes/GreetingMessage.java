package com.telegram.politehtelegrambot.messgeTypes;


import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class GreetingMessage {


    String greetingMessage = "Здравствуй студент Политеха!\n" +
            "Начни с команды /help, чтобы ознакомиться с функционалом.";

    public SendMessage sendGreetingMsg(String chatId) {
        SendMessage message_to_be_sent = new SendMessage();
        message_to_be_sent.setChatId(chatId);
        message_to_be_sent.setText(greetingMessage);
        return message_to_be_sent;
    }
}
