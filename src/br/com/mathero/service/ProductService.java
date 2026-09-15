package br.com.mathero.service;

import br.com.mathero.domain.ElectronicProduct;
import br.com.mathero.domain.FoodProduct;
import br.com.mathero.domain.Product;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Implementação da interface ProductCalatog.
 */
public class ProductService implements ProductCatalog {

    /**
     * O armazenamento principal dos produtos criados será
     * num Set. Escolhi Set porque não permite duplicatas.
     */
    private Set<Product> productSet = new HashSet<>();
    /**
     * Decidi criar um Map para o armazenamento categorizado
     * dos produtos. Então, posso armazenar um Product como chave
     * e o valor será a tag para o tipo de produto.
     */
    private Map<Product, String> categorizedProducts = new HashMap<>();

    public Set<Product> getProductSet() {
        return productSet;
    }

    public Map<Product, String> getCategorizedProducts() {
        return categorizedProducts;
    }

    /**
     * Utilizei o add() do Set como condicional para inserção
     * do produto, pois se o mesmo já estiver na coleção não
     * será inserido e retornará um boolean que sinaliza
     * o status. Fiz isso somente para poder retornar uma
     * mensagem para o cliente.
     *
     * @param product passa o produto a ser inserido no Set.
     * @return decidi por um Optional para poder retornar um
     * elemento vazio para sinalizar que o produto não foi
     * cadastrado, ou retornar o produto inserido.
     */
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

    /**
     * Utilizei a variável local result para poder mostrar a mensagem
     * confirmando a operação.
     *
     * @param id recebe a identificação do produto.
     * @return se a operação de exclusão teve sucesso com um boolean
     */
    @Override
    public boolean removeById(UUID id) {
        boolean result =  productSet.removeIf(p -> p.getId().equals(id));
        System.out.println("Produto removido!");
        return result;
    }

    /**
     * Não soube fazer o filtro sem usar stream().
     */
    public boolean findByName(Product product) {
        return productSet.stream()
                .anyMatch(p -> p.getName().equals(product.getName()));
    }

    /**
     * Não soube fazer o filtro sem usar stream().
     *
     */
    @Override
    public Optional<Product> findById(UUID id) {
        return productSet.stream().filter(p -> p.getId() == id).findAny();

    }

    /**
     * Não soube fazer o filtro sem usar stream().
     *
     */
    @Override
    public boolean checkById(UUID id) {
        return productSet.stream()
                .anyMatch(p -> p.getId() == id);
    }

    /**
     *
     * @return o conjunto de produtos atual.
     */
    @Override
    public Set<Product> findAll() {
        return productSet;
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
     * @param produto a ser categorizado.
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

        return categorizedProducts;
    }
}
