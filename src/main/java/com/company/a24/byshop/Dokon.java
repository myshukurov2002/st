package com.company.a24.byshop;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendContact;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Dokon extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        Long chatId = message.getChatId();
        String text = message.getText();

        switch (text) {
            case "/start" -> SendVil(chatId, "df");
            case "Toshkent" -> sendMenu(chatId, "fd");
            case "Navoiy" -> sendMenu(chatId, "fd");
            case "Qoraqlpog'iston" -> sendMenu(chatId, "fd");
            case "Samarqand" -> sendMenu(chatId, "fd");
            case "Nukus" -> sendMenu(chatId, "fd");
            case "Andijon" -> sendMenu(chatId, "fd");
            case "Qo'qon" -> sendMenu(chatId, "fd");
            case "Zenit" -> sendBuo(chatId, "lp");
            case "Nukus Asia.uz KSM" -> sendBuo(chatId, "lp");
            case "Buyuk ipak yo'li" -> sendBuo(chatId, "lp");
            case "Parus KSM" -> sendBuo(chatId, "bc");
            case "Atlas Chimgan" -> sendBuo(chatId, "lp");
            case "Ko'kcha" -> sendBuo(chatId, "lp");
            case "S. Rahimov" -> sendBuo(chatId, "lp");
            case "Eco Park" -> sendBuo(chatId, "lp");
        }
        switch (text) {
            case "Xorazim" -> sendMenu(chatId, "fd");
            case "\uD83D\uDCAC Biz bilan aloqaga chiqing" -> pl(chatId, "ji");
            case "\uD83D\uDED2 Buyurtma berish" -> SenBuy(chatId, "lpm");
            case "⬅\uFE0F Ortga" -> sendMenu(chatId, "frt");
            case "⬅\uFE0FOrtga" -> sendBuo(chatId, "frt");
            case "\uD83D\uDE99 Yetkazib berish" -> tet(chatId, "fes");
            case "\uD83C\uDFC3 Olib ketish" -> teot(chatId, "fgt");
            case "\uD83D\uDCD6 Buyurtmalar tarixi" -> SendRaqam(chatId, "ds");
            case "☎\uFE0F Dokon bilan aloqa" -> tewt(chatId, "ds");
            case "⚙\uFE0FSozlash ℹ\uFE0F Ma'lumotlar" -> Senuy(chatId, "kg");
            case "\uD83D\uDE4B\uD83C\uDFFB\u200D♂\uFE0F Jamoamizga qo'shiling" -> sendIlLiber(chatId);
            case "Filialni tanlang" -> Senfil(chatId, "cd");
            case "\uD83D\uDCF1Telefon" -> sendop(chatId, "lop");
        }
        switch (text) {
            case "Ismni o'zgartirish" -> cd(chatId);
            case "\uD83D\uDCF1Raqamni o'zgartirish" -> cd(chatId);
            case "\uD83C\uDFD9Shaharini o'zgartirish" -> cd(chatId);
            case "\uD83C\uDDFA\uD83C\uDDFFTilni o'zgartirish" -> cd(chatId);
            case "ℹ\uFE0FFilialar haqida malumot" -> cd(chatId);
            case "\uD83D\uDCC4Ommaviy taklif" -> cd(chatId);
        }
        switch (text) {
            case "Sezar sous" -> xa(chatId);
        }
        switch (text) {
            case "✍\uFE0F Fikr bildirish" -> c(chatId);
        }
        switch (text){
            case "iphone" -> enda(chatId);
            case "iphone 10"->sg(chatId);
            case "iphone 11"->p(chatId);
            case "iphone 12"->sg(chatId);
            case "iphone 13"->fg(chatId);
            case "iphone 14" -> senda(chatId);
            case "iphone 15"->sdp(chatId);
        }
        switch (text){
            case "Redmi"->Redmi(chatId);
            case "Redmi A1+"->A1(chatId);
            case "Redmi A2+"->A2(chatId);
            case "Redmi A3"->A3(chatId);
            case "Redmi A4"->A4(chatId);
        }
        switch (text){
            case "samsung"->Samsung(chatId);
            case "Samsung galaxy S10"->S10(chatId);
            case "Samsung galaxy S11"->S11(chatId);
            case "Samsung galaxy S12"->S12(chatId);
            case "Samsung galaxy S13"->S13(chatId);

        }
        switch (text){
            case "Mi"->Mi(chatId);
            case "xiaomi 11"->X11(chatId);
            case "xiaomi 12"->X12(chatId);
            case "xiaomi 13"->X13(chatId);
            case "xiaomi 14"->X14(chatId);
            case "xiaomi 15"->X15(chatId);
            case "xiaomi 16"->X16(chatId);



        }
        switch (text){
            case "\uD83D\uDDA5Kampyuterlar"->Kampyuter(chatId);
            case "Samsung Desktop Computer"->K1(chatId);
            case "Apple iMac"->K2(chatId);
            case "Xiomi 27"->K3(chatId);
            case "Xiomi A24i"->K4(chatId);
        }
        switch (text){
            case "\uD83D\uDCBBNoutbuklar"->Noutbuk(chatId);
            case "Lenovo 15"->N1(chatId);
            case "Aser Nitro"->N2(chatId);
            case "Aser Nitro 17"->N3(chatId);
            case "Asus vivobook"->N4(chatId);
        }
        switch (text){
            case "\uD83C\uDFAEPSP"->PSP(chatId);
            case "Play station"->Play_station(chatId);
            case "Play station 2"->PS2(chatId);
            case "Play station 3"->PS3(chatId);
            case "Play station 4"->PS4(chatId);
            case "Play station 5"->PS5(chatId);
            case "Xbox"->Xb(chatId);
            case "Xbox 360"->Xb3(chatId);
        }
        switch (text){
            case "Sony PSP 3000"->Psp1(chatId);
            case "Soniy PSP 2001"->Psp2(chatId);
            case "Soniy PSP E1008"->Psp3(chatId);
            case "Soniy PSP 2000"->Psp4(chatId);

        }
        switch (text){
            case "Vertual ko'zaynaklar"->Kozaynak(chatId);
            case "Virtual ko'zaynaklar"->koz1(chatId);
            case "Magic Leap 1"->vk1(chatId);
            case "Magic Leap 2"->vk2(chatId);
            case "G04 Popular Head"->vk3(chatId);
            case "VMAXTEL 5F"->vk4(chatId);
            case "Meta Quest 1"->vk5(chatId);
            case "Meta Quest 2"->vk6(chatId);
            case "Meta Quest 3"->vk7(chatId);
            case "Meta Quest 4"->vk8(chatId);
        }
        switch (text){
            case "Virtual shlemlar"->koz2(chatId);
            case "Sony Play station VR"->sh1(chatId);
            case "Aftanom VR shlem"->sh2(chatId);
            case "Oculus rift S"->sh3(chatId);
            case "Somnium VR1"->sh4(chatId);
            case "VR BOX 1.0"->sh5(chatId);
            case "VR BOX 2.0"->sh6(chatId);

        }
    }

    private void koz2(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0FOrtga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Sony Play station VR");


        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Aftanom VR shlem");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Oculus rift S");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Somnium VR1");


        KeyboardButton button7 = new KeyboardButton();
        button7.setText("VR BOX 1.0");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("VR BOX 2.0");

        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button3);
        keyboard1.add(button4);
        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button5);
        keyboard2.add(button6);
        KeyboardRow keyboard3 = new KeyboardRow();
        keyboard3.add(button7);
        keyboard3.add(button8);

        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keyboard2);
        qatorlar.add(keyboard3);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Nimadan boshlaymiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void koz1(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0FOrtga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Magic Leap 1");


        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Magic Leap 2");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("G04 Popular Head");


        KeyboardButton button6 = new KeyboardButton();
        button6.setText("VMAXTEL 5F");

        KeyboardButton button7= new KeyboardButton();
        button7.setText("Meta Quest 1");
        KeyboardButton button8 = new KeyboardButton();
        button8.setText("Meta Quest 2");
        KeyboardButton button9 = new KeyboardButton();
        button9.setText("Meta Quest 3");
        KeyboardButton button10 = new KeyboardButton();
        button10.setText("Meta Quest 4");
        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button3);
        keyboard1.add(button4);
        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button5);
        keyboard2.add(button6);
        KeyboardRow keyboard3 = new KeyboardRow();
        keyboard3.add(button7);
        keyboard3.add(button8);
        KeyboardRow keyboard4=new KeyboardRow();
        keyboard4.add(button9);
        keyboard4.add(button10);

        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keyboard2);
        qatorlar.add(keyboard3);
        qatorlar.add(keyboard4);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Nimadan boshlaymiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    private void Kozaynak(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0FOrtga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Virtual ko'zaynaklar");


        KeyboardButton button4= new KeyboardButton();
        button4.setText("Virtual shlemlar");
        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);
        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button3);
        keyboard2.add(button4);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard2);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Nimadan boshlaymiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    private void Play_station(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0FOrtga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Play station 2");


        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Play station 3");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Play station 4");


        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Play station 5");



        KeyboardButton button7= new KeyboardButton();
        button7.setText("Xbox");
        KeyboardButton button8 = new KeyboardButton();
        button8.setText("Xbox 360");
        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button3);
        keyboard1.add(button4);
        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button5);
        keyboard2.add(button6);
        KeyboardRow keyboard3 = new KeyboardRow();
        keyboard3.add(button7);
        keyboard3.add(button8);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keyboard2);
        qatorlar.add(keyboard3);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Nimadan boshlaymiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    private void PSP(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0FOrtga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Sony PSP 3000");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Soniy PSP 2001");


        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Soniy PSP E1008");


        KeyboardButton button6= new KeyboardButton();
        button6.setText("Soniy PSP 2000");
        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button3);
        keyboard1.add(button4);
        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button5);
        keyboard2.add(button6);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keyboard2);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Nimadan boshlaymiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    private void Kampyuter(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0FOrtga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Samsung Desktop Computer");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Apple iMac");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Xiomi 27");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Xiomi A24i");


        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button3);
        keyboard1.add(button4);
        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button5);
        keyboard2.add(button6);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keyboard2);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Nimadan boshlaymiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }
    private void Noutbuk(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0FOrtga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Lenovo 15");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Aser Nitro");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Aser Nitro 17");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Asus vivobook");


        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button3);
        keyboard1.add(button4);
        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button5);
        keyboard2.add(button6);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keyboard2);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Nimadan boshlaymiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    private void Mi(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0FOrtga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("xiaomi 11");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("xiaomi 12");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("xiaomi 13");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("xiaomi 14");

        KeyboardButton button7 =new KeyboardButton();
        button7.setText("xiaomi 15");

        KeyboardButton button8 =new KeyboardButton();
        button8.setText("xiaomi 16");


        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button3);
        keyboard1.add(button4);
        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button5);
        keyboard2.add(button6);
        KeyboardRow keyboard3=new KeyboardRow();
        keyboard3.add(button7);
        keyboard3.add(button8);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keyboard2);
        qatorlar.add(keyboard3);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Nimadan boshlaymiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    private void Samsung(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0FOrtga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Samsung galaxy S10");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Samsung galaxy S11");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Samsung galaxy S12");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Samsung galaxy S13");


        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button3);
        keyboard1.add(button4);
        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button5);
        keyboard2.add(button6);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keyboard2);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Nimadan boshlaymiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

}
    private void enda(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0FOrtga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("iphone 10");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("iphone 11");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("iphone 12");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("iphone 13");

        KeyboardButton button7 =new KeyboardButton();
        button7.setText("iphone 14");

        KeyboardButton button8 =new KeyboardButton();
        button8.setText("iphone 15");


        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button3);
        keyboard1.add(button4);
        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button5);
        keyboard2.add(button6);
        KeyboardRow keyboard3=new KeyboardRow();
        keyboard3.add(button7);
        keyboard3.add(button8);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keyboard2);
        qatorlar.add(keyboard3);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Nimadan boshlaymiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    private void Redmi(Long chatid) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0FOrtga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Redmi A1+");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Redmi A2+");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Redmi A3");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Redmi A4");


        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button3);
        keyboard1.add(button4);
        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button5);
        keyboard2.add(button6);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keyboard2);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatid);
        sendMessage.setText("Nimadan boshlaymiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

        private void c (Long chatId){
        InlineKeyboardButton btn1 = new InlineKeyboardButton();
        btn1.setText("Mahsulot");
        btn1.setCallbackData("Bu CE belgisi");
        InlineKeyboardButton btn2 = new InlineKeyboardButton();
        btn2.setText("1\uD83D\uDE23");
        btn2.setCallbackData("Bu C belgisi");

        InlineKeyboardButton btn3 = new InlineKeyboardButton();
        btn3.setText("2☹\uFE0F");
        btn3.setCallbackData("bu o'chirish");
        InlineKeyboardButton btn4 = new InlineKeyboardButton();
        btn4.setText("3\uD83D\uDE15");
        btn4.setCallbackData("Bu / belgisi");
        InlineKeyboardButton btn5 = new InlineKeyboardButton();
        btn5.setText("4\uD83D\uDE10");
        btn5.setCallbackData("Bu 7 belgisi");
        InlineKeyboardButton btn6 = new InlineKeyboardButton();
        btn6.setText("5\uD83D\uDE06");
        btn6.setCallbackData("Bu 8 belgisi");
        InlineKeyboardButton btn7 = new InlineKeyboardButton();
        btn7.setText("Xizmat");
        btn7.setCallbackData("Bu 9 belgisi");
        InlineKeyboardButton btn8 = new InlineKeyboardButton();
        btn8.setText("1\uD83D\uDC4A");
        btn8.setCallbackData("Bu * belgisi");
        InlineKeyboardButton btn9 = new InlineKeyboardButton();
        btn9.setText("2\uD83D\uDC4E\uD83C\uDFFB");
        btn9.setCallbackData("Bu 4 belgisi");
        InlineKeyboardButton btn10 = new InlineKeyboardButton();
        btn10.setText("3\uD83D\uDC4C");
        btn10.setCallbackData("Bu 5 belgisi");
        InlineKeyboardButton btn11 = new InlineKeyboardButton();
        btn11.setText("4\uD83E\uDD19");
        btn11.setCallbackData("Bu 6 belgisi");
        InlineKeyboardButton btn12 = new InlineKeyboardButton();
        btn12.setText("5\uD83D\uDC4D");
        btn12.setCallbackData("Bu - belgisi");
        InlineKeyboardButton btn13 = new InlineKeyboardButton();
        btn13.setText("Yetkazib berish");
        btn13.setCallbackData("Bu 1 belgisi");
        InlineKeyboardButton btn14 = new InlineKeyboardButton();
        btn14.setText("1\uD83D\uDC0C");
        btn14.setCallbackData("Bu 2 belgisi");
        InlineKeyboardButton btn15 = new InlineKeyboardButton();
        btn15.setText("2\uD83D\uDC22");
        btn15.setCallbackData("Bu 3 belgisi");
        InlineKeyboardButton btn16 = new InlineKeyboardButton();
        btn16.setText("3\uD83D\uDEFA");
        btn16.setCallbackData("Bu + belgisi");
        InlineKeyboardButton btn17 = new InlineKeyboardButton();
        btn17.setText("4\uD83C\uDFCE");
        btn17.setCallbackData("Bu # belgisi");
        InlineKeyboardButton btn18 = new InlineKeyboardButton();
        btn18.setText("5\uD83D\uDE80");
        btn18.setCallbackData("Bu 0 belgisi");
        ArrayList<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(btn1);
        ArrayList<InlineKeyboardButton> row = new ArrayList<>();
        row.add(btn2);
        row.add(btn3);
        row.add(btn4);
        row.add(btn5);
        row.add(btn6);
        ArrayList<InlineKeyboardButton> rowp = new ArrayList<>();
        rowp.add(btn7);
        ArrayList<InlineKeyboardButton> row6 = new ArrayList<>();
        row6.add(btn8);
        row6.add(btn9);
        row6.add(btn10);
        row6.add(btn11);
        row6.add(btn12);
        ArrayList<InlineKeyboardButton> row2 = new ArrayList<>();
        row2.add(btn13);
        ArrayList<InlineKeyboardButton> row3 = new ArrayList<>();
        row3.add(btn14);
        row3.add(btn15);
        row3.add(btn16);
        row3.add(btn17);
        row3.add(btn18);
        List<List<InlineKeyboardButton>> roes = new ArrayList<>();
        roes.add(row1);
        roes.add(row);
        roes.add(rowp);
        roes.add(row6);
        roes.add(row2);
        roes.add(row3);

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.setKeyboard(roes);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Tanlovingiz uchun rahmat va bizning ishimizni 5 balli tizimda \nbaholashingizdan mamnun bo'lamiz.");
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

        private void cd (Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("\uD83D\uDCDEMening raqamim");
        button1.setRequestContact(true);
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button1);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard1);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Avval ro'yxatdan o'ting.\n" + "Ro'yxatdan o'tish uchun telefon raqamingizni kiriting!\n" +
                "Misol uchun, +998xx xxx xx xx");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

        @SneakyThrows
        private void pl (Long chatId, String t){
        InlineKeyboardButton btn1 = new InlineKeyboardButton();
        btn1.setText("\uD83D\uDCAC Biz bilan aloqaga chiqing");
        btn1.setCallbackData("Bu CE belgisi");

        ArrayList<InlineKeyboardButton> row = new ArrayList<>();
        row.add(btn1);
        List<List<InlineKeyboardButton>> roes = new ArrayList<>();
        roes.add(row);

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.setKeyboard(roes);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Agar biron-bir savol yoki taklif bo'lsa, bizga aloqaga chiqing.");
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

        private void sendop (Long chatId, String text){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0FOrtga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("iphone");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Redmi");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("samsung");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Mi");

        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button3);
        keyboard1.add(button4);
        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button5);
        keyboard2.add(button6);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keyboard2);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Nimadan boshlaymiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }


        private void sendBuo (Long chatId, String lp){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Ortga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("\uD83D\uDCF1Telefon");
        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83D\uDDA5Kampyuterlar");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83D\uDCBBNoutbuklar");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDFAEPSP");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("Vertual ko'zaynaklar");
        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button3);
        keyboard1.add(button4);
        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button5);
        keyboard2.add(button6);
        KeyboardRow keyboard3 = new KeyboardRow();
        keyboard3.add(button7);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keyboard2);
        qatorlar.add(keyboard3);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Nimadan boshlaymiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

        private void Senfil (Long chatId, String cd){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Nukus Asia.uz KSM");
        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Buyuk ipak yo'li");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("S. Rahimov");
        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Eco Park");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Ko'kcha");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Zenit");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("Atlas Chimgan");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("Parus KSM");
        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button3);
        keyboard1.add(button4);
        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button5);
        keyboard2.add(button6);
        KeyboardRow keyboard3 = new KeyboardRow();
        keyboard3.add(button7);
        keyboard3.add(button8);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keyboard2);
        qatorlar.add(keyboard3);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Qayerni tanlaysiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

        private void sendIlLiber (Long chatId){
        InlineKeyboardButton btn1 = new InlineKeyboardButton();
        btn1.setText("O'tish");
        btn1.setCallbackData("Bu O'tish belgisi");

        ArrayList<InlineKeyboardButton> row = new ArrayList<>();
        row.add(btn1);
        ArrayList<List<InlineKeyboardButton>> roes = new ArrayList<>();
        roes.add(row);

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.setKeyboard(roes);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Ahil jamoamizda ishlashga taklif qilamiz! Telegramdan chiqmay, shu yerning o'zida anketani to'ldirish uchun quyidagi tugmani bosing.");
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

        private void tewt (Long chatId, String text){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("\uD83D\uDCAC Biz bilan aloqaga chiqing");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("✍\uFE0F Fikr bildirish");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("⬅\uFE0F Ortga");
        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);

        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button3);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Assalomu alaykum! By shop yetkazib berish xizmatiga xush kelibsiz" + "        " + "Здравствуйте! Добро пожаловать в службу доставки By shop." + "       " + "Hello! Welcome to By shop delivery service.");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

        private void tet (Long chatId, String text){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("\uD83D\uDDFA Mening manzillarim");
        button1.setRequestLocation(true);

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCCDEng Yaqin filialni aniqlash");
        button2.setRequestLocation(true);

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("⬅\uFE0F Ortga");
        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button2);

        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button1);
        keyboard1.add(button3);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Buyurtmangizni qayerga yetkazib berish kerak \uD83D\uDE99? Agar lokatsiyangizni\uD83D\uDCCD yuborsangiz, sizga eng yaqin filialni aniqlaymiz.");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

        private void teot (Long chatId, String text){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Ortga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCCDEng Yaqin filialni aniqlash");
        button2.setRequestLocation(true);

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Bu yerda buyurtma berish \uD83C\uDF10");
        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Filialni tanlang");
        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button3);
        keyboard1.add(button4);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Tanlang");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

        private void SenBuy (Long chatId, String text){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("\uD83C\uDFC3 Olib ketish");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDE99 Yetkazib berish");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("⬅\uFE0F Ortga");
        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);

        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button3);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Buyurtmani o'zingiz \uD83D\uDE4B\u200D♂\uFE0F olib keting yoki Yetkazib berishni \uD83D\uDE99 tanlang");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

        private void Senuy (Long chatId, String text){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Ismni o'zgartirish");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCF1Raqamni o'zgartirish");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("\uD83C\uDFD9Shaharini o'zgartirish");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDDFA\uD83C\uDDFFTilni o'zgartirish");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("ℹ\uFE0FFilialar haqida malumot");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83D\uDCC4Ommaviy taklif");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("⬅\uFE0F Ortga");
        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);

        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button3);
        keyboard1.add(button4);

        KeyboardRow keybort2 = new KeyboardRow();
        keybort2.add(button5);
        keybort2.add(button6);

        KeyboardRow keybort3 = new KeyboardRow();
        keybort3.add(button7);

        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keybort2);
        qatorlar.add(keybort3);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Nimani o'zgartirmoqchisiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

        private void SendRaqam (Long chatId, String rr){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("\uD83D\uDCDEMening raqamim");
        button1.setRequestContact(true);
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button1);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard1);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Ro'yxatdan o'tish uchun telefon raqamingizni kiriting!\n" +
                "Misol uchun, +998xx xxx xx xx");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

        private void SendVil (Long chatId, String text){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Toshkent");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Navoiy");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Samarqand");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Qoraqlpog'iston");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Nukus");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Andijon");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("Qo'qon");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("Xorazim");
        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        keyboard.add(button2);

        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button3);
        keyboard1.add(button4);

        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button5);
        keyboard2.add(button6);


        KeyboardRow keyboard3 = new KeyboardRow();
        keyboard3.add(button7);
        keyboard3.add(button8);

        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keyboard2);
        qatorlar.add(keyboard3);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Qayerdan siz.");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

        @SneakyThrows
        private void sendMenu (Long chatId, String menu){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("\uD83D\uDED2 Buyurtma berish");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCD6 Buyurtmalar tarixi");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("☎\uFE0F Dokon bilan aloqa");
        KeyboardButton button4 = new KeyboardButton();
        button4.setText("⚙\uFE0FSozlash ℹ\uFE0F Ma'lumotlar");
        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83D\uDE4B\uD83C\uDFFB\u200D♂\uFE0F Jamoamizga qo'shiling");
        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);

        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button2);
        keyboard1.add(button3);

        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button4);
        keyboard2.add(button5);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keyboard2);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Botga hush kelibsiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    @SneakyThrows
    private void senda(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAMEZ5ZWYbXjclb7JuHZ3L5mr0nHUBAAAmHrMRsaQLBIumoRZWq6BtgBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("iphone 14 \n" + "Narxi=800$");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void seda(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAMGZ5ZYOgNpEmEj-jYJQAb12voE3tcAAnXrMRsaQLBIvwgsAqWjbFwBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Samsung A55 \n" + "Narxi=5 000 000 som");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void sdp(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANKZ5erAAEOi0Sm1pLUjwQ_SaGOrCpQAAI38zEboJHASAaFGVPql72WAQADAgADcwADNgQ"));
        sendPhoto.setCaption("iphone 15 \n"+"Narxi=15 500 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void fg(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANIZ5epceU7eZthLeBw9T3CsOYYLDYAAjHzMRugkcBImlV9TYL26hEBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("iphone 13 \n"+"Narxi=14 000 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void sg(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANHZ5eouu2lVusWnezJXFYnrJlU7xkAAivzMRugkcBIxvRDsLWXjPEBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Iphone 12 \n"+"Narxi=8 380 000");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void v(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANFZ5enIfzDO9NB6ATRzAABG_pXI4-sAAIk8zEboJHASJrcAzRmdgtmAQADAgADcwADNgQ"));
        sendPhoto.setCaption("iphone 10 \n"+"Narxi=235.10$");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void p(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANGZ5en2QxD9ozJythmNYKuZq1Pc0AAAijzMRugkcBI4bWja3T5gWYBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("iphone 11 \n"+"Narxi=8 441 000 som");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void A1(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAMFZ5ZXpKtxRKkgVMdhOrPTr-5wOOYAAm7rMRsaQLBItuRb-t5PUkYBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Redmi A1+ \n" + "Narxi=1 600 000 som");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void A2(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANLZ5etTwohFrJuoGGrgAwFG4dCHwsAAkDzMRugkcBI1KvzeWC8_H8BAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Redmi A2+\n"+"Narxi=1 400 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void A3(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANMZ5euODpc40r1MTHDpJNNs6zsiSIAAkjzMRugkcBIoycaSAin1RcBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Redmi A3\n"+"Narxi=1 300 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void A4(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANNZ5evRmEjjtCE6YzowPoAAQcvgI25AAJT8zEboJHASKv_AvQEdaBjAQADAgADcwADNgQ"));
        sendPhoto.setCaption("Redmi A4 \n"+"Narxi=1 700 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void S10(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANsZ5eyFN0AAf_gAAGdpAoELWz5H3i6NwACpvMxG6CRwEgQYDGJwf4Z8QEAAwIAA3MAAzYE"));
        sendPhoto.setCaption("Samsung galaxy S10\n"+"Narxi=11 400 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void S11(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANtZ5ezs0CVzFq-WNurKR6uMI1ie68AAsfzMRugkcBIoNRyRrbcMAoBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Samsung Galaxsy S11\n"+"Narxi=1 190 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void S12(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANuZ5e0FlxfnHmhwWLTeZrLy1r4HrIAAsrzMRugkcBIgKgN1P8v5dwBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Samsung gelaxy S12\n"+"Narxi=2 550 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void S13(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANvZ5e0dAilwgGL0Du87al9I9sNlD8AAsvzMRugkcBIMiV7G8GuFKsBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Samsung gelaxs S13\n"+"Narxi=1 800 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void X14(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANwZ5e1yuxRRh325fY2cBoMxmU87GcAAtTzMRugkcBI_vaaCAIBAUcBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Xiomi 14\n"+"Narxi=11 000 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void  X15(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANxZ5e5FfeCW0rh34p5IEZ4kgABtGSxAALs8zEboJHASB1Ax4Kj2HNbAQADAgADcwADNgQ"));
        sendPhoto.setCaption("Xiomi 15\n"+"Narxi=11 000 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void X16(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANyZ5e52ZnSZBcPwjy0tNL9wS48Ka8AAvXzMRugkcBIehEE5HjNIKEBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Xiomi 16\n"+"Narxi=12 000 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void X13(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANzZ5e7WZggzNTdgD13q3ZSHt8K5HAAAvzzMRugkcBIVYlZPoiJDnoBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Xiomi 13\n"+"Narxi=8 800 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void X12(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAN0Z5e75uvyKGt2nTSEcyBM_jCdDSIAAgf0MRugkcBIoVDRY133vDoBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Xiomi 12\n"+"Narxi=6 600 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void X11(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAN1Z5e8OGWjWkI5RYiSyX8wfnwhCmEAAgr0MRugkcBIzxJZIiNggBsBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Xiomi 11\n"+"Narxi=7 580 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void K1(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAObZ5hUBa_Nm_CmKM-B1oODzX71Dg0AArb2MRugkcBINY_SJ3BBG0QBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Deskop kampyuter\n"+"Narxi=12 000 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void K2(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAOcZ5hVDc846amXQoJ7-BBnSsPOnRYAAivrMRugkchIbMLZ7M-IHD8BAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Apple Imac\n"+"Narxi=15 000 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void K3(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAOfZ5hhcp47RuSplyuTSY3mPNgju-kAAlLrMRugkchIxPiAuQ2yezoBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Xiomi 27\n"+"Narxi=3 300 $");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void K4(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAOgZ5hsc0WCuYTn0gR8NDTBtFYTOdoAAmrrMRugkchI2FKC_YZOzgYBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Xiomi A24i\n"+"Narxi=2 100 $");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void N1(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAPJZ5h5CR2oKZVrpRGlSFfIpSGia2kAApTrMRugkchIQ5Ebm0px3bABAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Lenovo 15 \n" +"Narxi=8 760 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void N2(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAPKZ5iK5ztjdzeiLLse5ByRrlRvtIcAAubrMRugkchIuJnbRWyEDDcBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Aser Nitro\n"+"Narxi=26 254 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void N3(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAPLZ5iL-wdjoNovjuziyQX_4aZ71aYAAu3rMRugkchIeg4LNr_5VcUBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Aser Nitro 17\n"+"Narxi=11 745 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void N4(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAPMZ5iMn5-6O0qeVMFBE7goHULjb-8AAvDrMRugkchIHwk-Jb06qCQBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Asus Vivobook\n"+"Narxi=10 545 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void PS2(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAP8Z5ifrjBkva-Ami-O10xLck7hs9AAAjHuMRuN-shIF7dEuJ93rvYBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Play station 2\n"+"Narxi=2 400 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void PS3(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAP9Z5igqPQlypoRfK9PC-p2laUznVMAAnPsMRugkchI_wtFlS7fXowBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Play Station 3\n"+"Narxi=3 750 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void PS4(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAP-Z5ih1fXI8HudeVgBgk2pn2ck2bIAAnXsMRugkchI9pT-uuYAAYwQAQADAgADcwADNgQ"));
        sendPhoto.setCaption("Play Station 4\n"+
                "Narxi=7 400 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void PS5(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAP_Z5iiLQd4VMS3Yl32SVP3iGx4H2sAAqXqMRuwp8BIVHrlfjzfHY0BAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Play station 5\n"+
                "Narxi=10 000 000");
        execute(sendPhoto);
    }


    @SneakyThrows
    private void Xb(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBAAFnmKOTJKUmxt8PEFFwWddBkXqDlQACg-wxG6CRyEi384-7cmIWEAEAAwIAA3MAAzYE"));
        sendPhoto.setCaption("Xbox\n"+"Narxi=11 550 000");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void Xb3(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBAWeYpGX7tz4laF7evS3XMxhY1Eq3AAKK7DEboJHISGjrt2yu4Z3BAQADAgADcwADNgQ"));
        sendPhoto.setCaption("Xbox 360\n"+"Narxi=5 000 000");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void Psp1(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBAmeYpWOhtt5zOMte-bLkLnUl2mGoAAKU7DEboJHISMiTv3OxLMkrAQADAgADcwADNgQ"));
        sendPhoto.setCaption("Sony PSP 3000\n"+"Narxi=1 497 800");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void Psp2(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBA2eYqLtcViahuB-wYNpTcBd1Su5UAAKn7DEboJHISDfPf5mOH1k2AQADAgADcwADNgQ"));
        sendPhoto.setCaption("Sony PSP 2001\n"+"Narxi=2 136 000");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void Psp3(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBBWeYrLxFUc-4j1nTyQYd-hNs3ycZAALA7DEboJHISHYe-DzQEO0RAQADAgADcwADNgQ"));
        sendPhoto.setCaption("Sony PSP E1008\n"+"Narxi=550 000");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void Psp4(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBBmeYrQycoAvoltXPwhDzsnM0YWyUAALC7DEboJHISDCGe5LhYqXwAQADAgADcwADNgQ"));
        sendPhoto.setCaption("Sony PSP 2000\n"+"Narxi=7 192 000");
        execute(sendPhoto);
    }

    @SneakyThrows
    private void vk1(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBLWeYsx1nO6iREuaQ9JR0SXwlBDFuAALz7DEboJHISMYmeNDWOBB-AQADAgADcwADNgQ"));
        sendPhoto.setCaption("Magic Leap 1\n"+"Narxi=2 500 000");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void vk2(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBLmeYs7sWJOvcZkWXVqrNvUzwN7WYAAL17DEboJHISCmJ8kX8KUxAAQADAgADcwADNgQ"));
        sendPhoto.setCaption("Magic Leap 2\n"+"Narxi=1 500 000");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void vk3(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBL2eYtGlVMucWR_oDeT18iNULCEyNAAL-7DEboJHISFQNhYMwx6cFAQADAgADcwADNgQ"));
        sendPhoto.setCaption("G04 Popular head\n"+"Narxi=1 200 000");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void vk4(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBMGeYtSzqQJGCAbEt7FYfbeKkwcZBAAID7TEboJHISNl0OBnMxv0uAQADAgADcwADNgQ"));
        sendPhoto.setCaption("VMAXTEL 5F\n"+"Narxi=3 000 000");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void vk5(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBMGeYtnD077y3pLZGDnLkEgcKjh3QAAIJ7TEboJHISAXvLJnNfvSKAQADAgADcwADNgQ"));
        sendPhoto.setCaption("Meta quest 1\n"+"Narxi=2 500 000");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void vk6(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBMmeYuBcCUe0X9AEVGXf5XJs_eboMAAIT7TEboJHISHcPor3LlHqmAQADAgADcwADNgQ"));
        sendPhoto.setCaption("Meta quest 2\n"+"Narxi=5 200 000");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void vk7(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBM2eYuXgdAAHhXEcz77xb0tkZRpzENgACHu0xG6CRyEj_zR9Gs6vZZQEAAwIAA3MAAzYE"));
        sendPhoto.setCaption("Meta quest 3\n"+"Narxi=7 500 000");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void vk8(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBNGeYuclBYAor9q1d62y4q2f-8wqEAAIg7TEboJHISN1M9Wc1LsujAQADAgADcwADNgQ"));
        sendPhoto.setCaption("Meta quest 4\n"+"Narxi=8 200 000");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void sh1(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBsmeZCVxRmt5YaV7vB6mvvehBE4SNAALN9DEb5VnISG4BqrWXVyHnAQADAgADcwADNgQ"));
        sendPhoto.setCaption("Sony Play Station VR 4\n"+"Narxi=9 250 000");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void sh2(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBs2eZCppbgdfJrqIh7EnqwSnZwOkLAALV9DEb5VnISFIx0U42Lx0SAQADAgADcwADNgQ"));
        sendPhoto.setCaption("Aftanom VR shlem 4\n"+"Narxi=7 150 000");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void sh3(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBtGeZC6qWG5QUMJcPnL787TYQXRxjAALZ9DEb5VnISAUlmnT6_qYoAQADAgADcwADNgQ"));
        sendPhoto.setCaption("Okculus rift S\n"+"Narxi=10 500 000");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void sh4(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBtGeZC6qWG5QUMJcPnL787TYQXRxjAALZ9DEb5VnISAUlmnT6_qYoAQADAgADcwADNgQ"));
        sendPhoto.setCaption("Somnium VR1\n"+"Narxi=10 548 000");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void sh5(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBtWeZDo7iUGxTQ9Mybq1dAAE3DedzFwAC8vQxG-VZyEj5nvkdHSh5igEAAwIAA3MAAzYE"));
        sendPhoto.setCaption("VR BOX 1.0\n"+"Narxi=7 548 000");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void sh6(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIBtmeZDttCmTAUE5EWo97DWmtK0uQHAAL09DEb5VnISPURZUvYGHdVAQADAgADcwADNgQ"));
        sendPhoto.setCaption("VR BOX 2.0\n"+"Narxi=7 548 000");
        execute(sendPhoto);
    }


    @SneakyThrows
    private void xa(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Mahsulot hozircha mavjud emas");
        execute(sendMessage);
    }

    public String getBotUsername() {
        return "@Elektronika_buyumlari_bot:";
    }

    @Override
    public String getBotToken() {
        return "7212429298:AAFkT_dCtUDyTFM9z0CP633V1a2VSQJBFdw";
    }
}
