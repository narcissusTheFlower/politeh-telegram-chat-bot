package com.telegram.politehtelegrambot.messages;

import com.telegram.politehtelegrambot.utils.EmojiFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;



@Component
public class UnknownCommandMessage extends SendMessage{

    private static String UNKNOWN_COMMAND_MESSAGE = """
        %warning Неверная команда %warning
        Используйте /help, чтобы вывести список возможных команд.
        """.replace("%warning", EmojiFactory.getWarning());

    public UnknownCommandMessage() {
    }

    public UnknownCommandMessage(String chatId) {
        super(chatId, UNKNOWN_COMMAND_MESSAGE);
    }



}
