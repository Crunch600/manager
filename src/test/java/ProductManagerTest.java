/*import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product product1 = new Book(1, "Сила подсознания", 1_000, "Джо Диспенза");
    Product product2 = new Smartphone(34, "Iphone 18", 30_000, "China");
    Product product3 = new Book(56, "Java explodes the brain", 1_500, "Филипп Воронов");
    Product product4 = new Smartphone(89, "Samsung", 20_000, "China");

    @BeforeEach
    void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
    }

    @Test

    public void shouldAllProducts() {
        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearch() {

        Product[] expected = {product1};
        Product[] actual = manager.searchBy("под");

        Assertions.assertArrayEquals(expected, actual);
    }



}*/
