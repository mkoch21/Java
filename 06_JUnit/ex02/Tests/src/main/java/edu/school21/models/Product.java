package edu.school21.models;

import java.util.Objects;

public class Product {
    private Long id;

    private String name;

    private Integer price;

    public Product(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Negative price! Set to 0");
            this.price = 0;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Negative price! Set to 0");
            this.price = 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
