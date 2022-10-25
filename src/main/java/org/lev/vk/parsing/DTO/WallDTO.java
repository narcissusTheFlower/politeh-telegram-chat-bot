package org.lev.vk.parsing.DTO;

import java.util.List;

public class WallDTO {

    public List<Items> items;

    public List<Items> getItems() {
        return items;
    }

    public class Items{
        public Long date;
        public Integer id;
        public String text;

        public Integer getId() {
            return id;
        }

        public String getText() {
            return text;
        }

        public Long getDate() {
            return date;
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
