package com.company.a24;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Mehmon extends TelegramLongPollingBot{
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        String text = message.getText();
        Long chatId = message.getChatId();
        switch (text){
            case "/start"->sendop(chatId,"lok");
            case "Buyurtmalar tarixi"->hj(chatId);
            case "Xonani bekor qilish"->Bek(chatId);
            case "Jamoamizga qo'shiling"->Jamoa(chatId);
            case "Mehmona bilan aloqa"->Aloqa(chatId);
            case "Xona band qilish"->hon(chatId);
            case "Ortga"->sendop(chatId,"dfw");
            case "Fikr bildirish"->c(chatId);
            case "\uD83D\uDCAC Biz bilan aloqaga chiqing" -> pl(chatId, "ji");
            case "⚙\uFE0FSozlash ℹ\uFE0F Ma'lumotlar" -> Senuy(chatId, "kg");
        }
        switch (text){
            case "Ismni o'zgartirish" -> hj(chatId);
            case "\uD83D\uDCF1Raqamni o'zgartirish" -> hj(chatId);
            case "\uD83C\uDFD9Shaharini o'zgartirish" -> hj(chatId);
            case "\uD83C\uDDFA\uD83C\uDDFFTilni o'zgartirish" -> hj(chatId);
            case "ℹ\uFE0FFilialar haqida malumot" -> hj(chatId);
            case "\uD83D\uDCC4Ommaviy taklif" -> hj(chatId);
        }
        switch (text){
            case "Lux xona"->senL(chatId);
            case "1 xona"->X1(chatId);
            case "2 xona"->X2(chatId);
            case "3 xona"->X3(chatId);
            case "4 xona"->X4(chatId);
            case "5 xona"->X5(chatId);
            case "6 xona"->X6(chatId);
            case "7 xona"->X7(chatId);
            case "8 xona"->X8(chatId);
            case "9 xona"->X9(chatId);
            case "10 xona"->X10(chatId);
        }
        switch (text){
            case "O'rtacha xona"->Orta(chatId);
            case "1 xona."->O1(chatId);
            case "2 xona."->O2(chatId);
            case "3 xona."->O3(chatId);
            case "4 xona."->O4(chatId);
            case "5 xona."->O5(chatId);
            case "6 xona."->O6(chatId);
            case "7 xona."->O7(chatId);
            case "8 xona."->O8(chatId);
            case "9 xona."->O9(chatId);
            case "10 xona."->O10(chatId);
        }
        switch (text){
            case "Arzon xona"->Arzon(chatId);
            case "1-xona"->A1(chatId);
            case "2-xona"->A2(chatId);
            case "3-xona"->A3(chatId);
            case "4-xona"->A4(chatId);
            case "5-xona"->A5(chatId);
            case "6-xona"->A6(chatId);
            case "7-xona"->A7(chatId);
            case "8-xona"->A8(chatId);
            case "9-xona"->A9(chatId);
            case "10-xona"->A10(chatId);
        }
    }
    private void hj(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("\uD83D\uDCDEMening raqamim");
        button1.setRequestContact(true);
        KeyboardButton button2 =new KeyboardButton();
        button2.setText("Ortga");
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button1);
        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button2);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
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
        sendMessage.setText("Ro'yxatdan o'tish uchun telefon raqamingizni kiriting!\n" +
                "Misol uchun, +998xx xxx xx xx");
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


    private void pl(Long chatId,String text){
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
    private void Arzon(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("1-xona");
        KeyboardButton button2 = new KeyboardButton();
        button2.setText("2-xona");
        KeyboardButton button3 = new KeyboardButton();
        button3.setText("3-xona");
        KeyboardButton button4 = new KeyboardButton();
        button4.setText("4-xona");
        KeyboardButton button5 = new KeyboardButton();
        button5.setText("5-xona");
        KeyboardButton button6 = new KeyboardButton();
        button6.setText("6-xona");
        KeyboardButton button7 = new KeyboardButton();
        button7.setText("7-xona");
        KeyboardButton button8 = new KeyboardButton();
        button8.setText("8-xona");
        KeyboardButton button9 = new KeyboardButton();
        button9.setText("9-xona");
        KeyboardButton button10 = new KeyboardButton();
        button10.setText("10-xona");
        KeyboardButton button11 = new KeyboardButton();
        button11.setText("Ortga");


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
        KeyboardRow keyboard4 = new KeyboardRow();
        keyboard4.add(button9);
        keyboard4.add(button10);
        KeyboardRow keyboard5=new KeyboardRow();
        keyboard5.add(button11);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keyboard2);
        qatorlar.add(keyboard3);
        qatorlar.add(keyboard4);
        qatorlar.add(keyboard5);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Arzon xonalarmiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    private void Orta(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("1 xona.");
        KeyboardButton button2 = new KeyboardButton();
        button2.setText("2 xona.");
        KeyboardButton button3 = new KeyboardButton();
        button3.setText("3 xona.");
        KeyboardButton button4 = new KeyboardButton();
        button4.setText("4 xona.");
        KeyboardButton button5 = new KeyboardButton();
        button5.setText("5 xona.");
        KeyboardButton button6 = new KeyboardButton();
        button6.setText("6 xona.");
        KeyboardButton button7 = new KeyboardButton();
        button7.setText("7 xona.");
        KeyboardButton button8 = new KeyboardButton();
        button8.setText("8 xona.");
        KeyboardButton button9 = new KeyboardButton();
        button9.setText("9 xona.");
        KeyboardButton button10 = new KeyboardButton();
        button10.setText("10 xona.");
        KeyboardButton button11 = new KeyboardButton();
        button11.setText("Ortga");


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
        KeyboardRow keyboard4 = new KeyboardRow();
        keyboard4.add(button9);
        keyboard4.add(button10);
        KeyboardRow keyboard5=new KeyboardRow();
        keyboard5.add(button11);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keyboard2);
        qatorlar.add(keyboard3);
        qatorlar.add(keyboard4);
        qatorlar.add(keyboard5);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("O'rtacha xonalarmiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    private void senL(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("1 xona");
        KeyboardButton button2 = new KeyboardButton();
        button2.setText("2 xona");
        KeyboardButton button3 = new KeyboardButton();
        button3.setText("3 xona");
        KeyboardButton button4 = new KeyboardButton();
        button4.setText("4 xona");
        KeyboardButton button5 = new KeyboardButton();
        button5.setText("5 xona");
        KeyboardButton button6 = new KeyboardButton();
        button6.setText("6 xona");
        KeyboardButton button7 = new KeyboardButton();
        button7.setText("7 xona");
        KeyboardButton button8 = new KeyboardButton();
        button8.setText("8 xona");
        KeyboardButton button9 = new KeyboardButton();
        button9.setText("9 xona");
        KeyboardButton button10 = new KeyboardButton();
        button10.setText("10 xona");
        KeyboardButton button11 = new KeyboardButton();
        button11.setText("Ortga");


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
        KeyboardRow keyboard4 = new KeyboardRow();
        keyboard4.add(button9);
        keyboard4.add(button10);
        KeyboardRow keyboard5=new KeyboardRow();
        keyboard5.add(button11);
        ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
        qatorlar.add(keyboard);
        qatorlar.add(keyboard1);
        qatorlar.add(keyboard2);
        qatorlar.add(keyboard3);
        qatorlar.add(keyboard4);
        qatorlar.add(keyboard5);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(qatorlar);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Lux honalarmiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    private void c (Long chatId) {
        InlineKeyboardButton btn1 = new InlineKeyboardButton();
        btn1.setText("Hizmat korsatish");
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
        btn7.setText("Sharoit");
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
        List<List<InlineKeyboardButton>> roes = new ArrayList<>();
        roes.add(row1);
        roes.add(row);
        roes.add(rowp);
        roes.add(row6);

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
    private void hon(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Lux xona");
        KeyboardButton button2 = new KeyboardButton();
        button2.setText("O'rtacha xona");
        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Arzon xona");
        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button1);
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button2);
        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button3);
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
        sendMessage.setText("Handay honani tanlaysiz");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    private void Jamoa(Long chatId){
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
    private void sendop (Long chatId, String text){
        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Xona band qilish");
        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Xonani bekor qilish");
        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Mehmona bilan aloqa");
        KeyboardButton button5 =new KeyboardButton();
        button5.setText("Jamoamizga qo'shiling");
        KeyboardButton button6 =new KeyboardButton();
        button6.setText("⚙\uFE0FSozlash ℹ\uFE0F Ma'lumotlar");
        KeyboardButton button7 =new KeyboardButton();
        button7.setText("Buyurtmalar tarixi");
        KeyboardRow keyboard = new KeyboardRow();
        keyboard.add(button2);
        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(button4);
        keyboard1.add(button5);
        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(button6);
        keyboard2.add(button7);
        KeyboardRow keyboard3 = new KeyboardRow();
        keyboard3.add(button3);
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
        sendMessage.setText("Bizning Mehmonhonamizga hush kelibsiz aziz mehmon");
        sendMessage.setReplyMarkup(markup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    private void Aloqa(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("\uD83D\uDCAC Biz bilan aloqaga chiqing");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Fikr bildirish");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Ortga");
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
    @SneakyThrows
    private  void Bek(Long chatId){
        SendMessage sendMessage=new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Band qilingan xona bekor qilindi");
        execute(sendMessage);
    }
    @SneakyThrows
    private void X1(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAMFZ5paU6sX89Wum5vjx07-TZS5GmgAAhzqMRtrXdBIEeW20ET3rvcBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Lux xona 2 kishiga mojalangan\n"+"Hamma sharoit 3 mahal ovqat 24/7 hizmat ko'rsatish\n"+"Narxi=1 hafta 1 000 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void X2(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAMOZ5pcjlhdbhR1J8Gx1g2udf0DS4QAAn_qMRtrXdBIiaX9z9-47qcBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Lux xona 1 kishiga mojalangan\n"+"Hamma sharoit bor 24/7 hizmat ko'rsatish\n"+"Narxi=1 hafta  900 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void X3(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAMQZ5suiablwN4K4rpeTKnzfw953HwAAl_uMRtaSNlIklgVPoAUpyYBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Lux xona 4 kishiga mojalangan\n"+"Hamma sharoit bor 24/7 hizmat ko'rsatish Shvet stoli mehmonxona hisobidan\n"+"Narxi=1 hafta  1 400 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void X4(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAMQZ5svPvMFwAJbOShD8S-AhcNnflYAAnPuMRtaSNlIdoHozXy2cyYBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Lux xona 2 kishiga mojalangan\n"+"Hamma sharoit bor Bar va chet el taomlari 24/7 hizmat ko'rsatish\n"+"Narxi=1 hafta  2 000 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void X5(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANwZ5tZ6smxr-I_aAypwvREzlOeVywAAuTvMRtaSNlIF7DSYlF6EYEBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Lux xona 2 kishiga mojalangan\n"+"Hamma sharoit bor 24/7 hizmat ko'rsatish\n"+"Narxi=1 hafta  1 000 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void X6(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAMOZ5pcjlhdbhR1J8Gx1g2udf0DS4QAAn_qMRtrXdBIiaX9z9-47qcBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Lux xona oila uchun mojalangan\n"+"Hamma sharoit bor\n"+"Narxi=1 hafta  1 500 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void X7(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAMUZ5sxRE4CMRLPInRntGYG7gjbhIYAAonuMRtaSNlIDQrd6SgUrRUBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Lux xona 1 kishiga mojalangan\n"+"Hamma sharoit bor 24/7 hizmat ko'rsatish\n"+"Narxi=1 hafta  900 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void X8(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAMVZ5sxmXl45cbwhCoAAXTNz4_KYq66AAKL7jEbWkjZSBH4PM7iPFGnAQADAgADcwADNgQ"));
        sendPhoto.setCaption("Lux xona 4 kishiga mojalangan\n"+"Hamma sharoit bor 24/7 hizmat ko'rsatish\n"+"Narxi=1 hafta  750 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void X9(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAMWZ5sx38DlVSsuKqkg6VTthkUSU1wAAozuMRtaSNlIIiWjJAVADJkBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Lux xona 1 kishiga mojalangan\n"+"Hamma sharoit bor 24/7 hizmat ko'rsatish\n"+"Narxi=1 hafta  1 000 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void X10(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAMXZ5syFi1KQt2xmYsfhx-I2G2u1hgAAo3uMRtaSNlI4VYww5ALnDkBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Lux xona 1 kishiga mojalangan\n"+"Hamma sharoit bor 24/7 hizmat ko'rsatish\n"+"Narxi=1 hafta  850 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void O1(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANaZ5tU4oOSJlxjXbnlfBVmRxy6Sh8AArbvMRtaSNlILaeKKcTGSbIBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 4 kishiga mojalangan\n"+"Hamma sharoit bor 24/7 hizmat ko'rsatish\n"+"Narxi=1 hafta  550 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void O2(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANbZ5tVmN253XUxSyVz6L3IX5TLa50AAr_vMRtaSNlIskoBJzkSVzYBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 2 kishiga mojalangan\n"+"Hamma sharoit bor 24/7 hizmat ko'rsatish\n"+"Narxi=1 hafta  400 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void O3(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANcZ5tWAh1b9I3N40iso_oYjQu9Ee8AAsDvMRtaSNlIsfxxN8cL3dcBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 2 kishiga mojalangan\n"+"Hamma sharoit bor 24/7 hizmat ko'rsatish\n"+"Narxi=1 hafta  350 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void O4(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANdZ5tWQ-LAFt33nNLAZNyvr_omsKgAAsXvMRtaSNlI_p99pb12PHABAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 1 kishiga mojalangan\n"+"Hamma sharoit bor 24/7 hizmat ko'rsatish\n"+"Narxi=1 hafta  400 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void O5(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANeZ5tW5OBC7HVVXC4jUnvc6B_F-1AAAsrvMRtaSNlIGUZVpFsck3kBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 2 kishiga mojalangan\n"+"Hamma sharoit bor 24/7 hizmat ko'rsatish\n"+"Narxi=1 hafta  400 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void O6(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANfZ5tXpAVLMDxwisVgqLUWlOquVSMAAs_vMRtaSNlIe3P-kAzx-JcBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 2 kishiga mojalangan\n"+"Hamma sharoit bor 24/7 hizmat ko'rsatish\n"+"Narxi=1 hafta  500 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void O7(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANgZ5tX_OtMAAG7SfE008Dc3FbILVsfAALQ7zEbWkjZSGGszaGE_lvUAQADAgADcwADNgQ"));
        sendPhoto.setCaption("Oddiy xona 2 kishiga mojalangan\n"+"Hamma sharoit bor 24/7 hizmat ko'rsatish\n"+"Narxi=1 hafta  600 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void O8(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANhZ5tYRCWHW9uPlwwU6EVgHRPVE_MAAtPvMRtaSNlIub6TSFWsl5sBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 2 kishiga mojalangan\n"+"Hamma sharoit bor 24/7 hizmat ko'rsatish\n"+"Narxi=1 hafta  700 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void O9(Long chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANiZ5tY33nIrFC-Czu5UXtBHo1TMaYAAtnvMRtaSNlIPS2qHr_V_IIBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 1 kishiga mojalangan\n"+"Hamma sharoit bor 24/7 hizmat ko'rsatish\n"+"Narxi=1 hafta  550 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void O10(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAANjZ5tZGB4wDwhPriIEC5rhKJEpomMAAtzvMRtaSNlIL_psSdYKB0UBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 1 kishiga mojalangan\n"+"Hamma sharoit bor 24/7 hizmat ko'rsatish\n"+"Narxi=1 hafta  850 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void A1(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAOoZ5uaOmDuViyJGLp9N9aQwMqAMVIAAofyMRtaSNlI8HOOMUQXBbEBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 1 kishiga mojalangan\n"+"Hamma sharoit bor O'z-o'ziga hizmat ko'rsatish\n"+"Narxi=1 hafta  150 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void A2(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAOpZ5uaoMoqXnIhrq9y61iGzkX1TawAAoryMRtaSNlI5qlntywwbwMBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 3 kishiga mojalangan\n"+"Hamma sharoit bor O'z-o'ziga hizmat ko'rsatish\n"+"Narxi=1 hafta  200 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void A3(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAOqZ5ua-0fuVXP5SQ_BlXTPdmloqJMAAo3yMRtaSNlIEyyqueXfvSEBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 3 kishiga mojalangan\n"+"Hamma sharoit bor O'z-o'ziga hizmat ko'rsatish\n"+"Narxi=1 hafta  120 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void A4(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAOrZ5ubcnUGvoLhszCidPmsTfDKUggAApPyMRtaSNlI674l3ml4wAIBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 3 kishiga mojalangan\n"+"Hamma sharoit bor O'z-o'ziga hizmat ko'rsatish\n"+"Narxi=1 hafta  1 000 000 so'm");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void A5(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAOsZ5ucR307SXkQwXqtdXv0fqj0h5QAApbyMRtaSNlI1L1BpmszULQBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 2 kishiga mojalangan\n"+"Hamma sharoit bor O'z-o'ziga hizmat ko'rsatish\n"+"Narxi=1 hafta  100 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void A6(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAOuZ5udG58xbXmcVwgELDrsrTuGuFQAApzyMRtaSNlI46BNy1u7sIYBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 3 kishiga mojalangan\n"+"Hamma sharoit bor O'z-o'ziga hizmat ko'rsatish\n"+"Narxi=1 hafta  150 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void A7(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAOvZ5udkmMjYeKrDNpaqnv04qvtlckAAqTyMRtaSNlIA4MVBuCmgwgBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 2 kishiga mojalangan\n"+"Hamma sharoit bor O'z-o'ziga hizmat ko'rsatish\n"+"Narxi=1 hafta  50 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void A8(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAOwZ5ud64AtzsBkQAt7FfxBls_OEXEAAqnyMRtaSNlI7bP777hWS28BAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 2 kishiga mojalangan\n"+"Hamma sharoit bor O'z-o'ziga hizmat ko'rsatish\n"+"Narxi=1 hafta  100 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void A9(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAOxZ5ueN88_sL1VTiENv3g6Ebvpnl0AAq7yMRtaSNlI_lnKCfJmbk0BAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 3 kishiga mojalangan\n"+"Hamma sharoit bor O'z-o'ziga hizmat ko'rsatish\n"+"Narxi=1 hafta  150 $");
        execute(sendPhoto);
    }
    @SneakyThrows
    private void A10(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAOzZ5ufaxDUA5fMdbvkvE2PbEmu-Y8AArvyMRtaSNlI6HRb3zVMOQsBAAMCAANzAAM2BA"));
        sendPhoto.setCaption("Oddiy xona 3 kishiga mojalangan\n"+"Hamma sharoit bor O'z-o'ziga hizmat ko'rsatish\n"+"Narxi=1 hafta  150 $");
        execute(sendPhoto);
    }


    public String getBotUsername() {
    return "@Mehmonhona1bot:";
}

@Override
public String getBotToken() {
    return "7939708364:AAH5r-cXj_l50YeotpGNA3y4JaIAbTrd-pk";
}

}

