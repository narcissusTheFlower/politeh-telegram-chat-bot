package com.telegram.politehtelegrambot.messgeTypes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import java.util.List;


@Component
public class StudyPlanMessage {
    @Value("${pic1}")
    private String picUrl1;
    @Value("${pic2}")
    private String picUrl2;
    @Value("${pic3}")
    private String picUrl3;
    @Value("${pic4}")
    private String picUrl4;

//    private final InputMediaPhoto photo1 = new InputMediaPhoto(picUrl1);
//    private final InputMediaPhoto photo2 = new InputMediaPhoto(picUrl2);
//    private final InputMediaPhoto photo3 = new InputMediaPhoto(picUrl3);
//    private final InputMediaPhoto photo4 = new InputMediaPhoto(picUrl4);
    //private final List<InputMedia> mediaGroupPhoto = List.of(new InputMediaPhoto(picUrl2));


    private java.util.Date today = new java.util.Date();
     public SendPhoto sendPhotoPlanMsg(String chatId) {
          SendPhoto message = new SendPhoto();
          message.setChatId(chatId);
          message.setCaption("Сегодня: " + today.toString());
          message.setPhoto(new InputFile(picUrl1));
//          SendMediaGroup mediaGroup = new SendMediaGroup();
//          mediaGroup.setMedias(mediaGroupPhoto);
//          mediaGroup.setChatId(chatId);
          return message;
     }

}
