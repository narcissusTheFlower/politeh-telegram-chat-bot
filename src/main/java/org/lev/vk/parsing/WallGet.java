package org.lev.vk.parsing;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.wall.GetFilter;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import org.lev.vk.ActorInit;

public class WallGet {

    public static String jsonString;

    public static String getPostsFromVKGroup(Integer groupId) {
        GetResponse getResponse;
        try {
            getResponse = ActorInit.vk.wall().get(ActorInit.actor)
                    //.ownerId(groupId) //main group
                    .ownerId(-216521484)
                    .count(2)
                    .offset(0)
                    .filter(GetFilter.ALL)
                    .extended(true)
                    .execute();
        } catch (ApiException | ClientException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Json from GetResponse\n" + getResponse);
        return jsonString = getResponse.toString();
    }
}
