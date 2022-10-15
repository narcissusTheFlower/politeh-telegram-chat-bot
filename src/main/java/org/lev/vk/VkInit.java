package org.lev.vk;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;

public class VkInit {

    //https://oauth.vk.com/access_token?client_id=51450107
    // &client_secret=hVFvbJn897bbfALVxYnk
    // &redirect_uri=https://oauth.vk.com/blank.html
    // &code=f2837ab2ebe3d70a81

    //https://oauth.vk.com/authorize?client_id={CLIENT_ID}
    // &display=page
    // &redirect_uri=https://oauth.vk.com/blank.html
    // &scope=groups,offline
    // &response_type=token
    // &v=5.131

    //token for API vk1.a.AdZwm4qbS_8CwbUlx8DSrMDF9Y3y2Il5bRXuijl4cbAD34sCmVnnWRawHnplP402aJ-WF2rRk3ErpjlTXsJNzz8WaEejgDBHOrgI569albUHqNvjO-qpFAx4dHbssK-Drn8pTfYstLsCfeOLtktMD5sneuvhw1LmKPJQx9fTbPVYm0HUMJJoySt9SHk5r0rO
    // &user_id=753797802
    //https://api.vk.com/method/groups.get?owner_id=120159853&access_token=38fa46d4c0c10bab105c760cc44ed373c0bc6a34405931f34c765ea&v=5.78
//        Запрос к методам API состоит из шаблона: https://api.vk.com/method/{METHOD_NAME}?{PARAMETERS}&access_token={ACCESS_TOKEN}&v={V}\n" +
//                "где {METHODNAME} - имя метода\n" +
//                "{PARAMETERS} - параметры, индивидуальные, в зависимости от метода\n" +
//                "{ACCESS_TOKEN} - ранее сохранённый токен\n" +
//                "{V} - версия API (на момент написания статья = 5.78)

    public VkInit() {
    }

    private static TransportClient transportClient = new HttpTransportClient();
    private static VkApiClient vk = new VkApiClient(transportClient);
    private static UserActor actor;

//Защищенный ключ (secret) лежит в самом приложении вк, надо туда зайти и посмотреть в профиле приложения
    public static void authorizeVk() throws ClientException, ApiException {
        UserAuthResponse authResponse = vk.oAuth()
                .userAuthorizationCodeFlow(51450107,
                        "hVFvbJn897bbfALVxYnk",
                        "https://oauth.vk.com/blank.html",
                        "f2837ab2ebe3d70a81")
                .execute();
     actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
        System.out.println();
    }

    public static void getGroupsVKApiCall(){
//create http test connection with apache fluent api
    }
}
