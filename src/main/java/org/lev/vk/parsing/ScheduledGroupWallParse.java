package org.lev.vk.parsing;

import org.lev.vk.VkApiProperties;
import org.lev.vk.parsing.DTO.StableVkGroup;
import org.lev.vk.parsing.DTO.VkGroupDTO;
import java.util.Timer;
import java.util.TimerTask;

public final class ScheduledGroupWallParse {


    //-216521484 my vk group
    //-207600346 serega vk group
    private final Long delay = 0L;
    private final Long period = 5000L;
    private StableVkGroup stableVkGroup = new StableVkGroup("OUR_VK_GROUP",-216521484);
    private StableVkGroup testkGroup = new StableVkGroup("testGroup",-216696601);
    public void parseGroupWalls() {
        new Timer().schedule(repeatedTask, delay, period);
    }

    private final TimerTask repeatedTask = new TimerTask() {
        @Override
        public void run() {
            new ParseCycle(stableVkGroup).initCycle();
            new ParseCycle(testkGroup).initCycle();
        }
    };


}

