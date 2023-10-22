package CinemaSysManagment.impl;

import CinemaSysManagment.dao.IProduct;
import CinemaSysManagment.model.Product;

import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    private List<Product> products;

    public ProductManagement(List<Product> products) {
        this.products = products;
    }

    public void run() {
        while (true) {
            System.out.println("Управление продуктами:");
            System.out.println("1. Добавить продукт");
            System.out.println("2. Удалить продукт");
            System.out.println("3. Редактировать продукт");
            System.out.println("4. Просмотреть все продукты");
            System.out.println("5. Вернуться в предыдущее меню");

            Scanner scanner = new Scanner(System.in);

            int productChoice;
            while (true) {
                System.out.print("Введите ваш выбор: ");
                if (scanner.hasNextInt()) {
                    productChoice = scanner.nextInt();
                    if (productChoice >= 1 && productChoice <= 5) {
                        break;
                    } else {
                        System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 5.");
                    }
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, введите число от 1 до 5.");
                    scanner.next();
                }
            }

            switch (productChoice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    editProduct();
                    break;
                case 4:
                    viewAllProducts();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 5.");
            }
        }
    }

    private void addProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название продукта: ");
        String name = scanner.nextLine();

        System.out.print("Введите цену продукта: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Введите описание продукта: ");
        String description = scanner.nextLine();

        System.out.print("Введите количество на складе: ");
        int stockQuantity = scanner.nextInt();

        Product newProduct = new Product(name, price, description, stockQuantity);
        products.add(newProduct);
        System.out.println("Продукт успешно добавлен.");
    }

    private void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        do {
            System.out.print("Введите номер продукта для удаления: ");
            int productNumber = scanner.nextInt();

            if (productNumber >= 1 && productNumber <= products.size()) {
                validInput = true;
                IProduct deletedProduct = products.remove(productNumber - 1);
                System.out.println("Продукт '" + deletedProduct.getName() + "' успешно удален.");
            } else {
                System.out.println("Некорректный номер продукта. Пожалуйста, повторите ввод.");
            }
        } while (!validInput);
    }

    private void editProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер продукта для редактирования: ");
        int productNumber = scanner.nextInt();

        if (productNumber >= 1 && productNumber <= products.size()) {
            IProduct product = products.get(productNumber - 1);

            System.out.println("Выберите, что вы хотите отредактировать:");
            System.out.println("1. Название");
            System.out.println("2. Цена");
            System.out.println("3. Описание");
            System.out.println("4. Количество на складе");

            int editChoice;
            while (true) {
                System.out.print("Введите ваш выбор: ");
                if (scanner.hasNextInt()) {
                    editChoice = scanner.nextInt();
                    if (editChoice >= 1 && editChoice <= 4) {
                        break;
                    } else {
                        System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 4.");
                    }
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, введите число от 1 до 4.");
                    scanner.next();
                }
            }
            scanner.nextLine();

            switch (editChoice) {
                case 1:
                    System.out.print("Введите новое название продукта: ");
                    String newName = scanner.nextLine();
                    product.setName(newName);
                    System.out.println("Название успешно изменено.");
                    break;
                case 2:
                    System.out.print("Введите новую цену продукта: ");
                    double newPrice = scanner.nextDouble();
                    product.setPrice(newPrice);
                    System.out.println("Цена успешно изменена.");
                    break;
                case 3:
                    System.out.print("Введите новое описание продукта: ");
                    String newDescription = scanner.nextLine();
                    product.setDescription(newDescription);
                    System.out.println("Описание успешно изменено.");
                    break;
                case 4:
                    System.out.print("Введите новое количество на складе: ");
                    int newStockQuantity = scanner.nextInt();
                    product.setStockQuantity(newStockQuantity);
                    System.out.println("Количество на складе успешно изменено.");
                    break;
            }
        } else {
            System.out.println("Некорректный номер продукта. Пожалуйста, повторите ввод.");
        }
    }

    private void viewAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Список продуктов пуст.");
        } else {
            System.out.println("Список всех продуктов:");
            for (int i = 0; i < products.size(); i++) {
                IProduct product = products.get(i);
                System.out.println((i + 1) + ". " + product.getName() + " - Цена: " + product.getPrice() + " - Наличие: " + product.getStockQuantity());
            }
        }
    }
}
//TODO check and realize all mismatch(s) and add color to errMess