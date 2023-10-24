package CinemaSysManagment.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CinemaServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Сервер запущен...");

            while (true) {
                Socket clientSocket = serverSocket.accept();

                new Thread(() -> {
                    try {
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                        while (true) {
                            String request = in.readLine();
                            if (request == null) {
                                break;
                            }

                            System.out.println("Клиент: " + request);
                            if (request.equalsIgnoreCase("Привет, я хочу купить билет")) {
                                out.println("Да, есть свободное место.");
                            } else if (request.equalsIgnoreCase("Есть ли свободное место?")) {
                                out.println("Билет успешно куплен!");
                            } else {
                                out.println("Некорректный запрос.");
                            }
                        }

                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}