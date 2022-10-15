package org.lev.messages;

import org.lev.utils.PropertiesLoader;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;

import java.io.File;
import java.util.List;

public class PlanMsg extends SendMediaGroup {

    public PlanMsg(String chatId){
        super(chatId, List.of(
                new InputMediaPhoto(PropertiesLoader.getProperty("pic1")),
                new InputMediaPhoto(PropertiesLoader.getProperty("pic2")),
                new InputMediaPhoto(PropertiesLoader.getProperty("pic3")),
                new InputMediaPhoto(PropertiesLoader.getProperty("pic4"))
        ));
    }
}
