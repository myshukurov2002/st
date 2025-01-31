package com.company.a24;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Mansur extends TelegramLongPollingBot {
    private boolean name = false;
    private boolean contact = false;
    private Object BotButton;

    public Mansur() {
        super("7957634893:AAF8hzSG47l40pBXM8lW_DrysQ_ZgiwVkHU");
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            switch (text) {
                case "/start":
                    sendStartMessage(chatId);
                    break;
                case "Toshkent":
                case "Chirchiq":
                case "Qo'qand":
                case "Andijon":
                case "Qo'qon":
                case "Farg'ona":
                case "Nukus":
                case "Marg'ilon":
                case "Xorazm":
                    sendMainMenu(chatId, mainSearch1(), "Bosh menyu");
                    break;
                case "Tashkent":
                case "ChirChiq":
                case "Qoqand":
                case "Andijan":
                case "Qoqon":
                case "Fargana":
                case ".Nukus":
                case "Margilan":
                case "Xorezm":
                    sendMainMenu(chatId, mainSearch2(), "Main menu");
                    break;
                case "Ташкент":
                case "Чирчик":
                case "Коканд":
                case "Андижан":
                case "Фергана":
                case "Нукус":
                case "Маргилан":
                case "Хорезм":
                    sendMainMenu(chatId, mainSearch3(), "главное меню");
                    break;
                case "\uD83C\uDF55Buyurtma berish":
                    sendMainMenu(chatId, mainAbout1(), "Buyurtmani o'zingiz  \uD83D\uDE4B\u200D♂\uFE0F olib keting yoki Yetkazib \uD83D\uDE99 berishni tanlang");
                    break;
                case "⬅️\uFE0F Orqaga":
                    sendMainMenu(chatId, mainSearch1(), "Bosh menyu");
                    break;
                case "⬅️\uFE0F Back":
                    sendMainMenu(chatId, mainAbout2(), "Bosh menyu");
                    break;
                case "⬅️\uFE0F Backs":
                    sendMainMenu(chatId, mainSearch2(), "Bosh menyu");
                    break;
                case "\uD83D\uDDFAMy addresses":
                    sendSimpleMessage(chatId, "No data");
                    break;
                case "\uD83D\uDDFA Mening manzillarim":
                    sendSimpleMessage(chatId, "Ma'lumot yoq");
                    break;
                case "\uD83D\uDDFA Мои адреса":
                    sendSimpleMessage(chatId, "Нравится информация");
                    break;
                case "⬅️\uFE0F Назад":
                    sendMainMenu(chatId, mainAbout3(), "Bosh menyu");
                    break;
                case "⬅️\uFE0F Назадs":
                    sendMainMenu(chatId, mainSearch3(), "Bosh menyu");
                    break;
                case "\uD83C\uDF55Place an order":
                    sendMainMenu(chatId, mainAbout2(), "Pick up your order yourself  \uD83D\uDE4B\u200D♂\uFE0F or choose Delivery \uD83D\uDE99");
                    break;
                case "\uD83C\uDF55Разместить заказ":
                    sendMainMenu(chatId, mainAbout3(), "Заберите заказ сами \uD83D\uDE4B\u200D♂\uFE0F или выберите «Доставка» \uD83D\uDE99");
                    break;
                case "Telefon raqamini jo'natish":
                    sendMainMenu(chatId, mainAbout1(), "Biz bilan bog'lanish uchun quyidagi raqamlarga telefon qiling +998507018500");
                    break;
                case "\uD83D\uDCCDEng yaqin fillialni aniqlash":
                    sendLocation(chatId, 41.2349931, 69.2053093, "Lokatsiyani ulashish");
                    break;
                case "\uD83D\uDCCDIdentifying the nearest branch":
                    sendLocation(chatId, 43.2349931, 62.2053093, "Location sharing");
                    break;
                case "\uD83D\uDCCDОпределение ближайшего отделения":
                    sendLocation(chatId, 56.2349931, 36.2053093, "Передача местоположения");
                    break;
                case "\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83E\uDDAFOlib ketish":
                    sendMainMenu(chatId, mainNews(), "Qayerdasiz \uD83D\uDC40? Agar lokatsiyangizni\uD83D\uDCCD yuborsangiz, sizga eng yaqin filialni aniqlaymiz");
                    break;
                case "VEGETARIAN LAVASH":
                    sendPhoto(chatId, "src/main/resources/img_6.png", "VEGETARIAN LAVASH Lavash xamir, mozzarella pishlog'i, shampinyon qo'ziqorini, sarxil pomidor, bulg'or qalampiri, qora va yashil zaytun, murch va oq sedana \nNarxi: 27 000 soʻm");
                    break;
                case "PISHLOQLI PIDE":
                    sendPhoto(chatId, "src/main/resources/img_7.png", "PISHLOQLI PIDE \nMozzarella pishlog'i, asal, oq sedana \nNarxi: 45 000 soʻm");
                    break;
                case "GO'SHTLI SET":
                    sendPhoto(chatId, "src/main/resources/img_9.png", "GO'SHTLI SET \nGo'shtli 30 Barbekyu 30 10% chegirma \nNarxi: 182 000 soʻm");
                    break;
                case "SNEK SET":
                    sendPhoto(chatId, "src/main/resources/img_10.png", "SNEK SET \nIshtaha ochar, qaynoq to'plam. Maxsus sousdagi qanotchalar, qarsildoq fri kartoshkasi, pishloqli tovuq qalamchalari va xushta'm jaydari kartoshka. Ushbu to'plamni xarid qilganda 10.000 so'm kamroq pul to'lab, 10% mablag'ingizni tejab qolasiz \nNarxi: 107 000 soʻm");
                    break;
                case "Tovuqli":
                    sendPhoto(chatId, "src/main/resources/img_12.png", "50/50 Kombo Katta + 50/50 Tovuqli Katta \nNarxi: 109 000 soʻm");
                    break;
                case "Margarita":
                    sendPhoto(chatId, "src/main/resources/img_14.png", "50/50 Go'shtli Katta + 50/50 Margarita Katta \nNarxi: 116 000 soʻm");
                    break;
                case "TOVUQ NAGETS, 6 dona":
                    sendPhoto(chatId, "src/main/resources/img_15.png", "TOVUQ NAGETS, 6 dona \nMaxsus panirovka bilan qoplangan, tovuq qiymasidan tayyorlangan mazali naggetslar \nNarxi: 26 000 soʻm");
                    break;
                case "TOVUQ NAGETS, 9 dona":
                    sendPhoto(chatId, "src/main/resources/img_16.png", "TOVUQ NAGETS, 9 dona \nMaxsus panirovka bilan qoplangan, tovuq qiymasidan tayyorlangan mazali naggetslar \nNarxi: 37 000 soʻm");
                    break;
                case "PISHLOQLI TOVUQ QALAMCHALARI":
                    sendPhoto(chatId, "src/main/resources/img_17.png", "PISHLOQLI TOVUQ QALAMCHALARI \nMaydalangan tovuq filesidan tayyorlangan pishloqli qalamchalar. 6 dona \nNarxi: 34 000 soʻm");
                    break;
                case "MAZALI SET":
                    sendPhoto(chatId, "src/main/resources/img_18.png", "MAZALI SET \nKombo 30 Pepperoni 30 Julyen 30 15% chegirma \nNarxi: 210 000 soʻm");
                    break;
                case "\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83E\uDDAFTake away":
                    sendMainMenu(chatId, mainNews2(), "Where are you \uD83D\uDC40? If you send us your location\uD83D\uDCCD, we will find the nearest branch to you");
                    break;
                case "\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83E\uDDAFЕда на вынос":
                    sendMainMenu(chatId, mainNews3(), "Где ты \uD83D\uDC40? Если вы отправите нам свое местоположение\uD83D\uDCCD, мы найдем ближайшее к вам отделение.");
                    break;
                case "\uD83D\uDE99Yetkazib berish":
                    sendMainMenu(chatId, mainDelivery(), "Buyurtmangizni qayerga yetkazib berish kerak \uD83D\uDE99? Agar lokatsiyangizni\uD83D\uDCCD yuborsangiz, sizga eng yaqin filialni aniqlaymiz.");
                    break;
                case "\uD83D\uDE99Delivery":
                    sendMainMenu(chatId, mainDelivery2(), "Where should your order be delivered \uD83D\uDE99? If you send us your location\uD83D\uDCCD, we will find the nearest branch to you.");
                    break;
                case "\uD83D\uDE99Доставка":
                    sendMainMenu(chatId, mainDelivery3(), "Куда доставить ваш заказ \uD83D\uDE99? Если вы отправите нам свое местоположение\uD83D\uDCCD, мы найдем ближайшее к вам отделение.");
                    break;
                case "Fillialni tanlang":
                    sendMainMenu(chatId, mainFlial(), "Qaysi filialdan olib ketishni tanlang");
                    break;
                case "Выберите филиал":
                    sendMainMenu(chatId, mainFlial3(), "Выберите, в каком отделении забрать");
                    break;
                case "Select branch":
                    sendMainMenu(chatId, mainFlial2(), "Choose which branch to pick up from");
                    break;
                case "Bu yerda buyurtma berish \uD83C\uDF10":
                case "Заказать здесь\uD83C\uDF10":
                case "Order here \uD83C\uDF10":
                    sendMainMenu(chatId, mainNews(), "https://choparpizza.uz/");
                    break;
                case "Zenit":
                case "Eco Park":
                case "S.Rahimov":
                case "Nukus Asia.uz KSM":
                case "Atlas Chimgen":
                case "Magaplanet KSM":
                case "Perus KSM":
                case "Markaz-5":
                case "Farhod":
                case "Ko'kcha":
                case "Qo'yliq-5":
                case "Sergeli-2":
                    sendMainMenu(chatId, mainMenu1(), "Iltimos menudan buyurtma qiling");
                    break;
                case "⬅️\uFE0F Ortga":
                    sendMainMenu(chatId, mainAbout1(), "Qayerdasiz \uD83D\uDC40? Agar lokatsiyangizni\uD83D\uDCCD yuborsangiz, sizga eng yaqin filialni aniqlaymiz");
                    break;
                case "📖Buyurtmalar tarixi":
                    sendSimpleMessage(chatId, "Buyurtmalar tarixi mavjud emas.");
                    break;
                case "⚙️️Sozlash Ma'lumotlar":
                    sendSimpleMessage(chatId, "Sozlash ma'lumotlari mavjud emas.");
                    break;
                case "🙋🏻Jamoamizga qo'shiling":
                    sendSimpleMessage(chatId, "Jamoamizga qo'shilish uchun biz bilan bog'laning.");
                    break;
                case "☎️️Chopar bilan aloqa":
                    sendSimpleMessage(chatId, "Chopar bilan aloqa uchun +998507018500 raqamiga qo'ng'iroq qiling.");
                    break;
                default:
                    break;
            }
        } else if (update.hasCallbackQuery()) {
            String data = update.getCallbackQuery().getData();
            Long chatId = update.getCallbackQuery().getMessage().getChatId();

            switch (data) {
                case "uz":
                    sendCallbackMessage(chatId, "Qaysi shaharda yashisiz?\nIltimos,shaharni tanlen", mainMenuUz());
                    break;
                case "eng":
                    sendCallbackMessage(chatId, "Where are you live?\nPlease! Enter your Accomodation", mainMenuEng());
                    break;
                case "rus":
                    sendCallbackMessage(chatId, "В каком городе Вы живёте?\nПожалуйста, выберите город:", mainMenuRus());
                    break;
                default:
                    break;
            }
        }
    }

    private void sendStartMessage(Long chatId) {
        SendMessage message = new SendMessage();
        message.setText("Assalomu alaykum! Chopar Pizza yetkazib berish xizmatiga xush kelibsiz.\n" +
                "\n" +
                "Здравствуйте! Добро пожаловать в службу доставки Chopar Pizza.\n" +
                "\n" +
                "Hello! Welcome to Chopar Pizza delivery service.");
        message.setChatId(chatId);
        message.setReplyMarkup(menuLanguageButton());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMainMenu(Long chatId, ReplyKeyboardMarkup markup, String text) {
        SendMessage message = new SendMessage();
        message.setText(text);
        message.setChatId(chatId);
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendSimpleMessage(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setText(text);
        message.setChatId(chatId);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendLocation(Long chatId, double latitude, double longitude, String buttonText) {
        SendLocation location = new SendLocation();
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        location.setChatId(chatId);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        KeyboardRow row = new KeyboardRow();
        row.add(new KeyboardButton (buttonText));
        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row);
        markup.setKeyboard(rowList);
        markup.setResizeKeyboard(true);

        location.setReplyMarkup(markup);
        try {
            execute(location);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendPhoto(Long chatId, String filePath, String caption) {
        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setCaption(caption);
        photo.setPhoto(new InputFile(new File(filePath)));

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendCallbackMessage(Long chatId, String text, ReplyKeyboardMarkup markup) {
        SendMessage message = new SendMessage();
        message.setParseMode(ParseMode.HTML);
        message.setText(text);
        message.setChatId(chatId);
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public InlineKeyboardMarkup menuLanguageButton() {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("\uD83C\uDDF7\uD83C\uDDFA Русский");
        button1.setCallbackData("rus");
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("\uD83C\uDDFA\uD83C\uDDFF O'zbekcha");
        button2.setCallbackData("uz");
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("\uD83C\uDDFA\uD83C\uDDF8 English");
        button3.setCallbackData("eng");


        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(button1);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        row2.add(button2);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        row3.add(button3);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);

        markup.setKeyboard(rowList);
        return markup;
    }

    public ReplyKeyboardMarkup mainMenuUz() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton ("Toshkent");
        KeyboardButton button2 = new KeyboardButton ("Chirchiq");
        KeyboardButton button3 = new KeyboardButton ("Qo'qand");
        KeyboardButton button4 = new KeyboardButton ("Andijon");
        KeyboardButton button5 = new KeyboardButton ("Qo'qon");
        KeyboardButton button6 = new KeyboardButton ("Farg'ona");
        KeyboardButton button7 = new KeyboardButton ("Nukus");
        KeyboardButton button8 = new KeyboardButton ("Marg'ilon");
        KeyboardButton button9 = new KeyboardButton ("Xorazm");

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

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        rowList.add(row5);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup mainMenuEng() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton ("Tashkent");
        KeyboardButton button2 = new KeyboardButton ("ChirChiq");
        KeyboardButton button3 = new KeyboardButton ("Qoqand");
        KeyboardButton button4 = new KeyboardButton ("Andijan");
        KeyboardButton button5 = new KeyboardButton ("Qoqon");
        KeyboardButton button6 = new KeyboardButton ("Fargana");
        KeyboardButton button7  = new KeyboardButton ("Nukus");
        KeyboardButton button8 = new KeyboardButton ("Margilan");
        KeyboardButton button9 = new KeyboardButton ("Xorezm");

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

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        rowList.add(row5);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup mainMenuRus() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton ("Ташкент");
        KeyboardButton button2 = new KeyboardButton ("Чирчик");
        KeyboardButton button3 = new KeyboardButton ("Коканд");
        KeyboardButton button4 = new KeyboardButton ("Фергана");
        KeyboardButton button5 = new KeyboardButton ("Нукус");
        KeyboardButton button6 = new KeyboardButton ("Маргилан");
        KeyboardButton button7 = new KeyboardButton ("Хорезм");
        KeyboardButton button8 = new KeyboardButton ("Андижан");

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

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup mainSearch1() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton ("\uD83C\uDF55Buyurtma berish");
        KeyboardButton button2 = new KeyboardButton ("\uD83D\uDCD6Buyurtmalar tarixi");
        KeyboardButton button3 = new KeyboardButton ("☎️\uFE0FChopar bilan aloqa");
        KeyboardButton button4 = new KeyboardButton ("⚙️\uFE0FSozlash Ma'lumotlar");
        KeyboardButton button5 = new KeyboardButton ("🙋🏻Jamoamizga qo'shiling");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button2);
        row2.add(button3);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button4);
        row3.add(button5);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup mainSearch2() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton ("\uD83C\uDF55Place an order");
        KeyboardButton button2 = new KeyboardButton ("\uD83D\uDCD6Order history");
        KeyboardButton button3 = new KeyboardButton ("☎️\uFE0FCommunication with Chopar");
        KeyboardButton button4 = new KeyboardButton ("⚙️\uFE0FSetting Information");
        KeyboardButton button5 = new KeyboardButton ("🙋🏻Jamoamizga qo'shiling");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button2);
        row2.add(button3);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button4);
        row3.add(button5);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup mainSearch3() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton ("\uD83C\uDF55Разместить заказ");
        KeyboardButton button2 = new KeyboardButton ("\uD83D\uDCD6История заказов");
        KeyboardButton button3 = new KeyboardButton ("☎️\uFE0FОбщение с Чопаром");
        KeyboardButton button4 = new KeyboardButton ("⚙️\uFE0FИнформация о настройке");
        KeyboardButton button5 = new KeyboardButton ("🙋🏻Jamoamizga qo'shiling");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button2);
        row2.add(button3);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button4);
        row3.add(button5);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup mainAbout1() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton ("\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83E\uDDAFOlib ketish");
        KeyboardButton button2 = new KeyboardButton ("\uD83D\uDE99Yetkazib berish");
        KeyboardButton button3 = new KeyboardButton ("⬅️\uFE0F Orqaga");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup mainAbout2() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton ("\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83E\uDDAFTake away");
        KeyboardButton button2 = new KeyboardButton ("\uD83D\uDE99Delivery");
        KeyboardButton button3 = new KeyboardButton ("⬅️\uFE0F Backs");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup mainAbout3() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton ("\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83E\uDDAFЕда на вынос");
        KeyboardButton button2 = new KeyboardButton ("\uD83D\uDE99Доставка");
        KeyboardButton button3 =new KeyboardButton ("⬅️\uFE0F Назадs");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup mainNews() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton ("⬅️\uFE0F Ortga");
        KeyboardButton button2 = new KeyboardButton ("\uD83D\uDCCDEng yaqin fillialni aniqlash");
        KeyboardButton button3 = new KeyboardButton ("Bu yerda buyurtma berish \uD83C\uDF10");
        KeyboardButton button4 = new KeyboardButton ("Fillialni tanlang");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup mainNews2() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅️\uFE0F Back");
        KeyboardButton button2 = new KeyboardButton ("\uD83D\uDCCDIdentifying the nearest branch");
        KeyboardButton button3 = new KeyboardButton ("Order here \uD83C\uDF10");
        KeyboardButton button4 = new KeyboardButton ("Select branch");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup mainNews3() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton ("⬅️\uFE0F Назад");
        KeyboardButton button2 = new KeyboardButton ("\uD83D\uDCCDОпределение ближайшего отделения");
        KeyboardButton button3 = new KeyboardButton ("Заказать здесь\uD83C\uDF10");
        KeyboardButton button4 = new KeyboardButton ("Выберите филиал");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup mainDelivery() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton ("\uD83D\uDCCDEng yaqin fillialni aniqlash");
        KeyboardButton button2 = new KeyboardButton ("\uD83D\uDDFA Mening manzillarim");
        KeyboardButton button3 = new KeyboardButton ("⬅️\uFE0F Ortga");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button2);
        row2.add(button3);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup mainDelivery2() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton ("\uD83D\uDCCDIdentifying the nearest branch");
        KeyboardButton button2 = new KeyboardButton ("\uD83D\uDDFAMy addresses");
        KeyboardButton button3 = new KeyboardButton ("⬅️\uFE0F Back");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button2);
        row2.add(button3);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup mainDelivery3() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton ("\uD83D\uDCCDОпределение ближайшего отделения");
        KeyboardButton button2 = new KeyboardButton ("\uD83D\uDDFA Мои адреса");
        KeyboardButton button3 = new KeyboardButton ("⬅️\uFE0F Назад");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button2);
        row2.add(button3);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup mainFlial() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton ("Eco Park");
        KeyboardButton button2 = new KeyboardButton ("Zenit");
        KeyboardButton button3 = new KeyboardButton ("S.Rahimov");
        KeyboardButton button4 = new KeyboardButton ("Nukus Asia.uz KSM");
        KeyboardButton button5 = new KeyboardButton ("Atlas Chimgen");
        KeyboardButton button6 = new KeyboardButton ("Magaplanet KSM");
        KeyboardButton button7 = new KeyboardButton ("Perus KSM");
        KeyboardButton button8 = new KeyboardButton ("Markaz-5");
        KeyboardButton button9 = new KeyboardButton ("Farhod");
        KeyboardButton button10 = new KeyboardButton ("Ko'kcha");
        KeyboardButton button11 = new KeyboardButton ("Qo'yliq-5");
        KeyboardButton button12 = new KeyboardButton ("Sergeli-2");
        KeyboardButton button13 = new KeyboardButton ("⬅️\uFE0F Ortga");

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

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        rowList.add(row5);
        rowList.add(row6);
        rowList.add(row7);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup mainFlial2() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton ("Eco Park");
        KeyboardButton button2 = new KeyboardButton ("Zenit");
        KeyboardButton button3 = new KeyboardButton ("S. Rahimov");
        KeyboardButton button4 = new KeyboardButton ("Nukus Asia.uz KSM");
        KeyboardButton button5 = new KeyboardButton ("Atlas Chimgen");
        KeyboardButton button6 = new KeyboardButton ("Magaplanet KSM");
        KeyboardButton button7 = new KeyboardButton ("Perus KSM");
        KeyboardButton button8 = new KeyboardButton ("Markaz-5");
        KeyboardButton button9 = new KeyboardButton ("Farhod");
        KeyboardButton button10 = new KeyboardButton ("Ko'kcha");
        KeyboardButton button11 = new KeyboardButton ("Qo'yliq-5");
        KeyboardButton button12 = new KeyboardButton ("Sergeli-2");
        KeyboardButton button13 = new KeyboardButton ("⬅️\uFE0F Back");

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

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        rowList.add(row5);
        rowList.add(row6);
        rowList.add(row7);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup mainFlial3() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton ("Eco Park");
        KeyboardButton button2 = new KeyboardButton ("Zenit");
        KeyboardButton button3 = new KeyboardButton ("S.Rahimov");
        KeyboardButton button4 = new KeyboardButton ("Nukus Asia.uz KSM");
        KeyboardButton button5 = new KeyboardButton ("Atlas Chimgen");
        KeyboardButton button6 = new KeyboardButton ("Magaplanet KSM");
        KeyboardButton button7 = new KeyboardButton ("Perus KSM");
        KeyboardButton button8 = new KeyboardButton ("Markaz-5");
        KeyboardButton button9 = new KeyboardButton ("Farhod");
        KeyboardButton button10 = new KeyboardButton ("Ko'kcha");
        KeyboardButton button11 = new KeyboardButton ("Qo'yliq-5");
        KeyboardButton button12 = new KeyboardButton ("Sergeli-2");
        KeyboardButton button13 = new KeyboardButton ("⬅️\uFE0F Назад");

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

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        rowList.add(row5);
        rowList.add(row6);
        rowList.add(row7);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public ReplyKeyboardMarkup mainMenu1() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        KeyboardButton button1 = new KeyboardButton ("VEGETARIAN LAVASH");
        KeyboardButton button2 = new KeyboardButton ("PISHLOQLI PIDE");
        KeyboardButton button3 = new KeyboardButton ("GO'SHTLI SET");
        KeyboardButton button4 = new KeyboardButton ("SNEK SET");
        KeyboardButton button5 = new KeyboardButton ("Tovuqli");
        KeyboardButton button6 = new KeyboardButton ("Margarita");
        KeyboardButton button7 = new KeyboardButton ("TOVUQ NAGETS, 6 dona");
        KeyboardButton button8 = new KeyboardButton ("TOVUQ NAGETS, 9 dona");
        KeyboardButton button9 = new KeyboardButton ("PISHLOQLI TOVUQ QALAMCHALARI");
        KeyboardButton button10 = new KeyboardButton ("MAZALI SET");
        KeyboardButton button11 = new KeyboardButton ("⬅️\uFE0F Ortga");

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

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        rowList.add(row5);
        rowList.add(row6);
        markup.setKeyboard(rowList);
        markup.setOneTimeKeyboard(true);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    @Override
    public String getBotUsername() {
        return "@asad_kot_bot";
    }
}