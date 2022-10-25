package org.lev.vk.parsing;

import org.lev.vk.VkApiProperties;
import org.lev.vk.parsing.DTO.VkGroupDTO;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public final class ScheduledGroupWallParse {


    //-216521484 my vk group
    //-207600346 serega vk group
    private final Long delay = 0L;
    private final Long period = 5000L;

    private final static Map<String,VkGroupDTO> mapOfParsedGroups = Map.of(
            "ourVkGroup", new VkGroupDTO("ourVkGroup",VkApiProperties.getOurVkGroupId()),
            "generalVkGroup", new VkGroupDTO("generalVkGroup",VkApiProperties.getGeneralVkGroupId()),
            "test", new VkGroupDTO("test",-216521484)
    );

    public void parseGroupWalls() {
        new Timer().schedule(repeatedTask, delay, period);
    }

    private final TimerTask repeatedTask = new TimerTask() {
        @Override
        public void run() {
            new ParseCycle(mapOfParsedGroups.get("ourVkGroup")).initCycle();
            new ParseCycle(mapOfParsedGroups.get("generalVkGroup")).initCycle();
            new ParseCycle(mapOfParsedGroups.get("test")).initCycle();
        }
    };


}

