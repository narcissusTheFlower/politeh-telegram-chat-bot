package org.lev.commands;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class PartialBotApiMethodReplyCommand <T extends PartialBotApiMethod> extends BotCommand {

    Class <T> cls;

    public PartialBotApiMethodReplyCommand(String commandIdentifier, String description, Class <T> cls) {
        super(commandIdentifier, description);
        this.cls = cls;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        try{
            absSender.execute((SendMediaGroup) cls.getConstructor(String.class).newInstance(chat.getId().toString()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
