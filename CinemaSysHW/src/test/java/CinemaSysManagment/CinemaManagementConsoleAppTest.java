package CinemaSysManagment;

import CinemaSysManagment.dao.ICinemaHall;
import CinemaSysManagment.dao.ICustomer;
import CinemaSysManagment.dao.IFilm;
import CinemaSysManagment.impl.ProductManagement;
import CinemaSysManagment.impl.SessionManagement;
import CinemaSysManagment.model.*;
import CinemaSysManagment.role.AdminMenu;
import CinemaSysManagment.role.ClientMenu;
import CinemaSysManagment.role.EmployeeMenu;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CinemaManagementConsoleAppTest {
    private final InputStream systemIn = System.in;
    private final AdminMenu adminMenu = new AdminMenu();
    Employee employee = new Employee("employeeName", "employeePassword", "employeePosition", "employeeFirstName", "employeeLastName", "employeeContactInfo");
    EmployeeMenu employeeMenu = new EmployeeMenu(employee);
    ICustomer customer = new Customer("clientName", "clientPassword");
    ClientMenu clientMenu = new ClientMenu(customer);
    private SessionManagement sessionManagement;
    private List<Session> sessions;
    private List<Film> films;
    private List<CinemaHall> cinemaHalls;
    private ProductManagement productManagement;
    private final List<Product> products = new ArrayList<>();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeAll
    public static void setUp() {
    }

    @AfterAll
    public static void tearDown() {
    }

    @BeforeEach
    public void setInput() {
        System.setIn(systemIn);
        sessions = new ArrayList<>();
        films = new ArrayList<>();
        cinemaHalls = new ArrayList<>();
        sessionManagement = new SessionManagement(sessions, films, cinemaHalls);
        productManagement = new ProductManagement(products);
        System.setOut(new PrintStream(outContent));
    }
    @Test
    @DisplayName("Тестирование аутентификации администратора")
    public void testAdminAuthentication() {
        String input = "\nadmin\nadmin\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertTrue(adminMenu.authenticate());
    }

    @Test
    @DisplayName("Тестирование аутентификации сотрудника")
    public void testEmployeeAuthentication() {
        String input = "\nemployee\nemployee\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertTrue(employeeMenu.authenticate());
    }

    @Test
    @DisplayName("Тестирование аутентификации клиента")
    public void testClientAuthentication() {
        String input = "\nclient\nclient\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertTrue(clientMenu.authenticate());
    }
    @ParameterizedTest
    @DisplayName("Аутентификация разных ролей")
    @ValueSource(strings = {"admin", "employee", "client"})
    public void testAuthentication(String role) {
        String input = "\n" + role + "\n" + role + "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        if (role.equals("admin")) {
            assertTrue(adminMenu.authenticate());
        } else if (role.equals("employee")) {
            assertTrue(employeeMenu.authenticate());
        } else if (role.equals("client")) {
            assertTrue(clientMenu.authenticate());
        }
    }
    @Test
    @DisplayName("Получение списка сеансов")
    public void testGetSessions() {
        assertEquals(sessions, sessionManagement.getSessions());
    }

    @Test
    @DisplayName("Установка списка сеансов")
    public void testSetSessions() {
        List<Session> newSessions = new ArrayList<>();
        sessionManagement.setSessions(newSessions);
        assertEquals(newSessions, sessionManagement.getSessions());
    }

    @Test
    @DisplayName("Добавление сеанса")
    public void testAddSession() {
        Film film1 = new Film("Фильм 1");
        Film film2 = new Film("Фильм 2");
        films.add(film1);
        films.add(film2);

        CinemaHall cinemaHall1 = new CinemaHall(1);
        CinemaHall cinemaHall2 = new CinemaHall(2);
        cinemaHalls.add(cinemaHall1);
        cinemaHalls.add(cinemaHall2);

        String input = "1\n2\n1\n15:00\n17:00\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        sessionManagement.addSession(sessionManagement.getAvailableFilms(), sessionManagement.getAvailableCinemaHalls());

        List<Session> sessions = sessionManagement.getSessions();
        assertEquals(1, sessions.size());

        Session addedSession = sessions.get(0);
        assertEquals(film1, addedSession.getFilm());
        assertEquals(cinemaHall2, addedSession.getCinemaHall());

        List<IFilm> availableFilms = sessionManagement.getAvailableFilms();
        assertTrue(availableFilms.contains(film1));
        List<ICinemaHall> availableCinemaHalls = sessionManagement.getAvailableCinemaHalls();
        assertTrue(availableCinemaHalls.contains(cinemaHall2));
    }


    @Test
    @DisplayName("Удаление сеанса")
    public void testDeleteSession() {
        Session session = new Session(new Film("Film1"), new CinemaHall(1), "15:00", "17:00");
        sessionManagement.getSessions().add(session);
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        sessionManagement.deleteSession();
        assertTrue(sessionManagement.getSessions().isEmpty());
    }

    @Test
    @DisplayName("Редактирование сеанса")
    public void testEditSession() {
        Session session = new Session(new Film("Film1"), new CinemaHall(1), "15:00", "17:00");
        sessionManagement.getSessions().add(session);
        String input = "1\n3\n14:00\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        sessionManagement.editSession();
        Session editedSession = sessionManagement.getSessions().get(0);
        assertEquals("14:00", editedSession.getStartTime());
    }

    @Test
    @DisplayName("Добавление продукта")
    public void testAddProduct() {
        String input = "Test Product\n10,9\nTest Description\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        productManagement.addProduct();

        List<Product> productList = productManagement.getProducts();
        assertEquals(1, productList.size());

        Product addedProduct = productList.get(0);
        assertEquals("Test Product", addedProduct.getName());
        assertEquals(10.9, addedProduct.getPrice(), 0.001);
        assertEquals("Test Description", addedProduct.getDescription());
        assertEquals(5, addedProduct.getStockQuantity());
    }

    @Test
    @DisplayName("Удаление продукта")
    public void testDeleteProduct() {

        products.add(new Product("Product1", 9.99, "Description1", 3));
        products.add(new Product("Product2", 14.99, "Description2", 2));

        String input = "2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        productManagement.deleteProduct();

        List<Product> productList = productManagement.getProducts();
        assertEquals(1, productList.size());

        String expectedOutput = "Введите номер продукта для удаления: Продукт 'Product2' успешно удален."
                + System.lineSeparator();

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Редактирование названия продукта")
    public void testEditProductName() {
        products.add(new Product("Product1", 9.99, "Description1", 3));

        String input = "1\n1\nNewName\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        productManagement.editProduct();

        List<Product> productList = productManagement.getProducts();
        assertEquals(1, productList.size());

        Product editedProduct = productList.get(0);
        assertEquals("NewName", editedProduct.getName());
        assertEquals(9.99, editedProduct.getPrice(), 0.001);
        assertEquals("Description1", editedProduct.getDescription());
        assertEquals(3, editedProduct.getStockQuantity());
    }

    @Test
    @DisplayName("Редактирование цены продукта")
    public void testEditProductPrice() {
        products.add(new Product("Product1", 9.99, "Description1", 3));

        String input = "2\n15.99\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        productManagement.editProduct();

        List<Product> productList = productManagement.getProducts();
        assertEquals(1, productList.size());

        Product editedProduct = productList.get(0);
        assertEquals("Product1", editedProduct.getName());
        assertEquals(9.99, editedProduct.getPrice(), 0.001);
        assertEquals("Description1", editedProduct.getDescription());
        assertEquals(3, editedProduct.getStockQuantity());
    }

    @Test
    @DisplayName("Редактирование описания продукта")
    public void testEditProductDescription() {
        products.add(new Product("Product1", 9.99, "Description1", 3));

        String input = "1\n3\nNew Description\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        productManagement.editProduct();

        List<Product> productList = productManagement.getProducts();
        assertEquals(1, productList.size());

        Product editedProduct = productList.get(0);
        assertEquals("Product1", editedProduct.getName());
        assertEquals(9.99, editedProduct.getPrice(), 0.001);
        assertEquals("New Description", editedProduct.getDescription());
        assertEquals(3, editedProduct.getStockQuantity());
    }

    @Test
    @DisplayName("Редактирование количества на складе продукта")
    public void testEditProductStockQuantity() {
        products.add(new Product("Product1", 9.99, "Description1", 3));

        String input = "1\n4\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        productManagement.editProduct();

        List<Product> productList = productManagement.getProducts();
        assertEquals(1, productList.size());

        Product editedProduct = productList.get(0);
        assertEquals("Product1", editedProduct.getName());
        assertEquals(9.99, editedProduct.getPrice(), 0.001);
        assertEquals("Description1", editedProduct.getDescription());
        assertEquals(5, editedProduct.getStockQuantity());
    }

    @Test
    @DisplayName("Просмотр всех продуктов")
    public void testViewAllProducts() {
        products.add(new Product("Product1", 9.99, "Description1", 3));
        products.add(new Product("Product2", 14.99, "Description2", 2));

        productManagement.viewAllProducts();

        String expectedOutput = "Список всех продуктов:" + System.lineSeparator() +
                "1. Product1 - Цена: 9.99 - Наличие: 3" + System.lineSeparator() +
                "2. Product2 - Цена: 14.99 - Наличие: 2" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

}
