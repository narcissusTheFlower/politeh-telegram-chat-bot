package com.telegram.politehtelegrambot.vk;

import org.springframework.beans.factory.annotation.Autowired;

public class VKAPIMethods {

    @Autowired
    VkApiCalls vkApiCalls;
    public String parseWall(){
        return vkApiCalls.soutresult();
    }

}
