package org.lev.messages.vkMessages;


import org.lev.utils.EmojiFactory;
import org.lev.utils.PropertiesLoader;
import org.lev.vk.VkApiProperties;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.spi.CalendarDataProvider;

public class AutomaticVkMsg extends SendMessage {


//    private static String ALERT_MSG = """
//            %exclamation В нашей группе ВК новый пост %dateNow %exclamation
//             %vkLink
//            """.replace("%exclamation", EmojiFactory.getExclamation())
//               .replace("%vkLink", PropertiesLoader.getProperty("ourGroup"));

private static String ALERT_MSG = "%exclamation В группе 09.03.02 - ИКНТ 2021 новый пост! (" + new Date() + (") %exclamation\n" +
                       "%link")
                       .replace("%exclamation",EmojiFactory.getExclamation()
                               .replace("%link",PropertiesLoader.getProperty("ourGroup")));

    public AutomaticVkMsg() {
        super(VkApiProperties.getTELEGRAM_CHAT_ID(), ALERT_MSG);
    }
}
