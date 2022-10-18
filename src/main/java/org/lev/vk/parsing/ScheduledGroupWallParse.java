package org.lev.vk.parsing;

import java.util.Timer;
import java.util.TimerTask;

public final class ScheduledGroupWallParse {

    private final Long delay = 0L;
    private final Long period = 5000L;

    public void parseGroupWalls() {
        new Timer().schedule(repeatedTask, delay, period);
    }

    private final TimerTask repeatedTask = new TimerTask() {
        @Override
        public void run() {
            ParsingMethods.getPostsFromVKGroup(-207600346);
            ParsedInfo.mapToPojo();

            //listenForNewPosts(ParsedInfo.lastParsedPostId);
        }
    };
}

