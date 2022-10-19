package org.lev.vk.parsing.alerting;

import org.telegram.telegrambots.bots.DefaultBotOptions;

public class NewPostAlert{

    private static Integer lastPostId;

    public static void listenForNewPosts(Integer parsedPostId){
        if (lastPostId == null){
            lastPostId = parsedPostId;
        }else if (!(lastPostId.equals(parsedPostId))){
            System.out.println("new id detected, message should be sent");
          new SendAlert(new DefaultBotOptions());
          lastPostId = parsedPostId;
        }
    }
}
