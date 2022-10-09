package com.telegram.politehtelegrambot.vk;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.springframework.stereotype.Component;

@Component
public class VKInit {

    private final String vkToken = System.getenv("VKTOKEN");

    private final Integer vkId =Integer.parseInt(System.getenv("VKID"));

    TransportClient transportClient = new HttpTransportClient();
    VkApiClient vk = new VkApiClient(transportClient);

    public UserActor getUserActor(){
        UserActor userActor = new UserActor(vkId, vkToken);
        return userActor;
    }

    public String parseWall(){
        return null;
    }
}
