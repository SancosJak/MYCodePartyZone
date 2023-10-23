package CinemaSysManagment.impl;

import CinemaSysManagment.model.DataModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.*;
import java.util.Scanner;

public class DataManagement {
    private FilmManagement filmManagement;
    private SessionManagement sessionManagement;
    private ProductManagement productManagement;

    public DataManagement(FilmManagement filmManagement, SessionManagement sessionManagement, ProductManagement productManagement) {
        this.filmManagement = filmManagement;
        this.sessionManagement = sessionManagement;
        this.productManagement = productManagement;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Сохранить данные в JSON");
            System.out.println("2. Загрузить данные из JSON");
            System.out.println("3. Вернуться в меню администратора");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    saveDataToJson("data.json");
                    break;
                case 2:
                    loadDataFromJson("data.json");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, введите 1, 2 или 3.");
            }
        }
    }

    public void saveDataToJson(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            String filmsJson = gson.toJson(filmManagement.getFilms());
            String sessionsJson = gson.toJson(sessionManagement.getSessions());
            String productsJson = gson.toJson(productManagement.getProducts());

            writer.write("{" +
                    "\"films\":" + filmsJson + "," +
                    "\"sessions\":" + sessionsJson + "," +
                    "\"products\":" + productsJson + "}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDataFromJson(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Gson gson = new Gson();

            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            DataModel data = gson.fromJson(json.toString(), DataModel.class);

            filmManagement.setFilms(data.films);
            sessionManagement.setSessions(data.sessions);
            productManagement.setProducts(data.products);
        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
        }
    }
}

// TODO check and realize all mismatch(s) and add color to errMess