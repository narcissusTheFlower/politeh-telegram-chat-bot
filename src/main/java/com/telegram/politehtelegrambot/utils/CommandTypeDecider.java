package com.telegram.politehtelegrambot.utils;

import com.telegram.politehtelegrambot.telegram.bot.Commands;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public final class CommandTypeDecider {

    public static Commands decideCommandFrom(Message incomingMessage) {
        String commandFromMessage = incomingMessage.toString();
        if (commandFromMessage.contains("start")) {
            return Commands.START;
        }
        if (commandFromMessage.contains("help")) {
            return Commands.HELP;
        }
        if (commandFromMessage.contains("info")) {
            return Commands.INFO;
        }
        if (commandFromMessage.contains("teachers")) {
            return Commands.TEACHERS_CONTACTS;
        }
        if (commandFromMessage.contains("plan")) {
            return Commands.PLAN;
        }
        if (commandFromMessage.contains("links")) {
            return Commands.LINKS;
        }

        return Commands.DEFAULT;
    }
}
