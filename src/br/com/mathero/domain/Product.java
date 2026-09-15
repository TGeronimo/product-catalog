package br.com.mathero.domain;

import java.util.UUID;

public class Product {
    private final UUID id;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Como optei por utilizar um UUID aleatório como "ID" do produto
     * o hashcode depende apenas do nome do produto.
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Product product)
                && (this.id.equals(product.id));
    }

    @Override
    public String toString() {
        return "{ " +
                    "id: " + id + "," +
                    " name: " + name + "," +
                    " price: " + price +
                " }";
    }

}
