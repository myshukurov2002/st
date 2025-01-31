package com.company.a24;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONObject;

public class WeatherRecommendationBot extends TelegramLongPollingBot {

    private static final String WEATHER_API_KEY = "b7a1e19d10f63a4a62d8d9851e35e488";

    @Override
    public String getBotUsername() {
        return "@weatherinformation_vbot";

    }

    @Override
    public String getBotToken() {
        return "7909980843:AAFCLbUUVpN2Y8XlSMjfOjHSDd2y_13M94g\n";

    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String userMessage = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();

            if (userMessage.equalsIgnoreCase("/start")) {
                sendMessage(chatId, "Salom! Menga shahringizni yozing, men sizga ob-havo haqida ma'lumot va tavsiyalar beraman.");
            } else {
                String weatherResponse = getWeather(userMessage);
                String recommendation = parseWeatherAndRecommend(weatherResponse, userMessage);
                sendMessage(chatId, recommendation);
            }
        }
    }

    private void sendMessage(String chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);


        ArrayList<String> genres = new ArrayList<>();
        genres.add("Tashkent");
        genres.add("Samarkand");
        genres.add("Bukhara");
        genres.add("Khiva");
        genres.add("Nukus");
        genres.add("Andijan");
        genres.add("Namangan");
        genres.add("Fergana");
        genres.add("Jizzakh");
        genres.add("Gulistan");
        genres.add("Navoi");
        genres.add("Termez");
        genres.add("Urganch");
        genres.add("Kokand");
        genres.add("Qarshi");

        ArrayList<KeyboardButton> buttons = new ArrayList<>();
        for (String i : genres) {
            KeyboardButton button = new KeyboardButton();
            button.setText(i);
            buttons.add(button);
        }

        int columns = 2;
        int count = 0;
        ArrayList<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRows.add(keyboardRow);

        for (KeyboardButton button : buttons) {
            if (count == columns) {
                count = 0;
                keyboardRow = new KeyboardRow();
                keyboardRows.add(keyboardRow);
            }
            keyboardRow.add(button);
            count++;
        }

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        rows.addAll(keyboardRows);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
                markup.setSelective(false);
        markup.setIsPersistent(false);


        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    private String getWeather(String city) {
        try {
            String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + WEATHER_API_KEY + "&units=metric";
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String parseWeatherAndRecommend(String weatherResponse, String city) {
        if (weatherResponse == null) {
            return "Kechirasiz, ob-havo ma'lumotlarini olishda xatolik yuz berdi.";
        }

        try {
            JSONObject json = new JSONObject(weatherResponse);
            double temperature = json.getJSONObject("main").getDouble("temp");
            String weatherCondition = json.getJSONArray("weather").getJSONObject(0).getString("main");
            String time = json.getJSONObject("sys").has("sunrise") ? "Quyosh chiqqan vaqti: " + json.getJSONObject("sys").getLong("sunrise") : "Vaqt mavjud emas";

            StringBuilder recommendation = new StringBuilder();
            recommendation.append("Shahar: ").append(city).append("\n");
            recommendation.append("Harorat: ").append(temperature).append("°C\n");
            recommendation.append("Ob-havo: ").append(weatherCondition).append("\n");

            if (weatherCondition.equalsIgnoreCase("Clear")) {
                recommendation.append("Tavsiya: Bugun quyoshli kun! Sayr qilish uchun yaxshi imkoniyat. 😊");
            } else if (weatherCondition.equalsIgnoreCase("Rain")) {
                recommendation.append("Tavsiya: Bugun yomg‘ir yog‘adi. Issiq choy bilan uyda dam olishni tavsiya qilamiz. ☔");
            } else {
                recommendation.append("Tavsiya: Ob-havo aralash. Shunchaki qiziqarli mashg‘ulot tanlang. 😉");
            }

            return recommendation.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Ob-havo ma'lumotlarini tahlil qilishda xatolik yuz berdi.";
        }


    }

}

