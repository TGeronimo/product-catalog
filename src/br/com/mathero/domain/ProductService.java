package br.com.mathero.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class ProductService implements ProductCatalog {

    private Set<Product> productSet = new HashSet<>();
    private Map<String, Product> categorizedProducts = new HashMap<>();

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
    public Product findById(String id) {
        return new FoodProduct("asdf", 1); //TODO
    }

    @Override
    public boolean checkById(UUID id) {
        return productSet.stream().anyMatch((p) -> p.getId() == id);
    }

    @Override
    public Set<Product> findAll() {
        return productSet;
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
