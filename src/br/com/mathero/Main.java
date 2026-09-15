package br.com.mathero;

import br.com.mathero.domain.ElectronicProduct;
import br.com.mathero.domain.FoodProduct;
import br.com.mathero.domain.Product;
import br.com.mathero.domain.ProductService;

public class Main {
    public static void main(String[] args) {

        ElectronicProduct eleProd1 = new ElectronicProduct("Notebook", 3500);
        ProductService productService = new ProductService();

        productService.add(eleProd1);

        testAddProduct();


    }

    public static void testAddProduct() {
        ProductService productService = new ProductService();
        Product product = new FoodProduct("Beterraba", 12.50);
        System.out.println(productService.add(product));
    }
}
