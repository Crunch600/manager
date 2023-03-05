package ru.netology.qa54.manager.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.qa54.manager.domain.Book;
import ru.netology.qa54.manager.domain.Product;
import ru.netology.qa54.manager.domain.Smartphone;
import ru.netology.qa54.manager.repository.ProductRepository;


public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product product1 = new Book(1, "Сила подсознания", 1_000, "Джо Диспенза");
    Product product2 = new Smartphone(34, "Iphone 18", 30_000, "China");
    Product product3 = new Book(56, "Java explodes the brain", 1_500, "Филипп Воронов");
    Product product4 = new Smartphone(89, "Samsung 18", 20_000, "China");
    Product product5 = new Smartphone(8, "Samsung 3", 60_000, "China");

    @BeforeEach
    void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
    }

    @Test

    public void shouldAllProducts() {

        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchOneProduct() {

        Product[] expected = {product1};
        Product[] actual = manager.searchBy("Сила подсознания");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchTwoProduct() {

        Product[] expected = {product4, product5};
        Product[] actual = manager.searchBy("Samsung");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test

    public void shouldSearchSomeProduct() {

        Product[] expected = {product4, product5};
        Product[] actual = manager.searchBy("Samsung");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNoSearchProduct() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Honor");

        Assertions.assertArrayEquals(expected, actual);
    }

}
