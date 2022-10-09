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
        //TODO to be added in future
//        listOfCommands.add(new BotCommand("/subjects", "set your preferences"));
//        listOfCommands.add(new BotCommand("/deadlines", "set your preferences"));
//        listOfCommands.add(new BotCommand("/vk", "set your preferences"));
        SetMyCommands setMyCommands = new SetMyCommands(listOfCommands,new BotCommandScopeDefault(),null);
        return setMyCommands;
    }

//Keyboard to be added in the future (maybe)
//    public ReplyKeyboardMarkup setButtons() {
//        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//            replyKeyboardMarkup.setSelective(true);
//            replyKeyboardMarkup.setResizeKeyboard(true);
//            replyKeyboardMarkup.setOneTimeKeyboard(false);
//                List<KeyboardRow> keyboardRowList = new ArrayList<>();
//                    KeyboardRow keyboardRow = new KeyboardRow();
//                    keyboardRow.add(new KeyboardButton("Список команд"));
//                    keyboardRow.add(new KeyboardButton("Общая информация"));
//                    keyboardRow.add(new KeyboardButton("Кнтакты преподавателей"));
//                    keyboardRow.add(new KeyboardButton("Расписание сессий"));
//                    keyboardRow.add(new KeyboardButton("Полезные ссылки"));
////        keyboardRow.add(new KeyboardButton("Последний пост ВК"));
////        keyboardRow.add(new KeyboardButton("Общая информация"));
//                keyboardRowList.add(keyboardRow);
//            replyKeyboardMarkup.setKeyboard(keyboardRowList);
//        return replyKeyboardMarkup;
//    }
}
