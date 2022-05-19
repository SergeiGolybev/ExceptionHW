package ru.netology.repository;

import ru.netology.AlreadyExistsException;
import ru.netology.NotFoundException;
import ru.netology.domain.Product;

public class Repository {

    private Product[] products = new Product[0];

    public void add(Product product) {

        for (Product tmp : products) {
            if (product.getId() == tmp.getId()) {
                throw new AlreadyExistsException("Product with this id already exists");
            }
        }

        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }


    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product[] findAll() {
        return products;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int i = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[i] = product;
                i++;
            }
        }
        products = tmp;
    }
}
