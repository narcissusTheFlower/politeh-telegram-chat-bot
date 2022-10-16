package org.lev.vk;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.wall.GetFilter;
import com.vk.api.sdk.objects.wall.responses.GetResponse;

public class GroupParsingMethods {

    public static void getPostsFromSergeiGroup() {
        GetResponse getResponse;
        try {
            getResponse = ActorInit.vk.wall().get(ActorInit.actor)
                    .ownerId(-207600346)
                    .count(100)
                    .offset(1)
                    .filter(GetFilter.OWNER)
                    .execute();
        } catch (ApiException | ClientException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getResponse);
    }
}
