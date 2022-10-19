package org.lev.vk.parsing.alerting;

import org.lev.bot.BotProperties;
import org.lev.messages.vkMessages.AutomaticVkMsg;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendAlert extends DefaultAbsSender {

    protected SendAlert(DefaultBotOptions options) {
        super(options);
        try {
            execute(new AutomaticVkMsg());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotToken() {
        return BotProperties.getBotToken();
    }
}
