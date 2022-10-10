package com.telegram.politehtelegrambot.telegram.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class BotMenu {

    public static SetMyCommands activateMenu(){
        List<BotCommand> listOfCommands = new ArrayList<>();
        listOfCommands.add(new BotCommand("/help", "Список команд бота"));
        listOfCommands.add(new BotCommand("/info", "Общая информация по учебе"));
        listOfCommands.add(new BotCommand("/teachers", "Преподаватели и их контакты"));
        listOfCommands.add(new BotCommand("/plan", "Расписание всех сессий"));
        listOfCommands.add(new BotCommand("/links", "Полезные ссылки"));
        SetMyCommands setMyCommands = new SetMyCommands(listOfCommands,new BotCommandScopeDefault(),null);
        return setMyCommands;
    }
}
