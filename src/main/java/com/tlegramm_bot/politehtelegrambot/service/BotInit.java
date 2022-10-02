package com.tlegramm_bot.politehtelegrambot.service;

import com.tlegramm_bot.politehtelegrambot.messgeTypes.HelpMessage;
import com.tlegramm_bot.politehtelegrambot.messgeTypes.MsgSender;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class BotInit implements InitializingBean {

    @Autowired
    Bot bot;
    @Override
    public void afterPropertiesSet() throws TelegramApiException {
        var my_telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            my_telegramBotsApi.registerBot(bot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
