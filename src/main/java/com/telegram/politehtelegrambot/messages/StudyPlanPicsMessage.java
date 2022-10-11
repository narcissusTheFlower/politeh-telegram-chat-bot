package com.telegram.politehtelegrambot.messages;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;

import java.util.List;


@Component
public class StudyPlanPicsMessage extends SendMediaGroup{

    static private String staticPicUrl1;

    static private String staticPicUrl2;
    static private String staticPicUrl3;
    static private String staticPicUrl4;

    static private  List <InputMedia> photoList() {
        List <InputMedia> list = List.of(
                new InputMediaPhoto(staticPicUrl1),
                new InputMediaPhoto(staticPicUrl2),
                new InputMediaPhoto(staticPicUrl3),
                new InputMediaPhoto(staticPicUrl4)
        );
        return list;
     }

    public StudyPlanPicsMessage() {
    }

    @Autowired
     private void setPics(@Value("${pic1}") String picUrl1,
                          @Value("${pic2}") String picUrl2,
                          @Value("${pic3}") String picUrl3,
                          @Value("${pic4}") String picUrl4){

         staticPicUrl1 = picUrl1;
         staticPicUrl2 = picUrl2;
         staticPicUrl3 = picUrl3;
         staticPicUrl4 = picUrl4;
     }
    public StudyPlanPicsMessage(String chatId){
        super(chatId,photoList());
    }
}
