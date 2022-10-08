package com.telegram.politehtelegrambot.messgeTypes;

import com.vdurmont.emoji.EmojiParser;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class InfoMessage {

    private String small_blue_diamond = EmojiParser.parseToUnicode(":small_blue_diamond:");

    //TODO dagerous, remember to change
    private final String info =
            """
                    Университет: ФГАО ВО "СПбПУ";
                    
                    %s Учебное подразделение: Институт компьютерных наук и технологий;
                    %s Направление подготовки: 09.03.02 Информационные системы и технологии;
                    %s Руководитель образовательной программы: Ефремов Артём Александрович
                    %s Уровень подготовки: Бакалавр;
                    %s Форма обучения: Заочная, платная;
                    %s Всего курсов: 4,5;
                    %s Всего семестров: 9;
                    %s Текущий курс: 2;
                    %s Текущий семестр: 3;
                    %s Группы в этом чате: з3530902/10002, з3530902/10001;
                    """.replace("%s",small_blue_diamond);


    public SendMessage sendInfoMsg(String chatId) {
        SendMessage messageToBeSent = new SendMessage();
        messageToBeSent.setChatId(chatId);
        messageToBeSent.setText(info);
        return messageToBeSent;
    }
}
