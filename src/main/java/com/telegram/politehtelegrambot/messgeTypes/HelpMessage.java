package com.telegram.politehtelegrambot.messgeTypes;

import com.vdurmont.emoji.EmojiParser;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
@ToString
public class HelpMessage {
    private String small_blue_diamond =EmojiParser.parseToUnicode(":small_blue_diamond:");

    private final String availableCommands ="""
                    Список доступных комманд:
                    %s /help - вывести это меню;
                    %s /info - общая информация по направлению учебы;
                    %s /teachers - список наших преподавателей и их контакты;
                    %s /plan - расписание сессий на год;
                    %s /subjects - список премедметов на текущий семестр;
                    %s /deadlines - список дат по сдаче предметов;
                    %s /vk - вывести последний пост из группы ВК.
                    """.replace("%s", small_blue_diamond);

    public SendMessage sendHelpMsg(String chatId) {
        SendMessage messageToBeSent = new SendMessage();
        messageToBeSent.setChatId(chatId);
        messageToBeSent.setText(availableCommands);
        return messageToBeSent;
    }
}
