package org.lev.bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class BotInit {

    private static PolitehLongPollingBot plg = new PolitehLongPollingBot();

    public static void registerBot(){
        try{
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(plg);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
