package com.telegram.politehtelegrambot.telegram.bot;

import com.telegram.politehtelegrambot.commands.MuteCommand;
import com.telegram.politehtelegrambot.commands.PlanCommand;
import com.telegram.politehtelegrambot.commands.StaticReplyCommand;
import com.telegram.politehtelegrambot.messages.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethodMessage;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.ArrayList;
import java.util.List;

@Component
public class BotCommands {
    @Autowired
    public static List<IBotCommand> getAllCommands(){
        List<IBotCommand> listOfCommands = new ArrayList<>();
        listOfCommands.add(new StaticReplyCommand<>("/start", "Начало (конца)", GreetingMessage.class));
        listOfCommands.add(new StaticReplyCommand<>("/help", "Список команд бота", HelpMessage.class));
        listOfCommands.add(new StaticReplyCommand<>("/info", "Общая информация по учебе",InfoMessage.class));
        listOfCommands.add(new StaticReplyCommand<>("/teachers", "Преподаватели и их контакты",TeacherContactsMessage.class));
        listOfCommands.add(new PlanCommand("/plan", "Расписание всех сессий"));
        listOfCommands.add(new StaticReplyCommand<>("/links", "Полезные ссылки",UseFullLinksMessage.class));
        // TODO
        //listOfCommands.add(new VkCommand("/vk","??"));

        return listOfCommands;
    }

    public static List<BotCommand> getMenu(){
        // BotCommand Class is has 2 different implementations: from bot library and bot library extensions.
        List<BotCommand> listOfCommands = new ArrayList<>();
        for(IBotCommand command: getAllCommands()){
            listOfCommands.add(new BotCommand(command.getCommandIdentifier(),command.getDescription()));
        }
        return listOfCommands;
    }

}
