package org.lev.commands;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class BotApiMethodReplyCommand<T extends BotApiMethod> extends BotCommand {

    Class <T> cls;

    public BotApiMethodReplyCommand(String commandIdentifier, String commandDescription, Class <T> cls){
        super(commandIdentifier, commandDescription);
        this.cls = cls;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments){
        try{
            absSender.execute(cls.getConstructor(String.class).newInstance(chat.getId().toString()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
