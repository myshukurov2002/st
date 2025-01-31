package com.company.elbek;

import com.company.elbek.repository.UserRepository;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.CopyMessage;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {
    private final UserRepository repository = new UserRepository();

    public MyBot(String token) {
        super(token);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage() != null) {
            Message message = update.getMessage();

            if (message.hasDocument()) {
            } else {
            }
        } else {
            System.out.println("Received update without a message.");
            System.out.println(update.toString());
        }
        if (update.hasMessage() && update.getMessage().hasContact()) {
            if (repository.getUserById(update.getMessage().getChatId()).getState() == BotState.PHONE_NUMBER) {
                repository.setPhoneNumber(update.getMessage().getChatId(), update.getMessage().getContact().getPhoneNumber());
                SendMessage message = new SendMessage();
                if (repository.getUserById(update.getMessage().getChatId()).getLanguage().equals("uzb")) {
                    message.setText("Telefon Raqmingiz muvafaqiyatli ro'yxatdan o'tkazildi\n\n" +
                            "Sizga murojat qilishimiz uchun ismingizni kiriting");
                } else {
                    message.setText("Ваш номер телефона успешно зарегистрирован\n" +
                            "Введите свое имя, чтобы мы могли связаться с вами");
                }
                message.setChatId(update.getMessage().getChatId());
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        } else if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            if (text.equals("/start")) {

                if (repository.getUserById(update.getMessage().getChatId()) == null) {
                    repository.createUser(update.getMessage().getChatId(), BotState.START);
                }
                User user = repository.getUserById(update.getMessage().getChatId());

                InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> list = new ArrayList<>();
                List<InlineKeyboardButton> row = new ArrayList<>();
                InlineKeyboardButton button = new InlineKeyboardButton();
                button.setText("O'zbek\uD83C\uDDFA\uD83C\uDDFF");
                button.setCallbackData("uzb");
                row.add(button);
                List<InlineKeyboardButton> row1 = new ArrayList<>();
                InlineKeyboardButton button1 = new InlineKeyboardButton();
                button1.setText("Русский\uD83C\uDDF7\uD83C\uDDFA");
                button1.setCallbackData("rus");
                row1.add(button1);
                list.add(row1);
                list.add(row);
                markup.setKeyboard(list);
                SendMessage message = new SendMessage();
                message.setText("Tilni tanlang\uD83D\uDC47\nВыберите язык\uD83D\uDC47\nТилни танланг\uD83D\uDC47");
                message.setChatId(chatId);
                message.setReplyMarkup(markup);
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            } else if (text.equals("/location")) {
                SendLocation sendLocation = new SendLocation();
                sendLocation.setLatitude(41.2318117);
                sendLocation.setLongitude(69.2066512);
                sendLocation.setChatId(chatId);
                try {
                    execute(sendLocation);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            } else {
                String phoneNumber = repository.getUserById(chatId).getPhoneNumber();
                SendMessage message1 = new SendMessage();
                message1.setText("Yangi kontakt qoldirildi:\n\nTelefon raqam:" + phoneNumber + " \nIsmi:" + update.getMessage().getFrom().getFirstName());
                message1.setChatId("-1002405745461");
                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
                ForwardMessage forwardMessage = new ForwardMessage();
                forwardMessage.setChatId("-1002405745461");
                forwardMessage.setMessageId(update.getMessage().getMessageId());
                forwardMessage.setFromChatId(chatId);
                try {
                    execute(forwardMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }


                SendMessage message = new SendMessage();
                message.setText("Sizning xabaringiz muvaffaqiyatli yuborildi tez orada sizbilan aloqaga chiqamiz");
                message.setChatId(chatId);
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        } else if (update.hasCallbackQuery()) {
            String data = update.getCallbackQuery().getData();
            switch (data) {
                case "uzb" -> {
                    long chatId = update.getCallbackQuery().getMessage().getChatId();
                    repository.setUpdateLanguage(chatId, "uzb");
                    List<List<InlineKeyboardButton>> list = new ArrayList<>();
                    SendMessage message = new SendMessage();
                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                    List<InlineKeyboardButton> row = new ArrayList<>();
                    InlineKeyboardButton button = new InlineKeyboardButton();
                    button.setText("Mashinalar");
                    button.setCallbackData("mash");
                    row.add(button);

                    List<InlineKeyboardButton> row1 = new ArrayList<>();
                    InlineKeyboardButton button34 = new InlineKeyboardButton();
                    button34.setText("Aloqa bo'limi");
                    button34.setCallbackData("alqblm");
                    row1.add(button34);

                    List<InlineKeyboardButton> row4 = new ArrayList<>();
                    InlineKeyboardButton button33 = new InlineKeyboardButton();
                    button33.setText("Avto servis bo'limi");
                    button33.setCallbackData("avts");
                    row4.add(button33);
                    InlineKeyboardButton button1 = new InlineKeyboardButton();
                    button1.setText("Onlayn shartnoma tuzish");
                    button1.setCallbackData("Onlnshrt");
                    row.add(button1);
//                    List<InlineKeyboardButton> row6 = new ArrayList<>();
                    list.add(row);
//                    list.add(row6);
                    list.add(row1);
                    list.add(row4);
                    markup.setKeyboard(list);

                    message.setText("Quyidagailardan birini tanlang.");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    message.setReplyMarkup(markup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }

                case "rus" -> {

                    long chatId = update.getCallbackQuery().getMessage().getChatId();
                    repository.setUpdateLanguage(chatId, "rus");
                    List<List<InlineKeyboardButton>> list = new ArrayList<>();
                    SendMessage message = new SendMessage();
                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                    List<InlineKeyboardButton> row = new ArrayList<>();
                    InlineKeyboardButton button = new InlineKeyboardButton();
                    button.setText("Машины");
                    button.setCallbackData("mash-ru");
                    row.add(button);
                    InlineKeyboardButton button1 = new InlineKeyboardButton();
                    button1.setText("Онлаин переговоры");
                    button1.setCallbackData("Onlnshrtru");
                    row.add(button1);
                    List<InlineKeyboardButton> row1 = new ArrayList<>();
                    List<InlineKeyboardButton> row2 = new ArrayList<>();
                    InlineKeyboardButton button5 = new InlineKeyboardButton();
                    button5.setText("Авто сервис");
                    button5.setCallbackData("avsru");
                    row2.add(button5);
                    InlineKeyboardButton button34 = new InlineKeyboardButton();
                    button34.setText("Отдел связи");
                    button34.setCallbackData("otdsru");
                    row1.add(button34);
                    list.add(row);
                    list.add(row1);
                    list.add(row2);
                    markup.setKeyboard(list);

                    message.setText("Выберите Один из Них.");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    message.setReplyMarkup(markup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "mash" -> {
                    long chatId = update.getCallbackQuery().getMessage().getChatId();
                    List<List<InlineKeyboardButton>> list = new ArrayList<>();
                    List<InlineKeyboardButton> row = new ArrayList<>();
                    InlineKeyboardButton button = new InlineKeyboardButton();
                    button.setText("BESTUNE");
                    button.setCallbackData("best");
                    row.add(button);
                    list.add(row);
                    List<List<InlineKeyboardButton>> list1 = new ArrayList<>();
                    List<InlineKeyboardButton> row0 = new ArrayList<>();
                    InlineKeyboardButton button1 = new InlineKeyboardButton();
                    button1.setText("CHANGAN");
                    button1.setCallbackData("changan");
                    row0.add(button1);
                    list.add(row0);
                    List<InlineKeyboardButton> row4 = new ArrayList<>();
                    InlineKeyboardButton button4 = new InlineKeyboardButton();
                    button4.setText("JETOUR");
                    button4.setCallbackData("jet");
                    row4.add(button4);
                    list.add(row4);
                    List<InlineKeyboardButton> row1 = new ArrayList<>();
                    InlineKeyboardButton button0 = new InlineKeyboardButton();
                    button0.setText("HONGQI");
                    button0.setCallbackData("hon");
                    row.add(button0);
                    List<InlineKeyboardButton> row45 = new ArrayList<>();
                    InlineKeyboardButton button45 = new InlineKeyboardButton();
                    button45.setText("AIQAR");
                    button45.setCallbackData("aiq");
                    row45.add(button45);
                    list.add(row45);
                    List<InlineKeyboardButton> row2 = new ArrayList<>();
                    InlineKeyboardButton button2 = new InlineKeyboardButton();
                    button2.setText("DONGFENG");
                    button2.setCallbackData("don");
                    row.add(button2);
                    list.add(row2);
                    List<InlineKeyboardButton> row3 = new ArrayList<>();
                    SendMessage message = new SendMessage();
                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                    SendMessage message1 = new SendMessage();
                    markup.setKeyboard(list);
                    message.setChatId(chatId);
                    message.setReplyMarkup(markup);
                    message.setText("Qaysi avtomobil haqida ma'lumotga ega bo'lmoqchisiz?");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    message.setReplyMarkup(markup);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "mash-ru" -> {
                    long chatId = update.getCallbackQuery().getMessage().getChatId();
                    List<List<InlineKeyboardButton>> list = new ArrayList<>();
                    List<InlineKeyboardButton> row = new ArrayList<>();
                    InlineKeyboardButton button = new InlineKeyboardButton();
                    button.setText("BESTUNE");
                    button.setCallbackData("best-ru");
                    row.add(button);
                    list.add(row);
                    List<List<InlineKeyboardButton>> list1 = new ArrayList<>();
                    List<InlineKeyboardButton> row0 = new ArrayList<>();
                    InlineKeyboardButton button1 = new InlineKeyboardButton();
                    button1.setText("CHANGAN");
                    button1.setCallbackData("changan-ru");
                    row0.add(button1);
                    list.add(row0);
                    List<InlineKeyboardButton> row4 = new ArrayList<>();
                    InlineKeyboardButton button4 = new InlineKeyboardButton();
                    button4.setText("JETOUR");
                    button4.setCallbackData("jet-ru");
                    row4.add(button4);
                    list.add(row4);
                    List<InlineKeyboardButton> row1 = new ArrayList<>();
                    InlineKeyboardButton button0 = new InlineKeyboardButton();
                    button0.setText("HONGQI");
                    button0.setCallbackData("hon-ru");
                    row.add(button0);
                    List<InlineKeyboardButton> row45 = new ArrayList<>();
                    InlineKeyboardButton button45 = new InlineKeyboardButton();
                    button45.setText("AIQAR");
                    button45.setCallbackData("aiq-ru");
                    row45.add(button45);
                    list.add(row45);
                    List<InlineKeyboardButton> row2 = new ArrayList<>();
                    InlineKeyboardButton button2 = new InlineKeyboardButton();
                    button2.setText("DONGFENG");
                    button2.setCallbackData("don-ru");
                    row.add(button2);
                    list.add(row2);
                    List<InlineKeyboardButton> row3 = new ArrayList<>();
                    SendMessage message = new SendMessage();
                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                    SendMessage message1 = new SendMessage();
                    markup.setKeyboard(list);
                    message.setChatId(chatId);
                    message.setReplyMarkup(markup);
                    message.setText("О какой машине вы хотели бы узнать?");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    message.setReplyMarkup(markup);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "best" -> {
                    long chatId = update.getCallbackQuery().getMessage().getChatId();
                    List<List<InlineKeyboardButton>> list = new ArrayList<>();
                    List<InlineKeyboardButton> row = new ArrayList<>();
                    InlineKeyboardButton button1 = new InlineKeyboardButton();
                    button1.setText("BESTUNE T55");
                    button1.setCallbackData("bestuneT55");
                    row.add(button1);
                    List<InlineKeyboardButton> row3 = new ArrayList<>();
                    List<InlineKeyboardButton> row2 = new ArrayList<>();
                    InlineKeyboardButton button2 = new InlineKeyboardButton();
                    button2.setText("BESTUNE B70");
                    button2.setCallbackData("bestuneB70");
                    row2.add(button2);
                    List<InlineKeyboardButton> row5 = new ArrayList<>();
                    InlineKeyboardButton button4 = new InlineKeyboardButton();
                    button4.setText("BESTUNE T33");
                    button4.setCallbackData("bestune33");
                    row3.add(button4);
                    InlineKeyboardButton button = new InlineKeyboardButton();
                    button.setText("BESTUNE T99");
                    button.setCallbackData("bestuneT99");
                    InlineKeyboardButton button3 = new InlineKeyboardButton();
                    button3.setText("BESTUNE B70S");
                    button3.setCallbackData("bestune B70S");
                    row.add(button3);
                    row.add(button);
                    list.add(row);
                    list.add(row2);
                    list.add(row3);
                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                    SendMessage message = new SendMessage();
                    markup.setKeyboard(list);
                    message.setChatId(chatId);
                    message.setReplyMarkup(markup);
                    message.setText("Avtomobillardan birini tanlang.");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    message.setReplyMarkup(markup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "best-ru" -> {
                    long chatId = update.getCallbackQuery().getMessage().getChatId();
                    List<List<InlineKeyboardButton>> list = new ArrayList<>();
                    List<InlineKeyboardButton> row = new ArrayList<>();
                    InlineKeyboardButton button1 = new InlineKeyboardButton();
                    button1.setText("BESTUNE T55");
                    button1.setCallbackData("bestuneruT55");
                    row.add(button1);
                    List<InlineKeyboardButton> row3 = new ArrayList<>();
                    List<InlineKeyboardButton> row2 = new ArrayList<>();
                    InlineKeyboardButton button2 = new InlineKeyboardButton();
                    button2.setText("BESTUNE B70");
                    button2.setCallbackData("bestuneruB70");
                    row2.add(button2);
                    List<InlineKeyboardButton> row5 = new ArrayList<>();
                    InlineKeyboardButton button4 = new InlineKeyboardButton();
                    button4.setText("BESTUNE T33");
                    button4.setCallbackData("bestuneru33");
                    row3.add(button4);
                    InlineKeyboardButton button = new InlineKeyboardButton();
                    button.setText("BESTUNE T99");
                    button.setCallbackData("bestuneruT99");
                    InlineKeyboardButton button3 = new InlineKeyboardButton();
                    button3.setText("BESTUNE B70S");
                    button3.setCallbackData("bestuneru B70S");
                    row.add(button3);
                    row.add(button);
                    list.add(row);
                    list.add(row2);
                    list.add(row3);
                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                    SendMessage message = new SendMessage();
                    markup.setKeyboard(list);
                    message.setChatId(chatId);
                    message.setReplyMarkup(markup);
                    message.setText("Выберите Щдин из Них");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    message.setReplyMarkup(markup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "bestuneT99" -> {
                    List<InputMedia> list = new ArrayList<>();

                    InputMedia file1 = new InputMediaPhoto("https://bestuneuzbekistan.uz/assets/photos/4add3f8804d1523230a007e4ca9a3779de2fc91a.png");
                    InputMedia file3 = new InputMediaPhoto("https://bestuneuzbekistan.uz/assets/photos/2022-t99-bestune-9qu9o0qjtybdn113.jpeg");
                    InputMedia file4 = new InputMediaPhoto("https://xn----7sbbeeptbfadjdvm5ab9bqj.xn--p1ai/wp-content/uploads/2023/04/faw_t99_2_1000.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file4);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);
                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage massage = new SendMessage();
                    massage.setText("Murojat uchun ☎\uFE0F+998712051555");
                    massage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(massage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(67);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "bestuneB70" -> {
                    List<InputMedia> list = new ArrayList<>();

                    InputMedia file1 = new InputMediaPhoto("https://bestuneuzbekistan.uz/assets/photos/Ext-2-scaled.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://bestuneuzbekistan.uz/assets/photos/7ce3f1617206f77096bc80981703c2ea.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://bestuneuzbekistan.uz/assets/photos/Screenshot%202022-07-19%20145844.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage massage = new SendMessage();
                    massage.setText("Murojat uchun ☎\uFE0F+998712051555");
                    massage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(massage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(63);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }
                case "bestuneT55" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file7 = new InputMediaPhoto("https://bestuneuzbekistan.uz/assets/photos/cattouch%20(1).png");
                    InputMedia file8 = new InputMediaPhoto("https://bestuneuzbekistan.uz/assets/photos/t55-int-0.png");
                    InputMedia file = new InputMediaPhoto("https://autoreview.ru/images/gallery/%D0%9D%D0%BE%D0%B2%D0%BE%D1%81%D1%82%D0%B8/2023/April/12/FAW-Bestune-T55-5.jpg");
                    list.add(file);
                    list.add(file7);
                    list.add(file8);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);
                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(65);

                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }
                case "bestune33" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file8 = new InputMediaPhoto("https://i.infocar.ua/i/2/6010/114626/1920x.jpg");
                    InputMedia file9 = new InputMediaPhoto("https://avtoaziya.ru/images/FOTO/16/FAW-Bestune-T33-2019-2020-8.jpg");
                    InputMedia file10 = new InputMediaPhoto("https://upload.wikimedia.org/wikipedia/commons/thumb/1/10/Bestune_T33_img04.jpg/305px-Bestune_T33_img04.jpg");
                    list.add(file8);
                    list.add(file9);
                    list.add(file10);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);
                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(19);

                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "hon" -> {
                    long chatId = update.getCallbackQuery().getMessage().getChatId();
                    List<List<InlineKeyboardButton>> list = new ArrayList<>();
                    List<InlineKeyboardButton> row = new ArrayList<>();
                    InlineKeyboardButton button1 = new InlineKeyboardButton();
                    button1.setText("HONGQI HS5");
                    button1.setCallbackData("HongqiHS5");
                    row.add(button1);
                    List<List<InlineKeyboardButton>> list09 = new ArrayList<>();
                    List<InlineKeyboardButton> row007 = new ArrayList<>();
                    InlineKeyboardButton button008 = new InlineKeyboardButton();
                    button008.setText("HONGQI E-QM5");
                    button008.setCallbackData("Eqm5w");
                    row007.add(button008);
                    InlineKeyboardButton button10 = new InlineKeyboardButton();
                    button10.setText("HONGQI H9");
                    button10.setCallbackData("Hongqi H9");
                    row.add(button10);
                    List<InlineKeyboardButton> row3 = new ArrayList<>();
                    List<InlineKeyboardButton> row2 = new ArrayList<>();
                    InlineKeyboardButton button2 = new InlineKeyboardButton();
                    button2.setText("HONGQI H5");
                    button2.setCallbackData("HongqiH5");
                    row2.add(button2);
                    List<InlineKeyboardButton> row5 = new ArrayList<>();
                    InlineKeyboardButton button4 = new InlineKeyboardButton();
                    button4.setText("HONGQI HS7");
                    button4.setCallbackData("HongqiHS7");
                    row3.add(button4);
                    InlineKeyboardButton button3 = new InlineKeyboardButton();
                    button3.setText("HONGQI EHS9");
                    button3.setCallbackData("HongqiEHS9");
                    row3.add(button3);
                    list.add(row007);
                    list.add(row);
                    list.add(row2);
                    list.add(row3);
                    list.add(row5);
                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                    SendMessage message = new SendMessage();
                    markup.setKeyboard(list);
                    message.setChatId(chatId);
                    message.setReplyMarkup(markup);
                    message.setText("Avtomobillardan birini tanlang.");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    message.setReplyMarkup(markup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Eqm5w" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/eqm5_5.jpeg");
                    InputMedia file3 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/51129338075_cc19ca8477_b.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://cdn.globalso.com/centuryautomobile/Hongqi-E-QM5-ZHU_6.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");

                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(21);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "HongqiH5" -> {
                    List<InputMedia> list = new ArrayList<>();

                    InputMedia file1 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/h5_image_cover_03_302.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/h5_image_cover_02_145.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/hongqi-h5-2e.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");

                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(61);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "HongqiHS5" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/hs5_banner_1.png");
                    InputMedia file3 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/hs5_banner_3.png");
                    InputMedia file5 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/Hs5%20int.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);

                    }

                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(69);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "HongqiHS7" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/8054363.jpeg");
                    InputMedia file3 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/HS7_CarTail_cover_396_186.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/1-(1).jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(73);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException ex) {
                        throw new RuntimeException(ex);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Hongqi H9" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/2020010916575521183.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/2020010916572050595.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/2020010916305547828.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(71);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "HongqiEHS9" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://hongqi-avilon.ru/upload/iblock/71c/qlga3dv50z5m2fwdhznut7rvts92qvm7.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://hongqi-avilon.ru/upload/iblock/915/1mm9jw3degjgpc5wezwd1o6okjedaxiu.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://s0.rbk.ru/v6_top_pics/media/img/3/48/756642878091483.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(75);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "don" -> {
                    long chatId = update.getCallbackQuery().getMessage().getChatId();
                    List<List<InlineKeyboardButton>> list = new ArrayList<>();
                    List<InlineKeyboardButton> row2 = new ArrayList<>();
                    InlineKeyboardButton button2 = new InlineKeyboardButton();
                    button2.setText("DONGFENG T5 EVO");
                    button2.setCallbackData("Dongfeng");
                    row2.add(button2);
                    List<InlineKeyboardButton>rowMark5 = new ArrayList<>();
                    InlineKeyboardButton buttonMark5 = new InlineKeyboardButton();
                    buttonMark5.setText("DONFENG E 008");
                    buttonMark5.setCallbackData("Mark5");
                    rowMark5.add(buttonMark5);
                    List<InlineKeyboardButton> rowMark3 = new ArrayList<>();
                    InlineKeyboardButton buttonMark3 = new InlineKeyboardButton();
                    buttonMark3.setText("DONGFENG AEOLUS L7 EV");
                    buttonMark3.setCallbackData("Mark3");
                    rowMark3.add(buttonMark3);
                    List<InlineKeyboardButton> rowMark1 = new ArrayList<>();
                    InlineKeyboardButton buttonMark1 = new InlineKeyboardButton();
                    buttonMark1.setText("DONGFENG T5 EVO HYBRID");
                    buttonMark1.setCallbackData("Mark1");
                    rowMark1.add(buttonMark1);
                    List<InlineKeyboardButton> row13 = new ArrayList<>();
                    InlineKeyboardButton button34 = new InlineKeyboardButton();
                    button34.setText("AEOLUS SHINE GS ATMOS");
                    button34.setCallbackData("AEOLUS SHINE GS ATMOS");
                    row13.add(button34);
                    List<InlineKeyboardButton> row23 = new ArrayList<>();
                    InlineKeyboardButton button21 = new InlineKeyboardButton();
                    button21.setText("AEOLUS SHINE GS TURBO");
                    button21.setCallbackData("AEOLUS SHINE GS TURBO");
                    row23.add(button21);
                    List<InlineKeyboardButton> row3 = new ArrayList<>();
                    InlineKeyboardButton button11 = new InlineKeyboardButton();
                    button11.setText("AEOLUS HUGE");
                    button11.setCallbackData("AEOLUS HUGE");
                    row3.add(button11);
                    List<InlineKeyboardButton> row4 = new ArrayList<>();
                    InlineKeyboardButton button12 = new InlineKeyboardButton();
                    button12.setText("DONGFENG AEOLUS YIXUAN MAX");
                    button12.setCallbackData("DONGFENG AEOLUS YIXUAN MAX");
                    row4.add(button12);
                    List<InlineKeyboardButton> row5 = new ArrayList<>();
                    InlineKeyboardButton button13 = new InlineKeyboardButton();
                    button13.setText("FENGON 600");
                    button13.setCallbackData("FENGON 600");
                    row5.add(button13);
                    List<InlineKeyboardButton> row6 = new ArrayList<>();
                    InlineKeyboardButton button14 = new InlineKeyboardButton();
                    button14.setText("GLORY 330S");
                    button14.setCallbackData("GLORY 330S");
                    row6.add(button14);
                    List<InlineKeyboardButton> row7 = new ArrayList<>();
                    InlineKeyboardButton button15 = new InlineKeyboardButton();
                    button15.setText("TUNLAND G9");
                    button15.setCallbackData("TUNLAND G9");
                    row7.add(button15);
                    List<InlineKeyboardButton> row10 = new ArrayList<>();
                    InlineKeyboardButton button17 = new InlineKeyboardButton();
                    button17.setText("DONGFENG FENGON S508 EVR");
                    button17.setCallbackData("DONGFENG FENGON S508 EVR");
                    row10.add(button17);
                    List<InlineKeyboardButton> row9 = new ArrayList<>();
                    InlineKeyboardButton button7 = new InlineKeyboardButton();
                    button7.setText("AEOLUS SHINE");
                    button7.setCallbackData("AEOLUS SHINE");
                    row9.add(button7);
                    list.add(row2);
                    list.add(row3);
                    list.add(row4);
                    list.add(row5);
                    list.add(row9);
                    list.add(row6);
                    list.add(row7);
                    list.add(row10);
                    list.add(row23);
                    list.add(row13);
                    list.add(rowMark1);
                    list.add(rowMark3);
                    list.add(rowMark5);
                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                    SendMessage message = new SendMessage();
                    markup.setKeyboard(list);
                    message.setChatId(chatId);
                    message.setReplyMarkup(markup);
                    message.setText("Avtomabillardan birini tanlang");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    message.setReplyMarkup(markup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Mark5"->{
                    List<InputMedia> mediaList = new ArrayList<>();
                    mediaList.add(new InputMediaPhoto("https://ncars.com.ua/image/data/Modelniy%20ryad/Dongfeng/Dongfeng%20e%CF%80%20008/%D0%91%D0%B0%D0%BD%D0%B5%D1%80%D0%B8/banner1.jpg"));
                    mediaList.add(new InputMediaPhoto("https://kolesa-uploads.ru/r/880x/e3984990-39e2-4add-acad-60380f568788/yipai-008-14.jpg"));
                    mediaList.add(new InputMediaPhoto("https://kolesa-uploads.ru/r/880x/573196c7-0e24-433e-aff4-935a2cf2892a/yipai008-12.jpg"));
// Add more media items if needed (up to 10)

                    SendMediaGroup sendMediaGroup = new SendMediaGroup();
                    sendMediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    sendMediaGroup.setMedias(mediaList);

                    try {
                        execute(sendMediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    if (mediaList.size() < 3) {
                        System.out.println("Error: Media list must contain at least 2 items.");
                        return; // or handle it gracefully
                    }


                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(2006);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Mark3" -> {
                    List<InputMedia> mediaList = new ArrayList<>();
                    mediaList.add(new InputMediaPhoto("https://img.gazeta.ru/files3/629/18500629/image-154-pic_32ratio_1200x800-1200x800-86255.jpg"));
                    mediaList.add(new InputMediaPhoto("https://sc04.alicdn.com/kf/H3f676646a04443ebb36b8c36cc4d5532r.jpg"));
                    mediaList.add(new InputMediaPhoto("https://c2.gasgoo.com/autonews/moblogo/News/UEditor/1640-X/20240527/6385242922516651628532093.jpg"));
// Add more media items if needed (up to 10)

                    SendMediaGroup sendMediaGroup = new SendMediaGroup();
                    sendMediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    sendMediaGroup.setMedias(mediaList);

                    try {
                        execute(sendMediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    if (mediaList.size() < 3) {
                        System.out.println("Error: Media list must contain at least 2 items.");
                        return; // or handle it gracefully
                    }


                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(1973);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Mark1"->{
                    List<InputMedia> mediaList = new ArrayList<>();
                    mediaList.add(new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/forthing_evo_hev_1_1000-1280x720.jpg"));
                    mediaList.add(new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/9_1400x0_1_q95_autohomecar_ChwFlWAJFXKAPsl5AB5z5h8kLuY1662_1024x12.jpg"));
                    mediaList.add(new InputMediaPhoto("https://chinamotor.bg/wp-content/uploads/2024/07/dongfeng-t5-hev-017.jpg"));
// Add more media items if needed (up to 10)

                    SendMediaGroup sendMediaGroup = new SendMediaGroup();
                    sendMediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    sendMediaGroup.setMedias(mediaList);

                    try {
                        execute(sendMediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    if (mediaList.size() < 3) {
                        System.out.println("Error: Media list must contain at least 2 items.");
                        return; // or handle it gracefully
                    }


                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(1975);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Dongfeng" -> {
                    List<InputMedia> mediaList = new ArrayList<>();
                    mediaList.add(new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/Forthing-T5-EVO-2023.jpg"));
                    mediaList.add(new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/346854368059493.jpg"));
                    mediaList.add(new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/HD-wallpaper-vehicles-forthing-t5-evo-suv.jpg"));
// Add more media items if needed (up to 10)

                    SendMediaGroup sendMediaGroup = new SendMediaGroup();
                    sendMediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    sendMediaGroup.setMedias(mediaList);

                    try {
                        execute(sendMediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    if (mediaList.size() < 3) {
                        System.out.println("Error: Media list must contain at least 2 items.");
                        return; // or handle it gracefully
                    }


                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(57);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "AEOLUS HUGE" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/Article_174270_860_575.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/dfmaeohuge-14-1701166710.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://s.auto.drom.ru/i24277/c/photos/fullsize/dongfeng/aeolus_haoji/dongfeng_aeolus_haoji_1112922.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(55);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "DONGFENG AEOLUS YIXUAN MAX" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/dongfeng_aeolus_yixuan_max_1112308.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/new-dongfeng-shine-max-4.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/dongfeng_shine_max_1138820.jpg");
                    InputMedia file9 = new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/high_05.af909f2.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file9);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(53);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "FENGON 600" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://image.made-in-china.com/202f0j00zKVkpuyIbTbS/Dfsk-Fengon-600-Best-SUV-with-Automatic-Gearbox.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://image.made-in-china.com/226f3j00atkBrgVfIocL/%D0%9A%D0%B8%D1%82%D0%B0%D0%B9%D1%81%D0%BA%D0%B8%D0%B9+%D0%BF%D1%80%D0%BE%D0%B8%D0%B7%D0%B2%D0%BE%D0%B4%D0%B8%D1%82%D0%B5%D0%BB%D1%8C+%D0%BD%D0%BE%D0%B2%D1%8B%D0%B9+%D0%B0%D0%B2%D1%82%D0%BE%D0%BC%D0%BE%D0%B1%D0%B8%D0%BB%D1%8C+Dfsk+Fengon+Glory+600+%D0%B4%D0%B5%D1%88%D0%B5%D0%B2%D1%8B%D0%B9+%D0%B1%D0%B5%D0%BD%D0%B7%D0%B8%D0%BD%D0%BE%D0%B2%D1%8B%D0%B9+%D0%B2%D0%BD%D0%B5%D0%B4%D0%BE%D1%80%D0%BE%D0%B6%D0%BD%D0%B8%D0%BA+1.5t+%D0%B4%D0%B2%D0%B8%D0%B3%D0%B0%D1%82%D0%B5%D0%BB%D1%8C+%D1%81+%D0%B0%D0%B4%D0%B0%D0%BF%D1%82%D0%B8%D0%B2%D0%BD%D1%8B%D0%BC+%D0%BA%D1%80%D1%83%D0%B8%D0%B7-%D0%BA%D0%BE%D0%BD%D1%82%D1%80%D0%BE%D0%BB%D0%B5%D0%BC.webp");
                    InputMedia file5 = new InputMediaPhoto("https://assets-global.website-files.com/636e3329f2c48fa4e963929e/63ce936cd805d541f3156894_features.jpg");
                    InputMedia file9 = new InputMediaPhoto("https://i.ytimg.com/vi/cuOnExDrca4/maxresdefault.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file9);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(49);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }
                case "GLORY 330S" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://mosautoshina.ru/i/auto/dongfeng_330s_2020.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://sc04.alicdn.com/kf/H4fc6e63cbb594cfd87b4f5646dc1035bZ/255107010/H4fc6e63cbb594cfd87b4f5646dc1035bZ.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://image.made-in-china.com/202f0j00FbgcKfTdLwor/Dfsk-Dongfeng-Glory-330s-Chinese-Gasoline-Hybrid-Used-Smart-MPV-Minivan-Small-Car-Engine-5mt-Cheap-7-Seats-Passenger-Best-Mini-Bus-MPV-Van-Vehicle-for-Business.jpg");
                    InputMedia file9 = new InputMediaPhoto("https://image.made-in-china.com/202f0j00jozkKqaFkmcr/Dfsk-Dongfeng-Glory-330s-Chinese-Gasoline-Hybrid-Used-Smart-MPV-Minivan-Small-Car-Engine-5mt-Cheap-7-Seats-Passenger-Best-Mini-Bus-MPV-Van-Vehicle-for-Business.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file9);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(47);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "TUNLAND G9" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://abiznews.net/wp-content/uploads/2023/09/Foton-Tunland-G9.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://repost.uz/storage/uploads/65000-1667536454-avto11-post-material.jpeg");
                    InputMedia file5 = new InputMediaPhoto("https://carsdb.ru/auto/foton/tunland-g9/photo/15.jpg");
                    InputMedia file9 = new InputMediaPhoto("https://carsdb.ru/auto/foton/tunland-g9/photo/8.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file9);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(45);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "bestune B70S" -> {
                    List<InputMedia> mediaList = new ArrayList<>();
                    mediaList.add(new InputMediaPhoto("https://cdn.syarah.com/photos-thumbs/online-v1/0x426/online/posts/215380/orignal-1727346678-653.jpg"));
                    mediaList.add(new InputMediaPhoto("https://cdn.syarah.com/photos-thumbs/online-v1/0x426/online/posts/215380/orignal-1727346685-948.jpg"));
                    mediaList.add(new InputMediaPhoto("https://s.auto.drom.ru/i24280/c/photos/fullsize/faw/besturn_b70/faw_besturn_b70_1128332.jpg"));
// Add more media items if needed (up to 10)

                    SendMediaGroup sendMediaGroup = new SendMediaGroup();
                    sendMediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    sendMediaGroup.setMedias(mediaList);

                    try {
                        execute(sendMediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    if (mediaList.size() < 3) {
                        System.out.println("Error: Media list must contain at least 2 items.");
                        return; // or handle it gracefully
                    }


                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(35);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }
                case "DONGFENG FENGON S508 EVR" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://autoreview.ru/images/Article/1750/Article_175081_860_575.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://autoreview.ru/images/gallery/%D0%9D%D0%BE%D0%B2%D0%BE%D1%81%D1%82%D0%B8/2022/December/28/dongfeng-e5-4.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://autoreview.ru/images/gallery/%D0%9D%D0%BE%D0%B2%D0%BE%D1%81%D1%82%D0%B8/2022/December/28/dongfeng-e5-5.jpg");
                    InputMedia file6 = new InputMediaPhoto("https://autoreview.ru/img/article/images/1773/177322/QQAEkC1VLR.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file6);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(33);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }
                case "AEOLUS SHINE" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://xn----7sbbeeptbfadjdvm5ab9bqj.xn--p1ai/wp-content/uploads/2023/07/dongfeng_aeolus_shine_max_1_1000-1280x720.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://wroom.ru/i/cars2/dongfeng_aeolus-shine-max_1_2.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://xn----7sbbeeptbfadjdvm5ab9bqj.xn--p1ai/wp-content/uploads/2023/08/dongfeng_aeolus_shine_max_3_1000.jpg");
                    InputMedia file6 = new InputMediaPhoto("https://turbo.azstatic.com/uploads/full/2024%2F02%2F05%2F17%2F59%2F08%2F479bdc3d-e674-4204-89a0-8517fccac9a1%2F3782_r1qMcGFRQblORIGanm7Szw.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file6);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(31);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "aiq-ru" -> {
                    List<List<InlineKeyboardButton>> list = new ArrayList<>();
                    List<InlineKeyboardButton> row21 = new ArrayList<>();
                    InlineKeyboardButton button2 = new InlineKeyboardButton();
                    button2.setText("AIQAR ARRIZO E");
                    button2.setCallbackData("AIQAR ARRIZO Eru");
                    row21.add(button2);
                    List<InlineKeyboardButton> row3 = new ArrayList<>();
                    InlineKeyboardButton button11 = new InlineKeyboardButton();
                    button11.setText("AIQAR  EQ7");
                    button11.setCallbackData("AIQAR  EQ7ru");
                    row3.add(button11);
                    List<InlineKeyboardButton> row4 = new ArrayList<>();
                    InlineKeyboardButton button12 = new InlineKeyboardButton();
                    button12.setText("AIQAR EQ3");
                    button12.setCallbackData("eqru");
                    row4.add(button12);
                    list.add(row21);
                    list.add(row3);
                    list.add(row4);
                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                    SendMessage message = new SendMessage();
                    markup.setKeyboard(list);
                    message.setReplyMarkup(markup);
                    message.setText("Выберите Один из Них");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    message.setReplyMarkup(markup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "AIQAR  EQ7ru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://carnewschina.com/wp-content/uploads/2023/04/1-4.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://carnewschina.com/wp-content/uploads/2023/04/4-4.jpg");
                    InputMedia file7 = new InputMediaPhoto("https://images.khmer24.co/24-02-12/aiqar-eq7-981845170770194028817274-d.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file7);
                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения  ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(27);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }
                case "AEOLUS SHINE GS TURBO" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/aeolus_shine_01.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/high_07.e27566d.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/aeolus_shine_gs_14.jpg");
                    InputMedia file6 = new InputMediaPhoto("https://otoba.ru/auto/dongfeng/img/shine-gs/1/kuzov/dongfeng-shine-gs-1-rus-szadi.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file6);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(25);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }
                case "AEOLUS SHINE GS ATMOS" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/Portada2.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://content.onliner.by/news/1100x5616/138cf6db47b787e22b81f4f46a587338.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://avcdn.av.by/salonoffermedium/0002/8071/8684.jpg");
                    InputMedia file6 = new InputMediaPhoto("https://content.onliner.by/news/amp/aee6c1b47a2e0cf8c1fad67d3703e44b.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file6);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(23);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "Onlnshrt" -> {
                    SendMessage message = new SendMessage();
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    message.setText("Onlayn shartnoma  olish uchun telefon raqamingizni qoldiring");
                    repository.updateBotState(update.getCallbackQuery().getMessage().getChatId(), BotState.PHONE_NUMBER);
                    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                    List<KeyboardRow> rowList = new ArrayList<>();
                    KeyboardRow row = new KeyboardRow();
                    KeyboardButton button = new KeyboardButton();
                    button.setText("Telefon raqamni ulashish");
                    button.setRequestContact(true);
                    row.add(button);
                    rowList.add(row);
                    replyKeyboardMarkup.setKeyboard(rowList);
                    message.setReplyMarkup(replyKeyboardMarkup);
                    replyKeyboardMarkup.setResizeKeyboard(true);
                    replyKeyboardMarkup.getOneTimeKeyboard();

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Onlnshrtru" -> {
                    SendMessage message = new SendMessage();
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    message.setText("Оставьте свой номер телефона, чтобы получить онлайн-договор");
                    repository.updateBotState(update.getCallbackQuery().getMessage().getChatId(), BotState.PHONE_NUMBER);
                    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                    List<KeyboardRow> rowList = new ArrayList<>();
                    KeyboardRow row = new KeyboardRow();
                    KeyboardButton button = new KeyboardButton();
                    button.setText("Поделитесь номером телефона");
                    button.setRequestContact(true);
                    row.add(button);
                    rowList.add(row);
                    replyKeyboardMarkup.setKeyboard(rowList);
                    message.setReplyMarkup(replyKeyboardMarkup);
                    replyKeyboardMarkup.setResizeKeyboard(true);
                    replyKeyboardMarkup.getOneTimeKeyboard();
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "bestuneruT99" -> {
                    List<InputMedia> list = new ArrayList<>();

                    InputMedia file1 = new InputMediaPhoto("https://bestuneuzbekistan.uz/assets/photos/4add3f8804d1523230a007e4ca9a3779de2fc91a.png");
                    InputMedia file3 = new InputMediaPhoto("https://bestuneuzbekistan.uz/assets/photos/2022-t99-bestune-9qu9o0qjtybdn113.jpeg");
                    InputMedia file4 = new InputMediaPhoto("https://xn----7sbbeeptbfadjdvm5ab9bqj.xn--p1ai/wp-content/uploads/2023/04/faw_t99_2_1000.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file4);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);
                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage massage = new SendMessage();
                    massage.setText("Для применения \uD83D\uDCDE+998712051555");
                    massage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(massage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(67);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "bestuneruB70" -> {
                    List<InputMedia> list = new ArrayList<>();

                    InputMedia file1 = new InputMediaPhoto("https://bestuneuzbekistan.uz/assets/photos/Ext-2-scaled.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://bestuneuzbekistan.uz/assets/photos/7ce3f1617206f77096bc80981703c2ea.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://bestuneuzbekistan.uz/assets/photos/Screenshot%202022-07-19%20145844.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage massage = new SendMessage();
                    massage.setText("Для применения \uD83D\uDCDE+998712051555");
                    massage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(massage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(63);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }
                case "bestuneruT55" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file7 = new InputMediaPhoto("https://bestuneuzbekistan.uz/assets/photos/cattouch%20(1).png");
                    InputMedia file8 = new InputMediaPhoto("https://bestuneuzbekistan.uz/assets/photos/t55-int-0.png");
                    InputMedia file = new InputMediaPhoto("https://autoreview.ru/images/gallery/%D0%9D%D0%BE%D0%B2%D0%BE%D1%81%D1%82%D0%B8/2023/April/12/FAW-Bestune-T55-5.jpg");
                    list.add(file);
                    list.add(file7);
                    list.add(file8);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);
                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(65);

                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }
                case "bestuneru33" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file8 = new InputMediaPhoto("https://i.infocar.ua/i/2/6010/114626/1920x.jpg");
                    InputMedia file9 = new InputMediaPhoto("https://avtoaziya.ru/images/FOTO/16/FAW-Bestune-T33-2019-2020-8.jpg");
                    InputMedia file10 = new InputMediaPhoto("https://upload.wikimedia.org/wikipedia/commons/thumb/1/10/Bestune_T33_img04.jpg/305px-Bestune_T33_img04.jpg");
                    list.add(file8);
                    list.add(file9);
                    list.add(file10);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);
                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(19);

                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "bestuneru B70S" -> {
                    List<InputMedia> mediaList = new ArrayList<>();
                    mediaList.add(new InputMediaPhoto("https://cdn.syarah.com/photos-thumbs/online-v1/0x426/online/posts/215380/orignal-1727346678-653.jpg"));
                    mediaList.add(new InputMediaPhoto("https://cdn.syarah.com/photos-thumbs/online-v1/0x426/online/posts/215380/orignal-1727346685-948.jpg"));
                    mediaList.add(new InputMediaPhoto("https://s.auto.drom.ru/i24280/c/photos/fullsize/faw/besturn_b70/faw_besturn_b70_1128332.jpg"));
// Add more media items if needed (up to 10)

                    SendMediaGroup sendMediaGroup = new SendMediaGroup();
                    sendMediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    sendMediaGroup.setMedias(mediaList);

                    try {
                        execute(sendMediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    if (mediaList.size() < 3) {
                        System.out.println("Error: Media list must contain at least 2 items.");
                        return; // or handle it gracefully
                    }

                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(35);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }


                case "AIQAR e Q7ru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://carnewschina.com/wp-content/uploads/2023/04/1-4.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://carnewschina.com/wp-content/uploads/2023/04/4-4.jpg");
                    InputMedia file7 = new InputMediaPhoto("https://images.khmer24.co/24-02-12/aiqar-eq7-981845170770194028817274-d.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file7);
                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(27);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "eqru" -> {
                    System.out.println(1);
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://www.hcrmotorsgroup.com/wp-content/uploads/2024/02/Aiqar-eQ3-grey.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://www.hcrmotorsgroup.com/wp-content/uploads/2024/01/Aiqar-eQ3-interior-green-1.jpg");
                    InputMedia file7 = new InputMediaPhoto("https://images.khmer24.co/24-02-12/aiqar-eq3-981845170770178691982277-d.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file7);
                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(15);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }
                case "don-ru" -> {
                    long chatId = update.getCallbackQuery().getMessage().getChatId();
                    List<List<InlineKeyboardButton>> list = new ArrayList<>();
                    List<InlineKeyboardButton> row2 = new ArrayList<>();
                    InlineKeyboardButton button2 = new InlineKeyboardButton();
                    button2.setText("DONGFENG T5 EVO");
                    button2.setCallbackData("Dongfengru");
                    row2.add(button2);
                    List<InlineKeyboardButton>rowMark6 = new ArrayList<>();
                    InlineKeyboardButton buttonMark6 = new InlineKeyboardButton();
                    buttonMark6.setText("DONFENG E 008");
                    buttonMark6.setCallbackData("Mark6");
                    rowMark6.add(buttonMark6);
                    List<InlineKeyboardButton>rowMark4 = new ArrayList<>();
                    InlineKeyboardButton buttonMark4 = new InlineKeyboardButton();
                    buttonMark4.setText("DONGFENG AEOLUS L7 EV");
                    buttonMark4.setCallbackData("Mark4");
                    rowMark4.add(buttonMark4);
                    List<InlineKeyboardButton>rowMark2 = new ArrayList<>();
                    InlineKeyboardButton buttonMark2 = new InlineKeyboardButton();
                    buttonMark2.setText("DONGFENG T5 EVO HYBRID");
                    buttonMark2.setCallbackData("Mark2");
                    rowMark2.add(buttonMark2);
                    List<InlineKeyboardButton> row13 = new ArrayList<>();
                    InlineKeyboardButton button34 = new InlineKeyboardButton();
                    button34.setText("AEOLUS SHINE GS ATMOS");
                    button34.setCallbackData("AEOLUS SHINE GS ATMOSru");
                    row13.add(button34);
                    List<InlineKeyboardButton> row23 = new ArrayList<>();
                    InlineKeyboardButton button21 = new InlineKeyboardButton();
                    button21.setText("AEOLUS SHINE GS TURBO");
                    button21.setCallbackData("AEOLUS SHINE GS TURBOru");
                    row23.add(button21);
                    List<InlineKeyboardButton> row3 = new ArrayList<>();
                    InlineKeyboardButton button11 = new InlineKeyboardButton();
                    button11.setText("AEOLUS HUGE");
                    button11.setCallbackData("AEOLUS HUGEru");
                    row3.add(button11);
                    List<InlineKeyboardButton> row4 = new ArrayList<>();
                    InlineKeyboardButton button12 = new InlineKeyboardButton();
                    button12.setText("DONGFENG AEOLUS YIXUAN MAX");
                    button12.setCallbackData("DONGFENG AEOLUS YIXUAN MAXru");
                    row4.add(button12);
                    List<InlineKeyboardButton> row5 = new ArrayList<>();
                    InlineKeyboardButton button13 = new InlineKeyboardButton();
                    button13.setText("FENGON 600");
                    button13.setCallbackData("FENGON 600ru");
                    row5.add(button13);
                    List<InlineKeyboardButton> row6 = new ArrayList<>();
                    InlineKeyboardButton button14 = new InlineKeyboardButton();
                    button14.setText("GLORY 330S");
                    button14.setCallbackData("GLORY 330Sru");
                    row6.add(button14);
                    List<InlineKeyboardButton> row7 = new ArrayList<>();
                    InlineKeyboardButton button15 = new InlineKeyboardButton();
                    button15.setText("TUNLAND G9");
                    button15.setCallbackData("TUNLAND G9ru");
                    row7.add(button15);
                    List<InlineKeyboardButton> row10 = new ArrayList<>();
                    InlineKeyboardButton button17 = new InlineKeyboardButton();
                    button17.setText("DONGFENG FENGON S508 EVR");
                    button17.setCallbackData("DONGFENG FENGON S508 EVRru");
                    row10.add(button17);
                    List<InlineKeyboardButton> row9 = new ArrayList<>();
                    InlineKeyboardButton button7 = new InlineKeyboardButton();
                    button7.setText("AEOLUS SHINE");
                    button7.setCallbackData("AEOLUS SHINEru");
                    row9.add(button7);
                    list.add(row2);
                    list.add(row3);
                    list.add(row4);
                    list.add(row5);
                    list.add(row9);
                    list.add(row6);
                    list.add(row7);
                    list.add(row10);
                    list.add(row23);
                    list.add(row13);
                    list.add(rowMark2);
                    list.add(rowMark4);
                    list.add(rowMark6);
                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                    SendMessage message = new SendMessage();
                    markup.setKeyboard(list);
                    message.setChatId(chatId);
                    message.setReplyMarkup(markup);
                    message.setText("Выберите щдин из них");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    message.setReplyMarkup(markup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Mark6"->{
                    List<InputMedia> mediaList = new ArrayList<>();
                    mediaList.add(new InputMediaPhoto("https://ncars.com.ua/image/data/Modelniy%20ryad/Dongfeng/Dongfeng%20e%CF%80%20008/%D0%91%D0%B0%D0%BD%D0%B5%D1%80%D0%B8/banner1.jpg"));
                    mediaList.add(new InputMediaPhoto("https://kolesa-uploads.ru/r/880x/e3984990-39e2-4add-acad-60380f568788/yipai-008-14.jpg"));
                    mediaList.add(new InputMediaPhoto("https://kolesa-uploads.ru/r/880x/573196c7-0e24-433e-aff4-935a2cf2892a/yipai008-12.jpg"));
// Add more media items if needed (up to 10)

                    SendMediaGroup sendMediaGroup = new SendMediaGroup();
                    sendMediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    sendMediaGroup.setMedias(mediaList);

                    try {
                        execute(sendMediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    if (mediaList.size() < 3) {
                        System.out.println("Error: Media list must contain at least 2 items.");
                        return; // or handle it gracefully
                    }


                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(2006);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Mark4"->{
                    List<InputMedia> mediaList = new ArrayList<>();
                    mediaList.add(new InputMediaPhoto("https://img.gazeta.ru/files3/629/18500629/image-154-pic_32ratio_1200x800-1200x800-86255.jpg"));
                    mediaList.add(new InputMediaPhoto("https://sc04.alicdn.com/kf/H3f676646a04443ebb36b8c36cc4d5532r.jpg"));
                    mediaList.add(new InputMediaPhoto("https://c2.gasgoo.com/autonews/moblogo/News/UEditor/1640-X/20240527/6385242922516651628532093.jpg"));
// Add more media items if needed (up to 10)

                    SendMediaGroup sendMediaGroup = new SendMediaGroup();
                    sendMediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    sendMediaGroup.setMedias(mediaList);

                    try {
                        execute(sendMediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    if (mediaList.size() < 3) {
                        System.out.println("Error: Media list must contain at least 2 items.");
                        return; // or handle it gracefully
                    }


                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(1973);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Mark2"->{
                    List<InputMedia> mediaList = new ArrayList<>();
                    mediaList.add(new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/forthing_evo_hev_1_1000-1280x720.jpg"));
                    mediaList.add(new InputMediaPhoto("https://chinamotor.bg/wp-content/uploads/2024/07/dongfeng-t5-hev-017.jpg"));
                    mediaList.add(new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/9_1400x0_1_q95_autohomecar_ChwFlWAJFXKAPsl5AB5z5h8kLuY1662_1024x12.jpg"));
// Add more media items if needed (up to 10)

                    SendMediaGroup sendMediaGroup = new SendMediaGroup();
                    sendMediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    sendMediaGroup.setMedias(mediaList);

                    try {
                        execute(sendMediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    if (mediaList.size() < 3) {
                        System.out.println("Error: Media list must contain at least 2 items.");
                        return; // or handle it gracefully
                    }


                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(1975);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Dongfengru" -> {
                    List<InputMedia> mediaList = new ArrayList<>();
                    mediaList.add(new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/Forthing-T5-EVO-2023.jpg"));
                    mediaList.add(new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/346854368059493.jpg"));
                    mediaList.add(new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/HD-wallpaper-vehicles-forthing-t5-evo-suv.jpg"));
// Add more media items if needed (up to 10)

                    SendMediaGroup sendMediaGroup = new SendMediaGroup();
                    sendMediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    sendMediaGroup.setMedias(mediaList);

                    try {
                        execute(sendMediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    if (mediaList.size() < 3) {
                        System.out.println("Error: Media list must contain at least 2 items.");
                        return; // or handle it gracefully
                    }


                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(57);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "AEOLUS SHINE GS ATMOSru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/Portada2.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://content.onliner.by/news/1100x5616/138cf6db47b787e22b81f4f46a587338.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://avcdn.av.by/salonoffermedium/0002/8071/8684.jpg");
                    InputMedia file6 = new InputMediaPhoto("https://content.onliner.by/news/amp/aee6c1b47a2e0cf8c1fad67d3703e44b.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file6);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(23);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "AEOLUS SHINE GS TURBOru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/aeolus_shine_01.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/high_07.e27566d.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/aeolus_shine_gs_14.jpg");
                    InputMedia file6 = new InputMediaPhoto("https://otoba.ru/auto/dongfeng/img/shine-gs/1/kuzov/dongfeng-shine-gs-1-rus-szadi.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file6);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(25);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }
                case "AEOLUS HUGEru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/Article_174270_860_575.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/dfmaeohuge-14-1701166710.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://s.auto.drom.ru/i24277/c/photos/fullsize/dongfeng/aeolus_haoji/dongfeng_aeolus_haoji_1112922.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(55);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "DONGFENG AEOLUS YIXUAN MAXru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/high_05.af909f2.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://dongfenguzbekistan.uz/assets/photos/dongfeng_shine_max_1138820.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://autoreview.ru/images/gallery/%D0%9D%D0%BE%D0%B2%D0%BE%D1%81%D1%82%D0%B8/2021/July/20/dongfeng-aeolus-max4.jpg");
                    InputMedia file9 = new InputMediaPhoto("https://www.ml-vehicle.com/uploads/202338258/dongfeng-aeolus-yixuan-max363566af-866e-4923-a262-955fe5a79b3a.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file9);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(53);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "FENGON 600ru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://image.made-in-china.com/202f0j00zKVkpuyIbTbS/Dfsk-Fengon-600-Best-SUV-with-Automatic-Gearbox.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://image.made-in-china.com/226f3j00atkBrgVfIocL/%D0%9A%D0%B8%D1%82%D0%B0%D0%B9%D1%81%D0%BA%D0%B8%D0%B9+%D0%BF%D1%80%D0%BE%D0%B8%D0%B7%D0%B2%D0%BE%D0%B4%D0%B8%D1%82%D0%B5%D0%BB%D1%8C+%D0%BD%D0%BE%D0%B2%D1%8B%D0%B9+%D0%B0%D0%B2%D1%82%D0%BE%D0%BC%D0%BE%D0%B1%D0%B8%D0%BB%D1%8C+Dfsk+Fengon+Glory+600+%D0%B4%D0%B5%D1%88%D0%B5%D0%B2%D1%8B%D0%B9+%D0%B1%D0%B5%D0%BD%D0%B7%D0%B8%D0%BD%D0%BE%D0%B2%D1%8B%D0%B9+%D0%B2%D0%BD%D0%B5%D0%B4%D0%BE%D1%80%D0%BE%D0%B6%D0%BD%D0%B8%D0%BA+1.5t+%D0%B4%D0%B2%D0%B8%D0%B3%D0%B0%D1%82%D0%B5%D0%BB%D1%8C+%D1%81+%D0%B0%D0%B4%D0%B0%D0%BF%D1%82%D0%B8%D0%B2%D0%BD%D1%8B%D0%BC+%D0%BA%D1%80%D1%83%D0%B8%D0%B7-%D0%BA%D0%BE%D0%BD%D1%82%D1%80%D0%BE%D0%BB%D0%B5%D0%BC.webp");
                    InputMedia file5 = new InputMediaPhoto("https://assets-global.website-files.com/636e3329f2c48fa4e963929e/63ce936cd805d541f3156894_features.jpg");
                    InputMedia file9 = new InputMediaPhoto("https://i.ytimg.com/vi/cuOnExDrca4/maxresdefault.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file9);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(49);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }
                case "GLORY 330Sru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://mosautoshina.ru/i/auto/dongfeng_330s_2020.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://sc04.alicdn.com/kf/H4fc6e63cbb594cfd87b4f5646dc1035bZ/255107010/H4fc6e63cbb594cfd87b4f5646dc1035bZ.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://image.made-in-china.com/202f0j00FbgcKfTdLwor/Dfsk-Dongfeng-Glory-330s-Chinese-Gasoline-Hybrid-Used-Smart-MPV-Minivan-Small-Car-Engine-5mt-Cheap-7-Seats-Passenger-Best-Mini-Bus-MPV-Van-Vehicle-for-Business.jpg");
                    InputMedia file9 = new InputMediaPhoto("https://image.made-in-china.com/202f0j00jozkKqaFkmcr/Dfsk-Dongfeng-Glory-330s-Chinese-Gasoline-Hybrid-Used-Smart-MPV-Minivan-Small-Car-Engine-5mt-Cheap-7-Seats-Passenger-Best-Mini-Bus-MPV-Van-Vehicle-for-Business.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file9);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(47);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "TUNLAND G9ru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://abiznews.net/wp-content/uploads/2023/09/Foton-Tunland-G9.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://repost.uz/storage/uploads/65000-1667536454-avto11-post-material.jpeg");
                    InputMedia file5 = new InputMediaPhoto("https://carsdb.ru/auto/foton/tunland-g9/photo/15.jpg");
                    InputMedia file9 = new InputMediaPhoto("https://carsdb.ru/auto/foton/tunland-g9/photo/8.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file9);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(45);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "DONGFENG FENGON S508 EVRru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://autoreview.ru/images/Article/1750/Article_175081_860_575.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://autoreview.ru/images/gallery/%D0%9D%D0%BE%D0%B2%D0%BE%D1%81%D1%82%D0%B8/2022/December/28/dongfeng-e5-4.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://autoreview.ru/images/gallery/%D0%9D%D0%BE%D0%B2%D0%BE%D1%81%D1%82%D0%B8/2022/December/28/dongfeng-e5-5.jpg");
                    InputMedia file6 = new InputMediaPhoto("https://autoreview.ru/img/article/images/1773/177322/QQAEkC1VLR.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file6);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(33);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }
                case "AEOLUS SHINEru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://xn----7sbbeeptbfadjdvm5ab9bqj.xn--p1ai/wp-content/uploads/2023/07/dongfeng_aeolus_shine_max_1_1000-1280x720.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://wroom.ru/i/cars2/dongfeng_aeolus-shine-max_1_2.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://xn----7sbbeeptbfadjdvm5ab9bqj.xn--p1ai/wp-content/uploads/2023/08/dongfeng_aeolus_shine_max_3_1000.jpg");
                    InputMedia file6 = new InputMediaPhoto("https://turbo.azstatic.com/uploads/full/2024%2F02%2F05%2F17%2F59%2F08%2F479bdc3d-e674-4204-89a0-8517fccac9a1%2F3782_r1qMcGFRQblORIGanm7Szw.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file6);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(31);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "jet" -> {
                    long chatId = update.getCallbackQuery().getMessage().getChatId();
                    List<List<InlineKeyboardButton>> list = new ArrayList<>();
                    List<InlineKeyboardButton> row2 = new ArrayList<>();
                    InlineKeyboardButton button2 = new InlineKeyboardButton();
                    button2.setText("JETOUR X70 PLUS");
                    button2.setCallbackData("jetx70");
                    row2.add(button2);
                    List<InlineKeyboardButton> row13 = new ArrayList<>();
                    InlineKeyboardButton button34 = new InlineKeyboardButton();
                    button34.setText("JETOUR X70");
                    button34.setCallbackData("jetx70+");
                    row13.add(button34);
                    List<InlineKeyboardButton> row23 = new ArrayList<>();
                    InlineKeyboardButton button21 = new InlineKeyboardButton();
                    button21.setText("JETOUR T2");
                    button21.setCallbackData("jet2");
                    row23.add(button21);
                    List<InlineKeyboardButton> row3 = new ArrayList<>();
                    InlineKeyboardButton button11 = new InlineKeyboardButton();
                    button11.setText("JETOUR DASHING");
                    button11.setCallbackData("jetdash");
                    row3.add(button11);
                    List<InlineKeyboardButton> row4 = new ArrayList<>();
                    InlineKeyboardButton button12 = new InlineKeyboardButton();
                    button12.setText("JETOUR X90 PLUS");
                    button12.setCallbackData("jet90");
                    row4.add(button12);
                    list.add(row2);
                    list.add(row3);
                    list.add(row4);
                    list.add(row23);
                    list.add(row13);
                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                    SendMessage message = new SendMessage();
                    markup.setKeyboard(list);
                    message.setChatId(chatId);
                    message.setReplyMarkup(markup);
                    message.setText("Avtomobillardan birini tanlang");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    message.setReplyMarkup(markup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "jetx70" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://xn----7sbbeeptbfadjdvm5ab9bqj.xn--p1ai/wp-content/uploads/2023/03/jetour_x70_new_version_1_1000.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://i.ytimg.com/vi/h5Zq_Vgg_XQ/maxresdefault.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://www.ixbt.com/img/n1/news/2023/2/0/5-11_large.jpg");
                    InputMedia file6 = new InputMediaPhoto("https://focus.ua/static/storage/thumbs/1088x/4/58/67269c7e-ce56a1d65b03c65fb0c8f502e67d3584.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file6);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(39);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "jetx70+" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://s.auto.drom.ru/i24276/c/photos/fullsize/jetour/x70/jetour_x70_1110095.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://autoreview.ru/images/gallery/%D0%9D%D0%BE%D0%B2%D0%BE%D1%81%D1%82%D0%B8/2020/September/11/jetour-x70-3.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://carsdo.ru/job/CarsDo/photo-gallery/jetour/x70-16.jpg");
                    InputMedia file6 = new InputMediaPhoto("https://ik.imagekit.io/girnar/sayaratbay/large/gallery/exterior/111/1916/jetour-x70-full-rear-view-329869.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file6);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(41);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "jet2" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/Jetour_T2.jpg/1280px-Jetour_T2.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://134706.selcdn.ru/v1/SEL_39171/site-production-public/system/image/file/10027702/vehicle_slider_4%402x.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://upload.wikimedia.org/wikipedia/commons/e/e9/Jetour_T2_interior.jpg");
                    InputMedia file6 = new InputMediaPhoto("https://134706.selcdn.ru/v1/SEL_39171/site-production-public/system/image/file/9408237/vehicle_slider_7%402x.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file6);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(17);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "jetdash" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://s.auto.drom.ru/i24278/c/photos/fullsize/jetour/dasheng/jetour_dasheng_1118354.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://www.borderlesscar.com/wp-content/uploads/2023/10/10013-2.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://www.gazeta.uz/media/img/2023/03/C6Qzwv16788786926614_b.jpg");
                    InputMedia file6 = new InputMediaPhoto("https://134706.selcdn.ru/v1/SEL_39171/site-production-public/system/image/file/7508001/vehicle_slider_7__1_%402x.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file6);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(37);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "jet90" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://data.favorit-motors.ru/upload/iblock/e89/e8941cca456515394fe44a6ce279d53e.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://japlantpoolgh.com/wp-content/uploads/2024/04/J.A-PLANT-POOL-JETOUR-X90-PLUS-BACKVIEW.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://www.souzcentr.ru/image/catalog/jetour/x90plus/features/x90plus_feature01.jpg");
                    InputMedia file6 = new InputMediaPhoto("https://alizing.by/storage/cars/2023/09/07/a7d7fe46b1708781e17277d13020e8a7290fd5dc.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file6);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(43);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "jet-ru" -> {
                    long chatId = update.getCallbackQuery().getMessage().getChatId();
                    List<List<InlineKeyboardButton>> list = new ArrayList<>();
                    List<InlineKeyboardButton> row2 = new ArrayList<>();
                    InlineKeyboardButton button2 = new InlineKeyboardButton();
                    button2.setText("JETOUR X70 PLUS");
                    button2.setCallbackData("jetx70ru");
                    row2.add(button2);
                    List<InlineKeyboardButton> row13 = new ArrayList<>();
                    InlineKeyboardButton button34 = new InlineKeyboardButton();
                    button34.setText("JETOUR X70");
                    button34.setCallbackData("jetx70+ru");
                    row13.add(button34);
                    List<InlineKeyboardButton> row23 = new ArrayList<>();
                    InlineKeyboardButton button21 = new InlineKeyboardButton();
                    button21.setText("JETOUR T2");
                    button21.setCallbackData("jet2ru");
                    row23.add(button21);
                    List<InlineKeyboardButton> row3 = new ArrayList<>();
                    InlineKeyboardButton button11 = new InlineKeyboardButton();
                    button11.setText("JETOUR DASHING");
                    button11.setCallbackData("jetdashru");
                    row3.add(button11);
                    List<InlineKeyboardButton> row4 = new ArrayList<>();
                    InlineKeyboardButton button12 = new InlineKeyboardButton();
                    button12.setText("JETOUR X90 PLUS");
                    button12.setCallbackData("jet90ru");
                    row4.add(button12);
                    list.add(row2);
                    list.add(row3);
                    list.add(row4);
                    list.add(row23);
                    list.add(row13);
                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                    SendMessage message = new SendMessage();
                    markup.setKeyboard(list);
                    message.setChatId(chatId);
                    message.setReplyMarkup(markup);
                    message.setText("Выберите один из них");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    message.setReplyMarkup(markup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "jetx70ru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://xn----7sbbeeptbfadjdvm5ab9bqj.xn--p1ai/wp-content/uploads/2023/03/jetour_x70_new_version_1_1000.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://i.ytimg.com/vi/h5Zq_Vgg_XQ/maxresdefault.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://www.ixbt.com/img/n1/news/2023/2/0/5-11_large.jpg");
                    InputMedia file6 = new InputMediaPhoto("https://focus.ua/static/storage/thumbs/1088x/4/58/67269c7e-ce56a1d65b03c65fb0c8f502e67d3584.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file6);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(39);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "jetx70+ru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://s.auto.drom.ru/i24276/c/photos/fullsize/jetour/x70/jetour_x70_1110095.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://autoreview.ru/images/gallery/%D0%9D%D0%BE%D0%B2%D0%BE%D1%81%D1%82%D0%B8/2020/September/11/jetour-x70-3.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://carsdo.ru/job/CarsDo/photo-gallery/jetour/x70-16.jpg");
                    InputMedia file6 = new InputMediaPhoto("https://ik.imagekit.io/girnar/sayaratbay/large/gallery/exterior/111/1916/jetour-x70-full-rear-view-329869.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file6);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(41);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "jet2ru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/Jetour_T2.jpg/1280px-Jetour_T2.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://134706.selcdn.ru/v1/SEL_39171/site-production-public/system/image/file/10027702/vehicle_slider_4%402x.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://upload.wikimedia.org/wikipedia/commons/e/e9/Jetour_T2_interior.jpg");
                    InputMedia file6 = new InputMediaPhoto("https://134706.selcdn.ru/v1/SEL_39171/site-production-public/system/image/file/9408237/vehicle_slider_7%402x.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file6);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(15);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "jetdashru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://s.auto.drom.ru/i24278/c/photos/fullsize/jetour/dasheng/jetour_dasheng_1118354.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://www.borderlesscar.com/wp-content/uploads/2023/10/10013-2.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://www.gazeta.uz/media/img/2023/03/C6Qzwv16788786926614_b.jpg");
                    InputMedia file6 = new InputMediaPhoto("https://134706.selcdn.ru/v1/SEL_39171/site-production-public/system/image/file/7508001/vehicle_slider_7__1_%402x.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file6);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(37);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "jet90ru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://data.favorit-motors.ru/upload/iblock/e89/e8941cca456515394fe44a6ce279d53e.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://japlantpoolgh.com/wp-content/uploads/2024/04/J.A-PLANT-POOL-JETOUR-X90-PLUS-BACKVIEW.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://www.souzcentr.ru/image/catalog/jetour/x90plus/features/x90plus_feature01.jpg");
                    InputMedia file6 = new InputMediaPhoto("https://alizing.by/storage/cars/2023/09/07/a7d7fe46b1708781e17277d13020e8a7290fd5dc.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    list.add(file6);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(43);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "hon-ru" -> {
                    long chatId = update.getCallbackQuery().getMessage().getChatId();
                    List<List<InlineKeyboardButton>> list = new ArrayList<>();
                    List<InlineKeyboardButton> row = new ArrayList<>();
                    InlineKeyboardButton button1 = new InlineKeyboardButton();
                    button1.setText("HONGQI HS5");
                    button1.setCallbackData("HongqiHS5-ru");
                    row.add(button1);
                    List<List<InlineKeyboardButton>> list09 = new ArrayList<>();
                    List<InlineKeyboardButton> row007 = new ArrayList<>();
                    InlineKeyboardButton button008 = new InlineKeyboardButton();
                    button008.setText("HONGQI E-QM5");
                    button008.setCallbackData("Eqm5w-ru");
                    row007.add(button008);
                    InlineKeyboardButton button10 = new InlineKeyboardButton();
                    button10.setText("HONGQI H9");
                    button10.setCallbackData("Hongqi H9-ru");
                    row.add(button10);
                    List<InlineKeyboardButton> row3 = new ArrayList<>();
                    List<InlineKeyboardButton> row2 = new ArrayList<>();
                    InlineKeyboardButton button2 = new InlineKeyboardButton();
                    button2.setText("HONGQI H5");
                    button2.setCallbackData("HongqiH5-ru");
                    row2.add(button2);
                    List<InlineKeyboardButton> row5 = new ArrayList<>();
                    InlineKeyboardButton button4 = new InlineKeyboardButton();
                    button4.setText("HONGQI HS7");
                    button4.setCallbackData("HongqiHS7-ru");
                    row3.add(button4);
                    InlineKeyboardButton button3 = new InlineKeyboardButton();
                    button3.setText("HONGQI EHS9");
                    button3.setCallbackData("HongqiEHS9-ru");
                    row3.add(button3);
                    list.add(row007);
                    list.add(row);
                    list.add(row2);
                    list.add(row3);
                    list.add(row5);
                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                    SendMessage message = new SendMessage();
                    markup.setKeyboard(list);
                    message.setChatId(chatId);
                    message.setReplyMarkup(markup);
                    message.setText("Выберите щдин из них");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    message.setReplyMarkup(markup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Eqm5w-ru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/eqm5_5.jpeg");
                    InputMedia file3 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/51129338075_cc19ca8477_b.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://cdn.globalso.com/centuryautomobile/Hongqi-E-QM5-ZHU_6.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);

                    }

                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(21);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "HongqiHS5-ru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/hs5_banner_1.png");
                    InputMedia file3 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/hs5_banner_3.png");
                    InputMedia file5 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/Hs5%20int.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);

                    }

                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(69);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Hongqi H9-ru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/2020010916575521183.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/2020010916572050595.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/2020010916305547828.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(71);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "HongqiH5-ru" -> {
                    List<InputMedia> list = new ArrayList<>();

                    InputMedia file1 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/h5_image_cover_03_302.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/h5_image_cover_02_145.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/hongqi-h5-2e.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(61);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }
                case "HongqiEHS9-ru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://hongqi-avilon.ru/upload/iblock/71c/qlga3dv50z5m2fwdhznut7rvts92qvm7.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://hongqi-avilon.ru/upload/iblock/915/1mm9jw3degjgpc5wezwd1o6okjedaxiu.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://s0.rbk.ru/v6_top_pics/media/img/3/48/756642878091483.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(75);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }
                case "AIQAR ARRIZO Eru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://www.chinapev.com/wp-content/uploads/2020/05/2020-Arrizo-e.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://storage.kun.uz/source/9/PSQM3dWnWaMX7VFHt0pu2QKqhEeCAQWN.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://otoba.ru/auto/chery/img/arrizo-5/1/kuzov/chery-arrizo-5-1-szadi.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(29);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "HongqiHS7-ru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/8054363.jpeg");
                    InputMedia file3 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/HS7_CarTail_cover_396_186.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://hongqiuzbekistan.uz/assets/photos/1-(1).jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);
                    SendMediaGroup group = new SendMediaGroup();
                    group.setMedias(list);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    mediaGroup.setMedias(list);
                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения \uD83D\uDCDE+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(34);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                case "aiq" -> {
                    List<List<InlineKeyboardButton>> list = new ArrayList<>();
                    List<InlineKeyboardButton> row21 = new ArrayList<>();
                    InlineKeyboardButton button2 = new InlineKeyboardButton();
                    button2.setText("AIQAR ARRIZO E");
                    button2.setCallbackData("AIQAR ARRIZO E");
                    row21.add(button2);
                    List<InlineKeyboardButton> row3 = new ArrayList<>();
                    InlineKeyboardButton button11 = new InlineKeyboardButton();
                    button11.setText("AIQAR EQ7");
                    button11.setCallbackData("AIQAR  EQ7");
                    row3.add(button11);
                    List<InlineKeyboardButton> row4 = new ArrayList<>();
                    InlineKeyboardButton button12 = new InlineKeyboardButton();
                    button12.setText("AIQAR EQ3");
                    button12.setCallbackData("eqtest");
                    row4.add(button12);
                    list.add(row21);
                    list.add(row3);
                    list.add(row4);
                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                    SendMessage message = new SendMessage();
                    markup.setKeyboard(list);
                    message.setReplyMarkup(markup);
                    message.setText("Avtomobillardan birini tanlang");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    message.setReplyMarkup(markup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "AIQAR  EQ7" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://carnewschina.com/wp-content/uploads/2023/04/1-4.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://carnewschina.com/wp-content/uploads/2023/04/4-4.jpg");
                    InputMedia file7 = new InputMediaPhoto("https://images.khmer24.co/24-02-12/aiqar-eq7-981845170770194028817274-d.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file7);
                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(27);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }
                case "eqtest" -> {
                    System.out.println(1);
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://www.hcrmotorsgroup.com/wp-content/uploads/2024/02/Aiqar-eQ3-grey.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://www.hcrmotorsgroup.com/wp-content/uploads/2024/01/Aiqar-eQ3-interior-green-1.jpg");
                    InputMedia file7 = new InputMediaPhoto("https://images.khmer24.co/24-02-12/aiqar-eq3-981845170770178691982277-d.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file7);
                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(15);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }
                case "AIQAR ARRIZO E" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://www.chinapev.com/wp-content/uploads/2020/05/2020-Arrizo-e.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://storage.kun.uz/source/9/PSQM3dWnWaMX7VFHt0pu2QKqhEeCAQWN.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://otoba.ru/auto/chery/img/arrizo-5/1/kuzov/chery-arrizo-5-1-szadi.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(29);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "alqblm" -> {
                    InputFile file1 = new InputFile("https://t4.ftcdn.net/jpg/03/65/60/33/360_F_365603381_jl2eSsk2nsz7hFbGpfZSWwfXLxO1Unp4.jpg");
                    SendPhoto photo = new SendPhoto();
                    photo.setCaption("Murojat uchun ☎\uFE0F+998712051555");
                    photo.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    photo.setPhoto(file1);
                    try {
                        execute(photo);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "avts" -> {
                    InputFile file2 = new InputFile("https://cooperlakeautomotive.com/img/service-AutoService.jpg");
                    SendPhoto photo = new SendPhoto();
                    photo.setCaption("☎\uFE0F +998910990303");
                    photo.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    photo.setPhoto(file2);
                    try {
                        execute(photo);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "avsru" -> {
                    InputFile file2 = new InputFile("https://cooperlakeautomotive.com/img/service-AutoService.jpg");
                    SendPhoto photo = new SendPhoto();
                    photo.setCaption("☎\uFE0F +998910990303");
                    photo.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    photo.setPhoto(file2);
                    try {
                        execute(photo);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }


                }
                case "changan-ru" -> {
                    long chatId = update.getCallbackQuery().getMessage().getChatId();
                    List<List<InlineKeyboardButton>> list = new ArrayList<>();
                    List<InlineKeyboardButton> row2 = new ArrayList<>();
                    InlineKeyboardButton button2 = new InlineKeyboardButton();
                    button2.setText("CHANGAN HUNTER");
                    button2.setCallbackData("changanhunter-ru");
                    row2.add(button2);
                    List<InlineKeyboardButton> row13 = new ArrayList<>();
                    InlineKeyboardButton button34 = new InlineKeyboardButton();
                    button34.setText("DEEPAL G318 REEV");
                    button34.setCallbackData("depalg318-ru");
                    row13.add(button34);
                    List<InlineKeyboardButton> row23 = new ArrayList<>();
                    InlineKeyboardButton button21 = new InlineKeyboardButton();
                    button21.setText("DEEPAL SLO3");
                    button21.setCallbackData("depalslo3-ru");
                    row23.add(button21);
                    List<InlineKeyboardButton> row3 = new ArrayList<>();
                    InlineKeyboardButton button11 = new InlineKeyboardButton();
                    button11.setText("DEEPAL S7");
                    button11.setCallbackData("depals7-ru");
                    row3.add(button11);
                    list.add(row3);
                    list.add(row23);
                    list.add(row13);
                    list.add(row2);
                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                    SendMessage message = new SendMessage();
                    markup.setKeyboard(list);
                    message.setChatId(chatId);
                    message.setReplyMarkup(markup);
                    message.setText("О какой машине вы хотели бы узнать?");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    message.setReplyMarkup(markup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "changan" -> {
                    long chatId = update.getCallbackQuery().getMessage().getChatId();
                    List<List<InlineKeyboardButton>> list = new ArrayList<>();
                    List<InlineKeyboardButton> row2 = new ArrayList<>();
                    InlineKeyboardButton button2 = new InlineKeyboardButton();
                    button2.setText("CHANGAN HUNTER");
                    button2.setCallbackData("changanhunter");
                    row2.add(button2);
                    List<InlineKeyboardButton> row13 = new ArrayList<>();
                    InlineKeyboardButton button34 = new InlineKeyboardButton();
                    button34.setText("DEEPAL G318 REEV");
                    button34.setCallbackData("depalg318");
                    row13.add(button34);
                    List<InlineKeyboardButton> row23 = new ArrayList<>();
                    InlineKeyboardButton button21 = new InlineKeyboardButton();
                    button21.setText("DEEPAL SLO3");
                    button21.setCallbackData("depalslo3");
                    row23.add(button21);
                    List<InlineKeyboardButton> row3 = new ArrayList<>();
                    InlineKeyboardButton button11 = new InlineKeyboardButton();
                    button11.setText("DEEPAL S7");
                    button11.setCallbackData("depals7");
                    row3.add(button11);
                    list.add(row3);
                    list.add(row23);
                    list.add(row13);
                    list.add(row2);
                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                    SendMessage message = new SendMessage();
                    markup.setKeyboard(list);
                    message.setChatId(chatId);
                    message.setReplyMarkup(markup);
                    message.setText("Quyidagailardan birini tanlang.");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    message.setReplyMarkup(markup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "changanhunter" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://s.auto.drom.ru/i24282/c/photos/fullsize/changan/hunter_plus/changan_hunter_plus_1145255.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://carsdb.ru/auto/changan/hunter/photo/2.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://xn----7sbbeeptbfadjdvm5ab9bqj.xn--p1ai/wp-content/uploads/2023/06/changan_hunter_salon_3__1000.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(413);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "depalg318" -> {
                    List<InputMedia> mediaList = new ArrayList<>();
                    mediaList.add(new InputMediaPhoto("https://www.carscoops.com/wp-content/uploads/2024/01/Deepal-7-copyr-1024x576.jpg"));
                    mediaList.add(new InputMediaPhoto("https://china-motors.org/storage/images/products/card/comfort-61719911887.jpg"));
                    mediaList.add(new InputMediaPhoto("https://xn----7sbbeeptbfadjdvm5ab9bqj.xn--p1ai/wp-content/uploads/2024/03/changan_deepal_g318_14_1000.jpg"));
// Add more media items if needed (up to 10)

                    SendMediaGroup sendMediaGroup = new SendMediaGroup();
                    sendMediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    sendMediaGroup.setMedias(mediaList);

                    try {
                        execute(sendMediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    if (mediaList.size() < 3) {
                        System.out.println("Error: Media list must contain at least 3 items.");
                        return; // or handle it gracefully
                    }


                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(57);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "depalslo3" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://china-motors.org/storage/images/products/card/sl03-81702588391.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://fordreamauto.com/wp-content/uploads/2023/10/ForDreamAuto_Changan-Deepal-SL03-2023_002.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://www.borderlesscar.com/wp-content/uploads/2023/07/01-15.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(414);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "depals7" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://gscarbuy.com/images/virtuemart/product/changan-deepal-s7_1.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://i.ytimg.com/vi/QdbJQFBuRjQ/maxresdefault.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://www.borderlesscar.com/wp-content/uploads/2023/07/01-14.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Murojat uchun ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(412);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "changanhunter-ru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://s.auto.drom.ru/i24282/c/photos/fullsize/changan/hunter_plus/changan_hunter_plus_1145255.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://carsdb.ru/auto/changan/hunter/photo/2.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://xn----7sbbeeptbfadjdvm5ab9bqj.xn--p1ai/wp-content/uploads/2023/06/changan_hunter_salon_3__1000.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения  ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(413);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "depalg318-ru" -> {
                    List<InputMedia> mediaList = new ArrayList<>();
                    mediaList.add(new InputMediaPhoto("https://www.carscoops.com/wp-content/uploads/2024/01/Deepal-7-copyr-1024x576.jpg"));
                    mediaList.add(new InputMediaPhoto("https://china-motors.org/storage/images/products/card/comfort-61719911887.jpg"));
                    mediaList.add(new InputMediaPhoto("https://xn----7sbbeeptbfadjdvm5ab9bqj.xn--p1ai/wp-content/uploads/2024/03/changan_deepal_g318_14_1000.jpg"));
// Add more media items if needed (up to 10)

                    SendMediaGroup sendMediaGroup = new SendMediaGroup();
                    sendMediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    sendMediaGroup.setMedias(mediaList);

                    try {
                        execute(sendMediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    if (mediaList.size() < 3) {
                        System.out.println("Error: Media list must contain at least 3 items.");
                        return; // or handle it gracefully
                    }


                    SendMessage message = new SendMessage();
                    message.setText("Для применения  ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(57);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "depalslo3-ru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://china-motors.org/storage/images/products/card/sl03-81702588391.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://fordreamauto.com/wp-content/uploads/2023/10/ForDreamAuto_Changan-Deepal-SL03-2023_002.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://www.borderlesscar.com/wp-content/uploads/2023/07/01-15.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения  ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(414);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "depals7-ru" -> {
                    List<InputMedia> list = new ArrayList<>();
                    InputMedia file1 = new InputMediaPhoto("https://gscarbuy.com/images/virtuemart/product/changan-deepal-s7_1.jpg");
                    InputMedia file3 = new InputMediaPhoto("https://i.ytimg.com/vi/QdbJQFBuRjQ/maxresdefault.jpg");
                    InputMedia file5 = new InputMediaPhoto("https://www.borderlesscar.com/wp-content/uploads/2023/07/01-14.jpg");
                    list.add(file1);
                    list.add(file3);
                    list.add(file5);

                    SendMediaGroup mediaGroup = new SendMediaGroup();
                    mediaGroup.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    mediaGroup.setMedias(list);


                    try {
                        execute(mediaGroup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage message = new SendMessage();
                    message.setText("Для применения  ☎\uFE0F+998712051555");
                    message.setChatId(update.getCallbackQuery().getMessage().getChatId());

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    CopyMessage copyMessage = new CopyMessage();
                    copyMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    copyMessage.setFromChatId("5750963176");
                    copyMessage.setMessageId(412);
                    try {
                        execute(copyMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "otdsru" -> {
                    InputFile file1 = new InputFile("https://t4.ftcdn.net/jpg/03/65/60/33/360_F_365603381_jl2eSsk2nsz7hFbGpfZSWwfXLxO1Unp4.jpg");
                    SendPhoto photo = new SendPhoto();
                    photo.setCaption("Murojat uchun ☎\uFE0F+998712051555");
                    photo.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    photo.setPhoto(file1);
                    try {
                        execute(photo);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }

            }

        } else if (update.getMessage().hasDocument()) {
            SendMessage message = new SendMessage();
            message.setText(String.valueOf(update.getMessage().getMessageId()));
            message.setChatId(update.getMessage().getChatId());
            try {
                execute(message);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "@auto_center_uz_bot";
    }
}