package com.company.a24;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Garant extends TelegramLongPollingBot {
    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
//



        Message message = update.getMessage();
//        PhotoSize photoSize = message.getPhoto().get(1);
//        String fileId = photoSize.getFileId();

        String text = message.getText();
        Long chatId = message.getChatId();


//        SendMessage s = new SendMessage();
//        s.setText(fileId);
//        s.setChatId(chatId);
//
//        execute(s);
//        if (true) {
//            return;
//        }





//        if (text.equals("/start")){
//            try {
//                setphoto(chatId, text);
//            } catch (TelegramApiException e) {
//                throw new RuntimeException(e);
//            }
//        }





        if (update.hasMessage()) {
            switch (text) {
                case "/start" -> {
                    SendPhoto photo = new SendPhoto();
                    photo.setChatId(String.valueOf(chatId));
                    photo.setPhoto(new InputFile("https://files.oaiusercontent.com/file-XMKK5jWVV1SPUBXthoj43n?se=2025-01-27T13%3A30%3A25Z&sp=r&sv=2024-08-04&sr=b&rscc=max-age%3D299%2C%20immutable%2C%20private&rscd=attachment%3B%20filename%3D0001.png&sig=oY7hThBMA5Gufjbo35Sw%2BVkjmcN/laG2iSVTIIMOwuc%3D"));
                    photo.setCaption("Assalomu alaykum! Garant shop yetkazib berish xizmatiga xush kelibsiz.");

                    try {
                        execute(photo);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    SendMessage sendMessage2 = new SendMessage();
                    sendMessage2.setChatId(update.getMessage().getChatId());
                    sendMessage2.setText("Qaysi tumanda yashaysiz?\n" +
                            "Iltimos, shaharni kiriting:");
                    sendMessage2.setReplyMarkup(cityButton());
                    try {
                        execute(sendMessage2);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                }
                case "Qibray", "Sergili", "Chirchiq", "MiroUlugbek", "\uD83D\uDD19 Ortga" -> {
                    SendMessage sendMessage3 = new SendMessage();
                    sendMessage3.setChatId(update.getMessage().getChatId());
                    sendMessage3.setText("Bosh royhat");
                    sendMessage3.setReplyMarkup(menuButton());
                    try {
                        execute(sendMessage3);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "\uD83D\uDC55 Buyurtma berish" -> {
                    SendMessage sendMessage1 = new SendMessage();
                    sendMessage1.setChatId(update.getMessage().getChatId());
                    sendMessage1.setText("Buyurtmani o'zingiz \uD83D\uDE4B\u200D♂\uFE0F olib keting yoki Yetkazib berishni \uD83D\uDE99 tanlang");
                    sendMessage1.setReplyMarkup(order());
                    try {
                        execute(sendMessage1);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "📕 Buyurtmalar tarixi" -> {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(update.getMessage().getChatId());
                    sendMessage.setText("Sizning buyurtmangiz:\n" +
                            "Buyurtma raqami: 595633\n" +
                            "Buyurtma sanasi: 07 dekabr 2024 13:09\n" +
                            "Buyurtma holati: Yuborildi\n" +
                            "Telefon raqamingiz: +99833 908 2004\n" +
                            "Manzil: Узбекистан, Ташкент, Сергелийский район, массив Сергели-V, 106\n" +
                            "Buyurtma turi: \uD83D\uDE99 Yetkazib berish\n" +
                            "Buyurtma vaqti: ✅ Iloji boricha tezroq\n" +
                            "To'lov turi: \uD83D\uDCB5 Naqt pul\n" +
                            "\n" +
                            "\n" +
                            "1. Finka\n" +
                            "1 x 99 000 = 99 000 so'm\n" +
                            "\n" +
                            "Qibray, Chirchiq, Sergili, MirzoUlugbek, tumanlriga YETKAZISH BEPUL. Shaharlar tashqarisida yetkazish tarifi 1 kmga 3 000 so‘m. O‘rtacha yetkazish vaqti 3 kun ichida. Saytimiz orqali buyurtma qilish yanada qulayroq garant shop.uz\n" +
                            "\n" +
                            "Umumiy: 99 000 so'm");
                    sendMessage.setReplyMarkup(back());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "☎ Garant shop bilan aloqa" -> {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(update.getMessage().getChatId());
                    sendMessage.setText("Biz bilan bog'lanish uchun contact:");
                    sendMessage.setReplyMarkup(back());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendContact sendContact = new SendContact();
                    sendContact.setChatId(update.getMessage().getChatId());
                    sendContact.setPhoneNumber("+998 (33) 908 - 20 - 04 ");
                    sendContact.setFirstName("Inagamov");
                    sendContact.setLastName("Baxrom");
                    try {
                        execute(sendContact);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "ℹ Sozlash" -> {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(update.getMessage().getChatId());
                    sendMessage.setText("Harakatni tanlang:");
                    sendMessage.setReplyMarkup(settings());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "🙋‍♂️ Jamoamizga qo'shilish" -> {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(update.getMessage().getChatId());
                    sendMessage.setText("Ahil jamoamizda ishlashga taklif qilamiz! Telegramdan chiqmay, shu yerning o'zida anketani to'ldirish uchun quyidagi tugmani bosing.");
                    sendMessage.setReplyMarkup(link());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Olib ketish" -> {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(update.getMessage().getChatId());
                    sendMessage.setText("Qayerdasiz \uD83D\uDC40? Agar lokatsiyangizni\uD83D\uDCCD yuborsangiz, sizga eng yaqin filialni aniqlaymiz");
                    sendMessage.setReplyMarkup(takeAway());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "🚗 Yetkazib berish" -> {

                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(update.getMessage().getChatId());
                    sendMessage.setText("Buyurtmangizni qayerga yetkazib berish kerak \uD83D\uDE99? Agar lokatsiyangizni\uD83D\uDCCD yuborsangiz, sizga eng yaqin filialni aniqlaymiz.");
                    sendMessage.setReplyMarkup(delivery());

                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    SendPhoto sendPhoto1 = new SendPhoto();
                    sendPhoto1.setChatId(chatId);
                    sendPhoto1.setPhoto(new InputFile("https://images.uzum.uz/ctvqa25ht56ksubcft0g/original.jpg"));
                    sendPhoto1.setCaption("1.000.000");
                    sendPhoto1.setAllowSendingWithoutReply(true);
                    sendPhoto1.setDisableNotification(false);
                    sendPhoto1.setProtectContent(false);
                    sendPhoto1.setReplyToMessageId(update.getMessage().getMessageId());
                    sendPhoto1.setParseMode("HTML");

                    try {
                        execute(sendPhoto1);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "🌆 Shaharni o'zgartirish" -> {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(update.getMessage().getChatId());
                    sendMessage.setText("Iltimos yangi shaharni tanlang!");
                    sendMessage.setReplyMarkup(cityButton());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "📃 Ommaviy ofera" -> {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(update.getMessage().getChatId());
                    sendMessage.setText("https://telegra.ph/Publichnaya-oferta-Garant_shop_05-21");
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "📍 Eng yaqin filialni aniqlash" -> {
                    SendLocation sendLocatoion = new SendLocation();
                    sendLocatoion.setChatId(chatId);
                    sendLocatoion.setLatitude(41.319798954460786);
                    sendLocatoion.setLongitude(41.32255860543957);

                    try {
                        execute(sendLocatoion);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "🌐 Bu yerda buyurtma qilish" -> {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(update.getMessage().getChatId());
                    sendMessage.setText("O'z joylashuvingiz bilan buyurtma bering - https://garant shop.uz/");
                    sendMessage.setReplyMarkup(site());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Filialni tanlang" -> {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(update.getMessage().getChatId());
                    sendMessage.setText("Qaysi filialdan olib ketishni tanlang");
                    sendMessage.setReplyMarkup(branches());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "🗺 Mening manzillarim" -> {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(update.getMessage().getChatId());
                    sendMessage.setText("Sizning manzillaringiz:");
                    sendMessage.setReplyMarkup(address());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Klassik kiyim" -> {
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIC5WeZ50Cticv0fkUCzWzOSoc-gqeCAAIf7DEb3qrRSL6yOmQq25KXAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Klassika \n Kostyum shim \n Narxi: 1.000.000 so'm \n " +
                            "✅ Elegant va rasmiy – Klassik rang va naqsh unga jiddiylik va nafislik baxsh etadi.\n" +
                            "✅ Uyg‘un kombinatsiya – Uch qismli (kostyum, shim, jilet) bo‘lishi uni yanada boyroq ko‘rsatadi.\n" +
                            "✅ Ko‘p vaziyatga mos – Ish uchrashuvlari, to‘y yoki maxsus tadbirlar uchun juda mos keladi.\n" +
                            "✅ Minimalistik stil – Oddiy oq ko‘ylak bilan yaxshi uyg‘unlashgan, ortiqcha detallarsiz sof did bilan \n" +
                            "Menedjer - @Foziljon_R_N \n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);


                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIC8WeZ6HEasSfPxZOTg-P0y2lDTjfcAAIt7DEb3qrRSB8ndCzBkg9VAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Klassika \n Kostyum shim \n Narxi: 120.000.000 so'm \n" +
                            " Minimalistik dizayn – Klassik qora rang va oddiy kesim unga universal ko‘rinish beradi.\n" +
                            "✅ Yengil va zamonaviy – Yenglarning qaytarilganligi uni noan'anaviy va yoshlar uslubiga moslashtirgan.\n" +
                            "✅ Ko‘p joyga mos – Rasmiy tadbirlar, biznes uchrashuvlari yoki kundalik smart-casual kiyinish uchun juda yaxshi tanlov.\n" +
                            "✅ Ajoyib kombinatsiya – Oq ko‘ylak va qora shim bilan uyg‘unlashgani uni yanada chiroyli ko‘rsatadi. \n" +
                            "Menedjer - @Foziljon_R_N \n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDAWeZ6qcir8C8o37v0Kc8XvzMxVu-AAIz7DEb3qrRSOtD1hnih04hAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Klassika \n Kostyum shim \n Narxi: 900.000 so'm \n " +
                            "✅ Elegant va rasmiy – Klassik rang va naqsh unga jiddiylik va nafislik baxsh etadi.\\n\" +\n" +
                            "✅ Uyg‘un kombinatsiya – Uch qismli (kostyum, shim, jilet) bo‘lishi uni yanada boyroq ko‘rsatadi.\\n\" +\n" +
                            "✅ Ko‘p vaziyatga mos – Ish uchrashuvlari, to‘y yoki maxsus tadbirlar uchun juda mos keladi.\\n\" +\n" +
                            "Menedjer - @Foziljon_R_N \n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDA2eZ6rtSivTTUVCfX5VZUtbh72_3AAI07DEb3qrRSDOs3BTy2kp9AQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Klassika \n Kostyum shim \n Narxi: 150.000.000 so'm \n" +
                            "✅ Ko‘p narsaga moslashuvchanlik – Oq ko‘ylak, qora yoki rangli galstuk, bo‘yinbog‘ va turli aksessuarlar bilan uyg‘unlashadi.\n" +
                            "✅ Har doim urfda – Modaning o‘zgarishidan qat’i nazar, qora kostyum har doim dolzarb bo‘lib qoladi.\n" +
                            "✅ Elegant va badavlat ko‘rinish – To‘g‘ri tikilgan qora kostyum insonning imijini o‘zgartirib, unga jiddiy va o‘ziga ishongan ko‘rinish beradi \n" +
                            "Menedjer - @Foziljon_R_N \n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDCWeZ6t1ccgTuAAGiI9LWj0hGt2RZbgACNuwxG96q0UhbxhnoVxQNsQEAAwIAA20AAzYE"));
                    sendPhoto.setCaption("Klassika \n Kostyum shim \n Narxi: 500.000 so'm \n" +
                            "✅ Kontrast va chiroyli uyg‘unlik – Qora va oq ranglar o‘rtasidagi kontrast, kiyimga yanada jozibadorlik qo‘shadi. Oq jenvor qora kostyumga yorqinlik, toza va yangi ko‘rinish beradi.\n" +
                            "✅ Rasmiy va nozik – Oq jenvor ko‘pincha rasmiy va nafis ko‘rinish uchun tanlanadi. Bu kombinatsiya ishbilarmonlik uchrashuvlari, to‘ylar yoki shunga o‘xshash tadbirlar uchun juda mos.\n" +
                            "✅ Yuqori sifatli ko‘rinish – Oq jenvor toza va sof ko‘rinishi bilan odatda yuqori sifatni anglatadi, bu esa sizning shaxsiy imijingizni yanada yuksaltiradi. \n" +
                            "Menedjer - @Foziljon_R_N \n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);


                }
                case "Sport kiymi" -> {
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIC72eZ6GmycEOATYrvITPGOu5k1iIMAAIs7DEb3qrRSBUiID2G02QqAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Sport \n Kapyushon va shlavar \n Narxi: 1.000.000 so'm \n" +
                            "✅ Qishki va kuzgi qulaylik s naches bilan: Ushbu hudilar ichki tomoni yumshoq nachesli yuqori sifatli materialdan tayyorlangan bo‘lib, qo‘shimcha issiqlik qatlami yaratadi va ularni nihoyatda yoqimli qiladi.\n" +
                            "✅ Universal uslub va dizayn: Bizning hudilarimiz erkaklar va ayollar uchun mos keladi. \n" +
                            "✅ Ideal o‘rnatilish: Hudilar erkin kesimga ega bo‘lib, harakatlaringizni cheklamaydi, ammo figuraning chiroyini saqlaydi va faol hayot tarzi uchun juda mos keladi. \n" +
                            "Menedjer - @Foziljon_R_N \n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIC7WeZ6FsDYXo72Fc5D7oCAUJqaO0MAAIp7DEb3qrRSIZlFUf0xPbEAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Sport \n Zipkalar \n Narxi: 900.000 so'm \n" +
                            "✅ Erkaklar tolstovkasi — bu qulaylik, stil va sifatni birlashtirgan ideal tanlov. Har qanday mavsumga mos keladigan, har bir erkakning kiyimlaridan ajralib turadi. \n" +
                            "✅ Yuqori sifatli materiallar: Sviterlar va tolstovkalarimiz paxta materiallardan tayyorlangan bo'lib, har qanday ob-havo sharoitida issiq tutadi va nafas olish xususiyatiga ega. \n" +
                            "✅  O'lchamlari: Standart o'lcham, Siz har doim o'zingizning o'lchamingizni buyurtma berishingiz mumkin!\n" +
                            "Menedjer - @Foziljon_R_N \n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIC62eZ6FOyjKzQCVdL0e9ogRrEhv_TAAIo7DEb3qrRSFyL2QABFtO6qwEAAwIAA20AAzYE"));
                    sendPhoto.setCaption("Sport \n OVERSIZE  \n Narxi: 500.000 so'm \n" +
                            "✅ Tepa pas emas. faqat sportivkani o'zi \n" +
                            "✅ Bahor, kuz, qish fasllari uchun \n" +
                            "✅ Tarkib; paxta va elastan \n" +
                            "Menedjer - @Foziljon_R_N\n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIC6WeZ6E1xbTNIcBtFqtGBhxL9wc15AAIn7DEb3qrRSOm6xYxGPuISAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Sport \n dvoyka \n Narxi: 600.000 so'm \n" +
                            "✅ Tvitlashmaydi: Material uzoq vaqt davomida yuqori sifatini saqlaydi \n" +
                            "✅ Faoliyat: Kundalik kiyish, sayr va faol dam olish uchun mos \n" +
                            "✅ Yasash usuli: Yuqori sifatli tikish, uzun muddatli foydalanish uchun mo‘ljallangan. \n" +
                            "Menedjer - @Foziljon_R_N \n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDC2eZ7_oAAdj9FvJzyuCAMoaZSd7A1gACSuwxG96q0UibgcDjmFy5QAEAAwIAA20AAzYE"));
                    sendPhoto.setCaption("Sport \n Tolstovka \n Narxi: 700.000 so'm \n" +
                            "✅ O'z uslubingizni bizning svitshotlarimiz bilan yarating. O'ziga xos ranglar uyg'unligi ushbu svitshotga o'zgacha ko'rinish beradi. \n" +
                            "✅ Bizning svitshot sizga zamonaviy ko'rinish maksimum komfort va erkin xarakatlanish uchun qulaylik yaratadi.\n" +
                            "✅ Siz ushbu svitshotda har qanday vaziyatlarda o'zingizga bo'lgan ishonch va zamonaviy korinishni xis qilasiz. Ushbu svitshotlarni siz jinsi shimlar, kalta shimlar hatto klassik shimlar bilanham kiysangiz bo'ladi. \n" +
                            "Menedjer - @Foziljon_R_N \n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);

                }
                case "Pol klassik" -> {
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDD2eZ9FYaqbp8NmaYQUulzGC4-wwvAAJl7DEb3qrRSJ7AUX1Hn2J4AQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Pol Klassika \n Narxi: 700.000 so'm \n" +
                            "✅ Zamonaviy va yoshlarbop uslub – Bu obraz yoshlar uchun juda mos. Oq va bej rang kombinatsiyasi yangi va zamonaviy ko‘rinadi. Sportiv uslubda kiyinishni yoqtiradiganlar uchun ideal tanlov.\n" +
                            "\n" +
                            "✅ Qulaylik va klassikaning uyg‘unligi – Ushbu polo futbolka oddiy, lekin o‘ziga xos dizaynga ega. Fermuarli bo‘lgani uni boshqa polo futbolkalardan ajratib turadi. Kundalik kiyinish uchun qulay va trendda.\n" +
                            "\n" +
                            "✅ Shaharliklar uchun ajoyib kombinatsiya – Qora shim va sport krossovkalar bilan birga ko‘pchilik erkaklarga mos tushadigan universal kombinatsiya hosil bo‘lgan. Ishga borish, do‘stlar bilan uchrashuv yoki oddiy kun uchun juda mos. \n" +
                            "Menedjer - @Foziljon_R_N \n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDFmeZ9PvBVa3d6sCksqHJef47CfwmAAJo7DEb3qrRSJxYfxSZgtalAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Pol Klassika \n Narxi: 500.000 so'm \n" +
                            "✅ Oddiy, lekin bejirim – Kulrang polo futbolka nafis va har qanday vaziyatga mos. Oq chiziqlar esa unga kichik, lekin chiroyli detallar qo‘shgan. Klasik uslubni sevuvchilar uchun yaxshi variant.\n" +
                            "\n" +
                            "✅ Ishbilarmon casual uslub – Bej shim bilan birga kiyilganda bu obraz yarim rasmiy ko‘rinishga ega bo‘lib, ish joyida yoki uchrashuvlarda ham mos keladi.\n" +
                            "\n" +
                            "✅ Minimalistik va jiddiy ko‘rinish – Bu obraz ortiqcha e’tiborni tortmaydi, lekin klassik va ishonchli ko‘rinadi. Oddiy, lekin nafis kiyinishni yoqtiradiganlar uchun mos tanlov.\n" +
                            "Menedjer - @Foziljon_R_N \n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDGGeZ9S6Z7W9CjHoB4misl60tU5LaAAJp7DEb3qrRSE17euv_J5O0AQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Pol Klassika \n Narxi: 900.000 so'm \n" +
                            "✅ Elegant va zamonaviy – To‘q ranglarning kombinatsiyasi obrazni juda jozibali va nufuzli ko‘rsatadi. Minimalistik dizayn esa ortiqcha detallardan xoli bo‘lib, sof va nafis ko‘rinishga ega.\n" +
                            "\n" +
                            "✅ Yozgi hamda kundalik kiyim uchun ajoyib variant – Polo futbolka qulay va yengil. Sandallar esa issiq kunlar uchun mukammal yechim. Stilni buzmasdan, o‘ziga xoslikni saqlab qolgan.\n" +
                            "\n" +
                            "✅ Modaga mos va klassik ko‘rinish – Qora rang har doim urfda bo‘lgan. Bu obraz bilan nafaqat casual, balki yarim rasmiy muhitda ham ishonchli va zamonaviy ko‘rinish mumkin. \n" +
                            "Menedjer - @Foziljon_R_N \n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDGmeZ9VwrjKZP7ZS-S8tmn3Sgjk4OAAJq7DEb3qrRSBx0TPVxJ0d0AQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Pol Klassika \n Narxi: 400.000 so'm \n" +
                            "✅ Yozgi qulay yumshoq paxta tolasidan  \n" +
                            "✅ Yozgi hamda kundalik kiyim uchun ajoyib variant \n" +
                            "✅ Modaga mos va klassik ko‘rinish \n" +
                            "Menedjer - @Foziljon_R_N \n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDHGeZ9fTHCzh2LM5hB02i4obdrjcBAAJv7DEb3qrRSGSIQHnCh2jTAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Pol Klassika \n Narxi: 250.000 so'm \n" +
                            "Elegant va zamonaviy – To‘q ranglarning kombinatsiyasi obrazni juda jozibali va nufuzli ko‘rsatadi. Minimalistik dizayn esa ortiqcha detallardan xoli bo‘lib, sof va nafis ko‘rinishga ega.\\n\" +\n" +
                            "\n" +
                            "✅ Yozgi hamda kundalik kiyim uchun ajoyib variant – Polo futbolka qulay va yengil. Sandallar esa issiq kunlar uchun mukammal yechim. Stilni buzmasdan, o‘ziga xoslikni saqlab qolgan.\\n\" +\n" +
                            "\n" +
                            "✅ Modaga mos va klassik ko‘rinish – Qora rang har doim urfda bo‘lgan. Bu obraz bilan nafaqat casual, balki yarim rasmiy muhitda ham ishonchli va zamonaviy ko‘rinish mumkin. \\n\" +\n" +
                            "Menedjer - @Foziljon_R_N \\n\" +\n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);
                }
                case "Oyoq Kiyimlar" -> {
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDHmeaA57_BFrKOy2puMgocP4OIlb4AALl7DEb3qrRSLMaaGpo5iFZAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Oyoq Kiyimlar \n Narxi: 300.000  so'm \n" +
                            "✅ Zamonaviy dizayn – Krossovkalar oddiy va uslubiy ko‘rinishga ega, qora bog‘ichlar va oq taglik kombinatsiyasi klassik uslub yaratgan.\n" +
                            "\n" +
                            "✅ Brend imidji – DIOR logotipi mahsulotning premium toifaga mansubligini bildiradi, bu esa brendni qadrlovchilar uchun jozibadorlik qo‘shadi.\n" +
                            "\n" +
                            "✅ Ko‘p jihatdan mos kelishi – Ushbu krossovkalar kundalik kiyimlar bilan yaxshi mos keladi, ayniqsa sport yoki casual uslubdagi kiyimlar bilan juda mos kelishi mumkin.\n" +
                            "Menedjer - @Foziljon_R_N \n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDIGeaBBCWs7aT4m8ahzRVWhNejZApAALx7DEb3qrRSE4yhVIpmKL-AQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Oyoq Kiyimlar \n Narxi: 500.000 so'm \n" +
                            "✅ Minimalistik uslub – Qora mato va oq taglik kombinatsiyasi juda klassik va har xil kiyimlar bilan yaxshi mos keladigan ko‘rinish yaratadi.\n" +
                            "\n" +
                            "✅ Qulaylik va amaliylik – Bog‘ichsiz slip-on dizayni tufayli ularni kiyish va yechish juda oson, bu kundalik foydalanish uchun juda qulay.\n" +
                            "\n" +
                            "✅ Ko‘p jihatdan mos keluvchi – Ushbu model sport, casual va hatto yarim rasmiy kiyimlar bilan yaxshi uyg‘unlashadi, shuning uchun har xil vaziyatlarda kiyish mumkin. \n" +
                            "Menedjer - @Foziljon_R_N \n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDImeaBFQV4LNh8-C6lEF39cYP-s1CAALy7DEb3qrRSIBUDHUsZibUAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Oyoq Kiyimlar \n Narxi: 250.000 so'm \n" +
                            "✅ Elegant va nafis dizayn – To‘q qora rang va ustidagi bezaklar poyabzalga hashamatli va jiddiy ko‘rinish beradi, ayniqsa rasmiy va yarim rasmiy kiyimlar bilan mos keladi.\n" +
                            "\n" +
                            "✅ Qulaylik va amaliylik – Yumshoq mato va ichki qismi oyoq uchun qulaylikni ta’minlaydi, shuningdek, bog‘ichsiz dizayni tufayli kiyish va yechish oson.\n" +
                            "\n" +
                            "✅ Turli vaziyatlar uchun mos – Ushbu mokasinlar ish uchrashuvlari, kechki sayr yoki hatto kundalik kiyim bilan ham yaxshi ko‘rinadi. \n" +
                            "Menedjer - @Foziljon_R_N \n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDJGeaBGauI-jJINOrc0LZr4ZRf2w0AALz7DEb3qrRSJyZQi6OE468AQADAgADeAADNgQ"));
                    sendPhoto.setCaption("Oyoq Kiyimlar \n Narxi: 350.000 so'm \n" +
                            "✅ Chiroyli dizayn - Qora rang va oq rang ugunligi juda churoyli qolda tikilgan bo'ib charimdan \n" +
                            "✅ Qulay yumshoq - yozgi ajoyib oyoq kiyim juda yumshoq havo otkazib turadi qulay tarafi bog'ichsiz \n" +
                            "✅ Turli vaziyatlar uchun mos – Ushbu mokasinlar ish uchrashuvlari, kechki sayr yoki hatto kundalik kiyim bilan ham yaxshi ko‘rinadi \n" +
                            "Menedjer - @Foziljon_R_N \n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDJmeaBHTg_tzxgnwqEH8TeVqunm59AAL07DEb3qrRSAzY1eAUZwJFAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Oyoq Kiyimlar \n Narxi: 400.000  so'm \n" +
                            "✅ Zamonaviy dizayn – Krossovkalar oddiy va uslubiy ko‘rinishga ega, qora bog‘ichlar va oq taglik kombinatsiyasi klassik uslub yaratgan.\\n\" +\n" +
                            "\n" +
                            "✅ Brend imidji – DIOR logotipi mahsulotning premium toifaga mansubligini bildiradi, bu esa brendni qadrlovchilar uchun jozibadorlik qo‘shadi.\\n\" +\n" +
                            "\n" +
                            "✅ Ko‘p jihatdan mos kelishi – Ushbu krossovkalar kundalik kiyimlar bilan yaxshi mos keladi, ayniqsa sport yoki casual uslubdagi kiyimlar bilan juda mos kelishi mumkin.\\n\" +\n" +
                            "Menedjer - @Foziljon_R_N \n" +
                            "Malumot uchun: 998-95-130-77-88");
                    execute(sendPhoto);
                }
                case "Shim va shalvar" -> {
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDKGeaBf9BWpJUqfa6L_ani1dNYSRmAAIF7TEb3qrRSGdqQPaupgezAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Shim va shalvar \n Narxi: 300.000  so'm");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDLGeaBhwOLMgkI284PP4_lnSguOl1AAIH7TEb3qrRSOCJ4eKKD9OtAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Shim va shalvar \n Narxi: 250.000 so'm");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDLmeaBln4UhJqYrRRhhl2R2cnwiqDAAIJ7TEb3qrRSEew5M7FkJHyAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Shim va shalvar \n Narxi: 150.000 so'm");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDMGeaBoS5AcH23R7pTpWDeCqyKknjAAIL7TEb3qrRSHZvW7nqi20fAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Shim va shalvar \n Narxi: 400.000 so'm");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDM2eaB1b23COST-TNO9AYd1KzXelzAAIR7TEb3qrRSHfiP0kCG9X7AQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Shim va shalvar \n Narxi: 350.000  so'm");
                    execute(sendPhoto);
                }
                case "Futbolka" -> {
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDNWeaCID-u73FMKp9HVSREKNM2t7PAAIe7TEb3qrRSIsqL-8ci8lWAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Futbolka \n Narxi: 250.000  so'm");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDN2eaCRHmHmWtFqFYtigtphsQnKUIAAIf7TEb3qrRSOS0seBw2GdSAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Futbolka \n Narxi: 200.000 so'm");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDOWeaCTWK9ZylSkAng7VK6QAB5vowtQACIe0xG96q0Ug8lMHGrt3yGQEAAwIAA20AAzYE" + "AgACAgIAAxkBAAIDO2eaCUe4-cOb_u7Ju4GJ0wfv4_qOAAIj7TEb3qrRSJ_qtDTfUIErAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Futbolka \n Narxi: 150.000 so'm");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDP2eaCZnBqt4sMxVBNW6cWDLY6a-fAAIp7TEb3qrRSCh9wQdxbuTRAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Futbolka \n Narxi: 100.000 so'm");
                    execute(sendPhoto);

                    sendPhoto.setPhoto(new InputFile("AgACAgIAAxkBAAIDQWeaCq36gN8u2P3iOk9CB8qkBjUvAAI27TEb3qrRSAVip8pqFzEKAQADAgADbQADNgQ"));
                    sendPhoto.setCaption("Futbolka \n Narxi: 100.000  so'm");
                    execute(sendPhoto);
                }

                default -> {
                }

            }
        } else if (update.hasCallbackQuery()){
            String data = update.getCallbackQuery().getData();
            switch (data) {
                case "Dormon 11-uy" -> {
                    SendLocation location = new SendLocation();
                    location.setChatId(update.getCallbackQuery().getFrom().getId());
                    location.setLongitude(887678.9);
                    location.setLatitude(88718.9);

                    try {
                        execute(location);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } else if (update.getMessage().hasLocation()) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId());
            sendMessage.setText("🔁 Texnik ishlar olib borilmoqda");
            sendMessage.setReplyMarkup(menuButton());
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }

        }


    private InlineKeyboardMarkup address() {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Sergeli-5 106");
        button.setCallbackData("SERGELI-5");
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(button);
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        rows.add(row1);
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.setKeyboard(rows);
        return markup;
    }

    private ReplyKeyboard branches() {
        KeyboardButton button1 = new KeyboardButton();
        KeyboardButton button2 = new KeyboardButton();
        KeyboardButton button3 = new KeyboardButton();
        KeyboardButton button4 = new KeyboardButton();
        KeyboardButton button5 = new KeyboardButton();
        KeyboardButton button6 = new KeyboardButton();
        KeyboardButton button7 = new KeyboardButton();
        button1.setText("Atlas Chimgan");
        button2.setText("Sergeli 2");
        button3.setText("Golden life");
        button4.setText("Oybek");
        button5.setText("Parus");
        button6.setText("Compass");
        button7.setText("🔙 Ortga");
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
        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        return markup;
    }

    private ReplyKeyboard site() {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("O'tish");
        button.setUrl("https://garant shop.uz/");
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(button);
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        rows.add(row);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rows);
        return null;
    }

    private void location() {
        KeyboardButton button = new KeyboardButton();
        KeyboardButton back = new KeyboardButton();
        button.setText("Lokatsiya yuborish");
        back.setText("🔙 Ortga");
        button.setRequestLocation(true);
        KeyboardRow row = new KeyboardRow();
        row.add(button);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(back);
        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row);
        rows.add(row1);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rows);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
    }

    private ReplyKeyboard delivery() {
        KeyboardButton button1 = new KeyboardButton();
        KeyboardButton button2 = new KeyboardButton();
        KeyboardButton button3 = new KeyboardButton();
        KeyboardButton button4 = new KeyboardButton();
        KeyboardButton button5 = new KeyboardButton();
        KeyboardButton button6 = new KeyboardButton();
        KeyboardButton button7 = new KeyboardButton();
        KeyboardButton button8 = new KeyboardButton();
        KeyboardButton button9 = new KeyboardButton();
        KeyboardButton button10 = new KeyboardButton();


        button1.setText("🔙 Orqaga");
        button2.setText("📍 Eng yaqin filialni tanlash");
        button3.setText("🌐 Bu yerda buyurtma qilish");
        button4.setText("Boshqa filyal");
        button5.setText("Sport kiymi");
        button6.setText("Klassik kiyim");
        button7.setText("Pol klassik");
        button8.setText("Oyoq Kiyimlar");
        button9.setText("Shim va shalvar");
        button10.setText("Futbolka");


        KeyboardRow row0 = new KeyboardRow();
        row0.add(button8);
        row0.add(button9);
        row0.add(button10);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button6);
        row1.add(button5);
        row1.add(button7);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button1);
        row2.add(button2);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button3);
        row3.add(button4);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row2);
        rows.add(row3);
        rows.add(row1);
        rows.add(row0);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rows);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        return null;

    }

    private ReplyKeyboard takeAway() {
        KeyboardButton button1 = new KeyboardButton();
        KeyboardButton button2 = new KeyboardButton();
        KeyboardButton button3 = new KeyboardButton();
        KeyboardButton button4 = new KeyboardButton();
        KeyboardButton button5 = new KeyboardButton();
        KeyboardButton button6 = new KeyboardButton();
        KeyboardButton button7 = new KeyboardButton();
        KeyboardButton button8 = new KeyboardButton();
        KeyboardButton button9 = new KeyboardButton();
        KeyboardButton button10 = new KeyboardButton();


        button1.setText("🔙 Orqaga");
        button2.setText("📍 Eng yaqin filialni tanlash");
        button3.setText("🌐 Bu yerda buyurtma qilish");
        button4.setText("Boshqa filyal");
        button5.setText("Sport kiymi");
        button6.setText("Klassik kiyim");
        button7.setText("Pol klassik");
        button8.setText("Oyoq Kiyimlar");
        button9.setText("Shim va shalvar");
        button10.setText("Futbolka");


        KeyboardRow row0 = new KeyboardRow();
        row0.add(button8);
        row0.add(button9);
        row0.add(button10);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button6);
        row1.add(button5);
        row1.add(button7);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button1);
        row2.add(button2);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button3);
        row3.add(button4);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row2);
        rows.add(row3);
        rows.add(row1);
        rows.add(row0);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rows);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        return null;
    }

    private ReplyKeyboardMarkup settings() {
        KeyboardButton button = new KeyboardButton();
        button.setText("🌆Boshqa Shahar");
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("📃 Ommaviy ofera");
        KeyboardButton button2 = new KeyboardButton();
        button2.setText("🔙 Orqaga");
        KeyboardRow row = new KeyboardRow();
        row.add(button);
        row.add(button1);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button2);
        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row);
        rows.add(row2);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rows);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        return replyKeyboardMarkup;
    }

    private ReplyKeyboardMarkup back() {
        KeyboardButton button = new KeyboardButton();
        button.setText("\uD83D\uDD19 Ortga");
        KeyboardRow row = new KeyboardRow();
        row.add(button);
        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rows);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        return replyKeyboardMarkup;
    }

    private ReplyKeyboardMarkup order() {
        KeyboardButton button1 = new KeyboardButton();
        KeyboardButton button2 = new KeyboardButton();
        KeyboardButton button3 = new KeyboardButton();
        button1.setText("Olib ketish");
        button2.setText("🚗 Yetkazib berish");
        button3.setText("\uD83D\uDD19 Ortga");
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);
        row2.add(button3);
        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rows);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        return replyKeyboardMarkup;
    }

    private InlineKeyboardMarkup link() {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("O'tish");
        button.setUrl("https://www.youtube.com/watch?v=dQw4w9WgXcQ&themeRefresh=1");
        List<InlineKeyboardButton> row = new ArrayList<InlineKeyboardButton>();
        row.add(button);
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        rows.add(row);
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.setKeyboard(rows);
        return markup;
    }

    private ReplyKeyboardMarkup menuButton() {
        KeyboardButton button1 = new KeyboardButton();
        KeyboardButton button2 = new KeyboardButton();
        KeyboardButton button3 = new KeyboardButton();
        KeyboardButton button4 = new KeyboardButton();
        KeyboardButton button5 = new KeyboardButton();
        KeyboardButton button6 = new KeyboardButton();
        KeyboardButton button7 = new KeyboardButton();
        KeyboardButton button8 = new KeyboardButton();
        KeyboardButton button9 = new KeyboardButton();
        KeyboardButton button10 = new KeyboardButton();


        button1.setText("🔙 Orqaga");
        button2.setText("📍 Eng yaqin filialni tanlash");
        button3.setText("🌐 Bu yerda buyurtma qilish");
        button4.setText("Boshqa filyal");
        button5.setText("Sport kiymi");
        button6.setText("Klassik kiyim");
        button7.setText("Pol klassik");
        button8.setText("Oyoq Kiyimlar");
        button9.setText("Shim va shalvar");
        button10.setText("Futbolka");


        KeyboardRow row0 = new KeyboardRow();
        row0.add(button8);
        row0.add(button9);
        row0.add(button10);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button6);
        row1.add(button5);
        row1.add(button7);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button1);
        row2.add(button2);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button3);
        row3.add(button4);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row2);
        rows.add(row3);
        rows.add(row1);
        rows.add(row0);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rows);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        return replyKeyboardMarkup;
    }

    private ReplyKeyboardMarkup cityButton() {
        KeyboardButton button1 = new KeyboardButton();
        KeyboardButton button2 = new KeyboardButton();
        KeyboardButton button3 = new KeyboardButton();
        KeyboardButton button4 = new KeyboardButton();
        button1.setText("Qibray");
        button2.setText("Chirchiq");
        button3.setText("Sergili");
        button4.setText("MiroUlugbek");
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);
        List<KeyboardRow> rows = new ArrayList<KeyboardRow>();
        rows.add(row1);
        rows.add(row2);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rows);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        return replyKeyboardMarkup;

    }


    @Override
    public String getBotUsername() {
        return "This_is_Garant_shop_bot";
    }

    @Override
    public String getBotToken() {
        return "7794272417:AAFC-i8ZqIfkjjDnAoDmoAg6yXzLYxjxFpg";
    }
}


