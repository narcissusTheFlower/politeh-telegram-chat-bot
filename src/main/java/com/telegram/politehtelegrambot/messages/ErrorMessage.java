package com.telegram.politehtelegrambot.messages;

import lombok.NonNull;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class ErrorMessage extends SendMessage {
    static private final String ERROR_PREFIX = "Ошибка:";

    public ErrorMessage() {
    }

    public ErrorMessage(@NonNull String chatId, @NonNull String text) {
        super(chatId, ERROR_PREFIX + text);
    }


}
