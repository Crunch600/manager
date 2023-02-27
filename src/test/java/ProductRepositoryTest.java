import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Product product1 = new Book(1, "Сила подсознания", 1_000, "Джо Диспенза");
    Product product2 = new Smartphone(34, "Iphone 18", 30_000, "China");
    Product product3 = new Book(56, "Java explodes the brain", 1_500, "Филипп Воронов");
    Product product4 = new Smartphone(89, "Samsung", 20_000, "China");

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
    public void shouldRemoveId() {

        repo.removeToID(product2.getId());

        Product[] expected = {product1, product3, product4};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

}
