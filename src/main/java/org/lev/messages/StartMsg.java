package org.lev.messages;

import org.lev.utils.DaysTillSessionCounter;
import org.lev.utils.EmojiFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class StartMsg extends SendMessage {

    private static final String START_MESSAGE = """
            %fire Привет студент Политеха! %fire
            Начни с команды /help, чтобы ознакомиться с функционалом!
             %exclamation До начала сессии %days  %exclamation
            """.replace("%fire", EmojiFactory.getFire())
            .replace("%exclamation",  EmojiFactory.getExclamation())
            .replace("%days", DaysTillSessionCounter.DaysTillSessionWithProperCase());

    public StartMsg(String chatId){
        super(chatId,START_MESSAGE);
    }
}
