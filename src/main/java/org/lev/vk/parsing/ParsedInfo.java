package org.lev.vk.parsing;

import com.google.gson.Gson;
import org.lev.vk.DTO.WallDTO;
import org.lev.vk.apiMethods.WallGetRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ParsedInfo {

    private static Logger logger = LoggerFactory.getLogger(ParsedInfo.class);

    private static WallDTO wallDTO = new WallDTO();
    private static WallDTO.Items lastPost = wallDTO.new Items();
    public static WallDTO parsedPojo;
    public static Integer jsonParsedPostId;

    public static void returnPojoMappedFromJson(){
        parsedPojo = new Gson().fromJson(WallGetRequest.jsonString, WallDTO.class);
        logger.info("Mapped pojo: " + parsedPojo.toString());
    }

    public static void extractInnerClassInfoFromPojo(){
       List<WallDTO.Items> innerClassInfo = parsedPojo.getItems();
       lastPost = innerClassInfo.get(1);
       jsonParsedPostId = lastPost.getId();
        logger.info("Вытащенный пост айди: " + lastPost.getId());
    }
}
