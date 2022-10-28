package com.telegram.politehtelegrambot.messages;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;

import java.util.ArrayList;
import java.util.List;


@Component
public class StudyPlanPdfMessage extends SendMessage{

    private static String staticPdfUrl;

     static private List<MessageEntity> getConfiguredLink(){
         MessageEntity messageEntity = new MessageEntity();
         messageEntity.setType("text_link");
         messageEntity.setUrl(staticPdfUrl);
         messageEntity.setOffset(0);
         messageEntity.setLength(18);
         List<MessageEntity> entitiesList = new ArrayList<>();
         entitiesList.add(messageEntity);
         return entitiesList;
     }

     public StudyPlanPdfMessage() {

     }

    // WTF Spring, but works
    @Autowired
     public void setPdfStatic(@Value("${pdfLink}") String pdfURL){
        staticPdfUrl = pdfURL;
     }

    public StudyPlanPdfMessage(String chatId){
        super(chatId,"Скачать полный PDF");
        this.setEntities(getConfiguredLink());
    }
}
