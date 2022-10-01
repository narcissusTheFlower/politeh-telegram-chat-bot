package com.tlegramm_bot.politehtelegrambot.service;


import com.tlegramm_bot.politehtelegrambot.messgeTypes.HelpMessage;
import com.tlegramm_bot.politehtelegrambot.messgeTypes.MsgSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiValidationException;

@Component
public class BotConfig extends TelegramLongPollingBot {


    private MsgSender msgSender;
    private HelpMessage helpMessage;

    @Autowired
    public BotConfig(MsgSender msgSender, HelpMessage helpMessage) {
        this.msgSender = msgSender;
        this.helpMessage = helpMessage;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message incoming_message = update.getMessage();
        if (incoming_message != null && incoming_message.hasText()) {
            String command = incoming_message.getText();
            String chatId = incoming_message.getChatId().toString();
            Integer messageId = incoming_message.getMessageId();

            try {
                switch (command) {
                    case "/help":
                        execute(helpMessage.sendHelpMsg(chatId, messageId));
                        break;
                    case "/start":

                        break;
                    case "/quote":

                    default:


                }
            }catch (TelegramApiException e){
                e.printStackTrace();
            }

        }
    }
    //@Value("${bot.token}")
    private static String botToken = "5795026222:AAFlEyb_XB6BIifsaNCZHxO4JhoXV5nIC6o";

   // @Value("${bot.Username}")
    private static String botUsername = "PolitehChatBot";

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }


}
