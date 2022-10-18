package org.lev.vk.parsing;

import com.google.gson.Gson;
import org.lev.vk.DTO.WallDTO;
import java.util.List;

public class ParsedInfo {

    private static WallDTO wallDTO = new WallDTO();
    private static WallDTO.Items lastPost = wallDTO.new Items();
    protected static Integer lastParsedPostId;

    public static void mapToPojo(){
        WallDTO parsedPojo = new Gson().fromJson(ParsingMethods.jsonString, WallDTO.class);
        extractInnerClassInfoFrom(parsedPojo);
        System.out.println("Mapped pojo: " + parsedPojo);
        System.out.println("Вытащенный пост айди" + lastParsedPostId);
    }

    private static void extractInnerClassInfoFrom(WallDTO parsedPojo){
       List<WallDTO.Items> innerClassInfo = parsedPojo.getItems();
       lastPost = innerClassInfo.get(1);
       lastParsedPostId = lastPost.getId();
    }
}
