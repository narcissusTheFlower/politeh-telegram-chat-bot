package org.lev.vk;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import org.lev.utils.PropertiesLoader;

public class ActorInit {

    private static TransportClient transportClient = new HttpTransportClient();
    public static VkApiClient vk = new VkApiClient(transportClient);
    public static UserActor actor;

    public static void authorizeVk() throws ClientException, ApiException {
        UserAuthResponse authResponse = vk.oAuth()
                .userAuthorizationCodeFlow(
                       VkApiProperties.getVkClientId(),
                       VkApiProperties.getVkSecret(),
                        PropertiesLoader.getProperty("redirectUri"),
                        "39efeb5ffa0c9e2a1c")
                        //VkApiProperties.getVkCode()
                .execute();
     actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
    }
}
