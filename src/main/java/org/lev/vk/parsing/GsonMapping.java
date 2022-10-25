package org.lev.vk.parsing;

import com.google.gson.Gson;
import org.lev.vk.parsing.DTO.WallDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class GsonMapping {

    private static Logger logger = LoggerFactory.getLogger(GsonMapping.class);
    private static WallDTO wallDTO = new WallDTO();
    private static WallDTO.Items lastPost = wallDTO.new Items();
    private static WallDTO.Groups group = wallDTO.new Groups();

    public WallDTO returnPojoMappedFromJson(String json) {
        return new Gson().fromJson(json, WallDTO.class);
    }

    public Long extractInnerClassInfoFrom(WallDTO wallDTO) {
        List<WallDTO.Items> innerClassItems = wallDTO.getItems();
        lastPost = innerClassItems.get(1);
//        List<WallDTO.Groups> innerClassGroup = wallDTO.getGroups();
//        group = innerClassGroup.get(0);
//        logger.info("Extracted 'date' from "+ group.getName() +": " + lastPost.getDate());
        logger.info("Extracted 'date': " + lastPost.getDate());
        return lastPost.getDate();
    }
}
