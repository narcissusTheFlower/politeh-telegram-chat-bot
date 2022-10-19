package org.lev.messages.vkMessages;


import org.lev.utils.EmojiFactory;
import org.lev.utils.PropertiesLoader;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class AutomaticVkMsg extends SendMessage {

    private static final String ALERT_MSG = """
            %exclamation В нашей группе ВК новый пост %exclamation
            %vkLink
            """. replace("%exclamation", EmojiFactory.getExclamation())
            .replace("%vkLink", PropertiesLoader.getProperty("ourGroup"));

    public AutomaticVkMsg() {
        super("-882685877", ALERT_MSG);
    }

}
