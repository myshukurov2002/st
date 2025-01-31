package com.company.a24.safia;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Safia extends TelegramLongPollingBot {
    private List<User> users = new ArrayList<>();
    private static int count = 0;

    List<Long> list = new ArrayList<>();

    public Safia() {
        super("7959021064:AAGzGIh3r2k8FwzRuMcwLQ8cJaMCyLqLlZg");
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (text.equals("/start")) {
                User user = new User();
                user.setChatId(chatId);
                user.setState(BotState.START);

                users.add(user);


                System.out.println(update.getMessage().getChatId());
                if (update.getMessage().getText().equals("/start")) ;
                Long chatId1 = update.getMessage().getChatId();
                list.add(chatId1);

                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://yandex.ru/images/search?pos=0&from=tabbar&img_url=https%3A%2F%2Favatars.mds.yandex.net%2Fget-altay%2F6311095%2F2a00000181b5138549ff7f8314eb052979df%2FXXL_height&text=Safia&rpt=simage&lr=10335.png"));
                photo.setCaption("Safiyaga xush kelibsiz!");
                photo.setReplyMarkup(mainMenu());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("/order")) {
                User user = new User();
                user.setChatId(chatId);
                user.setState(BotState.Shop_M);

                users.add(user);
                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText("Ozingizga yoqgan shirinliklarni tanlang!");
                message.setReplyMarkup(Shop());


            } else if (text.equals("Buyurtma berish\uD83D\uDECD")) {
                User user = new User();
                user.setChatId(chatId);
                user.setState(BotState.Buyurtma_berish);

                users.add(user);
                SendMessage message = new SendMessage();
                message.setText("Buyurtmani o'zingiz oling yoki yetkazib berishni tanlang");
                message.setChatId(chatId);
                message.setReplyMarkup(Next_menu());

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Biz haqimizdaℹ\uFE0F")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Biz_haqimizda);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Hammasi buvining shirinliklaridan boshlandi\n" +
                        "\n" +
                        "“Safia” qandolatchilik uylari tarmog‘i oilaviy biznes bo‘lib, uning tarixi havaskor qandolatchi Muxayo Qosimovadan boshlanadi. 2001-yilda u qarindoshlari, do‘stlari va qo‘ni-qo‘shnilarining iltimosiga ko‘ra o‘z uyidagi pechda non pishirishni boshlagan. Turmush o‘rtog‘i Akmal Ayupov unga buyurtma berishda yordam beradi.\n" +
                        "\n" +
                        "2008 yilda ularning qizi Madina Akmalovna oilaviy tadbirkorlikni rivojlantirish maqsadida birinchi qandolatchilik do'koniga asos solgan. Hech qanday tashqi investitsiyalarsiz, shaxsiy jamg‘armasiga asoslanib, u o‘zining birinchi qandolatchilik do‘konida “Madinaning nonvoyxona uyi”da ish boshlaydi." +
                        "\n" +
                        "\n" +
                        "Biz bilan bog'lanish uchun shu raqamga tel qiling 78 113 40 40");

                message1.setChatId(chatId);
                message1.setReplyMarkup(mainMenu());
                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Balans\uD83C\uDFE6")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Balans);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Sizning balansingizda 0$");
                message1.setChatId(chatId);
                message1.setReplyMarkup(mainMenu());


                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("\uD83D\uDC48\uD83C\uDFFB Ortga")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Balans);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ortga tugmasini bosildi");
                message1.setChatId(chatId);
                message1.setReplyMarkup(mainMenu());


                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("◀\uFE0F Ortga")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Balans);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ortga tugmasini bosildi");
                message1.setChatId(chatId);
                message1.setReplyMarkup(Shop_M());


                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Telefon raqamini o‘zgartirish")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Balans);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("+998******* mashnaqa korinishta yozsangiz boladi");
                message1.setChatId(chatId);
                message1.setReplyMarkup(Next_men());


                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Sergali")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Kushbegi")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Shahriston")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Sayram")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Glinka")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Algoritm")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Uch Qahramon")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Akkurgan")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Inha")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Okeani")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Yangiyul")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Ganga")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Yangihayot")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Tinchlik")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Shohsaroy")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Kommunizm")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Jum")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Yangi Qoyluq 5")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Chimgan")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Medgorod")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Maksim Gorkiy")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Ibn Sino")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Janubiy stansiya")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Jomiy")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Nova")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Malika")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia Chirchiq")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Buyurtma_berish);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Ozingizga yoqgan shirinliklarni tasnlashingiz mumkin!");
                message1.setChatId(chatId);
                message1.setReplyMarkup((Shop()));

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Sozlamalar⚙️\uFE0F")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Sozlamalar);
                users.add(user1);
                SendMessage message1 = new SendMessage();
                message1.setText("Telefon raqamini o‘zgartirish");
                message1.setChatId(chatId);
                message1.setReplyMarkup(Next_men());

                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("\uD83C\uDF82 Mini tortlar")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Shop_M);
                users.add(user1);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1671024267.png"));
                photo.setCaption("Kiev keki bezatilgan uch qatlamli rangli Merengue va ikki qatlamli rangli pechene, rezavorlar va mevalar bilan to'ldirilgan muzqaymoq kremi bilan birlashtirilgan.\n" +
                        "Kek qaymoq, shokolad bezaklari, Marshmallow, mavsumiy rezavorlar va makaron bilan bezatilgan.\n" +
                        "Kek 12-14 kishiga mo'ljallangan.\n" +
                        "Og'irligi: 4.80.\n" +
                        "Narxi 350.000 ming so'm");
                photo.setReplyMarkup(Raqam_M());

                SendMessage message = new SendMessage();
                message.setText("Miqdorini tanlang");
                message.setChatId(chatId);
                message.setReplyMarkup(Raqam_M());
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }


                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("1")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Shop_M);
                users.add(user1);
                SendMessage message = new SendMessage();
                message.setText("Davom etamizmi? \uD83D\uDE09");
                message.setChatId(chatId);
                message.setReplyMarkup(Raqam_M());

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("\uD83E\uDD6E Katta piroglar")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Shop_M);
                users.add(user1);
                SendMessage message = new SendMessage();
                message.setText("Kategoryani tanlang");
                message.setChatId(chatId);
                message.setReplyMarkup(Katta_Pirog());

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("2")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Shop_M);
                users.add(user1);
                SendMessage message = new SendMessage();
                message.setText("Davom etamizmi? \uD83D\uDE09");
                message.setChatId(chatId);
                message.setReplyMarkup(Raqam_M());

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("\uD83D\uDCE5 Savat")) {
                User user1 = new User();
                user1.setChatId(chatId);
                user1.setState(BotState.Shop_M);
                users.add(user1);
                SendMessage message = new SendMessage();
                message.setText("Sizning savatingiz bo'sh, buyurtma berish uchun mahsulotni tanlang");
                message.setChatId(chatId);
                message.setReplyMarkup(Raqam_M());

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }


            } else if (text.equals("Fikir qoldirish\uD83D\uDCDD")) {
                User user2 = new User();
                user2.setChatId(chatId);
                user2.setState(BotState.FIKIR_QOLDIRISH);
                users.add(user2);
                SendMessage message2 = new SendMessage();
                message2.setText("O'zingizni fikiringizni qoldirin");
                message2.setChatId(chatId);
                message2.setReplyMarkup(Next_men());


                try {
                    execute(message2);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Olib ketish\uD83C\uDFC3")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.YETKAZIB_BERISH);
                users.add(user3);
                SendMessage message3 = new SendMessage();
                message3.setText("O'zingizga yaqin bolgan filialni tanlang");
                message3.setChatId(chatId);
                message3.setReplyMarkup(Shop_M());

                try {
                    execute(message3);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("\uD83C\uDF70 Katta tortlar")) {
                User user = new User();
                user.setChatId(chatId);
                user.setState(BotState.Shop);
                users.add(user);
                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText("Shulardan yoqqanini tanlang");
                message.setReplyMarkup(Katta_Tort());

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("\uD83E\uDDC1 Tartaletkalar")) {
                User user = new User();
                user.setChatId(chatId);
                user.setState(BotState.Shop);
                users.add(user);
                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText("Taomni tanlang");
                message.setReplyMarkup(Tartaletka());

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Afg'oncha tort")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1693203863.png"));
                photo.setCaption("Uvoq korjlar, merenga, quyultirilgan sut qoʻshilgan yogʻli krem\n" +
                        "Вес: 3.86\n" +
                        "\n" +
                        "276 000 so'm");
                photo.setReplyMarkup(Katta_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Olchali va olmali pirog")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1672058331.png"));
                photo.setCaption("Barra olcha va olma solingan uvoq xamirli pirog.\n" +
                        "\n" +
                        "Pirog 16-18 kishiga mo'ljallangan.\n" +
                        "Вес: 3.13\n" +
                        "\n" +
                        "220 000 so'm");
                photo.setReplyMarkup(Katta_Pirog());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Italiano torti")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1671012000.png"));
                photo.setCaption("Yongʻoqli biskvit, qaymoqli krem, quyultirilgan sut va iriskali masalliq.\n" +
                        "\n" +
                        "Tort 16 kishiga mo'ljallangan.\n" +
                        "Вес: 2.92\n" +
                        "\n" +
                        "268 000 so'm");
                photo.setReplyMarkup(Katta_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Markiza torti")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1693204074.png"));
                photo.setCaption("Pishirilgan quyultirilgan sut qo'shilgan qum keklari, Meringue, sariyog' kremi. Yong'oq bilan karamellangan.\n" +
                        "\n" +
                        "16 kishiga mo'ljallangan.\n" +
                        "Og'irligi: 3.82\n" +
                        "\n" +
                        "286 000 so'm");
                photo.setReplyMarkup(Katta_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Tvorogli mozaika pirogi")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1672059667.png"));
                photo.setCaption("Uvoq xamirli tvorog solingan pirog.\n" +
                        "\n" +
                        "Pirog 16-18 kishiga mo'ljallangan.\n" +
                        "Вес: 3.15\n" +
                        "\n" +
                        "206 000 so'm");
                photo.setReplyMarkup(Katta_Pirog());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Fruktoviy to'rtburchak torti")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1693205114.png"));
                photo.setCaption("Apelsinli va malinali konfi bilan toʻyintirilgan qaymoqli kremli sariyogʻli biskvitning yupqa qavatlari.\n" +
                        "\n" +
                        "Tort 24 kishiga mo'ljallangan.\n" +
                        "Вес: 3.69\n" +
                        "\n" +
                        "318 000 so'm");
                photo.setReplyMarkup(Katta_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Yakobs torti")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1693205782.png"));
                photo.setCaption("Qahva-qaymoqli krem va shokolad masalliqli yupqa qahva biskvitlari.\n" +
                        "\n" +
                        "Tort 24 kishiga mo'ljallangan.\n" +
                        "Вес: 3.00\n" +
                        "\n" +
                        "318 000 so'm");
                photo.setReplyMarkup(Katta_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Dari torti")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1693203748.png"));
                photo.setCaption("Yupqa qatlamli oq biskvit tvorog-qaymoqli krem va barra malina bilan.\n" +
                        "\n" +
                        "Tort 24 kishiga mo'ljallangan.\n" +
                        "Вес: 3.79\n" +
                        "\n" +
                        "302 000 so'm");
                photo.setReplyMarkup(Katta_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Malinka torti")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1671272620.png"));
                photo.setCaption("“Salma” yogʻli biskviti malinali-qaymoqli va bananli-qaymoqli krem bilan.\n" +
                        "\n" +
                        "Tort 24 kishiga mo'ljallangan.\n" +
                        "Вес: 3.70\n" +
                        "\n" +
                        "310 000 so'm");
                photo.setReplyMarkup(Katta_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Asalli-yongʻoqli tort")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1690794040.png"));
                photo.setCaption("Yongʻoqli-asalli yupqa korjlar qaymoqli krem bilan.\n" +
                        "Tort 16-20 kishilik\n" +
                        "Вес: 2.38\n" +
                        "\n" +
                        "318 000 so'm");
                photo.setReplyMarkup(Katta_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Snikers torti")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1690796679.png"));
                photo.setCaption("Shokoladli pechene, karamelli yerfıstığı yog'i, shokoladli plomba va sariyog ' va yerfıstığı qatlami.\n" +
                        "\n" +
                        "Kek 6-8 kishiga mo'ljallangan.\n" +
                        "Og'irligi: 3.71\n" +
                        "\n" +
                        "242 000 so ' m");
                photo.setReplyMarkup(Katta_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Shokoladli-asalli tort")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1671012702.png"));
                photo.setCaption("Qaymoq-smetana kremli oltita yupqa asalli-shokoladli korj.\n" +
                        "\n" +
                        "Tort 16-20 kishiga mo'ljallangan.\n" +
                        "318 000 so'm");
                photo.setReplyMarkup(Katta_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Qora shahzoda toʻrtburchak tort")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1693203648.png"));
                photo.setCaption("Qaymoq-smetana kremli oltita yupqa asalli-shokoladli korj.\n" +
                        "\n" +
                        "Tort 16-20 kishiga mo'ljallangan.\n" +
                        "318 000 so'm");
                photo.setReplyMarkup(Katta_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("\uD83C\uDF82 Dumaloq tortlar")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendMessage message = new SendMessage();
                message.setText("Shulardan yoqqanini tanlang");
                message.setChatId(chatId);
                message.setReplyMarkup(Dumaloq_Tort());

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Rafaello torti")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1671253035.png"));
                photo.setCaption("Oq biskvit, qarsildoq biskvit, ichida bodomli vafli, kokosli krem.\n" +
                        "\n" +
                        "Tort 12 - 14 kishiga mo'ljallangan.\n" +
                        "Вес: 2.99\n" +
                        "\n" +
                        "354 000 so'm");
                photo.setReplyMarkup(Dumaloq_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Safia tort (Pushti) dumaloq")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1698218735.png"));
                photo.setCaption("Olchali krem, bananli krem, shokoladli krem bilan ishlangan klassik shifon biskvitli tort. Yangi mevalar bilan va pushti yoki oq yaltiroq glazurli krem bilan qoplangan.\n" +
                        "\n" +
                        "Tort 12 - 14 kishiga mo'ljallangan.\n" +
                        "Вес: 1.00\n" +
                        "\n" +
                        "385 000 so'm");
                photo.setReplyMarkup(Dumaloq_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Shokolad va  malinali dumaloq tort")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1672120581.png"));
                photo.setCaption("Uvoq korj, quyultirilgan sutli yogʻli krem, malinali masalliq.\n" +
                        "\n" +
                        "Tort 12 - 14 kishiga mo'ljallangan.\n" +
                        "Вес: 1.65\n" +
                        "\n" +
                        "260 000 so'm");
                photo.setReplyMarkup(Dumaloq_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Raduga dumaloq torti")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1671025231.png"));
                photo.setCaption("Olcha, apelsin, olma, malina va banan kremli rangli yupqa biskvitlardan iborat.\n" +
                        "\n" +
                        "Tort 12 - 14 kishiga mo'ljallangan.\n" +
                        "Вес: 2.89\n" +
                        "\n" +
                        "287 000 so'm");
                photo.setReplyMarkup(Dumaloq_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Rezavor mevali va tvorogli tort")) {
                User user = new User();
                user.setChatId(chatId);
                user.setState(BotState.Shop);
                users.add(user);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1687254360."));
                photo.setCaption("Oq biskvit, merenga, rezavorli jem, tvorogli yogurtli krem.\n" +
                        "221 000 so'm");

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Malina uvoq tort")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1707205032.png"));
                photo.setCaption("Uvoq korj, koʻpirtirilgan qaymoq, barra malina, malina jelesi.\"\n" +
                        "Вес: 1.49\n" +
                        "\n" +
                        "165 000 so'm");
                photo.setReplyMarkup(Dumaloq_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Pancho torti")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1671271062.png"));
                photo.setCaption("Kub shaklida kesilgan oq va qora biskvit, yongʻoqli masalliq, ananas donalari, smetanali krem\n" +
                        "\n" +
                        "Tort 8-10 kishiga mo'ljallangan.\n" +
                        "Вес: 3.09\n" +
                        "\n" +
                        "216 000 so'm");
                photo.setReplyMarkup(Dumaloq_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Julyetta torti")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1671024360.png"));
                photo.setCaption("Malina sharbati bilan toʻyintirilgan, korji malina (qulupnay) konfi bilan qorilgan, qaymoqli-qaynatma krem va barra rezavor mevalar qoʻshilgan oq biskvit \"\n" +
                        "\n" +
                        "\n" +
                        "Tort 10-12 kishi uchun mo'ljallangan\n" +
                        "229 000 so'm");
                photo.setReplyMarkup(Dumaloq_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Verona standart torti")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1672059719.png"));
                photo.setCaption("Olchali, apelsinli, bananli, olmali va malinali krem bilan yupqa oppoq biskvitlar.\n" +
                        "\n" +
                        "Tort 6 - 8 kishi uchun mo'ljallangan.\n" +
                        "Вес: 1.44\n" +
                        "\n" +
                        "190 000 so'm");
                photo.setReplyMarkup(Dumaloq_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Admiral dumaloq torti")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1671024084.png"));
                photo.setCaption("Makli, yongʻoqli, shokoladli biskvit. Qaymoqli va shokolad-qahvali krem. Sutli propitka. Olchali konfi.\n" +
                        "\n" +
                        "Tort 12-14 kishiga mo'ljallangan.\n" +
                        "Вес: 3.19\n" +
                        "\n" +
                        "241 000 so'm");
                photo.setReplyMarkup(Dumaloq_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Olchali pirog")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1672058356.png"));
                photo.setCaption("Barra olcha solingan uvoq xamirli pirog.\n" +
                        "\n" +
                        "Pirog 16-18 kishiga mo'ljallangan.\n" +
                        "Вес: 2.75\n" +
                        "\n" +
                        "248 000 so'm");
                photo.setReplyMarkup(Katta_Pirog());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Saksoniya torti")) {
                User user3 = new User();
                user3.setChatId(chatId);
                user3.setState(BotState.Shop);
                users.add(user3);
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                photo.setPhoto(new InputFile("https://safiabakery.uz/uploads/products/171_1669471301.png"));
                photo.setCaption("Shokoladli-qaymoqli krem va olmali jemli yengil yogʻli biskvit.\"\n" +
                        "\n" +
                        "Tort 24 kishiga mo'ljallangan.\n" +
                        "Вес: 4.06\n" +
                        "\n" +
                        "274 000 so'm\n");
                photo.setReplyMarkup(Katta_Tort());

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("Eng yaqin filialni aniqlash")) {
                User user = new User();
                user.setChatId(chatId);
                user.setState(BotState.Shop);
                users.add(user);
                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText("\uD83D\uDE98Etkazib berish narxi 10 000 so'mdan 3 km gacha, har bir keyingi 1 km shahar ichida 1500 so'mdan.\n" +
                        "Yetkazib berish muddati: 1 soat ichida.\n" +
                        "\uD83D\uDCCDShahar tashqarisiga yetkazib berish amalga oshirilmaydi.\n" +
                        "\n" +
                        "Dam olish kunlari masofadan qat'iy nazar yetkazib berish 15 000 so'm❤\uFE0F\n" +
                        "\n" +
                        "Tanlovingiz uchun rahmat\uD83E\uDD17");
                message.setReplyMarkup(Shipping_Delivery());

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else {
                SendMessage message3 = new SendMessage();
                message3.setText("Fikiringiz uchun raxmat");
                message3.setChatId(chatId);
                message3.setReplyMarkup(mainMenu());

                try {
                    execute(message3);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    @Override
    public String getBotUsername() {
        return "mysafiabot";
    }


    private ReplyKeyboardMarkup Next_menu() {

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        List<KeyboardRow> rowList1 = new ArrayList<>();


        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Yetkazib berish\uD83D\uDE95");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Olib ketish\uD83C\uDFC3");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("\uD83D\uDC48\uD83C\uDFFB Ortga");


        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);


        rowList1.add(row1);
        rowList1.add(row2);

        markup.setKeyboard(rowList1);
        return markup;
    }

    private ReplyKeyboardMarkup Raqam_M() {

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        List<KeyboardRow> rowList1 = new ArrayList<>();


        KeyboardButton button1 = new KeyboardButton();
        button1.setText("1");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("2");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("⬅\uFE0F Ortga");

        KeyboardRow row = new KeyboardRow();
        row.add(button1);
        row.add(button2);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button3);
        row1.add(button4);

        rowList1.add(row);
        rowList1.add(row1);

        markup.setKeyboard(rowList1);
        return markup;
    }

    private ReplyKeyboardMarkup Katta_Pirog() {

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        List<KeyboardRow> rowList1 = new ArrayList<>();


        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Ortga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Olchali va olmali pirog");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Olchali pirog");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Tvorogli mozaika pirogi");

        KeyboardRow row = new KeyboardRow();
        row.add(button1);
        row.add(button2);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button3);
        row1.add(button4);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button5);

        rowList1.add(row);
        rowList1.add(row1);
        rowList1.add(row2);

        markup.setKeyboard(rowList1);
        return markup;
    }

    private ReplyKeyboardMarkup Tartaletka() {

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        List<KeyboardRow> rowList1 = new ArrayList<>();


        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Ortga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardRow row = new KeyboardRow();
        row.add(button1);
        row.add(button2);

        rowList1.add(row);

        markup.setKeyboard(rowList1);
        return markup;
    }

    private ReplyKeyboardMarkup Katta_Tort() {

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        List<KeyboardRow> rowList1 = new ArrayList<>();


        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Ortga");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Afg'oncha tort");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Italiano torti");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Markiza torti");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Saksoniya torti");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("Fruktoviy to'rtburchak torti");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("Yakobs torti");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("Dari torti");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("Malinka torti");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("Asalli-yongʻoqli tort");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("Snikers torti");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("Shokoladli-asalli tort");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("Qora shahzoda toʻrtburchak tort");

        KeyboardRow row = new KeyboardRow();
        row.add(button1);
        row.add(button2);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button3);
        row1.add(button4);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button5);
        row2.add(button6);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button7);
        row3.add(button8);
        KeyboardRow row4 = new KeyboardRow();
        row4.add(button9);
        row4.add(button10);
        KeyboardRow row5 = new KeyboardRow();
        row5.add(button11);
        row5.add(button12);
        KeyboardRow row6 = new KeyboardRow();
        row6.add(button13);
        row6.add(button14);

        rowList1.add(row);
        rowList1.add(row1);
        rowList1.add(row2);
        rowList1.add(row3);
        rowList1.add(row4);
        rowList1.add(row5);
        rowList1.add(row6);

        markup.setKeyboard(rowList1);
        markup.setResizeKeyboard(true);
        return markup;
    }


    private ReplyKeyboardMarkup Next_men() {

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        List<KeyboardRow> rowList1 = new ArrayList<>();


        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Telefon raqamini o‘zgartirish");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDC48\uD83C\uDFFB Ortga");


        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button2);


        rowList1.add(row1);
        rowList1.add(row2);

        markup.setKeyboard(rowList1);
        return markup;
    }

    private ReplyKeyboardMarkup mainMenu() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        List<KeyboardRow> rowList = new ArrayList<>();


        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Buyurtma berish\uD83D\uDECD");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Fikir qoldirish\uD83D\uDCDD");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Balans\uD83C\uDFE6");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Biz haqimizdaℹ\uFE0F");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Sozlamalar⚙️\uFE0F");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button2);
        row2.add(button3);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button4);
        row3.add(button5);


        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);


        markup.setKeyboard(rowList);
        return markup;
    }

    private ReplyKeyboardMarkup Shipping_Delivery() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardButton button = new KeyboardButton();
        button.setText("Eng yaqin filialni aniqlash");

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("\uD83D\uDDFA Mening manzillarim");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("⬅\uFE0F Ortga");

        KeyboardRow row = new KeyboardRow();
        row.add(button);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button2);

        rowList.add(row);
        rowList.add(row1);
        rowList.add(row2);

        markup.setKeyboard(rowList);
        return markup;
    }

    private ReplyKeyboardMarkup Dumaloq_Tort() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardButton button = new KeyboardButton();
        button.setText("⬅\uFE0F Ortga");

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Admiral dumaloq torti");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Verona standart torti");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Julyetta torti");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Pancho torti");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Malina uvoq tort");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("Raduga dumaloq torti");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("Rafaello torti");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("Safia tort (Pushti) dumaloq");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("Shokolad va  malinali dumaloq tort");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("Rezavor mevali va tvorogli tort");

        KeyboardRow row = new KeyboardRow();
        row.add(button);
        row.add(button1);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button2);
        row1.add(button3);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button4);
        row2.add(button5);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button6);
        row3.add(button7);
        KeyboardRow row4 = new KeyboardRow();
        row4.add(button8);
        row4.add(button9);
        KeyboardRow row5 = new KeyboardRow();
        row5.add(button10);
        row5.add(button11);


        rowList.add(row);
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        rowList.add(row5);


        markup.setKeyboard(rowList);
        return markup;
    }

    private ReplyKeyboardMarkup Shop_M() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardButton button = new KeyboardButton();
        button.setText("Safia Shahriston");

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Safia Kushbegi");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Safia Sergali");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Safia Sayram");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Safia Glinka");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("Safia Algoritm");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("Safia Uch Qahramon");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("Safia Akkurgan");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("Safia Inha");

        KeyboardButton button9 = new KeyboardButton();
        button9.setText("Safia Okeani");

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("Safia Yangiyul");

        KeyboardButton button11 = new KeyboardButton();
        button11.setText("Safia Ganga");

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("Safia Yangihayot");

        KeyboardButton button13 = new KeyboardButton();
        button13.setText("Safia Tinchlik");

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("Safia Shohsaroy");

        KeyboardButton button15 = new KeyboardButton();
        button15.setText("Safia Kommunizm");

        KeyboardButton button16 = new KeyboardButton();
        button16.setText("Safia Jum");

        KeyboardButton button17 = new KeyboardButton();
        button17.setText("Safia Yangi Qoyluq 5");

        KeyboardButton button18 = new KeyboardButton();
        button18.setText("Safia Chimgan");

        KeyboardButton button19 = new KeyboardButton();
        button19.setText("Safia Medgorod");

        KeyboardButton button20 = new KeyboardButton();
        button20.setText("Safia Maksim Gorkiy");

        KeyboardButton button21 = new KeyboardButton();
        button21.setText("Safia Ibn Sino");

        KeyboardButton button22 = new KeyboardButton();
        button22.setText("Safia Janubiy stansiya");

        KeyboardButton button23 = new KeyboardButton();
        button23.setText("Safia Jomiy");

        KeyboardButton button24 = new KeyboardButton();
        button24.setText("Safia Nova");

        KeyboardButton button25 = new KeyboardButton();
        button25.setText("Safia Malika");

        KeyboardButton button26 = new KeyboardButton();
        button26.setText("Safia Chirchiq");

        KeyboardButton button27 = new KeyboardButton();
        button27.setText("\uD83D\uDC48\uD83C\uDFFB Ortga");

        KeyboardRow row = new KeyboardRow();
        row.add(button);
        row.add(button1);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button2);
        row1.add(button3);

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

        KeyboardRow row12 = new KeyboardRow();
        row12.add(button23);
        row12.add(button24);

        KeyboardRow row13 = new KeyboardRow();
        row13.add(button25);
        row13.add(button26);

        KeyboardRow row14 = new KeyboardRow();
        row14.add(button27);

        rowList.add(row);
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        rowList.add(row5);
        rowList.add(row6);
        rowList.add(row7);
        rowList.add(row8);
        rowList.add(row9);
        rowList.add(row10);
        rowList.add(row11);
        rowList.add(row12);
        rowList.add(row13);
        rowList.add(row14);

        markup.setKeyboard(rowList);
        return markup;
    }

    private ReplyKeyboardMarkup Shop() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardButton button = new KeyboardButton();
        button.setText("\uD83D\uDCE5 Savat");

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("\uD83C\uDF82 Dumaloq tortlar");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83C\uDF82 Mini tortlar");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF70 Katta tortlar");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83D\uDE96 Buyurtma berish");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83E\uDD6E Katta piroglar");

        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83E\uDDC1 Tartaletkalar");

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("◀\uFE0F Ortga");

        KeyboardRow row = new KeyboardRow();
        row.add(button);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button4);
        row2.add(button5);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button6);
        row3.add(button7);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(button8);

        rowList.add(row);
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);

        markup.setKeyboard(rowList);
        return markup;

    }
}

