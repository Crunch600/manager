package ru.netology.qa54.manager.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.qa54.manager.domain.Book;
import ru.netology.qa54.manager.domain.Product;
import ru.netology.qa54.manager.domain.Smartphone;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Product product1 = new Book(1, "Сила подсознания", 1_000, "Джо Диспенза");
    Product product2 = new Smartphone(34, "Iphone 18", 30_000, "China");
    Product product3 = new Book(56, "Java explodes the brain", 1_500, "Филипп Воронов");
    Product product4 = new Smartphone(89, "Samsung", 20_000, "China");
    Product product5 = new Smartphone(89, "LG", 24_000, "Japan");

    @BeforeEach
        void setup() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);

    }

   @Test

    public void shouldSaveProducts() {

       Product[] expected = {product1, product2, product3, product4};
       Product[] actual = repo.getProducts();
       Assertions.assertArrayEquals(expected, actual);
   }

    @Test
    public void shouldSaveAlreadyExistProducts() {


        Assertions.assertThrows(AlreadyExistException.class, () -> {repo.save(product5);});
    }

    @Test
    public void shouldRemoveId() {

        repo.removeToID(product2.getId());

        Product[] expected = {product1, product3, product4};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNotExistId() {


        Assertions.assertThrows(NotFoundException.class, () -> {repo.removeToID(500);});
    }


    @Test

    public void shouldFindId() {

        repo.findById(product3.getId());

        Product expected = product3;
        Product actual = repo.findById(56);
        Assertions.assertEquals(expected, actual);

    }

}
