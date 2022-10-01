package com.tlegramm_bot.politehtelegrambot.messgeTypes;

import com.tlegramm_bot.politehtelegrambot.messgeTypes.HelpMessage;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class MsgSender {

    HelpMessage helpMessage = new HelpMessage();

    //TODO add generic
     public void sendMessage(Object o){

    }
}
