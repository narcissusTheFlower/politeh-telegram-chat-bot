//package org.lev.commands;
//
//import com.vk.api.sdk.client.ApiRequest;
//import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
//import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
//import org.telegram.telegrambots.meta.api.objects.Chat;
//import org.telegram.telegrambots.meta.api.objects.User;
//import org.telegram.telegrambots.meta.bots.AbsSender;
//
//public class VkApiCommand<T extends ApiRequest> extends BotCommand {
//
//    Class <T> cls;
//
//    public VkApiCommand(String commandIdentifier, String description, Class <T> cls) {
//        super(commandIdentifier, description);
//        this.cls = cls;
//    }
//
//    @Override
//    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
//        try {
//            absSender.execute((SendMediaGroup) cls.getConstructor(String.class).newInstance(chat.getId().toString()));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
//}
