package work_with_file;

import java.io.*;
import java.util.Scanner;

public class FileReadWriteMenu {
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

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("1. Write data to file");
            System.out.println("2. Read data from file");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter data to save: ");
                    String dataToSave = scanner.nextLine();
                    saveToFile("data.txt", dataToSave);
                    break;
                case 2:
                    String readData = readFromFile("data.txt");
                    System.out.println("Data from file: \n" + readData);
                    break;
                case 3:
                    System.out.println("Program exit.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Incorrect choice. Please select 1, 2 or 3.");
            }
        }
    }

}
