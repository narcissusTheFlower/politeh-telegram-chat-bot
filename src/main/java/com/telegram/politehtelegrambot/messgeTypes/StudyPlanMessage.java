package com.telegram.politehtelegrambot.messgeTypes;


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
public class StudyPlanMessage{

    @Value("${pic1}")
    private String picUrl1;
    @Value("${pic2}")
    private String picUrl2;
    @Value("${pic3}")
    private String picUrl3;
    @Value("${pic4}")
    private String picUrl4;
    @Value("${pdfLink}")
    private String pdfURL;

     public SendMediaGroup sendPhotoPlanMsg(String chatId) {
          List <InputMedia> photoList = List.of(
                  new InputMediaPhoto(picUrl1),
                  new InputMediaPhoto(picUrl2),
                  new InputMediaPhoto(picUrl3),
                  new InputMediaPhoto(picUrl4)
                  );
          SendMediaGroup mediaGroup = new SendMediaGroup();
          mediaGroup.setMedias(photoList);
          mediaGroup.setChatId(chatId);
          return mediaGroup;
     }

     public SendMessage sendMessageWithPDFLink(String chatId){
         SendMessage messageToBeSent = new SendMessage();
         messageToBeSent.setChatId(chatId);
         messageToBeSent.setEntities(getConfiguredLink());
         messageToBeSent.setText("Скачать полный PDF");
         return messageToBeSent;
     }

     private List<MessageEntity> getConfiguredLink(){
         MessageEntity messageEntity = new MessageEntity();
         messageEntity.setType("text_link");
         messageEntity.setUrl(pdfURL);
         messageEntity.setOffset(0);
         messageEntity.setLength(18);
         List<MessageEntity> entitiesList = new ArrayList<>();
         entitiesList.add(messageEntity);
         return entitiesList;
     }
}
