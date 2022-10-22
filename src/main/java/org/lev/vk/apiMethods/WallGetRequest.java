package org.lev.vk.apiMethods;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.wall.GetFilter;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import org.lev.vk.ActorInit;
import org.lev.vk.parsing.ParsedInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class WallGetRequest {

    private static Logger logger = LoggerFactory.getLogger(WallGetRequest.class);

    private static final Set<Integer> groups = Set.of(
            Integer.parseInt(System.getenv("VK_GROUP_ID")),
            Integer.parseInt(System.getenv("VK_GROUP_ID_GENERAL"))
    );

    public static String jsonString;

    private Integer groupId;
    private Integer count;
    private Integer offset;
    private GetFilter filter;
    private Boolean isExtended;

    public WallGetRequest(Integer groupId, Integer count, Integer offset, GetFilter filter, Boolean isExtended) {
        this.groupId = groupId;
        this.count = count;
        this.offset = offset;
        this.filter = filter;
        this.isExtended = isExtended;
        wallGetRequest();
    }

//    public static final Set<String> parseGroups(){
//        for (Integer groupId: groups
//             ) {
//
//        } ()
//        return null;
//    }

    public String wallGetRequest(){
        GetResponse getResponse;
        try {
            getResponse = ActorInit.vk.wall().get(ActorInit.actor)
                    .ownerId(groupId)
                    // .ownerId(-216521484) //my vk group
                    .count(count)
                    .offset(offset)
                    .filter(filter)
                    .extended(isExtended)
                    .execute();
        } catch (ApiException | ClientException e) {
            throw new RuntimeException(e);
        }
        return jsonString = getResponse.toString();
    }
}
