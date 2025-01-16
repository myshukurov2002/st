package com.company;

import com.company.umid.MyBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main2 {
    public static void main(String[] args) throws TelegramApiException {


        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        System.out.println(" Umid running ...");
        botsApi.registerBot(new MyBot());
    }
}