package org.lev.messages;

import org.lev.utils.DaysTillSessionCounter;
import org.lev.utils.EmojiFactory;
import org.lev.utils.PropertiesLoader;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class TeachersMsg extends SendMessage {

    private static String CONTACTS = PropertiesLoader.getProperty("teacherContacts");

    public TeachersMsg(String chatId) {
        super(chatId,getMsgText);
    }

    private static final String getMsgText = """
            %star Контакты преподавателей:
            %contacts 
            %exclamation До начала сессии %days  %exclamation
            """.replace("%star", EmojiFactory.getStar()).replace("%contacts", CONTACTS)
            .replace("%exclamation",  EmojiFactory.getExclamation())
            .replace("%days", DaysTillSessionCounter.DaysTillSessionWithProperCase());
}
