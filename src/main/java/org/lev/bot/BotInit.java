package org.lev.bot;

import org.lev.Main;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BotInit {

    static Logger logger = Logger.getLogger(BotInit.class.getName());
    private static PolitehLongPollingBot plg = new PolitehLongPollingBot();

    public static void registerBot(){
        try{
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(plg);
            logger.log(Level.FINE,"App started");
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
