package com.telegram.politehtelegrambot.messgeTypes;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;


@Component
public class UseFullLinksMessage {

    private final String links = "\nhttps://vk.com/@iknt090302-ssylki-na-sdo";

    public SendMessage sendLinksMsg(String chatId) {
        SendMessage messageToBeSent = new SendMessage();
        messageToBeSent.setChatId(chatId);
        messageToBeSent.setText("Открыть список ссылок:" + links);
        return messageToBeSent;
    }
}
