package com.telegram.politehtelegrambot.messgeTypes;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class TeacherContactsMessage {

    private final String contacts = "https://vk.com/@iknt090302-kontakty-po-uchebnym-voprosam";

    public SendMessage sendTeacherContactsMsg(String chatId) {
        SendMessage messageToBeSent = new SendMessage();
        messageToBeSent.setChatId(chatId);
        messageToBeSent.setText("Контакты преподавателей:\n" + contacts);
        return messageToBeSent;
    }
}
