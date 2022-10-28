package com.telegram.politehtelegrambot.utils;

import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMember;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class AdminFilter {
    static final List<String> AdminStatuses = List.of(new String[]{"creator", "admin", "administrator"});

    static public boolean isAdmin(AbsSender absSender,Long chatId, Long userId) throws TelegramApiException {
        ChatMember member = absSender.execute(new GetChatMember(chatId.toString(),userId));

        return AdminStatuses.contains(member.getStatus());
    }
}
