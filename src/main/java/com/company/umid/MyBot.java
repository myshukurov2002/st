package com.company.umid;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

    private final Gemini geminiService = new Gemini();

    @Override
    public String getBotUsername() {
        return "ciytyinfopdpbot";
    }

    @Override
    public String getBotToken() {
        return "8009446130:AAGrm_pdGdh6oZYtZ3pl0j2TITpnC-iWhrQ";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String userMessage = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            try {

                String prompt = "Ozbek tilida javob ber,";
                String response = geminiService.generateResponse(prompt, userMessage);
                Gemini gemini = new Gemini();
                gemini(prompt,userMessage);

                sendTextMessage(chatId, response);

            } catch (Exception e) {
                e.printStackTrace();

                sendTextMessage(chatId, "xatolik keyinroq urinib koring.");
            }
        }
    }

    private void gemini(String prompt, String userMessage) {

    }


    private void sendTextMessage(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
