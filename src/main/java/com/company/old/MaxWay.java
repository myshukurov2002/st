package com.company.old;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
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
import java.util.LinkedList;
import java.util.List;


public class MaxWay extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        String text = message.getText();
        Long chatId = message.getChatId();

        switch (text) {
            case "\uD83D\uDC5CBuyurtma berish" -> ortga(chatId, "ortga");
            case "Olib ketish" -> olibketish(chatId, "olib");
            case "Yetkazib berish" -> yetqazib(chatId, "Yetkazib");
            case "MAX WAY ALAYSKIY" -> alayski(chatId, "ayal");
            case "MAX WAY BERUNIY" -> Beruniy(chatId, "beruniy");
            case "MAX WAY ATLAS" -> atlas(chatId, "atlas");
            case "MAX WAY DRUJBA" -> drujba(chatId, "drujba");
            case "MAX WAY MEGA PLANET" -> megaplanet(chatId, "mega");
            case "MAX WAY AVIASOZLAR" -> aviasozlar(chatId, "avia");
            case "MAX WAY RISOVIY" -> risoviy(chatId, "risoviy");
            case "MAX WAY PARUS" -> parus(chatId, "parus");
            case "MAX WAY MAGIC CITY" -> magiccity(chatId, "magic");
            case "MAX WAY SAMARQAND DARVOZA" -> samarqanddarvoza(chatId, "sama");
            case "MAX WAY PARKENT" -> parkent(chatId, "par");
            case "MAX WAY UNIVERSAM" -> universam(chatId, "uni");
            case "MAX WAY ROYSON" -> royson(chatId, "roy");
            case "MAX WAY NEXT" -> next(chatId);
            case "MAX WAY MUQUMIY" -> muqumi(chatId);
            case "MAX WAY GRAND MIR" -> grand(chatId);
            case "MAX WAY SAYRAM" -> sayram(chatId);
            case "MAX WAY MAKSIM GORKIY" -> maksim(chatId);
            case "MAX WAY FONTAN" -> fontan(chatId);
            case "MAX WAY MINOR" -> minor(chatId);
            case "Yangilik \uD83D\uDCE3" -> yangililik(chatId, "yang");
            case "\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX" -> maxibox(chatId);
            case "\uD83E\uDD6AKlab-Sendvich" -> klab(chatId);
            case "\uD83C\uDF2FLavash" -> lavash(chatId);
            case "\uD83C\uDF2EShaurma va Arapita" -> shaurma(chatId);
            case "\uD83C\uDF54Burger" -> burger(chatId);
            case "\uD83C\uDF71Donar kebab" -> donarkebap(chatId);
            case "\uD83C\uDF2DHot dog" -> hotdog(chatId);
            case "\uD83C\uDF5FGazaklar" -> gazaklar(chatId);
            case "\uD83C\uDF5ATamaddilar" -> tamadillar(chatId);
            case "\uD83C\uDF70Desertlar" -> desertlar(chatId);
            case "\uD83E\uDD64Ichimliklar" -> ichimlik(chatId);
            case "☕\uFE0FIssiq ichimliklar" -> issiqichimliklar(chatId);
            case "\uD83E\uDD6BSouslar" -> souslar(chatId);
            case "Maxi Box Original Chicken" -> boxorginalchicken(chatId);
            case "Maxi Box Original Beef" -> boxorginalbef(chatId);
            case "Maxi Box Traditsiya" -> boxtradit(chatId);
            case "Maxi Box Tasty" -> boxtasy(chatId);
            case "Maxi Box Popular" -> boxpopular(chatId);
            case "Maxi Box Retro" -> boxretro(chatId);
            case "Max Box German" -> boxgerman(chatId);
            case "Maxi Box Trent" -> boxtrend(chatId);
            case "Mini Box" -> minibox(chatId);
            case "\uD83C\uDF89Aksiya" -> aksiya(chatId);
            case "Arapita Chicken" -> yanglikarapita(chatId);
            case "Arapita Beef" -> yanglikarapitabef(chatId);
            case "Issiq mors Malina" -> yanglikmorsmalina(chatId);
            case "Issiq mors Kiwi-uzum" -> yanglikmorskiwi(chatId);
            case "Issiq mors Citrus-Lemongrass" -> yablikmorscitrus(chatId);
            case "ℹ\uFE0FBiz haqimizda" -> bizxaqmzda(chatId);
            case "Sendvich Original" -> sendvcorg(chatId);
            case "Klab sendvich" -> klabsendvc(chatId);
            case "Tasty Klab" -> tastyklab(chatId);
            case "Lavash mini klassik" -> lavashminiklass(chatId);
            case "Lavash mini pishloqli" -> lavashminipishlo(chatId);
            case "Lavash standart klassik" -> lavashstandartklass(chatId);
            case "Lavash standart achchiq" -> lavashstandartachiq(chatId);
            case "Lavash standart pishloqli" -> lavashstandartpishlo(chatId);
            case "Arapita Chickenn" -> arapitachicken(chatId);
            case "Arapita Beeff" -> arapitabeef(chatId);
            case "German Donar" -> germandonar(chatId);
            case "Shaurma" -> shaurmaa(chatId);
            case "Shaurma Pishloqli" -> shaurmapishlo(chatId);
            case "Gamburger" -> gamburger(chatId);
            case "Chizburger" -> chizburger(chatId);
            case "Bigburger" -> bigburger(chatId);
            case "Donar kebab" -> donarkebab(chatId);
            case "Donar Box" -> donarbox(chatId);
            case "Non" -> Non(chatId);
            case "Hot dog" -> Hotdog(chatId);
            case "Chiz dog" -> chizdog(chatId);
            case "Longer" -> longer(chatId);
            case "Kartoshka fri mini" -> kartoshkakrmini(chatId);
            case "Kartoshka fri standart" -> kartoshkafristandart(chatId);
            case "Kartoshka fri katta" -> kartoshkafrikatta(chatId);
            case "Po derevenski" -> poderevenski(chatId);
            case "Nagetslar 4 dona" -> naggets4(chatId);
            case "Nagetslar 6 dona" -> naggets6(chatId);
            case "Nagetslar 10 dona" -> naggets10(chatId);
            case "Nagetslar 18 dona" -> naggets18(chatId);
            case "Stripslar S(3)" -> stripss3(chatId);
            case "Stripslar M(5)" -> stripsm5(chatId);
            case "Stripslar L(7)" -> stripsl7(chatId);
            case "Naggets BOX" -> naggetsbox(chatId);
            case "Mix Box" -> mixbox(chatId);
            case "Tiramisu" -> tiramisu(chatId);
            case "Salat" -> salat(chatId);
            case "Guruch" -> guruch(chatId);
            case "Brauni" -> brauni(chatId);
            case "San sebastian" -> sansebastian(chatId);
            case "Yo'ng'okli donat" -> yongoklidonat(chatId);
            case "Karamel donat" -> karameldonat(chatId);
            case "Qulupnayli donat" -> qulupnaylidonat(chatId);
            case "Moxito" -> moxito(chatId);
            case "Coca cola" -> cocacola(chatId);
            case "Sprite 0,5" -> sprite(chatId);
            case "Coca Cola 1.5L" -> cocacola15(chatId);
            case "Fanta" -> fanta(chatId);
            case "Coca Cola 0.5L" -> cocacola05(chatId);
            case "Sharbat dena" -> sharbatdena(chatId);
            case "Fuse tea" -> fusetea(chatId);
            case "Bonaqua" -> bonaqua(chatId);
            case "Bir martali stakan" -> birmartalistakan(chatId);
            case "Issiq mors malina" -> issiqmorlmalina(chatId);
            case "Qora choy" -> qorachoy(chatId);
            case "Ko'k choy " -> kokchoy(chatId);
            case "Linonli choy" -> limonlichoy(chatId);
            case "Americano" -> americano(chatId);
            case "Kapuchino" -> kapuchino(chatId);
            case "Latte" -> latte(chatId);
            case "Ketchup" -> ketchup(chatId);
            case "Pishloqli sous" -> pishloqlisous(chatId);
            case "Sarimsoqli sous" -> sarimsoqlisous(chatId);
            case "Ketchup chili" -> ketchupchili(chatId);
            case "Xalapeno" -> xalapeno(chatId);
            case "Shirin va nordon sous" -> shirinvanordonsous(chatId);
            case "\uD83D\uDDD3Barcha filiallar" -> barchafillial(chatId);
            case "\uD83D\uDDD3Mening buyurtmalarim" -> buyurtmlarami(chatId);
            case "✍\uFE0FIzoh qoldirish" -> izoh(update);
            default -> buyurtma(chatId, "Buyurtma");
        }



    }

    private void buyurtma (Long chatId, String text) {

                KeyboardButton button1 = new KeyboardButton();
                button1.setText("\uD83D\uDC5CBuyurtma berish");


                KeyboardButton button2 = new KeyboardButton();
                button2.setText("\uD83C\uDF89Aksiya");

                KeyboardButton button3 = new KeyboardButton();
                button3.setText("\uD83D\uDDD3Barcha filiallar");


                KeyboardButton button4 = new KeyboardButton();
                button4.setText("\uD83D\uDCBCVakansiyalar");


                KeyboardButton button5 = new KeyboardButton();
                button5.setText("\uD83D\uDDD3Mening buyurtmalarim");

                KeyboardButton button6 = new KeyboardButton();
                button6.setText("✍\uFE0FIzoh qoldirish");
                KeyboardButton button7 = new KeyboardButton();
                button7.setText("\uD83D\uDCBCVakansiyalar");
                KeyboardButton button8 = new KeyboardButton();
                button8.setText("ℹ\uFE0FBiz haqimizda");

                KeyboardRow qator1 = new KeyboardRow();
                qator1.add(button1);

                KeyboardRow qator2 = new KeyboardRow();
                qator2.add(button2);
                qator2.add(button3);

                KeyboardRow qator3 = new KeyboardRow();
                qator3.add(button5);
                qator3.add(button6);

                KeyboardRow qator4 = new KeyboardRow();
                qator4.add(button7);
                qator4.add(button8);


                ArrayList<KeyboardRow> qatorlar = new ArrayList<>();
                qatorlar.add(qator1);
                qatorlar.add(qator2);
                qatorlar.add(qator3);
                qatorlar.add(qator4);


                ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
                markup.setKeyboard(qatorlar);
                markup.setResizeKeyboard(true);
                markup.setOneTimeKeyboard(true);
                markup.setSelective(false);
                markup.setIsPersistent(false);

                SendMessage sendMassage1 = new SendMessage();
                sendMassage1.setChatId(chatId);
                sendMassage1.setText("Buyurtma berishni boshlash uchun \uD83D\uDECD Buyurtma berish tugmasini bosing\n" + "\n" +
                        "Shuningdek, aksiyalarni ko'rishingiz va bizning filiallar bilan tanishishingiz mumkin\n" + "\n" +
                        "menu (https://maxway.uz/uz)");
                sendMassage1.setReplyMarkup(markup);


                try {
                    execute(sendMassage1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            }

    private void ortga (Long chatId, String text) {
            KeyboardButton buyurtma1 = new KeyboardButton();
            buyurtma1.setText("Olib ketish");

            KeyboardButton buyurtma2 = new KeyboardButton();
            buyurtma2.setText("Yetkazib berish");

            KeyboardButton buyurtma3 = new KeyboardButton();
            buyurtma3.setText("⬅\uFE0F Orqaga");

            KeyboardRow row = new KeyboardRow();
            row.add(buyurtma1);
            row.add(buyurtma2);

            KeyboardRow row1 = new KeyboardRow();
            row1.add(buyurtma3);

            ArrayList<KeyboardRow> rows = new ArrayList<>();
            rows.add(row);
            rows.add(row1);

            ReplyKeyboardMarkup markup1 = new ReplyKeyboardMarkup();
            markup1.setKeyboard(rows);
            markup1.setResizeKeyboard(true);
            markup1.setOneTimeKeyboard(true);
            markup1.setSelective(false);
            markup1.setIsPersistent(false);

            SendMessage message1 = new SendMessage();
            message1.setChatId(chatId);
            message1.setText("Yetkazib berish turini tanlang");
            message1.setReplyMarkup(markup1);

            try {
                execute(message1);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }

        private void buyurtmlarami(Long chatId){
        KeyboardButton button = new KeyboardButton();
        button.setText("\uD83D\uDDC2 | Asosiy menu");

        KeyboardRow row = new KeyboardRow();
        row.add(button);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row);

            ReplyKeyboardMarkup markup1 = new ReplyKeyboardMarkup();
            markup1.setKeyboard(rows);
            markup1.setResizeKeyboard(true);
            markup1.setOneTimeKeyboard(true);
            markup1.setSelective(false);
            markup1.setIsPersistent(false);

            SendMessage message1 = new SendMessage();
            message1.setChatId(chatId);
            message1.setText("Sizda buyurtmalar yo'q");
            message1.setReplyMarkup(markup1);

            try {
                execute(message1);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }


        private void izoh(Update update) {
            Message message = update.getMessage();
            String text = message.getText();
            Long chatId = message.getChatId();

            if (text.equals("✍\uFE0FIzoh qoldirish")) {
                List<List<InlineKeyboardButton>> rowList = new LinkedList<>();
                List<InlineKeyboardButton> row = new LinkedList<>();

                InlineKeyboardButton button = new InlineKeyboardButton();
                button.setText("Adminga xabar yuborish");
                button.setSwitchInlineQueryCurrentChat("Matnni kiriting : ");

                row.add(button);
                rowList.add(row);

                InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                inlineKeyboardMarkup.setKeyboard(rowList);

                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText("Izoh qoldiring. Sizning fikringiz biz uchun muhim");
                sendMessage.setReplyMarkup(inlineKeyboardMarkup);

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }


                ForwardMessage forwardMessage = new ForwardMessage();
                forwardMessage.setChatId("Your Admin Id");
                forwardMessage.setMessageId(message.getMessageId());
                forwardMessage.setFromChatId(message.getChatId());

                try {
                    execute(forwardMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }


                SendMessage sendMessage1 = new SendMessage();
                sendMessage1.setText("Xabaringiz yuborildi tez orada a'loqaga chiqamiz.");
                sendMessage1.setChatId(message.getChatId());
                try {
                    execute(sendMessage1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    private void olibketish(Long chatId, String text){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCCDEng yaqin fillialni aniqlash");
        button2.setRequestLocation(true);

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("MAX WAY ALAYSKIY");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("MAX WAY BERUNIY");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("MAX WAY ATLAS");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("MAX WAY DRUJBA");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("MAX WAY MEGA PLANET");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("MAX WAY AVIASOZLAR");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("MAX WAY RISOVIY");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("MAX WAY PARUS");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("MAX WAY MAGIC CITY");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("MAX WAY SAMARQAND DARVOZA");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("MAX WAY PARKENT");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("MAX WAY UNIVERSAM");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("MAX WAY ROYSON");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("MAX WAY NEXT");

        KeyboardButton button17 = new KeyboardButton();
        button17.setText("MAX WAY MUQUMIY");

        KeyboardButton button18 = new KeyboardButton();
        button18.setText("MAX WAY GRAND MIR");

        KeyboardButton button19 = new KeyboardButton();
        button19.setText("MAX WAY SAYRAM");

        KeyboardButton button20 = new KeyboardButton();
        button20.setText("MAX WAY MAKSIM GORKIY");

        KeyboardButton button21 = new KeyboardButton();
        button21.setText("MAX WAY FONTAN");

        KeyboardButton button22 = new KeyboardButton();
        button22.setText("MAX WAY MINOR");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        KeyboardRow row9 = new KeyboardRow();
        row9.add(button17);
        row9.add(button18);

        KeyboardRow row10 = new KeyboardRow();
        row10.add(button19);
        row10.add(button20);

        KeyboardRow row11 = new KeyboardRow();
        row11.add(button21);
        row11.add(button22);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);
        rows.add(row9);
        rows.add(row10);
        rows.add(row11);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Fillialni tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }

    private void yetqazib(Long chatId, String text){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Lakatsiya yuborish");
        button1.setRequestLocation(true);

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("⬅\uFE0F Orqaga");

        KeyboardRow row = new KeyboardRow();
        row.add(button1);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row);
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(chatId);
        sendMassage1.setText("Buyurtmani davom ettirish uchun iltimos lokatsiyangizni yuboring");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }

    private void alayski(Long chatId, String text){
        KeyboardButton button1= new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(chatId);
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void yangililik(Long chatId, String text){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Arapita Chicken");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Arapita Beef");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Issiq mors Malina");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Issiq mors Kiwi-uzum");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("Issiq mors Citrus-Lemongrass");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(chatId);
        sendMassage1.setText("Yangilik \uD83D\uDCE3\n" +
                "\n" +
                "Mahsulotni tanlang:");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void Beruniy(Long chatId, String text) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void atlas(Long chatId, String text) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
            button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void drujba(Long chatId, String text) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void megaplanet(Long chatId, String text) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void aviasozlar(Long chatId, String text) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void risoviy(Long chatId, String text) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void parus(Long chatId, String text) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void magiccity(Long chatId, String text) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void samarqanddarvoza(Long chatId, String text) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void parkent(Long chatId,String text){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void universam(Long chatId, String text){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }

    private void royson(Long chatId, String text){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }

    private void next(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }

    private void muqumi(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }

    private void grand(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }

    private void sayram(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }

    private void maksim(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }

    private void fontan(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }

    private void minor(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Yangilik \uD83D\uDCE3");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6AKlab-Sendvich");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2FLavash");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2EShaurma va Arapita");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54Burger");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71Donar kebab");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2DHot dog");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5FGazaklar");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5ATamaddilar");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70Desertlar");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64Ichimliklar");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("☕\uFE0FIssiq ichimliklar");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("\uD83E\uDD6BSouslar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("Kategoriyani tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void maxibox(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Maxi Box Original Chicken");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Maxi Box Original Beef");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Maxi Box Traditsiya");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Maxi Box Tasty");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("Maxi Box Popular");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("Maxi Box Retro");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("Max Box German");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("Maxi Box Trent");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("Mini Box");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX\n" +
                "\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64BARAKALI Maxi BOX\n" +
                "Mahsulotni tanlang:");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void klab(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Sendvich Original");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Klab sendvich");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Tasty Klab");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("\uD83E\uDD6AKlab-Sendvich\n" +
                "\uD83E\uDD6AKlab-Sendvich\n" +
                "Mahsulotni tanlang:");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void lavash(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Lavash mini klassik");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Lavash mini pishloqli");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Lavash standart klassik");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Lavash standart achchiq");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("Lavash standart pishloqli");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("\uD83C\uDF2FLavash\n" +
                "\uD83C\uDF2FLavash\n" +
                "Mahsulotni tanlang:");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void shaurma(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Arapita Chickenn");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Arapita Beeff");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("German Donar");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Shaurma");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("Shaurma Pishloqli");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("\uD83C\uDF2EShaurma va Arapita\n" +
                "\uD83C\uDF2EShaurma\n" +
                "Mahsulotni tanlang:");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void burger(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Gamburger");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Chizburger");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Bigburger");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button6);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("\uD83C\uDF54Burger" +
                "Mahsulotni tanlang ");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void donarkebap(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Donar kebab");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Donar Box");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Non");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("\uD83C\uDF71Donar kebab" +
                "Mahsulotni tanlang ");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void hotdog(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Hot dog");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Chiz dog");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Longer");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("\uD83C\uDF2DHot dog" +
                "Mahsulotni tanlang ");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void tamadillar(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Guruch ");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Salat ");


        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);


        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);


        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("\uD83C\uDF5ATamaddilar" +
                "Mahsulotni tanlang ");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void desertlar(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Tiramisu");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Brauni");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("San-sebastian");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Yo'ng'oqli donat");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("Karamel donat");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("Qulupnayli donat");


        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);


        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);


        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("\uD83C\uDF70Desertlar" +
                "Mahsulotno tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void souslar(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Ketchup");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Pishloqli sous");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Sarimsoqli sous");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Ketchup chili");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("Xalapeno");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("Shirin va nordon sous");


        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);


        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);


        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("\uD83E\uDD6BSouslar" +
                "Mahsulotno tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void issiqichimliklar(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Issiq mors malina");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Issiq mors Kiwi-Uzum");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Issiq mors Citrus-Lemograss");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Qora choy");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("Ko'k choy");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("Limonli choy ");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("Americano");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("Kapuchino");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("Latte");


        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);


        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("☕\uFE0FIssiq ichimliklar" +
                "Mahsulotno tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void gazaklar(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Kartoshka fri mini");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Kartoshka fri standart");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Kartoshka fri katta");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Po derevenski");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("Nagetslar 4 dona");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("Nagetslar 6 dona");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("Nagetslar 10 dona");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("Nagetslar 18 dona");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("Stripslar S(3)");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("Stripslar M(5)");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("Stripslar L(7)");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("Naggets BOX");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("Mix Box");


        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button12);
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);


        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("\uD83C\uDF5FGazaklar" +
                "Mahsulotni tanlang ");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void ichimlik(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Moxito");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Coca Cola(quyma)");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Sprite 0.5L");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Coca Cola 1.5L");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("Fanta");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("Coca Cola 0.5L");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("Sharbat Dena");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("Fuse tea");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("Bonaqua");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("Bir martali stakan");


        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage sendMassage1 = new SendMessage();
        sendMassage1.setChatId(String.valueOf(chatId));
        sendMassage1.setText("\uD83E\uDD64Ichimliklar" +
                "Mahsulotni tanlang");
        sendMassage1.setReplyMarkup(markup);


        try {
            execute(sendMassage1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void boxorginalchicken(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fae7c0ac9-9ae8-46ca-812b-584934a1d74c&w=3840&q=75"));
        photo.setCaption("Maxi Box Original Chicken \n" +
                "Arapita Chicken + tanlash uchun ichimlik 0,4 + tanlash uchun sous+fri s \n" +
                "\n" +
                "Maxi Box Original Chicken 40 000 x 1 = 40 000\n" +
                "  - kichik kartoshka-fri      0 x 1 = 0\n" +
                "  - sarimsoqli sous      0 x 1 = 0\n" +
                "  - Coca Cola (quyma) 400 ml      0 x 1 = 0\n" +
                "  - Aksiya stiker      0 x 1 = 0\n" +
                "\n" +
                "Umumiy: 40 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void boxorginalbef(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fa7fd1a67-82c0-4963-a9ed-ae14378b46de&w=3840&q=75"));
        photo.setCaption("Maxi Box Original Beef \n" +
                "Arapita Биф + tanlash uchun ichimlik 0,4 + tanlash uchun sous+fri s \n" +
                "\n" +
                "Maxi Box Original Beef 42 000 x 1 = 42 000\n" +
                "  - kichik kartoshka-fri      0 x 1 = 0\n" +
                "  - sarimsoqli sous      0 x 1 = 0\n" +
                "  - Coca Cola (quyma) 400 ml      0 x 1 = 0\n" +
                "  - Aksiya stiker      0 x 1 = 0\n" +
                "\n" +
                "Umumiy: 42 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void boxtradit(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fc410cfea-29ed-4a10-9cfb-d5e3f93d5b7e&w=3840&q=75"));
        photo.setCaption("Maxi BOX Traditsiya \n" +
                "Original sendvich, kartoshka fri, 0,4 l coca cola, tanlash uchun sous\n" +
                " \n" +
                "\n" +
                "Maxi BOX Traditsiya 48 000 x 1 = 48 000\n" +
                "  - kichik kartoshka-fri      0 x 1 = 0\n" +
                "  - sarimsoqli sous      0 x 1 = 0\n" +
                "  - Coca Cola (quyma) 400 ml      0 x 1 = 0\n" +
                "  - Aksiya stiker      0 x 1 = 0\n" +
                "\n" +
                "Umumiy: 48 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void boxtasy(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fe2286cf6-118a-4bda-a7e0-3faa463d8483&w=3840&q=75"));
        photo.setCaption("Maxi Box Tasty \n" +
                "Tasty klab + tanlash uchun ichimlik 0,4 + tanlash uchun sous+fri  \n" +
                "\n" +
                "Maxi Box Tasty 48 000 x 1 = 48 000\n" +
                "  - kichik kartoshka-fri      0 x 1 = 0\n" +
                "  - sarimsoqli sous      0 x 1 = 0\n" +
                "  - Coca Cola (quyma) 400 ml      0 x 1 = 0\n" +
                "  - Aksiya stiker      0 x 1 = 0\n" +
                "\n" +
                "Umumiy: 48 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void boxpopular(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F9524edf6-d5a4-4a45-bf3d-c4339a72cf96&w=3840&q=75"));
        photo.setCaption("Maxi BOX Popular \n" +
                "Original lavash, kartoshka fri, 0,4 l coca cola, tanlash uchun sous\n" +
                " \n" +
                "\n" +
                "Maxi BOX Popular 48 000 x 1 = 48 000\n" +
                "  - kichik kartoshka-fri      0 x 1 = 0\n" +
                "  - sarimsoqli sous      0 x 1 = 0\n" +
                "  - Coca Cola (quyma) 400 ml      0 x 1 = 0\n" +
                "  - Aksiya stiker      0 x 1 = 0\n" +
                "\n" +
                "Umumiy: 48 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void boxretro(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Ffe3923b2-43c9-400c-b353-a24c3f4f8975&w=3840&q=75"));
        photo.setCaption("Maxi BOX Retro \n" +
                "Shaurma Original, kartoshka fri, 0,4 l coca cola , tanlash uchun sous \n" +
                "\n" +
                "Maxi BOX Retro 45 000 x 1 = 45 000\n" +
                "  - kichik kartoshka-fri      0 x 1 = 0\n" +
                "  - sarimsoqli sous      0 x 1 = 0\n" +
                "  - Coca Cola (quyma) 400 ml      0 x 1 = 0\n" +
                "  - Aksiya stiker      0 x 1 = 0\n" +
                "\n" +
                "Umumiy: 45 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void boxgerman(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fd5f4958a-2c37-4f2a-8754-6954666dd0fd&w=3840&q=75"));
        photo.setCaption("Max BOX German \n" +
                "German Donar , kartoshka fri, 0,4 l coca cola, tanlash uchun sous \n" +
                "\n" +
                "Max BOX German 48 000 x 1 = 48 000\n" +
                "  - kichik kartoshka-fri      0 x 1 = 0\n" +
                "  - sarimsoqli sous      0 x 1 = 0\n" +
                "  - Coca Cola (quyma) 400 ml      0 x 1 = 0\n" +
                "  - Aksiya stiker      0 x 1 = 0\n" +
                "\n" +
                "Umumiy: 48 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void boxtrend(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F13d38d96-4187-448f-84b2-e47420c9aec2&w=3840&q=75"));
        photo.setCaption("Maxi BOX Trend \n" +
                "Gamburger,  kartoshka fri, 0,4 l coca cola, tanlash uchun sous\n" +
                " \n" +
                "\n" +
                "Maxi BOX Trend 42 000 x 1 = 42 000\n" +
                "  - kichik kartoshka-fri      0 x 1 = 0\n" +
                "  - sarimsoqli sous      0 x 1 = 0\n" +
                "  - Coca Cola (quyma) 400 ml      0 x 1 = 0\n" +
                "  - Aksiya stiker      0 x 1 = 0\n" +
                "\n" +
                "Umumiy: 42 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void minibox(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F5f585fb4-950c-4f22-9620-bb3dbad3ae31&w=3840&q=75"));
        photo.setCaption("Mini BOX \n" +
                "Longer, kartoshka fri, coca-cola 0,3, tanlovga ko'ra sous \n" +
                "\n" +
                "Mini BOX 25 000 x 1 = 25 000\n" +
                "  - kichik kartoshka-fri      0 x 1 = 0\n" +
                "  - coca-cola  0,3      0 x 1 = 0\n" +
                "  - sarimsoqli sous      0 x 1 = 0\n" +
                "\n" +
                "Umumiy: 25 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void aksiya(Long chatId){
        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F8ea2c227-b857-4626-b4c0-24dfc6c2eab8&w=3840&q=75"));
        photo.setCaption("Mazali Maxi Box-sovrinlarga katta imkoniyat! \n" +
                " \u200B\u200BBYD avtomobili yoki ko‘plab qimmatbaho sovg‘alardan birini yutib olish imkoniyatini boy bermang!\uD83C\uDF89\n" +
                "\n" +
                "2024-yil 20-dekabrdan 2025-yil 15-fevralgacha MaxWay restoranlarida yoki yetkazib berish xizmati orqali xohlagan Maxi Box ni buyurtma qiling va sovg'alik stiker oling:\n" +
                "\uD83C\uDF54 MaxWay menyusidan tezkor mazali sovg‘alar\n" +
                "\uD83C\uDF81 Qimmatbaho sovg‘alar uchun promokodlar: smartfonlar, aqlli soatlar, o‘yin pristavkalari\n" +
                "\uD83D\uDE97 Final o‘yinda BYD E2 avtomobilini yutib olish imkoniyati!\n" +
                "\n" +
                "Har bir promokod g‘alaba qozonish imkoniyatingizni oshiradi! Bosh sovrinning final o‘yini 2025-yil 20-fevralda MaxWay ning 20 yilligiga bag‘ishlangan bayramda bo‘lib o‘tadi\uD83E\uDD29\n" +
                "\n" +
                "\uD83D\uDCCC Qanday ishtirok etish mumkin:\n" +
                "1\uFE0F⃣ Maxi Box buyurtma qiling\n" +
                "2\uFE0F⃣ Stikerni oching va sovg‘angizni bilib oling\n" +
                "3\uFE0F⃣ Promokodni @maxway_promo_bot orqali ro‘yxatdan o‘tkazing\n" +
                "\n" +
                "Aksiyada ishtirok eting va MaxWay ning 20 yilligini sovg‘alar va yorqin hissiyotlar bilan nishonlang!");
        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void yanglikarapita(Long chatId){
        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F982a8f70-9795-4a7c-b1bf-45f8f3ef2190&w=3840&q=75"));
        photo.setCaption("Arapita Chiсken \n" +
                "Arab anʼanalariga muvofiq tayyorlangan yumshoq nonga oltin ranggacha qovurilgan tovuq shnitseli, paprika, achchiq qalampir va yengil dudlangan hidli maxsus sous,hamda yangi pomidor boʻlaklari va aysberg salati qoʻshilgan aralashmani his etishingiz mumkin. Bu toʻyimlilik va yengillikning ajoyib birikmasi. \n" +
                "\n" +
                "Arapita Chiсken 25 000 x 1 = 25 000\n" +
                "Umumiy: 25 000 UZS");
        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void yanglikarapitabef(Long chatId){
        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fcd524ec2-96e0-4657-99bf-bca73d92eb03&w=3840&q=75"));
        photo.setCaption("Arapita Beef \n" +
                "Yumshoq arab noniga o'ralgan sersuv mol go'shti bifshteksini, paprika, qayin qalampiri va yengil dudlangan ta'mga ega maxsus sous, barra pomidor bo‘laklari va qarsildoq aysberg salati qo‘shilgan. Shirali, ishtahani ochuvchi tanlov! \n" +
                "\n" +
                "Arapita Beef 27 000 x 1 = 27 000\n" +
                "Umumiy: 27 000 UZS");
        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void yanglikmorsmalina(Long chatId){
        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fd98b4342-697f-4be7-a921-a1f471911448&w=3840&q=75"));
        photo.setCaption("Issiq mors Malina \n" +
                "Shakar qo'shilgan tabiiy yoqimli\n" +
                "malinadan tayyorlangan issiq\n" +
                "ichimlik. Tabiiy ta'm, shirin malina\n" +
                "xushbo'yligi va shamollashni oldini\n" +
                "olish uchun ajoyib usul! \n" +
                "\n" +
                "Issiq mors Malina 16 000 x 1 = 16 000\n" +
                "Umumiy: 16 000 UZS");
        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void yanglikmorskiwi(Long chatId){
        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F3e6448d7-23bc-4f2d-98e3-8ee2a1b79e5c&w=3840&q=75"));
        photo.setCaption("Issiq mors Kiwi-Uzum \n" +
                "Tabiiy kivi va shirin oq uzumdan\n" +
                "tayyorlangan issiq ichimlik. Sevimli\n" +
                "sersuv mevalaringizning\n" +
                "kombinatsiyasi sizga vitaminli\n" +
                "energiya beradi, salqin kunda sizni\n" +
                "isitadi va quyoshli kayfiyat ulashadi. \n" +
                "\n" +
                "Issiq mors Kiwi-Uzum 16 000 x 1 = 16 000\n" +
                "Umumiy: 16 000 UZS");
        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void yablikmorscitrus(Long chatId){
        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fc8f6e835-18b9-48e6-8e03-6bf33c46fa50&w=3840&q=75"));
        photo.setCaption("Issiq mors Citrus-Lemongrass \n" +
                "Mandarin va apelsinning sitrusli\n" +
                "sharbati, boy zanjabil va limon\n" +
                "hidlariga ega limon o'simligining\n" +
                "tabiiy ekstraktli issiq ichimlik. U\n" +
                "yoqimli, o'ziga xos ta'mni beradi va\n" +
                "yallig'lanishga qarshi xususiyatlarga\n" +
                "ega. Bu kombinatsiya sovuq\n" +
                "mavsumda quvnoq va sog'lom\n" +
                "bo'lishga imkon beradi. \n" +
                "\n" +
                "Issiq mors Citrus-Lemongrass 16 000 x 1 = 16 000\n" +
                "Umumiy: 16 000 UZS");
        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void bizxaqmzda(Long chatId){
        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/images/maxway_cover.png"));
        photo.setCaption("\uD83C\uDF5F Max Way \n" +
                "☎\uFE0F Aloqa markazi: +998971756999");
        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendvcorg(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F6e75db0d-01c9-47e3-b178-0a2e61cd46fb&w=3840&q=75"));
        photo.setCaption("Sendvich Original \n" +
                "Toster non, tovuq shnitseli, yangi bodring, pomidor, klab sousi, Xoxland pishloq\n" +
                " \n" +
                "\n" +
                "Sendvich Original 32 000 x 1 = 32 000\n" +
                "Umumiy: 32 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void klabsendvc(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F033adb7c-0289-4f80-a0a9-05fda8e23bc5&w=3840&q=75"));
        photo.setCaption("Klab sendvich \n" +
                "Original sendvich, kartoshka fri, tanlash uchun sous\n" +
                " \n" +
                "\n" +
                "Klab sendvich 38 000 x 1 = 38 000\n" +
                "  - sarimsoqli sous      0 x 1 = 0\n" +
                "\n" +
                "Umumiy: 38 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void tastyklab(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fcf015491-69fd-4b45-a069-eaf5af9295c7&w=3840&q=75"));
        photo.setCaption("Tasty klab \n" +
                "Tasty klab\n" +
                "\n" +
                "Toster bulochkasi, mayonez, aysberg salat bargi, 1 dona pomidor va tovuqli shnitsel \n" +
                "\n" +
                "Tasty klab 32 000 x 1 = 32 000\n" +
                "Umumiy: 32 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void lavashminiklass(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fcc460cfc-cb63-42e2-9adc-7455dacb8295&w=3840&q=75"));
        photo.setCaption("Lavash mini klassik \n" +
                "Lavash xamiri, mol go'shti-donar, pomidor, chipslar, pomidor sousi, mayonez \n" +
                "\n" +
                "Lavash mini klassik 27 000 x 1 = 27 000\n" +
                "Umumiy: 27 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void lavashminipishlo(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Ff025021d-bd4c-410e-8bad-e60ad2032197&w=3840&q=75"));
        photo.setCaption("Lavash mini pishloqli \n" +
                "Lavash xamiri, mol go'shti-donar, pomidor, chipslar, pomidor sousi, mayonez, Xoxland pishloq \n" +
                "\n" +
                "Lavash mini pishloqli 30 000 x 1 = 30 000\n" +
                "Umumiy: 30 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void lavashstandartklass(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F750f3234-3fa8-4aab-b763-0e37dd82f609&w=3840&q=75"));
        photo.setCaption("Lavash standart klassik \n" +
                "Lavash xamiri, mol go'shti-donar, pomidor, chipslar, pomidor sousi, mayonez \n" +
                "\n" +
                "Lavash standart klassik 34 000 x 1 = 34 000\n" +
                "Umumiy: 34 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void lavashstandartachiq(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F14225f78-e339-42bc-ae75-909d9d25da40&w=3840&q=75"));
        photo.setCaption("Lavash standart achchiq \n" +
                "Lavash xamiri, mol go'shti donar, pomidor, kartoshkali chipslar, tomat sousi, mayonez, halapeno \n" +
                "\n" +
                "Lavash standart achchiq 34 000 x 1 = 34 000\n" +
                "Umumiy: 34 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void lavashstandartpishlo(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F614e827d-cd30-4b68-b5ec-655b85e708d0&w=3840&q=75"));
        photo.setCaption("Lavash standart pishloqli \n" +
                "Lavash xamiri, mol go'shti-donar, pomidor, chiplar, pomidor sousi, mayonez, Xoxland pishloq\n" +
                " \n" +
                "\n" +
                "Lavash standart pishloqli 37 000 x 1 = 37 000\n" +
                "Umumiy: 37 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void arapitachicken(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F982a8f70-9795-4a7c-b1bf-45f8f3ef2190&w=3840&q=75"));
        photo.setCaption("Arapita Chiсken \n" +
                "Arab anʼanalariga muvofiq tayyorlangan yumshoq nonga oltin ranggacha qovurilgan tovuq shnitseli, paprika, achchiq qalampir va yengil dudlangan hidli maxsus sous,hamda yangi pomidor boʻlaklari va aysberg salati qoʻshilgan aralashmani his etishingiz mumkin. Bu toʻyimlilik va yengillikning ajoyib birikmasi. \n" +
                "\n" +
                "Arapita Chiсken 25 000 x 1 = 25 000\n" +
                "Umumiy: 25 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void arapitabeef(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fcd524ec2-96e0-4657-99bf-bca73d92eb03&w=3840&q=75"));
        photo.setCaption("Arapita Beef \n" +
                "Yumshoq arab noniga o'ralgan sersuv mol go'shti bifshteksini, paprika, qayin qalampiri va yengil dudlangan ta'mga ega maxsus sous, barra pomidor bo‘laklari va qarsildoq aysberg salati qo‘shilgan. Shirali, ishtahani ochuvchi tanlov! \n" +
                "\n" +
                "Arapita Beef 27 000 x 1 = 27 000\n" +
                "Umumiy: 27 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void germandonar(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F1b1149fb-7e05-45bb-a92b-595b83c16d5a&w=3840&q=75"));
        photo.setCaption("German Donar \n" +
                "Non, ranch sousi, qizil karam salati, Doner go'shti, aysberg salati, yangi pomidor \n" +
                "\n" +
                "German Donar 34 000 x 1 = 34 000\n" +
                "Umumiy: 34 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void shaurmaa(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fdbb583ca-0328-4035-af73-8409b158019c&w=3840&q=75"));
        photo.setCaption("Shaurma \n" +
                "Donor bulochka, mol go'shti-donar, yangi bodring, pomidor, pomidor sousi \n" +
                "\n" +
                "Shaurma 32 000 x 1 = 32 000\n" +
                "Umumiy: 32 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void shaurmapishlo(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F79a3bc17-bbf5-4b5e-8337-9632683bd81e&w=3840&q=75"));
        photo.setCaption("Shaurma pishloqli \n" +
                "Donor bulochka, mol go'shti-donar, yangi bodring, pomidor, pomidor sousi, Xoxland pishloq \n" +
                "\n" +
                "Shaurma pishloqli 35 000 x 1 = 35 000\n" +
                "Umumiy: 35 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void gamburger(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F33f3c109-bbca-40a1-8d68-455a6f88b1f0&w=3840&q=75"));
        photo.setCaption("Gamburger \n" +
                "Burger bulochkasi, tuzlangan bodring, pomidor, go'shtli Patti, qizil piyoz, aysberg, Burger sousi\n" +
                " \n" +
                "\n" +
                "Gamburger 27 000 x 1 = 27 000\n" +
                "Umumiy: 27 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void chizburger(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Ffa034d3e-a445-4068-9475-05e71706910b&w=3840&q=75"));
        photo.setCaption("Chizburger \n" +
                "Burger bulochkasi, tuzlangan bodring, pomidor, go'shtli Patti, qizil piyoz, aysberg, Burger sousi, Xoxland pishlog'i\n" +
                " \n" +
                "\n" +
                "Chizburger 30 000 x 1 = 30 000\n" +
                "Umumiy: 30 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void bigburger(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fe4015fd5-0988-47e1-bb3e-9c1b6d1a0e90&w=3840&q=75"));
        photo.setCaption("Bigburger \n" +
                "Burger bulochkasi, tuzlangan bodring, pomidor, 2 ta go'shtli Patti, qizil piyoz, aysberg, Burger sousi, Xoxland pishloq\n" +
                " \n" +
                "\n" +
                "Bigburger 44 000 x 1 = 44 000\n" +
                "Umumiy: 44 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void donarkebab(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F561cf6a1-3f19-479d-b057-04c11ee0b891&w=3840&q=75"));
        photo.setCaption("Donar kebab  \n" +
                "Mol go'shti donari-go'sht, makkajo'xori bilan guruch, kartoshka fri, qizil karam salati, pomidor sous\n" +
                " \n" +
                "\n" +
                "Donar kebab  48 000 x 1 = 48 000\n" +
                "Umumiy: 48 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void donarbox(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F758cffd0-206c-4bae-8c6e-976008ca2beb&w=3840&q=75"));
        photo.setCaption("Donar Box \n" +
                "Mol go'shti donari-go'sht, kartoshka fri, guruch, ranch sous va pamidor\n" +
                "\n" +
                " \n" +
                "\n" +
                "Donar Box 41 000 x 1 = 41 000\n" +
                "Umumiy: 41 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void Non(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fa16f5b4d-5c74-494f-a905-67d3d2edb4d6&w=3840&q=75"));
        photo.setCaption("Non \n" +
                "Yumshoq bulochka\n" +
                " \n" +
                "\n" +
                "Non 4 000 x 1 = 4 000\n" +
                "Umumiy: 4 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void Hotdog(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fd07386d0-4d92-4406-8c47-0ec0ff3123a3&w=3840&q=75"));
        photo.setCaption("Hot Dog \n" +
                "Hot-dog bulochkasi, Kanada sosiskasi, tuzlangan bodring, pomidor, ketchup va mayonez\n" +
                " \n" +
                "\n" +
                "Hot Dog 12 000 x 1 = 12 000\n" +
                "Umumiy: 12 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void chizdog(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fc52a29e0-98dc-412d-863b-25de7c4f14f8&w=3840&q=75"));
        photo.setCaption("Chiz dog \n" +
                "  Hot-dog bulochkasi, kanada sosiskasi, tuzlangan bodring, pomidor, Xoxland pishloq, ketchup va mayonez\n" +
                " \n" +
                "\n" +
                "Chiz dog 15 000 x 1 = 15 000\n" +
                "Umumiy: 15 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void longer(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F39976b3b-6087-4260-8da0-8f29b4703d9d&w=3840&q=75"));
        photo.setCaption("Longer  \n" +
                "Hot-dog bulochka,ketchup, mayonez, strips  1 dona, tuzlangan bodring 3 dona va aysberg salat bargi \n" +
                "\n" +
                "Longer  15 000 x 1 = 15 000\n" +
                "Umumiy: 15 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void kartoshkakrmini(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F16b893c3-237d-46a3-9f11-655d8a0d63fe&w=3840&q=75"));
        photo.setCaption("Kartoshka fri  mini \n" +
                " \n" +
                "\n" +
                "Kartoshka fri  mini 11 000 x 1 = 11 000\n" +
                "Umumiy: 11 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void kartoshkafristandart(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fe238451f-6851-4554-8225-0be60c7e81c5&w=3840&q=75"));
        photo.setCaption("Kartoshka fri  standart \n" +
                " \n" +
                "\n" +
                "Kartoshka fri  standart 16 000 x 1 = 16 000\n" +
                "Umumiy: 16 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void kartoshkafrikatta(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F988e60f1-1a3a-4ba2-9a20-4d31cc53093b&w=3840&q=75"));
        photo.setCaption("Kartoshka fri katta \n" +
                " \n" +
                "\n" +
                "Kartoshka fri katta 20 000 x 1 = 20 000\n" +
                "Umumiy: 20 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void poderevenski(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F5e891d3c-4b71-4282-b9e4-ca1f8c504e3e&w=3840&q=75"));
        photo.setCaption("Po derevenski \n" +
                " \n" +
                "\n" +
                "Po derevenski 16 000 x 1 = 16 000\n" +
                "Umumiy: 16 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void naggets4(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fd1474fd8-d220-4a49-8c5c-e92324ccdac8&w=3840&q=75"));
        photo.setCaption("Naggetslar  4 dona \n" +
                " \n" +
                "\n" +
                "Naggetslar  4 dona 11 000 x 1 = 11 000\n" +
                "Umumiy: 11 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void naggets6(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fcd7a3f78-a80e-4d9c-894a-6f5b88a52b9b&w=3840&q=75"));
        photo.setCaption("Naggetslar  6 dona \n" +
                " \n" +
                "\n" +
                "Naggetslar  6 dona 15 000 x 1 = 15 000\n" +
                "Umumiy: 15 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void naggets10(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fb081f071-b76b-4ce3-a85c-8b05c5e31ffb&w=3840&q=75"));
        photo.setCaption("Naggetslar  10 dona \n" +
                " \n" +
                "\n" +
                "Naggetslar  10 dona 23 000 x 1 = 23 000\n" +
                "Umumiy: 23 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void naggets18(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F08cc6197-b070-4cf7-ba69-6dd2a1c5fe61&w=3840&q=75"));
        photo.setCaption("Naggetslar 18 dona \n" +
                " \n" +
                "\n" +
                "Naggetslar 18 dona 36 000 x 1 = 36 000\n" +
                "Umumiy: 36 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void stripss3(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F89e290e2-3ac1-4059-bcff-5ec14ccb79f1&w=3840&q=75"));
        photo.setCaption("Stripslar S(3) \n" +
                "Stripslar  \n" +
                "\n" +
                "Stripslar S(3) 17 000 x 1 = 17 000\n" +
                "Umumiy: 17 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void stripsm5(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fedc39fa8-f6aa-4c01-8d61-087e276e1bc3&w=3840&q=75"));
        photo.setCaption("Stripslar M(5) \n" +
                "Stripslar \n" +
                "\n" +
                "Stripslar M(5) 27 000 x 1 = 27 000\n" +
                "Umumiy: 27 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void stripsl7(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fa7b20c20-062e-4bf6-9e58-19934ed29378&w=3840&q=75"));
        photo.setCaption("Stripslar L(7) \n" +
                "Stripslar \n" +
                "\n" +
                "Stripslar L(7) 36 000 x 1 = 36 000\n" +
                "Umumiy: 36 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void naggetsbox(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F2d2dd25e-9b26-42ea-8de6-0a66f7ab3c1a&w=3840&q=75"));
        photo.setCaption("Naggets BOX \n" +
                "naggetslar (5 dona), kartoshka fri (100 gr) \n" +
                "\n" +
                "Naggets BOX 22 000 x 1 = 22 000\n" +
                "Umumiy: 22 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void mixbox(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fcbaa012b-eece-441c-a4f9-0caff2b40616&w=3840&q=75"));
        photo.setCaption("Mix Box \n" +
                "kartoshka fri 60 g, naggetslar 4 dona, stripslar 2 dona    \n" +
                "\n" +
                "Mix Box 29 000 x 1 = 29 000\n" +
                "Umumiy: 29 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void guruch(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F1c55ac0a-6436-4b1d-ada7-8377b6871e53&w=1920&q=75"));
        photo.setCaption("Guruch \n" +
                "Shirin makkajo'xori bilan pishirilgan lazer guruch\n" +
                " \n" +
                "\n" +
                "Guruch 8 000 x 1 = 8 000\n" +
                "Umumiy: 8 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void salat(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fefff60bd-15c2-4e6c-9f1b-2a0eea692af7&w=1920&q=75"));
        photo.setCaption("Salat \n" +
                "Salat qizil karam aralashmasi\n" +
                " \n" +
                "\n" +
                "Salat 8 000 x 1 = 8 000\n" +
                "Umumiy: 8 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void tiramisu(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fdd3eb9ef-b9e6-48ac-824a-66cfd0f39913&w=1920&q=75"));
        photo.setCaption("Tiramisu \n" +
                "Savoyardi pechene, mascarpone, qahva\n" +
                " \n" +
                "\n" +
                "Tiramisu 22 000 x 1 = 22 000\n" +
                "Umumiy: 22 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void brauni(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Febf7f8ee-0181-4294-9be8-f9241e3cff08&w=1920&q=75"));
        photo.setCaption("Brauni \n" +
                "Qora shokolad, yong'oq va shokoladli pechene\n" +
                " \n" +
                "\n" +
                "Brauni 22 000 x 1 = 22 000\n" +
                "Umumiy: 22 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void sansebastian(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F1ae33c55-cbd8-4d0a-b9a6-6a7624beca32&w=1920&q=75"));
        photo.setCaption("San-sebastian \n" +
                "Savoyardi kukilari, mascarpone, kahva\n" +
                "\n" +
                " \n" +
                "\n" +
                "San-sebastian 22 000 x 1 = 22 000\n" +
                "Umumiy: 22 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void yongoklidonat(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fe10a89fe-5795-4d83-85ca-9eea113dc547&w=1920&q=75"));
        photo.setCaption("Yo'ng'oqli donat \n" +
                " \n" +
                "\n" +
                "Yo'ng'oqli donat 16 000 x 1 = 16 000\n" +
                "Umumiy: 16 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void karameldonat(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fb8b5b8f1-f169-4b8e-8c0d-4e078617bb7d&w=1920&q=75"));
        photo.setCaption("Karamel donat \n" +
                " \n" +
                "\n" +
                "Karamel donat 16 000 x 1 = 16 000\n" +
                "Umumiy: 16 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void qulupnaylidonat(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F49e2f3af-66e9-46de-8646-5433e5dfb9af&w=1920&q=75"));
        photo.setCaption("Qulupnayli donat \n" +
                " \n" +
                "\n" +
                "Qulupnayli donat 16 000 x 1 = 16 000\n" +
                "Umumiy: 16 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void moxito(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F4e142541-b7ff-46e3-8e59-d102a1e6f519&w=1920&q=75"));
        photo.setCaption("Moxito" +
                "\uD83E\uDD64Ichimliklar\n" +
                "\uD83E\uDD64Ichimliklar\n" +
                "Mahsulotni tanlang:"
        );

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void cocacola(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F91f72331-571c-45b8-9745-b2b961ed5e0d&w=1920&q=75"));
        photo.setCaption("Quyma Coca Cola 300ml \n" +
                " \n" +
                "\n" +
                "Quyma Coca Cola 300ml 8 000 x 1 = 8 000");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void sprite(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F3e32b6d5-4a64-4091-8d9e-167833ed1048&w=1920&q=75"));
        photo.setCaption("Sprite 0.5 L \n" +
                "Sprite 0.5 L \n" +
                "\n" +
                "Sprite 0.5 L 10 000 x 1 = 10 000\n" +
                "Umumiy: 10 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void cocacola15(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Ff9db764b-7804-4220-82e8-a0c9eb71f53b&w=1920&q=75"));
        photo.setCaption("Coca Cola  1.5 L \n" +
                "Coca Cola  1.5 L \n" +
                "\n" +
                "Coca Cola  1.5 L 19 000 x 1 = 19 000\n" +
                "Umumiy: 19 000 UZS");
        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void fanta(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F9ebe8f81-c8cf-44da-9f62-8f65a65f4c3a&w=1920&q=75"));
        photo.setCaption("Fanta 500 ml \n" +
                " \n" +
                "\n" +
                "Fanta 500 ml 10 000 x 1 = 10 000");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void cocacola05(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Feefc67f4-9e14-4635-a174-4c5c6483744f&w=1920&q=75"));
        photo.setCaption("Coca Cola  0.5 L \n" +
                " Coca Cola  0.5 L \n" +
                "\n" +
                "Coca Cola  0.5 L 10 000 x 1 = 10 000\n" +
                "Umumiy: 10 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void sharbatdena(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F58c745c9-cf0c-442a-a6d9-963e5aabc362&w=1920&q=75"));
        photo.setCaption("Сок Dena 1 л \n" +
                " \n" +
                "\n" +
                "Сок Dena 1 л 18 000 x 1 = 18 000 \n" +
                "  - olma sharbati 1 l      0 x 1 = 0\n" +
                "\n" +
                "Umumiy: 18 000");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void fusetea(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F4af4d45b-6a1e-4e9c-976a-7cd5348d7efc&w=1920&q=75"));
        photo.setCaption("Fuse tea \n" +
                " \n" +
                "\n" +
                "Fuse tea 10 000 x 1 = 10 000\n" +
                "Umumiy: 10 000 UZS ");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void bonaqua(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F1a92d0aa-a6fa-4c8d-90e6-811c8fb9af17&w=1920&q=75"));
        photo.setCaption("Bonaqua \n" +
                " \n" +
                "\n" +
                "Bonaqua 5 000 x 1 = 5 000\n" +
                "Umumiy: 5 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void birmartalistakan(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fbb5aa888-f006-4d52-aac6-38949456569e&w=1920&q=75"));
        photo.setCaption("Bir martali stakan \n" +
                " \n" +
                "\n" +
                "Bir martali stakan 1 000 x 1 = 1 000\n" +
                "Umumiy: 1 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void issiqmorlmalina(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fd98b4342-697f-4be7-a921-a1f471911448&w=1920&q=75"));
        photo.setCaption("Issiq mors Malina \n" +
                "Shakar qo'shilgan tabiiy yoqimli\n" +
                "malinadan tayyorlangan issiq\n" +
                "ichimlik. Tabiiy ta'm, shirin malina\n" +
                "xushbo'yligi va shamollashni oldini\n" +
                "olish uchun ajoyib usul! \n" +
                "\n" +
                "Issiq mors Malina 16 000 x 1 = 16 000\n" +
                "Umumiy: 16 000 UZS");

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }


    private void qorachoy(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F3ae92eaf-c56e-4db7-9c5b-f658bc595144&w=1920&q=75"));
        photo.setCaption("Qora choy \n" +
                "Qora choy (ta’bga kora shakar) \n" +
                "\n" +
                "Qora choy 5 000 x 1 = 5 000\n" +
                "Umumiy: 5 000 UZS"


        );

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void kokchoy(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F62b72bbe-d73a-4eb2-baf7-054f05b53464&w=1920&q=75"));
        photo.setCaption("Ko'k choy \n" +
                "Ko’k choy (ta’bga kora shakar) \n" +
                "\n" +
                "Ko'k choy 5 000 x 1 = 5 000\n" +
                "Umumiy: 5 000 UZS"
        );

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void limonlichoy(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F62b72bbe-d73a-4eb2-baf7-054f05b53464&w=1920&q=75"));
        photo.setCaption("Limonli choy \n" +
                "Limonli choy (ta’bga ko'rish uchun shakar) \n" +
                "\n" +
                "Limonli choy 7 000 x 1 = 7 000\n" +
                "  - limonli choy (qora)      0 x 1 = 0\n" +
                "\n" +
                "Umumiy: 7 000 UZS"
        );

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void americano(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F70ffc412-2b3f-463f-b8ef-a25f04e1d114&w=1920&q=75"));
        photo.setCaption("Amerikano \n" +
                "Tabiiy donli qahva (espresso, suv)\n" +
                " \n" +
                "\n" +
                "Amerikano 12 000 x 1 = 12 000\n" +
                "\n" +
                "Umumiy: 12 000 UZS"
        );

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void kapuchino(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F8893320f-bbc3-4a89-825e-afd4906cdbfc&w=1920&q=75"));
        photo.setCaption("Kapuchino \n" +
                "Tabiiy donli qahva (espresso, sut, suv)\n" +
                " \n" +
                "\n" +
                "Kapuchino 14 000 x 1 = 14 000\n" +
                "\n" +
                "Umumiy: 14 000 UZS"
        );

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void latte(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F6435f137-7a98-40a8-aba7-4a2ee4a28966&w=1920&q=75"));
        photo.setCaption("Latte \n" +
                "Tabiiy donli qahva (espresso, sut, suv)\n" +
                " \n" +
                "\n" +
                "Latte 14 000 x 1 = 14 000\n" +
                "\n" +
                "Umumiy: 14 000 UZS"
        );

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void ketchup(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F7602a40e-d2ee-495e-8543-1a505f97fc21&w=1920&q=75"));
        photo.setCaption("Ketchup \n" +
                " \n" +
                "\n" +
                "Ketchup 4 000 x 1 = 4 000\n" +
                "Umumiy: 4 000 UZS"
        );

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void pishloqlisous(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F09d6df13-155c-4371-9189-87402a4c2c3f&w=1920&q=75"));
        photo.setCaption("Pishloqli sous \n" +
                " \n" +
                "\n" +
                "Pishloqli sous 4 000 x 1 = 4 000\n" +
                "Umumiy: 4 000 UZS"
        );

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void sarimsoqlisous(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Ff8fd90f1-d947-491c-acdd-a7b67c3de2eb&w=1920&q=75"));
        photo.setCaption("Sarimsoqli sous \n" +
                " \n" +
                "\n" +
                "Sarimsoqli sous 4 000 x 1 = 4 000\n" +
                "Umumiy: 4 000 UZS"
        );

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void ketchupchili(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F5eb2e752-0de6-40d2-be31-9b380e16145a&w=1920&q=75"));
        photo.setCaption("Ketchup chili \n" +
                " \n" +
                "\n" +
                "Ketchup chili 4 000 x 1 = 4 000\n" +
                "Umumiy: 4 000 UZS"
        );

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void xalapeno(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F6019580b-7f23-462f-befc-3fcf2e211d0c&w=1920&q=75"));
        photo.setCaption("Xalapeno \n" +
                " \n" +
                "\n" +
                "Xalapeno 4 000 x 1 = 4 000\n" +
                "Umumiy: 4 000 UZS"
        );

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private void shirinvanordonsous(Long chatId) {
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setSelective(false);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Maqsulot miqdorini tanlang");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendPhoto photo = new SendPhoto();
        photo.setChatId(String.valueOf(chatId));
        photo.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F986269d6-7f60-4424-a2dc-a6640d00fca4&w=1920&q=75"));
        photo.setCaption("Shirin va nordon sous \n" +
                " \n" +
                "\n" +
                "Shirin va nordon sous 4 000 x 1 = 4 000\n" +
                "Umumiy: 4 000 UZS"
        );

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void barchafillial(Long chatId){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCCDEng yaqin fillialni aniqlash");
        button2.setRequestLocation(true);

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("MAX WAY ALAYSKIY");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("MAX WAY BERUNIY");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("MAX WAY ATLAS");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("MAX WAY DRUJBA");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("MAX WAY MEGA PLANET");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("MAX WAY AVIASOZLAR");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("MAX WAY RISOVIY");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("MAX WAY PARUS");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("MAX WAY MAGIC CITY");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("MAX WAY SAMARQAND DARVOZA");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("MAX WAY PARKENT");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("MAX WAY UNIVERSAM");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("MAX WAY ROYSON");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("MAX WAY NEXT");

        KeyboardButton button17 = new KeyboardButton();
        button17.setText("MAX WAY MUQUMIY");

        KeyboardButton button18 = new KeyboardButton();
        button18.setText("MAX WAY GRAND MIR");

        KeyboardButton button19 = new KeyboardButton();
        button19.setText("MAX WAY SAYRAM");

        KeyboardButton button20 = new KeyboardButton();
        button20.setText("MAX WAY MAKSIM GORKIY");

        KeyboardButton button21 = new KeyboardButton();
        button21.setText("MAX WAY FONTAN");

        KeyboardButton button22 = new KeyboardButton();
        button22.setText("MAX WAY MINOR");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button7);
        row4.add(button8);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(button9);
        row5.add(button10);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(button11);
        row6.add(button12);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(button13);
        row7.add(button14);

        KeyboardRow row8 = new KeyboardRow();
        row8.add(button15);
        row8.add(button16);

        KeyboardRow row9 = new KeyboardRow();
        row9.add(button17);
        row9.add(button18);

        KeyboardRow row10 = new KeyboardRow();
        row10.add(button19);
        row10.add(button20);

        KeyboardRow row11 = new KeyboardRow();
        row11.add(button21);
        row11.add(button22);

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        rows.add(row6);
        rows.add(row7);
        rows.add(row8);
        rows.add(row9);
        rows.add(row10);
        rows.add(row11);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(false);
        markup.setIsPersistent(false);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Bizning filiallarimiz :");
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String getBotUsername() {
        return "@maxxway_bot";
    }

    @Override
    public String getBotToken() {
        return "7907318096:AAER6iJeOywj6Xtgv9-wjXFwxRrbOJpX85s";

    }
}
