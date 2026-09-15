package br.com.mathero.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class ProductService implements ProductCatalog {

    private Set<Product> productSet = new HashSet<>();
    private Map<String, Product> categorizedProducts = new HashMap<>();

    @Override
    public Optional<Product> add(Product product) {
        if (checkById(product.getId())) {
            productSet.add(product);
            return Optional.of(product);
        } else return Optional.empty();
    }

    @Override
    public Product removeById(int id) {
        return null;
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return productSet.stream().filter((p) -> p.getId() == id).findAny();

    }

    @Override
    public boolean checkById(UUID id) {
        return productSet.stream()
                .anyMatch((p) -> p.getId() == id);
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
