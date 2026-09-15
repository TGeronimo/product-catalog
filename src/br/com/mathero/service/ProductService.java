package br.com.mathero.service;

import br.com.mathero.domain.ElectronicProduct;
import br.com.mathero.domain.FoodProduct;
import br.com.mathero.domain.Product;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Implementação da interface ProductCalatog.
 */
public class ProductService implements ProductCatalog {

    /**
     * O armazenamento principal dos produtos criados será
     * num Map.
     */
    private Map<UUID, Product> productMap = new HashMap<>();
    /**
     * Decidi criar um Map para o armazenamento categorizado
     * dos produtos. Então, posso armazenar um Product como chave
     * e o valor será a tag para o tipo de produto.
     */
    private Map<Product, String> categorizedProducts = new HashMap<>();

    public Set<Product> getProductSet() {
        return new HashSet<>(productMap.values());
    }

    public Map<Product, String> getCategorizedProducts() {
        return new HashMap<>(categorizedProducts);
    }

    @Override
    public Product add(Product product) {
        return productMap.put(product.getId(), product);
    }

    /**
     * Utilizei a variável local result para poder mostrar a mensagem
     * confirmando a operação.
     *
     * @param id recebe a identificação do produto.
     * @return se a operação de exclusão teve sucesso com um boolean
     */
    @Override
    public boolean removeById(UUID id) {
        if (productMap.remove(id) != null) {
            System.out.println("Produto removido!");
            return true;
        }

        System.out.println("Produto não encontrado.");
        return false;
    }

    @Override
    public Product findById(UUID id) {
        return productMap.get(id);
    }

    @Override
    public boolean checkById(UUID id) {
        return productMap.containsKey(id);
    }

    @Override
    public List<Product> findAll() {
        return productMap.values().stream().toList();
    }

    /**
     * Cria um Set a partir do Map de produtos categorizados,
     * filtra usando o valor de "produtos eletrônicos", mapeia
     * esse conjunto para retornar somente a chave, ou seja,
     * os produtos e envia para uma lista.
     *
     * @return uma lista de Produtos. Embora o retorno sejá genérico
     * com Product, o filtro aplicado garante que teremos somente produtos
     * eletrônicos.
     */
    @Override
    public List<Product> findAllElectronics() {
        return categorizedProducts.entrySet().stream()
                .filter(v -> v.getValue().equals("produtos eletrônicos"))
                .map(Map.Entry::getKey)
                .toList();
    }

    /**
     * Permite associar uma categoria textual a um produto.
     *
     * @param product a ser categorizado.
     * @return um mapa tendo o produto como chave e a categoria como valor.
     * Essa decisão foi tomada, pois usar a tag como chave impediria a
     * adição de mais de um produto por categoria.
     */
    @Override
    public Map<Product, String> addTag(Product product) {
        var tagElectronic = "produtos eletrônicos";
        var tagFood = "produtos alimentícios";

        if (product instanceof ElectronicProduct) categorizedProducts.put(product, tagElectronic);
        if (product instanceof FoodProduct) categorizedProducts.put(product, tagFood);

        return new HashMap<>(categorizedProducts);
    }
}
