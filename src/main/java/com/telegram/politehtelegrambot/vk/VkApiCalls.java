package com.telegram.politehtelegrambot.vk;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class VkApiCalls {
    static Response response;
    ObjectMapper mapper = new ObjectMapper();

    static OkHttpClient client = new OkHttpClient();

    static Request request = new Request.Builder()
            .url("https://www.google.com/")
            .build(); // defaults to GET

    public static String soutresult(){

        try {
             response = client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.toString());
        return response.toString();
    }
}
