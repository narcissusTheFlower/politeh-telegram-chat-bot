package com.telegram.politehtelegrambot.messages;

import com.telegram.politehtelegrambot.utils.EmojiFactory;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@ToString
public class HelpMessage extends SendMessage{

//                    %diamond /subjects - список премедметов на текущий семестр;
//                    %diamond /deadlines - список дат по сдаче предметов;
//                    %diamond /vk - вывести последний пост из группы ВК.
    private static final String AVAILABLE_COMMANDS ="""
                    %star Список доступных комманд:
                    %diamond /help - вывести это меню
                    %diamond /info - общая информация по направлению учебы
                    %diamond /teachers - список наших преподавателей и их контакты
                    %diamond /plan - расписание сессий на год
                    %diamond /links - список полезных ссылок
                    """.replace("%diamond", EmojiFactory.getBlueDiamond()).replace("%star", EmojiFactory.getStar());
    public HelpMessage() {
    }

    public HelpMessage(String chatId) {
        super(chatId, AVAILABLE_COMMANDS);
    }


}
