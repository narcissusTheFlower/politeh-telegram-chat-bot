package org.lev.vk.parsing;

import org.lev.vk.parsing.DTO.WallDTO;
import org.lev.vk.parsing.alerting.SendAlert;
import org.lev.vk.parsing.apiMethods.WallGetRequest;
import org.lev.vk.parsing.DTO.VkGroupDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.DefaultBotOptions;

public class ParseCycle {

    private static Logger logger = LoggerFactory.getLogger(ParseCycle.class);
    private VkGroupDTO group;

    private WallGetRequest wallGetRequest = new WallGetRequest();
    private GsonMapping gsonMapping = new GsonMapping();

    public ParseCycle(VkGroupDTO group) {
        this.group = group;
    }

    public void initCycle() {
        compareDates();
    }

    private void compareDates() {
        Long newPostDate = getDateFromPojo();
        if (group.getCurrentPostDate() == null) {
            logger.info("First 'date' came in from " + group.getName() + " ;");
            group.setCurrentPostDate(newPostDate);
        } else if (group.getCurrentPostDate() < newPostDate) {
            logger.info("New 'date' came in from " + group.getName() + ", must send an alert;");
            new SendAlert(new DefaultBotOptions(), group.getGroupId());
            group.setCurrentPostDate(newPostDate);
        } else if (group.getCurrentPostDate() > newPostDate) {
            logger.info("Post was deleted in " + group.getName() + ", rewrite 'date' field;");
            group.setCurrentPostDate(newPostDate);
        }
    }

    private Long getDateFromPojo() {
        WallDTO pojo = createPojo();
        return gsonMapping.extractInnerClassInfoFrom(pojo);
    }

    private WallDTO createPojo() {
        String json = makeGetRequest();
        return gsonMapping.returnPojoMappedFromJson(json);
    }

    private String makeGetRequest() {
        return wallGetRequest.wallGet(group.getGroupId());
    }
}
