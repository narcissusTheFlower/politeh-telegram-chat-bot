package org.lev.messages;

import lombok.NonNull;
import org.lev.utils.DaysTillSessionCounter;
import org.lev.utils.EmojiFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import java.util.List;

public class HelpMsg extends SendMessage {

    private static String AVAILABLE_COMMANDS ="""
                    %star Список доступных комманд:
                    %diamond /help - вывести это меню
                    %diamond /info - общая информация по направлению учебы
                    %diamond /teachers - список наших преподавателей и их контакты
                    %diamond /plan - расписание сессий на год
                    %diamond /links - список полезных ссылок
                    %exclamation До начала сессии %days  %exclamation
                    """ .replace("%diamond", EmojiFactory.getBlueDiamond())
                        .replace("%star", EmojiFactory.getStar())
                        .replace("%exclamation",  EmojiFactory.getExclamation())
                        .replace("%days", DaysTillSessionCounter.DaysTillSessionWithProperCase());
//                    %diamond /subjects - список премедметов на текущий семестр;
//                    %diamond /deadlines - список дат по сдаче предметов;
//                    %diamond /vk - вывести последний пост из группы ВК.

    public HelpMsg(String chatId) {
        super(chatId, AVAILABLE_COMMANDS);
    }

//    public HelpMsg(String chatId) {
//        super(chatId,
//                AVAILABLE_COMMANDS,
//                null,
//                false,
//                null,
//                null,
//                null, //new Keyboard();
//                null,
//                null,
//                false);
//    }
}
