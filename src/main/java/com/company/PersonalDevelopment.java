package com.company;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonalDevelopment extends TelegramLongPollingBot {

    private final Map<Long, UserFinanceData> userFinanceDataMap = new HashMap<>();
    private final Map<Long, String> userStates = new HashMap<>();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String userMessage = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            userFinanceDataMap.putIfAbsent(chatId, new UserFinanceData());
            UserFinanceData financeData = userFinanceDataMap.get(chatId);

            if (userMessage.startsWith("/start")) {
                userStates.remove(chatId);
                sendWelcomeMessage(chatId);
            } else if (userStates.containsKey(chatId)) {
                String state = userStates.get(chatId);
                handleStateInput(chatId, state, userMessage, financeData);
            } else {
                sendMessage(chatId, "Iltimos, tugmalardan birini tanlang yoki /start ni bosing.");
            }
        } else if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            Long chatId = update.getCallbackQuery().getMessage().getChatId();

            UserFinanceData financeData = userFinanceDataMap.get(chatId);
            if (financeData == null) {
                financeData = new UserFinanceData();
                userFinanceDataMap.put(chatId, financeData);
            }

            switch (callbackData) {
                case "add_income":
                    userStates.put(chatId, "add_income");
                    sendMessage(chatId, "Daromad miqdorini kiriting (faqat son):");
                    break;
                case "add_expense":
                    userStates.put(chatId, "add_expense");
                    sendMessage(chatId, "Xarajat miqdorini kiriting (faqat son):");
                    break;
                case "view_report":
                    String report = generateReport(financeData);
                    sendReportWithOptions(chatId, report);
                    break;
                case "save_report":
                    sendMessage(chatId, "Hisobot saqlandi!");
                    break;
                case "discard_report":
                    userFinanceDataMap.put(chatId, new UserFinanceData());
                    sendMessage(chatId, "Hisobot bekor qilindi va ma'lumotlar yangilandi.");
                    break;
                default:
                    sendMessage(chatId, "Noma'lum amal. Iltimos, /start ni bosing.");
                    break;
            }
        }
    }

    private void handleStateInput(Long chatId, String state, String userMessage, UserFinanceData financeData) {
        try {
            double amount = Double.parseDouble(userMessage);
            if (amount <= 0) {
                sendMessage(chatId, "Iltimos, miqdorni musbat son sifatida kiriting.");
                return;
            }

            if (state.equals("add_income")) {
                financeData.addIncome(amount);
                sendMessage(chatId, "Daromad muvaffaqiyatli qo'shildi: " + amount + " so'm.");
            } else if (state.equals("add_expense")) {
                financeData.addExpense(amount);
                sendMessage(chatId, "Xarajat muvaffaqiyatli qo'shildi: " + amount + " so'm.");
            }
            userStates.remove(chatId);
        } catch (NumberFormatException e) {
            sendMessage(chatId, "Iltimos, faqat son kiriting, masalan: 50000");
        }
    }

    private void sendWelcomeMessage(Long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText("Assalomu alaykum! Men Shaxsiy Moliya Boshqaruv Botiman. Quyidagi tugmalardan foydalaning:");

        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(createInlineButton("Daromad qo'shish", "add_income"));
        row1.add(createInlineButton("Xarajat qo'shish", "add_expense"));

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        row2.add(createInlineButton("Hisobotni ko'rish", "view_report"));

        keyboard.add(row1);
        keyboard.add(row2);
        inlineKeyboard.setKeyboard(keyboard);
        message.setReplyMarkup(inlineKeyboard);

        sendMessage(message);
    }

    private String generateReport(UserFinanceData financeData) {
        return "Moliyaviy hisobot:\n" +
                "Jami daromad: " + financeData.getTotalIncome() + " so'm\n" +
                "Jami xarajat: " + financeData.getTotalExpenses() + " so'm\n" +
                "Balans: " + financeData.getBalance() + " so'm.";
    }

    private void sendReportWithOptions(Long chatId, String report) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText(report);

        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(createInlineButton("Saqlash", "save_report"));
        row.add(createInlineButton("Bekor qilish", "discard_report"));

        keyboard.add(row);
        inlineKeyboard.setKeyboard(keyboard);
        message.setReplyMarkup(inlineKeyboard);

        sendMessage(message);
    }

    private InlineKeyboardButton createInlineButton(String text, String callbackData) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(text);
        button.setCallbackData(callbackData);
        return button;
    }

    private void sendMessage(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText(text);
        try {
            execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(SendMessage message) {
        try {
            execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "t.me/Shaxsiy_daromat_bot";
    }

    @Override
    public String getBotToken() {
        return "7714113888:AAGCBQJgdiYgqQuxeNAk1GW1gkYu4dD1qqk";
    }

    static class UserFinanceData {
        private double totalIncome = 0;
        private double totalExpenses = 0;

        public void addIncome(double amount) {
            totalIncome += amount;
        }

        public void addExpense(double amount) {
            totalExpenses += amount;
        }

        public double getTotalIncome() {
            return totalIncome;
        }

        public double getTotalExpenses() {
            return totalExpenses;
        }

        public double getBalance() {
            return totalIncome - totalExpenses;
        }
    }
}