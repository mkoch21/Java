package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.HSQL;

public class ProductsRepositoryJdbcImplTest {

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(1L, "apple", 10),
            new Product(2L, "orange", 20),
            new Product(3L, "apricot", 30),
            new Product(4L, "pear", 40),
            new Product(5L, "banana", 50),
            new Product(6L, "kiwi", 60)
    );

    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(2L, "orange", 20);

    final Product EXPECTED_UPDATED_PRODUCT = new Product(2L, "pineapple", 10);

    final Product EXPECTED_SAVED_PRODUCT = new Product(7L, "pineapple", 100);

    EmbeddedDatabase dataSource;
    ProductsRepository productsRepository;

    @BeforeEach
    void init() {
        dataSource = new EmbeddedDatabaseBuilder().setType(HSQL)
                .setName("product")
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        productsRepository = new ProductsRepositoryJdbcImpl(dataSource);
    }

    @Test
    void findAllTest() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, productsRepository.findAll());
    }

    @Test
    void findByIdTest() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, productsRepository.findById(2L).get());
    }

    @Test
    void updateTest() throws SQLException {
        productsRepository.update(EXPECTED_UPDATED_PRODUCT);
        Assertions.assertEquals(EXPECTED_UPDATED_PRODUCT, productsRepository.findById(2L).get());
    }

    @Test
    void saveTest() throws SQLException {
        productsRepository.save(EXPECTED_SAVED_PRODUCT);
        Assertions.assertEquals(EXPECTED_SAVED_PRODUCT, productsRepository.findById(7L).get());
    }

    @Test
    void deleteTest() throws SQLException {
        productsRepository.delete(1L);
        Assertions.assertThrows(SQLException.class, () -> productsRepository.findById(1L));
    }

    @AfterEach
    void close() {dataSource.shutdown();};

}