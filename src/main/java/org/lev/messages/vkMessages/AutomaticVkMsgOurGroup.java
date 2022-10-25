package org.lev.messages.vkMessages;

import org.lev.utils.EmojiFactory;
import org.lev.utils.PropertiesLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import java.util.Date;

public class AutomaticVkMsgOurGroup extends SendMessage {

    private final static Date dateNow = new Date();    //TODO add simple date formatter

    private final static String exclamation = EmojiFactory.getExclamation();
    private final static String envelopeWithArrow = EmojiFactory.getEnvelopeWithArrow();
    private final static String clock4= EmojiFactory.getClock4();

    private static String ALERT_MSG = exclamation + " " + envelopeWithArrow + " В группе '09.03.02 - ИКНТ 2021' новый пост! " + envelopeWithArrow + " " + exclamation + "\n"+
            clock4 + dateNow + clock4 + "\n"+
            "https://vk.com/iknt090302";
            //PropertiesLoader.getProperty("ourGroup"); TODO does not work for some reason

    public AutomaticVkMsgOurGroup() {
        super("-882685877", ALERT_MSG);
    }
}
