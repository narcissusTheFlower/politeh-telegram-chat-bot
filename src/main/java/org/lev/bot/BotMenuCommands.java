package org.lev.bot;

import org.lev.commands.BotApiMethodReplyCommand;
import org.lev.commands.PartialBotApiMethodReplyCommand;
import org.lev.messages.*;
import org.lev.messages.PlanMsg;
import org.lev.messages.vkMessages.VkMsg;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import java.util.ArrayList;
import java.util.List;

public class BotMenuCommands {

    public static List<IBotCommand> setAllMenuCommands(){
        return List.of(
                new BotApiMethodReplyCommand<>("/start", "Начало работы", StartMsg.class),
                new BotApiMethodReplyCommand<>("/help", "Список команд бота", HelpMsg.class),
                new BotApiMethodReplyCommand<>("/info", "Общая информация по учебе", InfoMsg.class),
                new BotApiMethodReplyCommand<>("/teachers", "Преподаватели и их контакты", TeachersMsg.class),
                new PartialBotApiMethodReplyCommand<>("/plan", "Расписание всех сессий", PlanMsg.class),
                new BotApiMethodReplyCommand<>("/links", "Полезные ссылки", LinksMsg.class)
                //new BotApiMethodReplyCommand<>("/vk", "Вывести последний пост группы ВК Сергея", VkMsg.class)
        );
    }

    public static List<BotCommand> getMenu(){
        //BotCommand class is from org.telegram.telegrambots.meta.api.objects.commands.BotCommand
        List<BotCommand> listOfCommands = new ArrayList<>();
        for (IBotCommand command: setAllMenuCommands()){
            listOfCommands.add(new BotCommand(command.getCommandIdentifier(), command.getDescription()));
        }
        return listOfCommands;
    }
}
