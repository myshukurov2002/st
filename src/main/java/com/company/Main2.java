package com.company;

import com.company.a24.Mehmon;
import com.company.elbek.MyBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main2 {
    public static void main(String[] args) throws TelegramApiException {


        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new Mehmon());
        System.out.println("Azizbek successfully running ");
    }
}