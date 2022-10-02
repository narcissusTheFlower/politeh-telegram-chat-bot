package com.telegram.politehtelegrambot.messgeTypes;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class InfoMessage {


    private final String info =
            "Университет: ФГАО ВО \"СПбПУ\";\n" +
                    "Учебное подразделение: Институт компьютерных наук и технологий;\n" +
                    "Направление подготовки: 09.03.02 Информационные системы и технологии;\n" +
                    "Уровень подготовки: Бакалавр;\n" +
                    "Форма обучения: Заочная, платная;\n" +
                    "Всего курсов: 4,5;\n" +
                    "Всего семестров: 9;\n" +
                    //TODO dagerous, remember to change
                    "Текущий курс: 2;\n" +
                    "Текущий семестр: 3;\n" +
                    "Группы в этом чате: з3530902/10002, з3530902/10001;\n" +
                    "Ссылка на нашу группу ВК: https://vk.com/iknt090302";
    public SendMessage sendInfoMsg(String chatId) {
        SendMessage message_to_be_sent = new SendMessage();
        message_to_be_sent.enableMarkdown(true);
        message_to_be_sent.setChatId(chatId);
        message_to_be_sent.setText(info);
        return message_to_be_sent;
    }

}
