package com.telegram.politehtelegrambot.commands;

import com.telegram.politehtelegrambot.database.MutedPerson;
import com.telegram.politehtelegrambot.database.databasesource.DatabaseSource;
import com.telegram.politehtelegrambot.utils.AdminFilter;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMember;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UnmuteCommand extends BotCommand {

    DatabaseSource<MutedPerson> source;

    List<MutedPerson> unMuteQuery;

    public UnmuteCommand(String commandIdentifier, String description,DatabaseSource<MutedPerson> source) {
        super(commandIdentifier, description);
        this.source = source;
        unMuteQuery = new ArrayList<>();
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] arguments) {
        for(String arg: arguments){
            if(arg.startsWith("@")){
                unMuteQuery.add(new MutedPerson(-1, arg.substring(1), new Date()));
            }
        }
        super.processMessage(absSender, message, arguments);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        // TOOD Better admin filtering
        try {
            if(!AdminFilter.isAdmin(absSender, chat.getId(),user.getId())){
                absSender.execute(new SendMessage(chat.getId().toString(), "Permission denied."));
                return;
            }
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        if(unMuteQuery.size() > 0){
            try {
                List<MutedPerson> mutedPeople = source.selectAll();
                for (MutedPerson person : unMuteQuery) {
                    for (MutedPerson mutedPerson : mutedPeople) {
                        if (person.samePerson(mutedPerson)) {
                            source.delete(mutedPerson);
                            absSender.execute(new SendMessage(chat.getId().toString(), "Пользователь " + person + " теперь не заглушен!"));
                            break; //FIXME If not to break there will be ConcurrentModificationException
                        }
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        unMuteQuery.clear();
    }
}
