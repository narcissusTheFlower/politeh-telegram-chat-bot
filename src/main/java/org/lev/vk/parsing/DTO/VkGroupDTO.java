package org.lev.vk.parsing.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VkGroupDTO {
    private String name;
    private Integer groupId;
    private Long currentPostDate;

    public VkGroupDTO(String name, Integer groupId) {
        this.name = name;
        this.groupId = groupId;
    }

}
