package com.telegram.politehtelegrambot.telegram.bot;

import com.telegram.politehtelegrambot.messgeTypes.*;
import com.telegram.politehtelegrambot.vk.VkApiCalls;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class BotService extends TelegramLongPollingBot {

    private BotProperties botProperties;

    private StudyPlanMessage studyPlanMessage;   //I have to create this object as POJO, otherwise links are not instantiated(i think)

    @Autowired
    public BotService(BotProperties botProperties, StudyPlanMessage studyPlanMessage) throws TelegramApiException {
        this.botProperties = botProperties;
        this.studyPlanMessage = studyPlanMessage;
        execute(BotMenu.activateMenu());
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        BotMsgSender.updateNotNull(update);
        Message incoming_message = update.getMessage();
        String setChatId = incoming_message.getChatId().toString();
                switch (incoming_message.getText()) {
                    case "/start":
                        execute(new GreetingMessage().sendGreetingMsg(setChatId));
                        break;
                    case "/help":
                        execute(new HelpMessage().sendHelpMsg(setChatId));
                        break;
                    case "/info":
                        execute(new InfoMessage().sendInfoMsg(setChatId));
                        break;
                    case "/teachers":
                        execute(new TeacherContactsMessage().sendTeacherContactsMsg(setChatId));
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
                        execute(new UseFullLinksMessage().sendLinksMsg(setChatId));
                        break;
                    case "/vk":
                        //VKInit.parseWall();
                        VkApiCalls.soutresult();
                        break;
                    default: execute(new DefaultMessage().sendDefaultMsg(setChatId));
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
