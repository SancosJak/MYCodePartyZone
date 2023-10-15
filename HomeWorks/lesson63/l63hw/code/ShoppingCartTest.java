package code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import practice.ShoppingCart;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeAll
    void setup() {
        cart = new ShoppingCart();
    }

    @BeforeEach
    void init() {
        cart = new ShoppingCart();
    }

    @AfterEach
    void tearDown() {
        cart.empty();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Тест добавления товара в корзину")
    void testAddItem() {
        cart.addItem(30.0);
        cart.addItem(70.0);
        assertEquals(2, cart.getItemCount(), "Количество товаров должно быть 2");
        assertEquals(100.0, cart.getTotalPrice(), 0.01, "Общая стоимость должна быть 100.0");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Тест очистки корзины")
    void testEmptyCart() {
        cart.addItem(10.0);
        cart.addItem(20.0);
        cart.empty();
        assertEquals(0, cart.getItemCount(), "Количество товаров должно быть 0 после очистки");
        assertEquals(0.0, cart.getTotalPrice(), 0.01, "Общая стоимость должна быть 0.0 после очистки");
    }

    @Test
    @DisplayName("Тест расчета общей стоимости")
    void testTotalPriceCalculation() {
        cart.addItem(10.0);
        cart.addItem(30.0);
        cart.addItem(15.5);
        assertEquals(3, cart.getItemCount(), "Количество товаров должно быть 3");
        assertEquals(55.5, cart.getTotalPrice(), 0.01, "Общая стоимость должна быть 55.5");
    }

    // Добавьте дополнительные тестовые методы по мере необходимости

    @Test
    @DisplayName("Тест добавления товара с нулевой стоимостью")
    void testAddItemWithZeroPrice() {
        cart.addItem(0.0);
        assertEquals(1, cart.getItemCount(), "Количество товаров должно быть 1");
        assertEquals(0.0, cart.getTotalPrice(), 0.01, "Общая стоимость должна быть 0.0");
    }

    @Test
    @DisplayName("Тест добавления товара с отрицательной стоимостью")
    void testAddItemWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem(-10.0), "Добавление товара с отрицательной стоимостью должно генерировать IllegalArgumentException");
        assertEquals(0, cart.getItemCount(), "Количество товаров должно быть 0, так как товар с отрицательной стоимостью не добавлен");
        assertEquals(0.0, cart.getTotalPrice(), 0.01, "Общая стоимость должна быть 0.0, так как товар с отрицательной стоимостью не добавлен");
    }

    @Test
    @DisplayName("Тест попытки очистки пустой корзины")
    void testEmptyEmptyCart() {
        cart.empty();
        assertEquals(0, cart.getItemCount(), "Количество товаров должно быть 0 после попытки очистки пустой корзины");
        assertEquals(0.0, cart.getTotalPrice(), 0.01, "Общая стоимость должна быть 0.0 после попытки очистки пустой корзины");
    }


    @Test
    @DisplayName("Тест обновления общей стоимости после добавления товара")
    void testTotalPriceAfterAddingItem() {
        assertEquals(0.0, cart.getTotalPrice(), 0.01, "Общая стоимость должна быть 0.0 перед добавлением товара");
        cart.addItem(15.0);
        assertEquals(15.0, cart.getTotalPrice(), 0.01, "Общая стоимость должна быть 15.0 после добавления товара");
    }

    @Test
    @DisplayName("Тест на несколько операций добавления и очистки корзины")
    void testAddAndEmptyCartMultipleTimes() {
        cart.addItem(10.0);
        cart.addItem(20.0);
        cart.empty();
        assertEquals(0, cart.getItemCount(), "Количество товаров должно быть 0 после первой очистки");
        assertEquals(0.0, cart.getTotalPrice(), 0.01, "Общая стоимость должна быть 0.0 после первой очистки");

        cart.addItem(30.0);
        cart.empty();
        assertEquals(0, cart.getItemCount(), "Количество товаров должно быть 0 после второй очистки");
        assertEquals(0.0, cart.getTotalPrice(), 0.01, "Общая стоимость должна быть 0.0 после второй очистки");
    }

    @Test
    @DisplayName("Тест добавления большого количества товаров")
    void testAddManyItems() {
        for (int i = 0; i < 1000; i++) {
            cart.addItem(10.0);
        }
        assertEquals(1000, cart.getItemCount(), "Количество товаров должно быть 1000");
        assertEquals(10000.0, cart.getTotalPrice(), 0.01, "Общая стоимость должна быть 10000.0");
    }

    @Test
    @DisplayName("Тест добавления товара с очень большой стоимостью")
    void testAddItemWithHugePrice() {
        cart.addItem(Double.MAX_VALUE + 1);
//        assertTrue(Double.isFinite(cart.getTotalPrice()), "Общая стоимость должна быть бесконечностью");
        assertNotEquals(Double.POSITIVE_INFINITY, cart.getTotalPrice(), "Общая стоимость не должна быть бесконечностью");
    }

}