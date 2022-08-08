package edu.school21.repositories;

import edu.school21.models.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository{
    private DataSource dataSource;

    public ProductsRepositoryJdbcImpl (DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> findAll() throws SQLException{
        List<Product> products = new ArrayList<>();

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM product");

        while (resultSet.next()) {
            products.add(new Product(
                    resultSet.getLong(1),
                    resultSet.getString(2),
                    resultSet.getInt(3)
            ));
        }

        statement.close();
        connection.close();
        return products;
    }

    public Optional<Product> findById(Long id) throws SQLException {

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(" SELECT * FROM product WHERE id = " + id + " ;");

        resultSet.next();

        Product product = new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getInt(3));

        statement.close();
        connection.close();
        return Optional.of(product);
    }

    public void update(Product product) throws SQLException {

        String str = "UPDATE product SET name = \'" + product.getName() + "\', price = " + product.getPrice() + " WHERE id = " + product.getId();

        Connection connection = dataSource.getConnection();

        PreparedStatement statement = connection.prepareStatement(str);

        statement.execute();
        statement.close();
        connection.close();
    }

    public void save(Product product) throws SQLException {
        String str = "INSERT INTO product (id, name, price) VALUES (" + product.getId() + ", \'" + product.getName() + "\', " + product.getPrice() + ");";

        Connection connection = dataSource.getConnection();

        PreparedStatement statement = connection.prepareStatement(str);

        statement.execute();
        statement.close();
        connection.close();
    }

    public void delete (Long id) throws SQLException {
        String str = "DELETE FROM product WHERE id = " + id + ";";

        Connection connection = dataSource.getConnection();

        PreparedStatement statement = connection.prepareStatement(str);

        statement.execute();
        statement.close();
        connection.close();
    }

}
