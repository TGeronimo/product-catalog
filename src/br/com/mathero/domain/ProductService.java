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

    public Set<Product> getProductSet() {
        return productSet;
    }

    @Override
    public Optional<Product> add(Product product) {
        if (productSet.add(product)) {
            System.out.println("Produto cadastrado com sucesso!");
            return Optional.of(product);
        } else {
            System.out.println("ERRO: Produto já cadastrado.");
            return Optional.empty();
        }
    }

    @Override
    public boolean removeById(UUID id) {
        boolean result =  productSet.removeIf(p -> p.getId().equals(id));
        System.out.println("Produto removido!");
        return result;
    }

    public boolean findByName(Product product) {
        return productSet.stream()
                .anyMatch(p -> p.getName().equals(product.getName()));
    }
    @Override
    public Optional<Product> findById(UUID id) {
        return productSet.stream().filter(p -> p.getId() == id).findAny();

    }

    @Override
    public boolean checkById(UUID id) {
        return productSet.stream()
                .anyMatch(p -> p.getId() == id);
    }

    @Override
    public Set<Product> findAll() {
        return productSet;
    }

    @Override // TODO
    public List<ElectronicProduct> findAllElectronics() {
        return List.of();
    }

    @Override //TODO
    public Map<String, Product> addTag(String category, Product product) {
        return Map.of();
    }
}
