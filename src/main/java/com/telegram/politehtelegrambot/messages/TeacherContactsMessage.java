package com.telegram.politehtelegrambot.messages;

import com.telegram.politehtelegrambot.utils.EmojiFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class TeacherContactsMessage extends SendMessage{

    private static final String CONTACTS = "https://vk.com/@iknt090302-kontakty-po-uchebnym-voprosam";
    
    private static final String getMsgText = """
            %star Контакты преподавателей:
            %contacts 
            """.replace("%star", EmojiFactory.getStar()).replace("%contacts", CONTACTS);

    public TeacherContactsMessage() {
    }
    public TeacherContactsMessage(String chatId) {
        super(chatId,getMsgText);
    }


}
