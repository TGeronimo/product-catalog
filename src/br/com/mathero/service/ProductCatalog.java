package br.com.mathero.service;

import br.com.mathero.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Decidi por criar a interface para estabelecer o contrato para os requisitos
 * que o professor pediu.
 */
public interface ProductCatalog {

    Product add(Product product);

    boolean removeById(UUID id);

    Product findById(UUID id);

    boolean checkById(UUID id);

    List<Product> findAll();

    List<Product> findAllElectronics();

    void addTag(Product product);
}
