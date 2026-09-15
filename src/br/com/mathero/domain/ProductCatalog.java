package br.com.mathero.domain;

import java.util.List;
import java.util.Map;

public interface ProductCatalog {

    Product add(Product product);

    Product removeById(int id);

    boolean findById(int id);

    List<Product> findAll();

    List<ElectronicProduct> findAllElectronics();

    Map<String, Product> addTag(String category, Product product);
}
