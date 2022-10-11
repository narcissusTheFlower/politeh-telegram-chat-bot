package com.telegram.politehtelegrambot.messages;

import com.telegram.politehtelegrambot.utils.EmojiFactory;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class UseFullLinksMessage extends SendMessage{

    private static final String GETlINKS = """
            %blue_diamond Ссылки на учебные порталы:
            https://vk.com/@iknt090302-ssylki-na-sdo
            %blue_diamond Наша группа ВК: 
            https://vk.com/iknt090302
            %blue_diamond Общая группа ВК: 
            https://vk.com/obuchenie_iknt_zaochnyi
            %blue_diamond Личный кабинет студента Политеха: 
            https://lk.spbstu.ru/app/profile/home
            %blue_diamond Открытое образование: 
            https://openedu.ru/my/
            %blue_diamond "Сайт Андрея" (ответы по англ.яз, физике):
            https://polytech.rellowy.tech/
            %blue_diamond Polythis (ответы по разным предметам): 
            https://polyphis.ru/
            %blue_diamond Polyvsp(ответы по разным предметам): 
            https://polyvsp.ru/istoriya/
            %blue_diamond Студенческий архив ответов СПбПУ: 
            https://studfile.net/spbgpu/
            
         """.replace("%blue_diamond", EmojiFactory.getBlueDiamond());
    public UseFullLinksMessage() {
    }

    public UseFullLinksMessage(String chatId) {
        super(chatId, GETlINKS);
    }


}
