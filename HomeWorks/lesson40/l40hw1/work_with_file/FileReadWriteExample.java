package work_with_file;

import java.io.*;
import java.util.Scanner;

public class FileReadWriteExample {
    public static void saveToFile(String fileName, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
            System.out.println("Data successfully saved to file " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving data to file" + fileName);
            e.printStackTrace();
        }
    }

    public static String readFromFile(String fileName) {
        StringBuilder data = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading data from file " + fileName);
            e.printStackTrace();
        }

        return data.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter data to save: ");
        String dataToSave = scanner.nextLine();

        saveToFile("data.txt", dataToSave);

        String readData = readFromFile("data.txt");
        System.out.println("Data from file: " + readData);

        scanner.close();
    }

}
