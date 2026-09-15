package br.com.mathero.domain;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ProductCatalog {

    Optional<Product> add(Product product);

    boolean removeById(UUID id);

    Optional<Product> findById(UUID id);

    boolean checkById(UUID id);

    Set<Product> findAll();

    List<ElectronicProduct> findAllElectronics();

    Map<Product, String> addTag(Product product);
}
