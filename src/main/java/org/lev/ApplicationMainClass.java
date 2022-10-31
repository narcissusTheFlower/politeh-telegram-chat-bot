package org.lev;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.lev.bot.BotInit;
import org.lev.bot.BotProperties;
import org.lev.utils.PropertiesLoader;
import org.lev.vk.ActorInit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationMainClass {

    private static Logger logger = LoggerFactory.getLogger(ApplicationMainClass.class);

    public static void main(String[] args) throws ClientException, ApiException {
        logger.info("Application is starting up...");
        PropertiesLoader.loadBotProperties("application.properties");
        BotProperties.setBotProperties();
        BotInit.registerBot();
        ActorInit.authorizeVk();
    }
}