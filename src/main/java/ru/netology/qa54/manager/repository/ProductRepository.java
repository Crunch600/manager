package ru.netology.qa54.manager.repository;

import ru.netology.qa54.manager.domain.Product;

import java.util.Arrays;

public class ProductRepository {

    public Product[] products = new Product[0];


    public void save(Product product) {
        if (findById(product.getId()) != null) {
            throw new AlreadyExistException(
                    "Element with id: " + product.getId() + "already exist");
        }
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }


    public void removeToID(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found");
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for(Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
            products = tmp;
        }
    }

    public Product findById(int id) {
        for(Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


    public Product[] getProducts() {

        return products;
    }


}
