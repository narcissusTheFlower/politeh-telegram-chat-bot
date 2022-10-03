package com.telegram.politehtelegrambot.vk;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import org.springframework.stereotype.Component;

@Component
public class LoginVK {
    TransportClient transportClient = new HttpTransportClient();
    VkApiClient vk = new VkApiClient(transportClient);

    private void authenticate(){

        UserAuthResponse authResponse = vk.oAuth()
                .userAuthorizationCodeFlow()
                .execute();
    }
}
