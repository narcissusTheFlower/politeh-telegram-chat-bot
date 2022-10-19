package org.lev.vk.parsing.alerting;

import org.lev.bot.BotProperties;
import org.lev.messages.vkMessages.AutomaticVkMsg;
import org.lev.utils.EmojiFactory;
import org.lev.utils.PropertiesLoader;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
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
