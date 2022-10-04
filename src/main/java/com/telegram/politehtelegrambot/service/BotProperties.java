package com.telegram.politehtelegrambot.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;

@Component
@Data
@PropertySource("classpath:application.properties")
public class BotProperties {

    @Value("${bot.username}")
    private String botName;
    @Value("${bot.token}")
    private String botToken;

    //Files for StudyPlanMessage class
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

    //For TeacherContactsMessage class
    @Value("${teacherContacts}")
    private String teacherContactsURL;

    //VK API
    @Value("${vk.token}")
    private String vkToken;
    @Value("${vk.id}")
    private Integer vkId;
}
