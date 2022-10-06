package com.telegram.politehtelegrambot.service;


import com.telegram.politehtelegrambot.messgeTypes.HelpMessage;
import com.telegram.politehtelegrambot.messgeTypes.InfoMessage;
import com.telegram.politehtelegrambot.messgeTypes.StudyPlanMessage;
import com.telegram.politehtelegrambot.messgeTypes.TeacherContactsMessage;
import com.telegram.politehtelegrambot.vk.VKInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class BotService extends TelegramLongPollingBot {

    private VKInit VKInit;

    private StudyPlanMessage studyPlanMessage;

    private HelpMessage helpMessage;

    private InfoMessage infoMessage;

    private BotProperties botProperties;

    private TeacherContactsMessage teacherContactsMessage;

    @Autowired
    public BotService(VKInit VKInit,
                      StudyPlanMessage studyPlanMessage,
                      HelpMessage helpMessage,
                      InfoMessage infoMessage,
                      BotProperties botProperties,
                      TeacherContactsMessage teacherContactsMessage) {
        this.VKInit = VKInit;
        this.studyPlanMessage = studyPlanMessage;
        this.helpMessage = helpMessage;
        this.infoMessage = infoMessage;
        this.botProperties = botProperties;
        this.teacherContactsMessage = teacherContactsMessage;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message incoming_message = update.getMessage();
        if (incoming_message != null && incoming_message.hasText()) {
            String command = incoming_message.getText();
            String setChatId = incoming_message.getChatId().toString();

            try {
                switch (command) {
                    case "/help":
                        execute(helpMessage.sendHelpMsg(setChatId));
                        break;
                    case "/info":
                        execute(infoMessage.sendInfoMsg(setChatId));
                        break;
                    case "/teachers":
                        execute(teacherContactsMessage.sendTeacherContactsMsg(setChatId));
                        break;
                    case "/plan":
                        execute(studyPlanMessage.sendPhotoPlanMsg(setChatId));
                        execute(studyPlanMessage.sendMessageWithPDFLink(setChatId));
                        break;
                    case "/subjects":

                        break;
                    case "/deadlines":

                        break;
                    case "/vk":
                        VKInit.parseWall();
                        break;
                }
            }catch (TelegramApiException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotToken() {
        return botProperties.getBotToken();
    }

    @Override
    public String getBotUsername() {
        return botProperties.getBotName();
    }


}
