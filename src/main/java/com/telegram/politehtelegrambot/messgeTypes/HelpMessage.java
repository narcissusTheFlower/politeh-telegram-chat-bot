package com.telegram.politehtelegrambot.messgeTypes;

import lombok.ToString;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
@ToString
public class HelpMessage {

    private final String availableCommands =
            "Список доступных комманд:\n" +
                    "/help - вывести это меню;\n" +
            "/info - общая информация по направлению учебы;\n" +
            "/teachers - список наших преподавателей и их контакты;\n" +
            "/plan - расписание сессий на год;\n" +
            "/subjects - список премедметов на текущий семестр;\n" +
            "/deadlines - список дат по сдаче предметов;\n" +
            "/vk - вывести последний пост из группы ВК.\n";

    public SendMessage sendHelpMsg(String chatId) {
        SendMessage message_to_be_sent = new SendMessage();
        message_to_be_sent.setChatId(chatId);
        message_to_be_sent.setText(availableCommands);
        return message_to_be_sent;
    }
}
