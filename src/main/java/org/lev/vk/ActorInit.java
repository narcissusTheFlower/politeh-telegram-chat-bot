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
                        Integer.valueOf(System.getenv("VKCLIENTID")),
                        System.getenv("VKSECRET"),
                        PropertiesLoader.getProperty("redirectUri"),
                        //https://oauth.vk.com/authorize?client_id=51450107&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=offline,groups,wall&response_type=code&v=5.131
                        //TODO hide this
                        "da1e3681ceaffccac3")
                .execute();
     actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
    }
}
