package com.chanhtin.model.service;

import com.chanhtin.model.model.Product;

import java.util.List;

public interface BaseService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    List<Product> findByName(String name);

    void update(int id, Product product);

    void remove(int id);


}
