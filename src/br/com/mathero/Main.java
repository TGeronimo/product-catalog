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

//        productService.add(eleProd1);
//        testAddProduct(productService);
//        testFindAllProducts();
//        testCheckById();
//        testFindById();
//        testFindByName();
//        testRemoveById(productService);
        testAddTag(productService);
    }

    public static void testAddProduct(ProductService productService) {
        Product product = new FoodProduct("Beterraba", 12.50);
        Product duplicatedProduct = new FoodProduct("Beterraba", 12.50);

        productService.add(product);
        productService.add(duplicatedProduct);
        System.out.println(productService.getProductSet());

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
        Product duplicatedProduct = new FoodProduct("Beterraba", 12.50);

        productService.add(product);
        productService.add(product2);
        productService.add(product3);
        productService.add(duplicatedProduct);


        System.out.println(productService.findById(duplicatedProduct.getId()));
        System.out.println(productService.findById(UUID.randomUUID()));
    }

    public static void testFindByName() {
        ProductService productService = new ProductService();
        Product product = new FoodProduct("Beterraba", 12.50);
        Product product2 = new FoodProduct("Aspargos", 27.00);
        Product product3 = new ElectronicProduct("Smartphone", 2700.00);

        productService.add(product);
        productService.add(product2);
        productService.add(product3);

        System.out.println(productService.findByName(product));
        System.out.println(productService.findByName(product2));
        System.out.println(productService.findByName(product3));
        System.out.println(productService.getProductSet());
    }

    public static void testRemoveById(ProductService productService) {
        Product product = new FoodProduct("Beterraba", 12.50);
        productService.add(product);
        System.out.println(productService.getProductSet());
        productService.removeById(product.getId());
        System.out.println(productService.getProductSet());
    }

    public static void testAddTag(ProductService ps) {
        Product food1 = new FoodProduct("Aspargos", 29.50);
        Product food2 = new FoodProduct("Batata-doce", 12.00);
        Product elec1 = new ElectronicProduct("Smartphone Moto Edge 50 Neo", 2700.00);
        Product elec2 = new ElectronicProduct("Notebook HP Probook 440 G11", 5200.00);
        ps.add(food1);
        ps.add(food2);
        ps.add(elec1);
        ps.add(elec2);
        System.out.println(ps.getProductSet());

        ps.addTag(food1);
        ps.addTag(food2);
        ps.addTag(elec1);
        ps.addTag(elec2);
        System.out.println(ps.getCategorizedProducts());

    }
}
