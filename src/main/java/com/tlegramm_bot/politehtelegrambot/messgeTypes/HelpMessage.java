package com.tlegramm_bot.politehtelegrambot.messgeTypes;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;


@Component
public class HelpMessage {

    public SendMessage sendHelpMsg(String chatId, Integer messageId) {
        SendMessage message_to_be_sent = new SendMessage();
        message_to_be_sent.setChatId(chatId);
        message_to_be_sent.setReplyToMessageId(messageId);
        message_to_be_sent.setText("text_message");
        return message_to_be_sent;
    }
}
