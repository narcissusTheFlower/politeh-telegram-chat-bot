package org.lev.vk.parsing;

import org.lev.utils.EmojiFactory;
import org.lev.utils.PropertiesLoader;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.io.Serializable;

public abstract class NewPostAlert extends AbsSender {

    private static Integer lastPostId;

    private static final String ALERT_MSG = """
            %exclamation В нашей группе ВК новый пост %exclamation
            %vkLink
            """. replace("%exclamation",EmojiFactory.getExclamation())
            .replace("%vkLink", PropertiesLoader.getProperty("ourGroup"));

    public void listenForNewPosts(Integer parsedPostId){
        if (lastPostId == null){
            lastPostId = parsedPostId;
        }else if (!(lastPostId.equals(parsedPostId))){
            sendAlert();
        }
    }

    private void sendAlert(){
        try {
            execute(new SendMessage("476514894",ALERT_MSG)); //мой чат
            //execute(new SendMessage(System.getenv("TELEGRAM_CHAT_ID"),ALERT_MSG)); общий чат икнт
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public <T extends Serializable, Method extends BotApiMethod<T>> T execute(Method method) throws TelegramApiException {
        return super.execute(method);
    }
}
