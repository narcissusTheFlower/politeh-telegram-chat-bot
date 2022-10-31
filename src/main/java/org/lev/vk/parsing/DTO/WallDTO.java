package org.lev.vk.parsing.DTO;

import java.util.List;
public class WallDTO {

    public List<Items> items;
    public List<Groups> groups;

    public List<Items> getItems() {
        return items;
    }

    public List<Groups> getGroups() {
        return groups;
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

    public class Groups {
        public Long id;
        public String name;

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "groupId: " + id + "\n" +
                    "groupName: " + name;

        }
    }

    @Override
    public String toString() {
        return items + "\n";
    }
}
