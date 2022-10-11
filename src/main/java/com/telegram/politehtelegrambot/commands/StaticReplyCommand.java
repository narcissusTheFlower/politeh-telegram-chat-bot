package com.telegram.politehtelegrambot.commands;

import com.telegram.politehtelegrambot.messages.StudyPlanPdfMessage;
import com.telegram.politehtelegrambot.messages.StudyPlanPicsMessage;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethodMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class StaticReplyCommand<T extends BotApiMethodMessage> extends BotCommand {
    Class<T> cls;

    public StaticReplyCommand(String commandIdentifier, String description, Class<T> cls) {
        super(commandIdentifier, description);
        this.cls = cls;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        try {
            absSender.execute(cls.getConstructor(String.class).newInstance(chat.getId().toString()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
