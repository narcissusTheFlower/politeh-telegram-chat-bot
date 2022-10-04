package com.telegram.politehtelegrambot.vk;

import com.telegram.politehtelegrambot.service.BotProperties;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VKInit {

    private BotProperties botProperties;

    @Autowired
    public VKInit(BotProperties botProperties) {
        this.botProperties = botProperties;
    }

    TransportClient transportClient = new HttpTransportClient();
    VkApiClient vk = new VkApiClient(transportClient);

    public void connectToVKApi(){
        UserActor userActor = new UserActor(botProperties.getVkId(), botProperties.getBotToken());
        System.out.println(userActor.getAccessToken());
    }

    public String parseWall(){

        return null;
    }
}
