package org.lev.vk.apiMethods;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.wall.GetFilter;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import org.lev.vk.ActorInit;

public class WallGetRequest {

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

    public String wallGetRequest(){
        GetResponse getResponse;
        try {
            getResponse = ActorInit.vk.wall().get(ActorInit.actor)
                    .ownerId(groupId) //segrei vk group, its passed from above
                    // .ownerId(-216521484) //my vk group
                    .count(count)
                    .offset(offset)
                    .filter(filter)
                    .extended(isExtended)
                    .execute();
        } catch (ApiException | ClientException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Json from GetResponse\n" + getResponse);
        return jsonString = getResponse.toString();
    }
}
