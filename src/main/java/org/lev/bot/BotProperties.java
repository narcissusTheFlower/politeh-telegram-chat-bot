package org.lev.bot;

public class BotProperties {

    private static String botToken;
    private static String botName;

    public static void setBotProperties(){
        setBotName();
        setBotToken();
    }

    public static String getBotToken() {
        return botToken;
    }

    public static String getBotName() {
        return botName;
    }

    private static void setBotToken() {
        BotProperties.botToken = System.getenv("BOT_TOKEN");
    }

    private static void setBotName() {
        BotProperties.botName = System.getenv("BOT_USERNAME");
    }
}
