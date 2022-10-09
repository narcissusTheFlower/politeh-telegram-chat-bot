package com.telegram.politehtelegrambot.telegram.bot;

import com.telegram.politehtelegrambot.messgeTypes.*;
import com.telegram.politehtelegrambot.vk.VkApiCalls;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
//TODO refactor huge switch function in BotService
    //    public SendMessage reactToUpdate(Update incomingUpdate){
//        if (updateNotNull(incomingUpdate)){
//            switch (command) {
//                case "/start":
//                    return (new GreetingMessage().sendGreetingMsg(chatId));
//
//                case "/help":
//                    return (new HelpMessage().sendHelpMsg(chatId));
//
//                case "/info":
//                    return (new InfoMessage().sendInfoMsg(chatId));
//
//                case "/teachers":
//                    return (new TeacherContactsMessage().sendTeacherContactsMsg(chatId));
//
//                case "/plan":
//                    return new StudyPlanMessage().sendPhotoPlanMsg(chatId);
//                //return new StudyPlanMessage().sendMessageWithPDFLink(chatId);
//                case "/subjects":
//
//                case "/deadlines":
//
//                case "/links":
//                    return(new UseFullLinksMessage().sendLinksMsg(chatId));
//
//                case "/vk":
//                    //VKInit.parseWall();
//                    VkApiCalls.soutresult();
//
//                default: return(new DefaultMessage().sendDefaultMsg(chatId));
//            }
//        }
//           return new IllegalStateException("Switch case problem");
//    }
    }

