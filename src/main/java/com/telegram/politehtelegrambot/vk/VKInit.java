package com.telegram.politehtelegrambot.vk;

import com.telegram.politehtelegrambot.service.BotProperties;
import com.vk.api.sdk.actions.Wall;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VKInit {

    private String vkToken = System.getenv("vk.token");

    private Integer vkId =Integer.parseInt(System.getenv("vk.id"));

    TransportClient transportClient = new HttpTransportClient();
    VkApiClient vk = new VkApiClient(transportClient);

    public UserActor getUserActor(){
        UserActor userActor = new UserActor(vkId, vkToken);
        System.out.println(userActor.getAccessToken());
        return userActor;
    }

    public String parseWall(){
        System.out.println(vk.wall().get(getUserActor()));
        return null;
    }
}
