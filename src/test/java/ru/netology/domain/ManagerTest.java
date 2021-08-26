package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTest {

    ProductRepository productRepository = new ProductRepository();
    Manager manager = new Manager(productRepository);
    private Book coreJava = new Book(1, "coreJava", 100, "Developers");
    private Book someBook = new Book(2, "someBook", 300, "Someone");
    private Smartphone iPhone10 = new Smartphone(3, "iPhone10", 70_000, "Apple");
    private Smartphone samsung10 = new Smartphone(4, "samsung10", 50_000, "Samsung");


    @BeforeEach
    public void setUp() {
        manager.add(coreJava);
        manager.add(someBook);
        manager.add(iPhone10);
        manager.add(samsung10);
    }

    @Test
    public void shouldAddItemsInRepository() {
        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{coreJava, someBook, iPhone10, samsung10};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookByName() {
        Product[] actual = manager.searchBy("coreJava");
        Product[] expected = new Product[]{coreJava};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByName() {
        Product[] actual = manager.searchBy("iPhone10");
        Product[] expected = new Product[]{iPhone10};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        Product[] actual = manager.searchBy("Developers");
        Product[] expected = new Product[]{coreJava};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturer() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{iPhone10};
        assertArrayEquals(expected, actual);
    }

}
