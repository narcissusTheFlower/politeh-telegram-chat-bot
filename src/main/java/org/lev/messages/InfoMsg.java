package org.lev.messages;

import org.lev.utils.DaysTillSessionCounter;
import org.lev.utils.EmojiFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class InfoMsg extends SendMessage {
    //TODO dangerous, remember to change numbers
    static private final Short currentSemester = 3;
    static private final Short currentYear = 2;
    static private final Short endYear = 2026;

    public InfoMsg(String chatId) {
        super(chatId, INFO);
    }

    static private final String INFO =
            """
                    %star Университет: ФГАО ВО "СПбПУ";
                    %diamond Учебное подразделение: Институт компьютерных наук и технологий;
                    %diamond Направление подготовки: 09.03.02 Информационные системы и технологии;
                    %diamond Руководитель образовательной программы: Ефремов Артём Александрович
                    %diamond Уровень подготовки: Бакалавр;
                    %diamond Форма обучения: Заочная, платная;
                    %diamond Всего курсов: 4,5;
                    %diamond Всего семестров: 9;
                    %diamond Текущий курс: %currentYear;
                    %diamond Текущий семестр: %currentSemester;
                    %diamond Учимся до: %endYear;
                    %diamond Группы в этом чате: з3530902/10002, з3530902/10001;
                    %exclamation До начала сессии %days %exclamation
                    """
                    .replace("%diamond", EmojiFactory.getBlueDiamond())
                    .replace("%star", EmojiFactory.getStar())
                    .replace("%currentSemester", String.valueOf(currentSemester))
                    .replace("%currentYear", String.valueOf(currentYear))
                    .replace("%endYear", String.valueOf(endYear))
                    .replace("%exclamation",  EmojiFactory.getExclamation())
                    .replace("%days", DaysTillSessionCounter.DaysTillSessionWithProperCase());
}
