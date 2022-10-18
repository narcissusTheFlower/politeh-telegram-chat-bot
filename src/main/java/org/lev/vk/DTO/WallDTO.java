package org.lev.vk.DTO;

import lombok.Getter;
import java.util.List;


public class WallDTO {

    public List<Items> items;

    public List<Items> getItems() {
        return items;
    }

    public class Items{
        public Integer id;
        public String text;

        public Integer getId() {
            return id;
        }

        public String getText() {
            return text;
        }

        @Override
        public String toString() {
//            return "postId: " + id + "\n" +
//                    "postText: " + text;
            return "postId "+ id;
        }
    }

    @Override
    public String toString() {
        return items + "\n";
    }
}
