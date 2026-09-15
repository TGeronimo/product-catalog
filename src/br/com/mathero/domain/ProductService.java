package br.com.mathero.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductService implements ProductCatalog {

    Set<Product> productSet = new HashSet<>();
    Map<String, Product> categorizedProducts = new HashMap<>();

    @Override
    public Product add(Product product) {
        productSet.add(product);
        return product;
    }

    @Override
    public Product removeById(int id) {
        return null;
    }

    @Override
    public boolean findById(int id) {
        return false;
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public List<ElectronicProduct> findAllElectronics() {
        return List.of();
    }

    @Override
    public Map<String, Product> addTag(String category, Product product) {
        return Map.of();
    }
}
