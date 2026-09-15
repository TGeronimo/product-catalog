package br.com.mathero;

import br.com.mathero.domain.ElectronicProduct;
import br.com.mathero.domain.FoodProduct;
import br.com.mathero.domain.Product;
import br.com.mathero.domain.ProductService;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        ElectronicProduct eleProd1 = new ElectronicProduct("Notebook", 3500);
        ProductService productService = new ProductService();

        productService.add(eleProd1);

//        testAddProduct();
//        testFindAllProducts();
        testCheckById();
        testFindById();

    }

    public static void testAddProduct() {
        ProductService productService = new ProductService();
        Product product = new FoodProduct("Beterraba", 12.50);
        System.out.println(productService.add(product));
    }

    public static void testFindAllProducts() {
        ProductService productService = new ProductService();
        Product product = new FoodProduct("Beterraba", 12.50);
        Product product2 = new FoodProduct("Aspargos", 27.00);
        Product product3 = new ElectronicProduct("Smartphone", 2700.00);

        productService.add(product);
        productService.add(product2);
        productService.add(product3);

        System.out.println(productService.findAll());

    }

    public static void testCheckById() {
        ProductService productService = new ProductService();
        Product product = new FoodProduct("Beterraba", 12.50);
        Product product2 = new FoodProduct("Aspargos", 27.00);
        Product product3 = new ElectronicProduct("Smartphone", 2700.00);

        productService.add(product);
        productService.add(product2);
        productService.add(product3);

        System.out.println(productService.checkById(product3.getId()));
        System.out.println(productService.checkById(UUID.randomUUID()));
    }

    public static void testFindById() {
        ProductService productService = new ProductService();
        Product product = new FoodProduct("Beterraba", 12.50);
        Product product2 = new FoodProduct("Aspargos", 27.00);
        Product product3 = new ElectronicProduct("Smartphone", 2700.00);

        productService.add(product);
        productService.add(product2);
        productService.add(product3);

        System.out.println(productService.findById(product2.getId()));
        System.out.println(productService.findById(UUID.randomUUID()));
    }
}
