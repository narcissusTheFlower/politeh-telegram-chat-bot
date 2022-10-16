package org.lev.vk;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.wall.GetFilter;
import com.vk.api.sdk.objects.wall.responses.GetResponse;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class VkService extends Thread {

//    TimerTask task = new TimerTask() {
//        public void () {
//            System.out.println("Task performed on: " + new Date() + "n" +
//                    "Thread's name: " + Thread.currentThread().getName());
//        }

//
//    public static void parseVkGroupWalls(){
//        Timer timer = new Timer();
//        timer.schedule(run(),2000L);
//    }

    public static void getPostsFromWall(){
        GetResponse getResponse;
        try {
            getResponse = VkInit.vk.wall().get(VkInit.actor)
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
