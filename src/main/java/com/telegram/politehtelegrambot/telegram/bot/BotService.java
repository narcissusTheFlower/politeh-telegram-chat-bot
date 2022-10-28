package com.telegram.politehtelegrambot.telegram.bot;

import com.telegram.politehtelegrambot.commands.MuteCommand;
import com.telegram.politehtelegrambot.commands.UnmuteCommand;
import com.telegram.politehtelegrambot.database.MutedPerson;
import com.telegram.politehtelegrambot.database.databasesource.SetDatabaseSource;
import com.telegram.politehtelegrambot.database.databasesource.DatabaseSource;
import com.telegram.politehtelegrambot.messages.UnknownCommandMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class BotService extends TelegramLongPollingCommandBot {

    private BotProperties botProperties;
    private DatabaseSource<MutedPerson> mutedPersons;

    @Autowired
    public BotService(BotProperties botProperties) throws TelegramApiException {
        this.botProperties = botProperties;
        this.mutedPersons = new SetDatabaseSource<>((o1, o2) -> {
            if(o1.getId() == -1 || o2.getId() == -1){
                return o1.getUsername().hashCode() - o2.getUsername().hashCode();
            }else {
                return o1.samePerson(o2) ? 0 : (int) (o1.getId() - o2.getId()); //FIXME
            }
        });

        registerAll(BotCommands.getAllCommands().toArray(new IBotCommand[0]));

        register(new MuteCommand("/mute","Mute",mutedPersons));
        register(new UnmuteCommand("/unmute","Unmute",mutedPersons));

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
        if(update.hasMessage()) {
            Message message = update.getMessage();
            User sender = message.getFrom();
            Long chatId = message.getChatId();

            List<MutedPerson> muted = mutedPersons.selectAll();
            for (MutedPerson person : muted) {
                if (person.samePerson(sender)) {
                    try {
                        execute(new DeleteMessage(chatId.toString(), message.getMessageId()));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
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
