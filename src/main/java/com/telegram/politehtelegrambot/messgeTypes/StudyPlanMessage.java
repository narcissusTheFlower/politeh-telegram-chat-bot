package com.telegram.politehtelegrambot.messgeTypes;

import com.telegram.politehtelegrambot.service.BotProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import java.util.ArrayList;
import java.util.List;


@Component
public class StudyPlanMessage{

    private final BotProperties botProperties;

    @Autowired
    public StudyPlanMessage(BotProperties botProperties) {
        this.botProperties = botProperties;
    }

     public SendMediaGroup sendPhotoPlanMsg(String chatId) {
          List <InputMedia> photoList = List.of(
                  new InputMediaPhoto(botProperties.getPicUrl1()),
                  new InputMediaPhoto(botProperties.getPicUrl2()),
                  new InputMediaPhoto(botProperties.getPicUrl3()),
                  new InputMediaPhoto(botProperties.getPicUrl4())
                  );
          SendMediaGroup mediaGroup = new SendMediaGroup();
          mediaGroup.setMedias(photoList);
          mediaGroup.setChatId(chatId);
          return mediaGroup;
     }

     public SendMessage sendMessageWithPDFLink(String chatId){
         SendMessage message = new SendMessage();
         message.setChatId(chatId);
         message.setEntities(getConfiguredLink());
         message.setText("Скачать полный PDF");
         return message;
     }

     private List<MessageEntity> getConfiguredLink(){
         MessageEntity messageEntity = new MessageEntity();
         messageEntity.setType("text_link");
         messageEntity.setUrl(botProperties.getPdfURL());
         messageEntity.setOffset(0);
         messageEntity.setLength(18);
         List<MessageEntity> entitiesList = new ArrayList<>();
         entitiesList.add(messageEntity);
         return entitiesList;
     }
}
