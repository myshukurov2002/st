package com.company.a24.byshop;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Loo extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        String text = message.getText();
        Long chatId = message.getChatId();

        System.out.println(message.getPhoto());
    }

    public String getBotUsername() {
        return "@Elektronika_buyumlari_bot:";
    }

    @Override
    public String getBotToken() {
        return "7212429298:AAFkT_dCtUDyTFM9z0CP633V1a2VSQJBFdw";
    }
}
