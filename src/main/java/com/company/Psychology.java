package com.company;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Psychology extends TelegramLongPollingBot {

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();

        if (message.hasText()) {

            String text = message.getText();
            long chatId = message.getChatId();

            String response = getAIResponse(text);
            sendMessage(chatId, response);
        }
    }

    private void sendMessage(long chatId, String response) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(response);
        sendMessage.setParseMode(ParseMode.HTML);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAIResponse(String userInput) {
        String text = """
                Foydalanuvchi muammo yuborganida, faqat qisqa psixologik maslahat bering. Uzun javob yozmang
                 """ + "User input: " + userInput;


        try {
            HttpClient client = HttpClient.newHttpClient();

            // Properly escape the text inside the JSON payload
            String jsonBody = "{\n" +
                    "  \"contents\": [\n" +
                    "    { \"parts\": [{ \"text\": \"" + text.replace("\"", "\\\"") + "\" }] }\n" +
                    "  ]\n" +
                    "}";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash-exp:generateContent?key="
                            + "AIzaSyDqg2VTxbzAQrL6FyaeToz82Oe80MFN8rI"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JsonElement json = JsonParser.parseString(response.body());
                JsonArray array = json.getAsJsonObject().getAsJsonArray("candidates");
                if (array != null && array.size() > 0) {
                    JsonObject candidate = array.get(0).getAsJsonObject();
                    JsonObject content = candidate.getAsJsonObject("content");
                    JsonArray parts = content.getAsJsonArray("parts");
                    if (parts != null && parts.size() > 0) {
                        JsonObject part = parts.get(0).getAsJsonObject();
                        return part.get("text").getAsString();
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "I think there's some problem. Because of that, I can't generate response. " +
                "Please contact with [Your contact info]";
    }


    @Override
    public String getBotUsername() {
        return "https://t.me/translator9abot";
    }

    @Override
    public String getBotToken() {
        return "7664831585:AAF5x0RFQRz7qM_2DT80fTslvnmke9JrnSk";
    }
}