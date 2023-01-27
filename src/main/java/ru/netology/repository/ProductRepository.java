package ru.netology.repository;

import ru.netology.product.NotFoundException;
import ru.netology.product.Product;

public class ProductRepository {

    private Product[] products = new Product[0];


    public void saveProduct(Product product) {
        Product[] add = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            add[i] = products[i];
        }
        add[add.length - 1] = product;
        products = add;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Product[] add = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                add[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = add;
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}
