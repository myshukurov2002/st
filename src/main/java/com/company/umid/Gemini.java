package com.company.umid;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Gemini {
    private static final String API_KEY = "AIzaSyAOs5B-Ys5LL3V7pLCLGyOI8_HXdTlB1_Q";
    private static final String GEMINI_API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=";

    /**
     * Генерация ответа на основе пользовательского ввода и начального текста (prompt).
     *
     * @param prompt   Начальный текст, который направляет генерацию.
     * @param userInput Текст от пользователя.
     * @return Сгенерированный ответ.
     */
    public String generateResponse(String prompt, String userInput) {
        try {
            return getGeminiResponse(prompt + userInput);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Ошибка при генерации ответа через Gemini API", e);
        }
    }

    /**
     * Отправка запроса к Gemini API для генерации текста.
     *
     * @param request Текст запроса (prompt + пользовательский ввод).
     * @return Сгенерированный текст ответа.
     */
    private static String getGeminiResponse(String request) throws IOException, InterruptedException {
        String json = "{"
                + "  \"contents\": ["
                + "    {"
                + "      \"parts\": ["
                + "        {"
                + "          \"text\": \"" + request + "\""
                + "        }"
                + "      ]"
                + "    }"
                + "  ]"
                + "}";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(GEMINI_API_URL + API_KEY))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String response = httpResponse.body();


        Gson gson = new Gson();
        ResponseObject responseObject = gson.fromJson(response, ResponseObject.class);


        if (responseObject != null && responseObject.candidates != null && !responseObject.candidates.isEmpty()) {
            ResponseObject.Candidate candidate = responseObject.candidates.get(0);
            if (candidate.content != null && !candidate.content.parts.isEmpty()) {
                return candidate.content.parts.get(0).text;
            }
        }

        return "Ошибка: пустой ответ от Gemini.";
    }
}
