package org.lev.vk.parsing.apiMethods;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.wall.GetFilter;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import org.lev.vk.ActorInit;

public class WallGetRequest {

    private Integer count = 2;
    private Integer offset = 0;
    private GetFilter filter = GetFilter.ALL;
    private Boolean isExtended = true;

    public String wallGet(Integer groupId){
        GetResponse getResponse;
        try {
            getResponse = ActorInit.vk.wall().get(ActorInit.actor)
                    .ownerId(groupId)
                    .count(count)
                    .offset(offset)
                    .filter(filter)
                    .extended(isExtended)
                    .execute();
        } catch (ApiException | ClientException e) {
            throw new RuntimeException(e);
        }
        return getResponse.toString();
    }
}
