package com.chanhtin.model.service;

import com.chanhtin.model.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements BaseService {
    private static final Map<Integer, Product> productMap = new HashMap<>();
    public static int count = 5;

    static {
        productMap.put(1,new Product(1,"Note 20","SamSung", 22000000));
        productMap.put(2,new Product(2,"Pixel 5XL","Google", 31000000));
        productMap.put(3,new Product(3,"Iphone 12","Apple", 32500000));
        productMap.put(4,new Product(4,"Huawei P40","Huawei", 23000000));
        productMap.put(5,new Product(5,"Note 20","ViVo", 15000000));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        ++count;
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        if (productMap.containsKey(id))
            return productMap.get(id);
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = findAll();
        List<Product> resultList = new ArrayList<>();

        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name))
                resultList.add(product);
        }

        return resultList;
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
