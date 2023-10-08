package code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilesReadParallel_Thread {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new ReadFile("HomeWorks/lesson58/l58hw/code/file1.txt"));
        Thread thread2 = new Thread(new ReadFile("HomeWorks/lesson58/l58hw/code/file2.txt"));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class ReadFile implements Runnable {
        private final String fileName;

        public ReadFile(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.print(line + " ");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
