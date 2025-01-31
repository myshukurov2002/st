package com.company;

import com.company.a24.*;
import com.company.a24.byshop.Dokon;
import com.company.a24.safia.Safia;
import com.company.umid.MyBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws TelegramApiException {

        TelegramBotsApi telegramBotsApi1 = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi1.registerBot(new com.company.old.Translator("7724128881:AAESF-_z26MbPk8WVjAvhvis60Nwbs-RAs8"));
        System.out.println("running 1 ...");

        TelegramBotsApi telegramBotsApi2 = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi2.registerBot(new com.company.old.Meme());
        System.out.println("running 2 ...");

        TelegramBotsApi telegramBotsApi3 = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi3.registerBot(new com.company.old.Motivation());
        System.out.println("running 3 ...");

        TelegramBotsApi telegramBotsApi4 = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi4.registerBot(new com.company.old.Psychology());
        System.out.println("running 4 ...");

        TelegramBotsApi telegramBotsApi5 = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi5.registerBot(new com.company.old.Progress());
        System.out.println("running 5 ...");

//        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
//        System.out.println(" Namoz running ...");
//        botsApi.registerBot(new MyBot("7560789894:AAHWyVouM4DdreUypaMVIqnr8ZooLKBtw_4"));

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        System.out.println(" Ilyos running ...");
        botsApi.registerBot(new com.company.old.PersonalDevelopment());

        TelegramBotsApi botsApi5 = new TelegramBotsApi(DefaultBotSession.class);
        System.out.println(" Saidazim running ...");
        botsApi5.registerBot(new com.company.old.StudyBot("7347972642:AAFxIhbjQWVItgVSnE5JL2Q02hFBldTRxx4"));


        TelegramBotsApi unmid = new TelegramBotsApi(DefaultBotSession.class);
        System.out.println(" Umid running ...");
        unmid.registerBot(new MyBot());

        TelegramBotsApi abdulloh = new TelegramBotsApi(DefaultBotSession.class);
        System.out.println(" Abdulloh running ...");
        abdulloh.registerBot(new com.company.old.MaxWay());

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new Mehmon());
        System.out.println("Azizbek successfully running ");

        TelegramBotsApi mansur = new TelegramBotsApi(DefaultBotSession.class);
        mansur.registerBot(new Mansur());
        System.out.println("Mansur successfully running ");


        TelegramBotsApi byShop = new TelegramBotsApi(DefaultBotSession.class);
        byShop.registerBot(new Dokon());
        System.out.println("ByShop successfully running ");

        TelegramBotsApi kia = new TelegramBotsApi(DefaultBotSession.class);
        kia.registerBot(new Kia());
        System.out.println("Kia successfully running ");

        TelegramBotsApi garant = new TelegramBotsApi(DefaultBotSession.class);
        garant.registerBot(new Garant());
        System.out.println("Garant successfully running ");

        TelegramBotsApi safia = new TelegramBotsApi(DefaultBotSession.class);
        safia.registerBot(new Safia());
        System.out.println("Safia successfully running ");

        TelegramBotsApi weather = new TelegramBotsApi(DefaultBotSession.class);
        weather.registerBot(new WeatherRecommendationBot());
        System.out.println("WeatherRecommendationBot successfully running ");


    }
}