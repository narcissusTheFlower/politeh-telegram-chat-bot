package com.telegram.politehtelegrambot.messgeTypes;

import com.telegram.politehtelegrambot.utils.EmojiFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class DefaultMessage {
private String getDefaultMsg = """
        %warning Неверная команда %warning
        Используйте /help, чтобы вывести список возможных команд.
        """.replace("%warning", EmojiFactory.getWarning());

    public SendMessage sendDefaultMsg(String chatId) {
        SendMessage messageToBeSent = new SendMessage();
        messageToBeSent.setChatId(chatId);
        messageToBeSent.setText(getDefaultMsg);
        return messageToBeSent;
    }
}
