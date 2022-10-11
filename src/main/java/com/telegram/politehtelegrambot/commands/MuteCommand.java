package com.telegram.politehtelegrambot.commands;

import com.telegram.politehtelegrambot.database.MutedPerson;
import com.telegram.politehtelegrambot.database.databasesource.DatabaseSource;
import com.telegram.politehtelegrambot.utils.AdminFilter;
import org.apache.commons.lang3.NotImplementedException;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MuteCommand extends BotCommand {

    DatabaseSource<MutedPerson> source;

    List<MutedPerson> muteQuery;

    public MuteCommand(String commandIdentifier, String description,DatabaseSource<MutedPerson> source) {
        super(commandIdentifier, description);
        this.source = source;
        muteQuery = new ArrayList<>();
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] arguments) {
        if(arguments.length == 0) {
            if(message.getReplyToMessage() != null) {
                User user = message.getReplyToMessage().getFrom();
                muteQuery.add(new MutedPerson(user.getId(), user.getUserName(), new Date()));
            }else {

            }
        }else {
            for(String arg: arguments){
                if(arg.startsWith("@")){
                    muteQuery.add(new MutedPerson(-1, arg.substring(1), new Date()));
                }
            }
        }
        super.processMessage(absSender, message, arguments);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        try {
            if(!AdminFilter.isAdmin(absSender, chat.getId(),user.getId())){
                absSender.execute(new SendMessage(chat.getId().toString(), "Permission denied."));
                return;
            }
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        if(muteQuery.size() > 0){
            try {
                for(MutedPerson person: muteQuery) {
                    source.insert(person);
                    absSender.execute(new SendMessage(chat.getId().toString(), "Пользователь " + person.toString() + " заглушен!"));
                }
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
        muteQuery.clear();
    }
}
