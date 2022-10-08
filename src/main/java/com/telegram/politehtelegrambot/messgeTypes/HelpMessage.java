package com.telegram.politehtelegrambot.messgeTypes;

import com.telegram.politehtelegrambot.utils.EmojiFactory;
import com.telegram.politehtelegrambot.vk.VkApiCalls;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
@ToString
public class HelpMessage {

    private final String availableCommands ="""
                    %star Список доступных комманд:
                    %diamond /help - вывести это меню;
                    %diamond /info - общая информация по направлению учебы;
                    %diamond /teachers - список наших преподавателей и их контакты;
                    %diamond /plan - расписание сессий на год;
                    %diamond /links - список полезных ссылок;
                    %diamond /subjects - список премедметов на текущий семестр;
                    %diamond /deadlines - список дат по сдаче предметов;
                    %diamond /vk - вывести последний пост из группы ВК.
                    """.replace("%diamond", EmojiFactory.getBlueDiamond()).replace("%star", EmojiFactory.getStar());

    public SendMessage sendHelpMsg(String chatId) {
        SendMessage messageToBeSent = new SendMessage();
        messageToBeSent.setChatId(chatId);
        messageToBeSent.setText(availableCommands);
        return messageToBeSent;
    }
}
