package br.com.mathero.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public interface ProductCatalog {

    Product add(Product product);

    Product removeById(int id);

    Product findById(String id);

    boolean checkById(UUID id);

    Set<Product> findAll();

    List<ElectronicProduct> findAllElectronics();

    Map<String, Product> addTag(String category, Product product);
}
