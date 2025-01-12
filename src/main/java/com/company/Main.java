package com.company;

import com.company.robiya.MyBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws TelegramApiException {

        TelegramBotsApi telegramBotsApi1 = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi1.registerBot(new Translator("7724128881:AAESF-_z26MbPk8WVjAvhvis60Nwbs-RAs8"));
        System.out.println("running 1 ...");

        TelegramBotsApi telegramBotsApi2 = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi2.registerBot(new Meme());
        System.out.println("running 2 ...");

        TelegramBotsApi telegramBotsApi3 = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi3.registerBot(new Motivation());
        System.out.println("running 3 ...");

        TelegramBotsApi telegramBotsApi4 = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi4.registerBot(new Psychology());
        System.out.println("running 4 ...");

        TelegramBotsApi telegramBotsApi5 = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi5.registerBot(new Progress());
        System.out.println("running 5 ...");

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        System.out.println(" Namoz running ...");
        botsApi.registerBot(new MyBot("7560789894:AAHWyVouM4DdreUypaMVIqnr8ZooLKBtw_4"));
    }
}