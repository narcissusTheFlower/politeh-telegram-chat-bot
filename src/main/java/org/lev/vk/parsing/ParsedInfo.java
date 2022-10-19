package org.lev.vk.parsing;

import com.google.gson.Gson;
import org.lev.vk.DTO.WallDTO;
import java.util.List;

public class ParsedInfo {

    private static WallDTO wallDTO = new WallDTO();
    private static WallDTO.Items lastPost = wallDTO.new Items();
    public static WallDTO parsedPojo;
    public static Integer jsonParsedPostId;

    public static void pojoMappedFromJson(){
        parsedPojo = new Gson().fromJson(WallGet.jsonString, WallDTO.class);
        System.out.println("Mapped pojo: " + parsedPojo);
    }

    public static void extractInnerClassInfoFrom(){
       List<WallDTO.Items> innerClassInfo = parsedPojo.getItems();
       lastPost = innerClassInfo.get(1);
       jsonParsedPostId = lastPost.getId();
        System.out.println("Вытащенный пост айди: " + lastPost.getId());
    }
}
