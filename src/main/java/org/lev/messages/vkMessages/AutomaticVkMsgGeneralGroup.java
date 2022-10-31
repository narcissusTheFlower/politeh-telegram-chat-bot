package org.lev.messages.vkMessages;

import org.lev.utils.EmojiFactory;
import org.lev.vk.VkApiProperties;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.Date;

public class AutomaticVkMsgGeneralGroup extends SendMessage {

    private final static Date dateNow = new Date();    //TODO add simple date formatter

    private final static String exclamation = EmojiFactory.getExclamation();
    private final static String envelopeWithArrow = EmojiFactory.getEnvelopeWithArrow();
    private final static String clock4= EmojiFactory.getClock4();

    private static  String ALERT_MSG = exclamation + " " + envelopeWithArrow + " В группе 'Заочное отделение ИКНТ СПбПУ' новый пост! " + envelopeWithArrow + " " + exclamation + "\n"+
            clock4 + dateNow + clock4 + "\n"+
            "https://vk.com/obuchenie_iknt_zaochnyi";
            //PropertiesLoader.getProperty("ourGroup"); TODO does not work for some reason

    public AutomaticVkMsgGeneralGroup() {
        super(VkApiProperties.getTelegramChatId(), ALERT_MSG);
    }
}