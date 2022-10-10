package com.telegram.politehtelegrambot.telegram.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Deprecated
@Component
public class BotMsgSender {

    private static Message incomingMessage;

//TODO refactor this method
    public static Boolean updateNotNull(Update incomingUpdate){
            incomingMessage = incomingUpdate.getMessage();
            if ((incomingMessage != null && incomingMessage.hasText())){
                return true;
            }else {
                throw new IllegalStateException("Incoming update or message is null");
            }
        }
    }

