package CinemaSysManagment;

import CinemaSysManagment.dao.ICinemaHall;
import CinemaSysManagment.dao.ICustomer;
import CinemaSysManagment.dao.IEmployee;
import CinemaSysManagment.dao.IFilm;
import CinemaSysManagment.impl.*;
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

import static org.junit.jupiter.api.Assertions.*;

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
    private HallManagement hallManagement;
    private List<CinemaHall> halls;
    private FilmManagement filmManagement;
    private EmployeeManagement employeeManagement;
    private List<IEmployee> employees;

    @BeforeAll
    public static void setUp() {
    }

    @AfterAll
    public static void tearDown() {
    }

    @BeforeEach
    public void setInput() {
        System.setIn(systemIn);
        System.setOut(new PrintStream(outContent));
        sessions = new ArrayList<>();
        films = new ArrayList<>();
        cinemaHalls = new ArrayList<>();
        sessionManagement = new SessionManagement(sessions, films, cinemaHalls);
        productManagement = new ProductManagement(products);
        halls = new ArrayList<>();
        hallManagement = new HallManagement(halls);
        filmManagement = new FilmManagement(films);
        employees = new ArrayList<>();
        employeeManagement = new EmployeeManagement(employees);
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
    @Test
    @DisplayName("Тест на добавление зала")
    public void testAddHall() {
        HallManagement hallManagement = new HallManagement(new ArrayList<>());

        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n100\n1\n".getBytes());
        System.setIn(inputStream);

        hallManagement.addHall();

        List<CinemaHall> halls = hallManagement.getHalls();
        assertEquals(1, halls.size());

        CinemaHall addedHall = halls.get(0);
        assertEquals(1, addedHall.getHallNumber());
        assertEquals(100, addedHall.getCapacity());
        assertEquals(CinemaHall.HallType._2D, addedHall.getHallType());
    }

    @Test
    @DisplayName("Тест на удаление зала")
    public void testDeleteHall() {
        CinemaHall hall1 = new CinemaHall(1, 100, CinemaHall.HallType._2D);
        CinemaHall hall2 = new CinemaHall(2, 150, CinemaHall.HallType._3D);

        List<CinemaHall> halls = new ArrayList<>();
        halls.add(hall1);
        halls.add(hall2);

        HallManagement hallManagement = new HallManagement(halls);

        ByteArrayInputStream inputStream = new ByteArrayInputStream("2\n1\n".getBytes());
        System.setIn(inputStream);

        hallManagement.deleteHall();

        List<CinemaHall> remainingHalls = hallManagement.getHalls();
        assertEquals(1, remainingHalls.size());
        assertTrue(remainingHalls.contains(hall1));
        assertFalse(remainingHalls.contains(hall2));
    }
    @Test
    @DisplayName("Тест на просмотр всех залов")
    public void testViewAllHalls() {
        CinemaHall hall1 = new CinemaHall(1, 100, CinemaHall.HallType._2D);
        CinemaHall hall2 = new CinemaHall(2, 150, CinemaHall.HallType._3D);

        List<CinemaHall> halls = new ArrayList<>();
        halls.add(hall1);
        halls.add(hall2);

        HallManagement hallManagement = new HallManagement(halls);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        hallManagement.viewAllHalls();

        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains("Зал №1"));
        assertTrue(consoleOutput.contains("Зал №2"));
        assertTrue(consoleOutput.contains("Вместимость: 100 человек"));
        assertTrue(consoleOutput.contains("Вместимость: 150 человек"));
    }
    @Test
    @DisplayName("Тест на добавление фильма")
    public void testAddFilm() {
        FilmManagement filmManagement = new FilmManagement(new ArrayList<>());

        ByteArrayInputStream inputStream = new ByteArrayInputStream("Film1\n120\nAction\nPG-18\nAction movie\nEnglish\n".getBytes());
        System.setIn(inputStream);

        filmManagement.addFilm();

        List<Film> films = filmManagement.getFilms();
        assertEquals(1, films.size());

        Film addedFilm = films.get(0);
        assertEquals("Film1", addedFilm.getName());
        assertEquals(120, addedFilm.getDuration());
        assertEquals("Action", addedFilm.getGenre());
        assertEquals("PG-18", addedFilm.getRating());
        assertEquals("Action movie", addedFilm.getDescription());
        assertEquals("English", addedFilm.getLanguage());
    }

    @Test
    @DisplayName("Тест на удаление фильма")
    public void testDeleteFilm() {
        Film film1 = new Film("Film1", 120, "Action", "PG-13", "Action movie", "English");
        Film film2 = new Film("Film2", 90, "Comedy", "PG", "Comedy movie", "Russian");

        List<Film> films = new ArrayList<>();
        films.add(film1);
        films.add(film2);

        FilmManagement filmManagement = new FilmManagement(films);

        ByteArrayInputStream inputStream = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(inputStream);

        filmManagement.deleteFilm();

        List<Film> remainingFilms = filmManagement.getFilms();
        assertEquals(1, remainingFilms.size());
        assertFalse(remainingFilms.contains(film2));
        assertTrue(remainingFilms.contains(film1));
    }

    @Test
    @DisplayName("Тест на просмотр всех фильмов")
    public void testViewAllFilms() {
        Film film1 = new Film("Film1", 120, "Action", "PG-13", "Action movie", "English");
        Film film2 = new Film("Film2", 90, "Comedy", "PG", "Comedy", "Russian");

        List<Film> films = new ArrayList<>();
        films.add(film1);
        films.add(film2);

        FilmManagement filmManagement = new FilmManagement(films);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        filmManagement.viewAllFilms();

        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains("Фильм #1"));
        assertTrue(consoleOutput.contains("Фильм #2"));
        assertTrue(consoleOutput.contains("Название: Film1"));
        assertTrue(consoleOutput.contains("Название: Film2"));
        assertTrue(consoleOutput.contains("Продолжительность: 120 минут"));
        assertTrue(consoleOutput.contains("Продолжительность: 90 минут"));
        assertTrue(consoleOutput.contains("Жанр: Action"));
        assertTrue(consoleOutput.contains("Жанр: Comedy"));
    }
    @Test
    @DisplayName("Тест на добавление сотрудника")
    public void testAddEmployee() {
        EmployeeManagement employeeManagement = new EmployeeManagement(new ArrayList<>());

        ByteArrayInputStream inputStream = new ByteArrayInputStream("Tony\nStark\nironman@avengers.com\nGenius Billionaire Playboy Philanthropist\nironman\njarvis123\n".getBytes());
        System.setIn(inputStream);

        employeeManagement.addEmployee();

        List<IEmployee> employees = employeeManagement.getEmployees();
        assertEquals(1, employees.size());

        IEmployee addedEmployee = employees.get(0);
        assertEquals("Tony", addedEmployee.getFirstName());
        assertEquals("Stark", addedEmployee.getLastName());
        assertEquals("ironman@avengers.com", addedEmployee.getContactInfo());
        assertEquals("Genius Billionaire Playboy Philanthropist", addedEmployee.getPosition());
        assertEquals("ironman", addedEmployee.getUsername());
        assertEquals("jarvis123", addedEmployee.getPassword());
    }

    @Test
    @DisplayName("Тест на удаление сотрудника")
    public void testDeleteEmployee() {
        IEmployee employee1 = new Employee("user1", "password1", "Genius Billionaire Playboy Philanthropist", "Tony", "Stark", "ironman@avengers.com");
        IEmployee employee2 = new Employee("user2", "password2", "Super Soldier", "Steve", "Rogers", "cap@avengers.com");

        List<IEmployee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        EmployeeManagement employeeManagement = new EmployeeManagement(employees);

        ByteArrayInputStream inputStream = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(inputStream);

        employeeManagement.deleteEmployee();

        List<IEmployee> remainingEmployees = employeeManagement.getEmployees();
        assertEquals(1, remainingEmployees.size());
        assertFalse(remainingEmployees.contains(employee2));
        assertTrue(remainingEmployees.contains(employee1));
    }

    @Test
    @DisplayName("Тест на просмотр всех сотрудников")
    public void testViewEmployees() {
        IEmployee employee1 = new Employee("user1", "password1", "Genius Billionaire Playboy Philanthropist", "Tony", "Stark", "ironman@avengers.com");
        IEmployee employee2 = new Employee("user2", "password2", "Super Soldier", "Steve", "Rogers", "cap@avengers.com");

        List<IEmployee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        EmployeeManagement employeeManagement = new EmployeeManagement(employees);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        employeeManagement.viewEmployees();

        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains("1. Tony Stark (Genius Billionaire Playboy Philanthropist)"));
        assertTrue(consoleOutput.contains("2. Steve Rogers (Super Soldier)"));
    }

}