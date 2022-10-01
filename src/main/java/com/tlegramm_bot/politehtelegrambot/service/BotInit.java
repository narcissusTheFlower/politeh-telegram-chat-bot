package com.tlegramm_bot.politehtelegrambot.service;

import com.tlegramm_bot.politehtelegrambot.messgeTypes.HelpMessage;
import com.tlegramm_bot.politehtelegrambot.messgeTypes.MsgSender;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class BotInit implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws TelegramApiException {
        var my_telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            my_telegramBotsApi.registerBot(new BotConfig(new MsgSender(), new HelpMessage()));
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
