package CinemaSysManagment;

import CinemaSysManagment.role.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;


public class LoggerTest {
    private static File logFile;

    @BeforeEach
    void setUp() {
        try {
            logFile = File.createTempFile("test_activity", ".log");
            Logger.LOG_FILE = logFile.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @AfterEach
    void tearDown() {
        if (logFile.exists()) {
            logFile.delete();
        }
    }

    @Test
    @DisplayName("Тест записи и чтения лога")
    void testViewLog() {
        Logger.log("Test log message 1");
        Logger.log("Test log message 2");
        Logger.log("Test log message 3");

        System.out.println("Log file content:");
        Logger.viewLog();
    }
}