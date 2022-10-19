package org.lev.vk.parsing;

import org.lev.vk.VkApiProperties;
import org.lev.vk.parsing.alerting.NewPostAlert;
import java.util.Timer;
import java.util.TimerTask;
import static org.lev.vk.parsing.ParsedInfo.pojoMappedFromJson;

public final class ScheduledGroupWallParse {

    private final Long delay = 0L;
    private final Long period = 5000L;

    public void parseGroupWalls() {
        new Timer().schedule(repeatedTask, delay, period);
    }

    private final TimerTask repeatedTask = new TimerTask() {
        @Override
        public void run() {
            WallGet.getPostsFromVKGroup(VkApiProperties.getVK_GROUP_ID());
            pojoMappedFromJson();
            ParsedInfo.extractInnerClassInfoFrom();
            NewPostAlert.listenForNewPostsById(ParsedInfo.jsonParsedPostId);
        }
    };


}

