package com.telegram.politehtelegrambot.service;

import com.telegram.politehtelegrambot.vk.VKInit;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class BotInit implements InitializingBean {

    private BotService botService;

    private VKInit vkInit;

    @Autowired
    public BotInit(BotService botService, VKInit vkInit) {
        this.botService = botService;
        this.vkInit = vkInit;
    }

    @Override
    public void afterPropertiesSet() throws TelegramApiException  {
        connectTelegramBot();
    }

    private void connectTelegramBot() throws TelegramApiException{
        TelegramBotsApi my_telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            my_telegramBotsApi.registerBot(botService);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
