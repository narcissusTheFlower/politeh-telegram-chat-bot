package com.telegram.politehtelegrambot.messgeTypes;

import com.vdurmont.emoji.EmojiParser;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class InfoMessage {

    private String small_blue_diamond = EmojiParser.parseToUnicode(":small_blue_diamond:");
    private final String info =
            "Университет: ФГАО ВО \"СПбПУ\";\n" +
                    "Учебное подразделение: Институт компьютерных наук и технологий;\n" +
                    "Направление подготовки: 09.03.02 Информационные системы и технологии;\n" +
                    "Руководитель образовательной программы: Ефремов Артём Александрович\n" +
                    "Уровень подготовки: Бакалавр;\n" +
                    "Форма обучения: Заочная, платная;\n" +
                    "Всего курсов: 4,5;\n" +
                    "Всего семестров: 9;\n" +
                    //TODO dagerous, remember to change
                    "Текущий курс: 2;\n" +
                    "Текущий семестр: 3;\n" +
                    "Группы в этом чате: з3530902/10002, з3530902/10001;\n";


    public SendMessage sendInfoMsg(String chatId) {
        SendMessage messageToBeSent = new SendMessage();
        messageToBeSent.setChatId(chatId);
        messageToBeSent.setText(info);
        return messageToBeSent;
    }
}
