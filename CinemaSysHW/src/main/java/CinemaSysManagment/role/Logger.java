package CinemaSysManagment.role;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logger {
    public static  String LOG_FILE = "activity.log";

    public static void log(String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String logMessage = timestamp + " - " + message + "\n";

        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(logMessage);
        } catch (IOException e) {
            System.err.println("Ошибка записи в журнал событий: " + e.getMessage());
        }
    }
    public static List<String> viewLog() {
        List<String> logMessages = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                logMessages.add(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения журнала событий: " + e.getMessage());
        }
        return logMessages;
    }
}
// TODO make log for all actions (e.q. editing, changing, sell and refund tickets, exit the program and etc.