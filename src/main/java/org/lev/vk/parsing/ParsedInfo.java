package org.lev.vk.parsing;

import com.google.gson.Gson;
import org.lev.vk.DTO.WallDTO;
import java.util.List;

public class ParsedInfo {

    private static WallDTO wallDTO = new WallDTO();
    private static WallDTO.Items lastPost = wallDTO.new Items();

    public static WallDTO pojoMappedFromJson(){
        WallDTO parsedPojo = new Gson().fromJson(WallGet.jsonString, WallDTO.class);
        System.out.println("Mapped pojo: " + parsedPojo);
        return parsedPojo;
    }

    public static Integer extractInnerClassInfoFrom(WallDTO parsedPojo){
       List<WallDTO.Items> innerClassInfo = parsedPojo.getItems();
       lastPost = innerClassInfo.get(1);
        System.out.println("Вытащенный пост айди: " + lastPost.getId());
       return lastPost.getId();
    }
}
