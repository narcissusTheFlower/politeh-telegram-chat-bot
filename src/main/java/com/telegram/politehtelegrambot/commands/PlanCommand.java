package com.telegram.politehtelegrambot.commands;

import com.telegram.politehtelegrambot.messages.StudyPlanPdfMessage;
import com.telegram.politehtelegrambot.messages.StudyPlanPicsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class PlanCommand extends BotCommand {
    public PlanCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }


    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        try{
            absSender.execute(new StudyPlanPdfMessage(chat.getId().toString()));
            absSender.execute(new StudyPlanPicsMessage(chat.getId().toString()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
