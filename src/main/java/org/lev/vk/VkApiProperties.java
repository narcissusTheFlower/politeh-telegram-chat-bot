package org.lev.vk;

public final class VkApiProperties {

    private static final Integer OUR_VK_GROUP_ID = Integer.parseInt(System.getenv("VK_GROUP_ID"));
    private static final Integer GENERAL_VK_GROUP_ID = Integer.parseInt(System.getenv("VK_GROUP_ID_GENERAL"));//TODO no such export in bash_profile yet
    private static final Integer VK_CLIENT_ID = Integer.parseInt(System.getenv("VK_CLIENT_ID"));
    private static final String VK_SECRET = System.getenv("VK_SECRET");
    private static final String VK_CODE = System.getenv("VK_CODE");
    private static final String TELEGRAM_CHAT_ID = System.getenv("TELEGRAM_CHAT_ID");

    public static Integer getOUR_VK_GROUP_ID() {
        return OUR_VK_GROUP_ID;
    }

    public static Integer getVK_CLIENT_ID() {
        return VK_CLIENT_ID;
    }

    public static String getVK_SECRET() {
        return VK_SECRET;
    }

    public static String getVK_CODE() {
        return VK_CODE;
    }

    public static String getTELEGRAM_CHAT_ID() {
        return TELEGRAM_CHAT_ID;
    }

    public static Integer getGeneralVkGroupId() {
        return GENERAL_VK_GROUP_ID;
    }
}
