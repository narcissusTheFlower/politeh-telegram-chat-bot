package org.lev.vk.parsing;

public class ParsingThread extends Thread {

    @Override
    public void run() {
        var vkScheduledGroupParsingTimerTask =
                new ScheduledGroupWallParse();
        try {
            //There is a dangerous situation that an actor in VkInit might be null cos the VK api call is made too fast, access token might be not set yet
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        vkScheduledGroupParsingTimerTask.parseGroupWalls();
    }
}
