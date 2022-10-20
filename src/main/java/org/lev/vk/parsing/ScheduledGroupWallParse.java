package org.lev.vk.parsing;

import com.vk.api.sdk.objects.wall.GetFilter;
import org.lev.vk.VkApiProperties;
import org.lev.vk.apiMethods.WallGetRequest;
import org.lev.vk.parsing.alerting.NewPostListener;
import java.util.Timer;
import java.util.TimerTask;
import static org.lev.vk.parsing.ParsedInfo.returnPojoMappedFromJson;

public final class ScheduledGroupWallParse {

    private final Long delay = 0L;
    private final Long period = 5000L;

    public void parseGroupWalls() {
        new Timer().schedule(repeatedTask, delay, period);
    }

    private final TimerTask repeatedTask = new TimerTask() {
        @Override
        public void run() {
            new WallGetRequest(
                    VkApiProperties.getVK_GROUP_ID(),
                    2,
                    0,
                    GetFilter.ALL,
                    true
            );
            returnPojoMappedFromJson();
            ParsedInfo.extractInnerClassInfoFromPojo();
            NewPostListener.listenForNewPostsById(ParsedInfo.jsonParsedPostId);
        }
    };


}

