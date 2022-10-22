package org.lev.vk.parsing;

public class ParsingThread extends Thread {

    @Override
    public void run() {
        ScheduledGroupWallParse vkScheduledGroupParsingTimerTask = new ScheduledGroupWallParse();
            //There is a dangerous situation that an actor in VkInit might be null cos the VK method api call is made too fast, access token might be not set yet
        try {Thread.sleep(5000L);} catch (InterruptedException e) {throw new RuntimeException(e);}
        vkScheduledGroupParsingTimerTask.parseGroupWalls();
    }

}
