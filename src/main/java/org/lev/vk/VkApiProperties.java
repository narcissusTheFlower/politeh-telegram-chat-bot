package org.lev.vk;

public final class VkApiProperties {

    private static Integer VK_GROUP_ID = Integer.parseInt(System.getenv("VK_GROUP_ID"));
    private static Integer VK_CLIENT_ID = Integer.parseInt(System.getenv("VK_CLIENT_ID"));
    private static String VK_SECRET = System.getenv("VK_SECRET");
    private static String VK_CODE = System.getenv("VK_CODE");
    private static String TELEGRAM_CHAT_ID = System.getenv("TELEGRAM_CHAT_ID");


    public static Integer getVK_GROUP_ID() {
        return VK_GROUP_ID;
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
}
