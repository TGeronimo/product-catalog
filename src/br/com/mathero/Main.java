package br.com.mathero;

import br.com.mathero.domain.ElectronicProduct;
import br.com.mathero.domain.FoodProduct;
import br.com.mathero.domain.Product;
import br.com.mathero.service.ProductService;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // Instância de ProductService para testar as funcionalidades da aplicação.
        ProductService productService = new ProductService();

        // Conjunto de testes.
//        ElectronicProduct produto = new ElectronicProduct("Notebook", 3500);
//        productService.add(produto);
//        testAddProduct(productService);
        testFindAllProducts(productService);
//        testCheckById(productService);
//        testFindById(productService);
//        testRemoveById(productService);
//        testAddTag(productService);
//        testFindAllElectronics(productService);
    }

    // Métodos estáticos para os testes.

    /**
     * Cria um produto e o insere no conjunto.
     * Foi criado um produto duplicado para testar a inserção
     * sem duplicatas.
     *
     * @param productService injeta a dependência para manter
     *                       o acesso ao mesmo conjunto de produtos.
     */
    public static void testAddProduct(ProductService productService) {
        Product product = new FoodProduct("Beterraba", 12.50);
        productService.add(product);
        System.out.println(productService.getProductMap());

    }

    /**
     * Verifica se findAll() retorna todos os três
     * produtos criados.
     */
    public static void testFindAllProducts(ProductService productService) {
        Product product = new FoodProduct("Beterraba", 12.50);
        Product product2 = new FoodProduct("Aspargos", 27.00);
        Product product3 = new ElectronicProduct("Smartphone", 2700.00);

        productService.add(product);
        productService.add(product2);
        productService.add(product3);

        System.out.println(productService.findAll());

    }

    /**
     * Verifica se checkById retorna true para um
     * produto inserido e false para um produto inexistente,
     * aqui simulado por randomUUID().
     */
    public static void testCheckById(ProductService productService) {
        Product product = new FoodProduct("Beterraba", 12.50);
        Product product2 = new FoodProduct("Aspargos", 27.00);
        Product product3 = new ElectronicProduct("Smartphone", 2700.00);

        productService.add(product);
        productService.add(product2);
        productService.add(product3);

        System.out.println(productService.checkById(product3.getId()));
        System.out.println(productService.checkById(UUID.randomUUID()));
    }

    /**
     * Verifica se findById retorna o produto correto
     * ao ser procurado por seu UUID.
     */
    public static void testFindById(ProductService productService) {
        Product product = new FoodProduct("Beterraba", 12.50);

        productService.add(product);

        System.out.println(productService.findById(product.getId()));
        System.out.println(productService.findById(UUID.randomUUID()));
    }

    /**
     * Verifica se removeById consegue apagar um produto
     * do conjunto usando sua id.
     *
     */
    public static void testRemoveById(ProductService productService) {
        Product product = new FoodProduct("Beterraba", 12.50);
        productService.add(product);
        System.out.println(productService.getProductMap());
        productService.removeById(product.getId());
        System.out.println(productService.getProductMap());
    }

    /**
     * Verifica se addTag consegue atribuir uma categoria a
     * um produto cadastrado e inserir como conjunto chave-valor
     * em um mapa.
     *
     */
    public static void testAddTag(ProductService ps) {
        Product food1 = new FoodProduct("Aspargos", 29.50);
        Product food2 = new FoodProduct("Batata-doce", 12.00);
        Product elec1 = new ElectronicProduct("Smartphone Moto Edge 50 Neo", 2700.00);
        Product elec2 = new ElectronicProduct("Notebook HP Probook 440 G11", 5200.00);
        ps.add(food1);
        ps.add(food2);
        ps.add(elec1);
        ps.add(elec2);
        System.out.println(ps.getProductMap());

        ps.addTag(food1);
        ps.addTag(food2);
        ps.addTag(elec1);
        ps.addTag(elec2);
        System.out.println(ps.getCategorizedProducts());

    }

    /**
     * Verifica se findAllElectronics consegue filtrar os produtos
     * que possuem o valor "produto eletrônico" no mapa de produtos
     * categorizados.
     * @param ps
     */
    public static void testFindAllElectronics(ProductService ps) {
        Product food1 = new FoodProduct("Aspargos", 29.50);
        Product food2 = new FoodProduct("Batata-doce", 12.00);
        Product elec1 = new ElectronicProduct("Smartphone Moto Edge 50 Neo", 2700.00);
        Product elec2 = new ElectronicProduct("Notebook HP Probook 440 G11", 5200.00);
        ps.add(food1);
        ps.add(food2);
        ps.add(elec1);
        ps.add(elec2);

        ps.addTag(food1);
        ps.addTag(food2);
        ps.addTag(elec1);
        ps.addTag(elec2);
        System.out.println(ps.findAllElectronics());
    }
}
