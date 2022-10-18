package org.lev.messages;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class VkMsg extends SendMessage {

    public VkMsg(String chatId, String text) {
        super(chatId, NEW_VK_POST);
    }

    private static final String NEW_VK_POST = """
            //text here
            """;
}
