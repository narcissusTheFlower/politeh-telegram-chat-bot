package org.lev.vk;

import java.util.Timer;
import java.util.TimerTask;

public final class ScheduledGroupParsingTimerTask {

    private final Long delay = 0L;
    private final Long period = 5000L;
    public void parseGroupWalls() {
        new Timer().schedule(task, delay, period);
    }

    private final TimerTask task = new TimerTask() {
        @Override
        public void run() {
            GroupParsingMethods.getPostsFromSergeiGroup();
        }
    };
}
