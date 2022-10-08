package com.telegram.politehtelegrambot.telegram.bot;


import com.telegram.politehtelegrambot.messgeTypes.*;
import com.telegram.politehtelegrambot.vk.VKInit;
import com.telegram.politehtelegrambot.vk.VkApiCalls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class BotService extends TelegramLongPollingBot {

    private DefaultMessage defaultMessage;
    private VKInit VKInit;
    private StudyPlanMessage studyPlanMessage;
    private GreetingMessage greetingMessage;
    private HelpMessage helpMessage;
    private InfoMessage infoMessage;
    private BotProperties botProperties;
    private TeacherContactsMessage teacherContactsMessage;
    private UseFullLinksMessage useFullLinksMessage;

    @Autowired
    public BotService(VKInit VKInit,
                      StudyPlanMessage studyPlanMessage,
                      HelpMessage helpMessage,
                      InfoMessage infoMessage,
                      BotProperties botProperties,
                      TeacherContactsMessage teacherContactsMessage,
                      GreetingMessage greetingMessage,
                      DefaultMessage defaultMessage,
                      UseFullLinksMessage useFullLinksMessage) {
        this.VKInit = VKInit;
        this.studyPlanMessage = studyPlanMessage;
        this.helpMessage = helpMessage;
        this.infoMessage = infoMessage;
        this.botProperties = botProperties;
        this.teacherContactsMessage = teacherContactsMessage;
        this.greetingMessage =greetingMessage;
        this.defaultMessage = defaultMessage;
        this.useFullLinksMessage = useFullLinksMessage;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message incoming_message = update.getMessage();
        if (incoming_message != null && incoming_message.hasText()) {
            String command = incoming_message.getText();
            String setChatId = incoming_message.getChatId().toString();
            try {
                switch (command) {
                    case "/start":
                        execute(greetingMessage.sendGreetingMsg(setChatId));
                        break;
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
                    case "/links":
                        execute(useFullLinksMessage.sendLinksMsg(setChatId));
                        break;
                    case "/vk":
                        //VKInit.parseWall();
                        VkApiCalls.soutresult();
                        break;
                    default: execute(defaultMessage.sendDefaultMsg(setChatId));
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
