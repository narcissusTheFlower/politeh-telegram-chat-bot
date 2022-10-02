package com.tlegramm_bot.politehtelegrambot.service;


import com.tlegramm_bot.politehtelegrambot.messgeTypes.HelpMessage;
import com.tlegramm_bot.politehtelegrambot.messgeTypes.MsgSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {


    private MsgSender msgSender;
    private HelpMessage helpMessage;
    private BotConfig botConfig;

    @Autowired
    public Bot(MsgSender msgSender, HelpMessage helpMessage, BotConfig botConfig) {
        this.msgSender = msgSender;
        this.helpMessage = helpMessage;
        this.botConfig = botConfig;
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

    @Override
    public String getBotToken() {
        return botConfig.getBotToken();
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }


}
