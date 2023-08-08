package warehouseAppl;

import model.Computer;
import java.util.Scanner;

public class WarehouseAppl {
    private Computer[] computers;
    private int count;

    public WarehouseAppl(int capacity) {
        computers = new Computer[capacity];
        count = 0;
    }

    public void addComputer(Computer computer) {
        if (count < computers.length) {
            computers[count] = computer;
            count++;
            System.out.println("The product has been successfully added to the warehouse.");
        } else {
            System.out.println("There is not enough space in the warehouse to add an item.");
        }
    }

    public Computer findComputerByName(String name) {
        for (int i = 0; i < count; i++) {
            if (computers[i].getName().equalsIgnoreCase(name)) {
                return computers[i];
            }
        }
        return null;
    }

    public Computer[] findComputersByCategory(String category) {
        int foundCount = 0;
        for (int i = 0; i < count; i++) {
            if (computers[i].getCategory().equalsIgnoreCase(category)) {
                foundCount++;
            }
        }

        Computer[] foundComputers = new Computer[foundCount];
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (computers[i].getCategory().equalsIgnoreCase(category)) {
                foundComputers[index] = computers[i];
                index++;
            }
        }

        return foundComputers;
    }
    public void updateComputerQuantity(String name, int quantity) {
        for (int i = 0; i < count; i++) {
            if (computers[i].getName().equalsIgnoreCase(name)) {
                computers[i].setQuantity(quantity);
                System.out.println("Quantity of items successfully updated.");
                return;
            }
        }
        System.out.println("Product Not Found.");
    }

    public void removeComputer(String name) {
        for (int i = 0; i < count; i++) {
            if (computers[i].getName().equalsIgnoreCase(name)) {
                for (int j = i; j < count - 1; j++) {
                    computers[j] = computers[j + 1];
                }
                count--;
                System.out.println("The product has been successfully removed from the warehouse.");
                return;
            }
        }
        System.out.println("Product Not Found.");
    }

    public int getTotalComputerCount() {
        int totalCount = 0;
        for (int i = 0; i < count; i++) {
            totalCount += computers[i].getQuantity();
        }
        return totalCount;
    }

    public void printCategoryReport() {
        String[] categories = new String[count];
        int[] categoryCounts = new int[count];
        int categoryCount = 0;

        for (int i = 0; i < count; i++) {
            String category = computers[i].getCategory();
            boolean found = false;
            for (int j = 0; j < categoryCount; j++) {
                if (categories[j].equalsIgnoreCase(category)) {
                    categoryCounts[j] += computers[i].getQuantity();
                    found = true;
                    break;
                }
            }
            if (!found) {
                categories[categoryCount] = category;
                categoryCounts[categoryCount] = computers[i].getQuantity();
                categoryCount++;
            }
        }

        System.out.println("Report on the number of products by category:");
        for (int i = 0; i < categoryCount; i++) {
            System.out.println(categories[i] + ": " + categoryCounts[i]);
        }
    }

    public void printComputerList() {
        System.out.println("List of products in stock:");
        for (int i = 0; i < count; i++) {
            System.out.println(computers[i]);
        }
    }

    public boolean checkProductAvailability(String name) {
        for (Computer computer : computers) {
            if (computer != null && computer.getName().equalsIgnoreCase(name) && computer.getQuantity() > 0) {
                return true;
            }
        }
        return false;
    }

    public void increaseProductQuantity(String name, int quantityToAdd) {
        Computer computer = findComputerByName(name);
        if (computer != null) {
            int currentQuantity = computer.getQuantity();
            computer.setQuantity(currentQuantity + quantityToAdd);
            System.out.println("Quantity of items '" + name + "' increased by " + quantityToAdd + ".");
        } else {
            System.out.println("Product '" + name + "' Not Found.");
        }
    }

    public double calculateTotalValue() {
        double totalValue = 0;
        for (Computer computer : computers) {
            if (computer != null) {
                totalValue += computer.getPrice() * computer.getQuantity();
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WarehouseAppl warehouse = new WarehouseAppl(100);

        Computer computer1 = new Computer("Apple MacBook Air 13", "Notebook", 10, 1100.);
        Computer computer2 = new Computer("Asus ZenBook 13", "Notebook", 5, 1020);
        Computer computer3 = new Computer("ARTLINE Gaming X63", "PC", 8, 1700);

        warehouse.addComputer(computer1);
        warehouse.addComputer(computer2);
        warehouse.addComputer(computer3);

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("1. Add a product");
            System.out.println("2. Find a product by name");
            System.out.println("3. Find products by category");
            System.out.println("4. Update product quantity");
            System.out.println("5. Remove an item from the warehouse");
            System.out.println("6. Display a list of products in stock");
            System.out.println("7. Display the total number of products");
            System.out.println("8. Display a report on the number of products by category");
            System.out.println("9. Check product availability");
            System.out.println("10. Increase the quantity of goods");
            System.out.println("11. Calculate the total cost of goods");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the product:");
                    String name = scanner.nextLine();
                    System.out.println("Enter the product category:");
                    String category = scanner.nextLine();
                    System.out.println("Enter the quantity of the product:");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the price of the product:");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    Computer newComputer = new Computer(name, category, quantity, price);
                    warehouse.addComputer(newComputer);
                    break;
                case 2:
                    System.out.println("Enter the name of the product:");
                    String searchName = scanner.nextLine();
                    Computer foundComputer = warehouse.findComputerByName(searchName);
                    if (foundComputer != null) {
                        System.out.println(foundComputer);
                    } else {
                        System.out.println("Product Not Found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the product category:");
                    String searchCategory = scanner.nextLine();
                    Computer[] foundComputers = warehouse.findComputersByCategory(searchCategory);
                    if (foundComputers.length > 0) {
                        System.out.println("Found Products:");
                        for (Computer computer : foundComputers) {
                            System.out.println(computer);
                        }
                    } else {
                        System.out.println("Product Not Found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter the name of the product:");
                    String updateName = scanner.nextLine();
                    System.out.println("Enter a new quantity of goods:");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine();
                    warehouse.updateComputerQuantity(updateName, newQuantity);
                    break;
                case 5:
                    System.out.println("Enter the name of the product:");
                    String removeName = scanner.nextLine();
                    warehouse.removeComputer(removeName);
                    break;
                case 6:
                    warehouse.printComputerList();
                    break;
                case 7:
                    int totalComputerCount = warehouse.getTotalComputerCount();
                    System.out.println("The total number of products in stock: " + totalComputerCount);
                    break;
                case 8:
                    warehouse.printCategoryReport();
                    break;
                case 9:
                    System.out.println("Enter the name of the product:");
                    String availabilityName = scanner.nextLine();
                    boolean available = warehouse.checkProductAvailability(availabilityName);
                    if (available) {
                        System.out.println("The product is available.");
                    } else {
                        System.out.println("The product is not available.");
                    }
                    break;
                case 10:
                    System.out.println("Enter the name of the product:");
                    String increaseName = scanner.nextLine();
                    System.out.println("Enter the quantity of the product to add:");
                    int quantityToAdd = scanner.nextInt();
                    scanner.nextLine();
                    warehouse.increaseProductQuantity(increaseName, quantityToAdd);
                    break;
                case 11:
                    double totalValue = warehouse.calculateTotalValue();
                    System.out.println("The total cost of items in stock: " + totalValue + " €");
                    break;
                case 0:
                    System.out.println("The program is over.");
                    return;
                default:
                    System.out.println("Wrong choice. Please select an action from the list.");
            }
            System.out.println();
        }
    }
}
