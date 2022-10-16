package org.lev;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.lev.bot.BotInit;
import org.lev.bot.BotProperties;
import org.lev.utils.PropertiesLoader;
import org.lev.vk.ActorInit;


public class Main {

    public static void main(String[] args) throws ClientException, ApiException {
        PropertiesLoader.loadBotProperties("application.properties");
        BotProperties.setBotProperties();
        BotInit.registerBot();
        ActorInit.authorizeVk();
        //VkService.getPostsFromWall();
    }
}