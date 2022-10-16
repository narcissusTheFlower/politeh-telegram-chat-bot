package org.lev.vk;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import com.vk.api.sdk.objects.base.UserGroupFields;
import com.vk.api.sdk.objects.wall.GetFilter;
import com.vk.api.sdk.objects.wall.responses.GetResponse;

public class VkInit{

    //https://oauth.vk.com/access_token?client_id=51450107
    // &client_secret=hVFvbJn897bbfALVxYnk
    // &redirect_uri=https://oauth.vk.com/blank.html
    // &code=f2837ab2ebe3d70a81

    //https://api.vk.com/method/groups.get?owner_id=120159853&access_token=38fa46d4c0c10bab105c760cc44ed373c0bc6a34405931f34c765ea&v=5.78
//        Запрос к методам API состоит из шаблона: https://api.vk.com/method/{METHOD_NAME}?{PARAMETERS}&access_token={ACCESS_TOKEN}&v={V}\n" +
//                "где {METHODNAME} - имя метода\n" +
//                "{PARAMETERS} - параметры, индивидуальные, в зависимости от метода\n" +
//                "{ACCESS_TOKEN} - ранее сохранённый токен\n" +
//                "{V} - версия API (на момент написания статья = 5.78)

    private static TransportClient transportClient = new HttpTransportClient();
    protected static VkApiClient vk = new VkApiClient(transportClient);
    protected static UserActor actor;

    public static void authorizeVk() throws ClientException, ApiException {
        UserAuthResponse authResponse = vk.oAuth()
                .userAuthorizationCodeFlow(
                        51450107, //System.getenv("CLIENTID");
                        "hVFvbJn897bbfALVxYnk", //System.getenv("VKSECRET");
                        "https://oauth.vk.com/blank.html",
                        //чтоы получить этото конченый код надо из документации скорпировать ссылку для получения code и вбить под себя
                        //https://oauth.vk.com/authorize?client_id=51450107&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=offline,groups,wall&response_type=code&v=5.131
                        "e6ca617d0b01c9110e")
                .execute();
     actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
    }
}
