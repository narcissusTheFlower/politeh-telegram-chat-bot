package org.lev.vk.parsing.alerting;

import org.lev.bot.BotProperties;
import org.lev.messages.vkMessages.AutomaticVkMsgGeneralGroup;
import org.lev.messages.vkMessages.AutomaticVkMsgOurGroup;
import org.lev.vk.VkApiProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendAlert extends DefaultAbsSender {

    private static Logger logger = LoggerFactory.getLogger(SendAlert.class);

    //TODO BAD IF STATEMENT FIX ME
    public SendAlert(DefaultBotOptions options, Integer groupId) {
        super(options);
        try {
            if (groupId.equals(VkApiProperties.getOurVkGroupId())){
                execute(new AutomaticVkMsgOurGroup());
            }else {
                execute(new AutomaticVkMsgGeneralGroup());
            }
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotToken() {
        return BotProperties.getBotToken();
    }
}
