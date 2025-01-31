package com.company.old;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StudyBot extends TelegramLongPollingBot {

    private final String GEMINI_API_KEY = "AIzaSyAQ_7ivB0PFAsGVAq_iUSjMOdVhd8QMShc";

    public StudyBot(String botToken) {
        super(botToken);
    }

    @Override
    public String getBotUsername() {
        return "StudySphereBot";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String userMessage = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            String response;

            if (userMessage.equalsIgnoreCase("/start")) {
                response = "Assalomu alaykum! Men dars mavzulari bo'yicha yordam beradigan botman. Savollaringizni yuboring!";
            } else {
                response = getAIResponse(userMessage);
            }

            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText(response);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private String getAIResponse(String userInput) {
        String prompt = "Iltimos, faqat darsga oid savollarni qabul qilgin."  + userInput;
        String jsonBody = "{ \"contents\": [ { \"parts\": [ { \"text\": \"" + prompt + "\" } ] } ] }";

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=" + GEMINI_API_KEY))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JsonElement json = JsonParser.parseString(response.body());
                JsonArray candidates = json.getAsJsonObject().getAsJsonArray("candidates");

                if (candidates != null && !candidates.isEmpty()) {
                    JsonObject content = candidates.get(0).getAsJsonObject().getAsJsonObject("content");
                    return content.getAsJsonArray("parts").get(0).getAsJsonObject().get("text").getAsString();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return "Kechirasiz, biror xatolik yuz berdi. Iltimos, qayta urinib ko'ring.";
    }
}