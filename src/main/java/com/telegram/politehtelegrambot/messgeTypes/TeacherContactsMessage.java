package com.telegram.politehtelegrambot.messgeTypes;

import com.telegram.politehtelegrambot.utils.EmojiFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class TeacherContactsMessage {

    private final String contacts = "https://vk.com/@iknt090302-kontakty-po-uchebnym-voprosam";
    
    private final String getMsgText = """
            %star Контакты преподавателей:
            %contacts 
            """.replace("%star", EmojiFactory.getStar()).replace("%contacts", contacts);

    public SendMessage sendTeacherContactsMsg(String chatId) {
        SendMessage messageToBeSent = new SendMessage();
        messageToBeSent.setChatId(chatId);
        messageToBeSent.setText(getMsgText);
        return messageToBeSent;
    }
}
