package CinemaSysManagment.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CinemaClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Thread responseReader = new Thread(() -> {
                try {
                    while (true) {
                        String response = in.readLine();
                        if (response == null) {
                            break;
                        }
                        System.out.println("Server: " + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            responseReader.start();

            out.println("Привет, я хочу купить билет");
            out.println("Есть ли свободное место?");

            try {
                responseReader.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}