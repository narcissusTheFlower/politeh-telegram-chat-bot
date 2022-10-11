package com.telegram.politehtelegrambot.telegram.bot;

import com.telegram.politehtelegrambot.messages.StudyPlanPdfMessage;
import com.telegram.politehtelegrambot.messages.UnknownCommandMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class BotService extends TelegramLongPollingCommandBot {

    private BotProperties botProperties;

    @Autowired
    public BotService(BotProperties botProperties) throws TelegramApiException {
        this.botProperties = botProperties;
        registerAll(BotCommands.getAllCommands().toArray(new IBotCommand[0]));
        execute(new SetMyCommands(BotCommands.getMenu(),new BotCommandScopeDefault(),null));
    }

    @Override
    public String getBotToken() {
        return botProperties.getBotToken();
    }

    @Override
    public String getBotUsername() {
        return botProperties.getBotName();
    }

    @Override
    public void processNonCommandUpdate(Update update) {

    }

    @Override
    public void processInvalidCommandUpdate(Update update) {
        try {
            execute(new UnknownCommandMessage(update.getMessage().getChatId().toString()));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
