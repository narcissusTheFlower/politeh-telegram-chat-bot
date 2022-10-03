package com.telegram.politehtelegrambot.messgeTypes;

import com.telegram.politehtelegrambot.service.BotProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;

import java.util.ArrayList;
import java.util.List;


@Component
public class TeacherContactsMessage {

    private BotProperties botProperties;

    @Autowired
    public TeacherContactsMessage(BotProperties botProperties) {
        this.botProperties = botProperties;
    }

    public SendMessage sendTeacherContactsMsg(String chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Контакты преподавателей:\n https://vk.com/@iknt090302-kontakty-po-uchebnym-voprosam");
        //message.setEntities(getConfiguredLink());
        return message;
    }

    private List<MessageEntity> getConfiguredLink(){
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setType("text_link");
        messageEntity.setUrl(botProperties.getTeacherContactsURL());
        messageEntity.setOffset(0);
        messageEntity.setLength(23);
        List<MessageEntity> entitiesList = new ArrayList<>();
        entitiesList.add(messageEntity);
        return entitiesList;
    }

}
