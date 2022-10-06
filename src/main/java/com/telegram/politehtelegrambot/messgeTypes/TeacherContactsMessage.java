package com.telegram.politehtelegrambot.messgeTypes;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class TeacherContactsMessage {

    public SendMessage sendTeacherContactsMsg(String chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Контакты преподавателей:\n https://vk.com/@iknt090302-kontakty-po-uchebnym-voprosam");
        return message;
    }
}
