package com.telegram.politehtelegrambot.messages;

import com.telegram.politehtelegrambot.utils.EmojiFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class InfoMessage extends SendMessage{
    //TODO dagerous, remember to change numbers
    static private final Short currentSemester = 3;
    static private final Short currentYear = 2;
    static private final Short endYear = 2026;

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
                    """
                    .replace("%diamond", EmojiFactory.getBlueDiamond())
                    .replace("%star", EmojiFactory.getStar())
                    .replace("%currentSemester", String.valueOf(currentSemester))
                    .replace("%currentYear", String.valueOf(currentYear))
                    .replace("%endYear", String.valueOf(endYear));

    public InfoMessage() {
    }

    public InfoMessage(String chatId) {
        super(chatId,INFO);

    }


}
