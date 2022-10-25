package org.lev.messages.vkMessages;

import org.lev.utils.EmojiFactory;
import org.lev.utils.PropertiesLoader;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import java.util.Date;

public class AutomaticVkMsg extends SendMessage {
    //TODO add simple date formatter
    private final static Date dateNow = new Date();

    private final static String exclamation = EmojiFactory.getExclamation();
    private final static String envelopeWithArrow = EmojiFactory.getEnvelopeWithArrow();
    private final static String clock4= EmojiFactory.getClock4();
    private static String groupName;

    private static String ALERT_MSG = exclamation+ " " + envelopeWithArrow + " В группе" + groupName + " новый пост! " + envelopeWithArrow + " " + exclamation + "\n"+
            clock4 + dateNow + clock4 + "\n";
          //  PropertiesLoader.getProperty("ourGroup");

    public AutomaticVkMsg(String groupName) {
        super("-882685877", ALERT_MSG);
        AutomaticVkMsg.groupName = groupName;
    }
}
