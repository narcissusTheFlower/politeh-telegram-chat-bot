package com.telegram.politehtelegrambot.messgeTypes;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class DefaultMessage {

    String wrongCommandMsg = "Неверная команда. \n" +
            "Используйте /help, чтобы вывести список команд.";

    public SendMessage sendDefaultMsg(String chatId) {
        SendMessage message_to_be_sent = new SendMessage();
        message_to_be_sent.setChatId(chatId);
        message_to_be_sent.setText(wrongCommandMsg);
        return message_to_be_sent;
    }
}
