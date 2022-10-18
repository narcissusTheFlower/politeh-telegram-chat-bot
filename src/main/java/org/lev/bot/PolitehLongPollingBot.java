package org.lev.bot;


import org.lev.vk.parsing.ParsingThread;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class PolitehLongPollingBot extends TelegramLongPollingCommandBot {

    ParsingThread parsingThread = new ParsingThread();

    public PolitehLongPollingBot(){
        registerAll(BotMenuCommands.setAllMenuCommands().toArray(new IBotCommand[0]));
        try {
            execute(new SetMyCommands(BotMenuCommands.getMenu(),new BotCommandScopeDefault(),null));
            parsingThread.start();
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return BotProperties.getBotName();
    }

    @Override
    public String getBotToken() {
        return BotProperties.getBotToken();
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        System.out.println("non command used");
    }
}
