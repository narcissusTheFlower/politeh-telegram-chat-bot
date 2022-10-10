package com.telegram.politehtelegrambot.commandTypes;

import com.telegram.politehtelegrambot.utils.EmojiFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;


@Deprecated
@Component
public class DefaultMessage {

    private final String CHAT_ID = "5795026222";
    private String getDefaultMsg = """
        %warning Неверная команда %warning
        Используйте /help, чтобы вывести список возможных команд.
        """.replace("%warning", EmojiFactory.getWarning());


    //TODO never return null, FIX THIS
    public SendMessage sendDefaultMsg(String chatId) {
        if (checkValidChatId(chatId)){
            return buildDefaultMsg(chatId);
        } else return new SendMessage();
    }

    private SendMessage buildDefaultMsg(String chatId){
        SendMessage messageToBeSent = new SendMessage();
        messageToBeSent.setChatId(chatId);
        messageToBeSent.setText(getDefaultMsg);
        return messageToBeSent;
    }

    private Boolean checkValidChatId(String chatId){
        return chatId.equals(CHAT_ID);
    }
}
