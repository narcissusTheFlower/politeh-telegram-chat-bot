//package com.telegram.politehtelegrambot.service;
//
//import org.springframework.stereotype.Component;
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
//import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
//import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
//import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class BotKeyboard {
//
//    public void setButtons(SendMessage sendMessage) {
//
//        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//
//        sendMessage.setReplyMarkup(replyKeyboardMarkup);
//        replyKeyboardMarkup.setSelective(true);
//        replyKeyboardMarkup.setResizeKeyboard(true);
//        replyKeyboardMarkup.setOneTimeKeyboard(false);
//        List<KeyboardRow> keyboardRowList = new ArrayList<>();
//        KeyboardRow keyboardRow = new KeyboardRow();
//        keyboardRow.add(new KeyboardButton("Список команд"));
//        keyboardRow.add(new KeyboardButton("Общая информация"));
//        keyboardRow.add(new KeyboardButton("Расписание сессий"));
//        keyboardRowList.add(keyboardRow);
//        replyKeyboardMarkup.setKeyboard(keyboardRowList);
//    }
//}
