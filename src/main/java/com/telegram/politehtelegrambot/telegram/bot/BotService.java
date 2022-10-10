package com.telegram.politehtelegrambot.telegram.bot;

import com.telegram.politehtelegrambot.commandTypes.*;
import com.telegram.politehtelegrambot.utils.CommandTypeDecider;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
        Message incoming_message = update.getMessage();
        String setChatId = incoming_message.getChatId().toString();
                switch (CommandTypeDecider.decideCommandFrom(incoming_message)) {
                    case START:
                        execute(new GreetingMessage().sendGreetingMsg(setChatId));
                        break;
                    case HELP:
                        execute(new HelpMessage().sendHelpMsg(setChatId));
                        break;
                    case INFO:
                        execute(new InfoMessage().sendInfoMsg(setChatId));
                        break;
                    case TEACHERS_CONTACTS:
                        execute(new TeacherContactsMessage().sendTeacherContactsMsg(setChatId));
                        break;
                    case PLAN:
                        execute(studyPlanMessage.sendPhotoPlanMsg(setChatId));
                        execute(studyPlanMessage.sendMessageWithPDFLink(setChatId));
                        break;
                    case LINKS:
                        execute(new UseFullLinksMessage().sendLinksMsg(setChatId));
                        break;
                    case VK:
                        //VKInit.parseWall();
                        break;
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
