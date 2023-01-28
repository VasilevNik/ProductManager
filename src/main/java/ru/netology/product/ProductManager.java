package ru.netology.product;

import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;


    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void save(Product product) {

        repository.saveProduct(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] add = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    add[i] = result[i];
                }
                add[add.length - 1] = product;
                result = add;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
