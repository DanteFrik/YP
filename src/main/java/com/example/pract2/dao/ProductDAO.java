package com.example.pract2.dao;

import com.example.pract2.model.ProductModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAO implements GenericDAO<ProductModel> {
    private final List<ProductModel> products = new ArrayList<>();
    private int idCounter = 1;

    public ProductDAO() {
        // Добавим 5 продуктов при инициализации DAO
        create(new ProductModel("Продукт 1", 10.99, "Описание продукта 1"));
        create(new ProductModel("Продукт 2", 20.99, "Описание продукта 2"));
        create(new ProductModel("Продукт 3", 5.99, "Описание продукта 3"));
        create(new ProductModel("Продукт 4", 15.99, "Описание продукта 4"));
        create(new ProductModel("Продукт 5", 8.99, "Описание продукта 5"));
    }

    @Override
    public List<ProductModel> getAll() {
        return products;
    }

    @Override
    public ProductModel getById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void create(ProductModel product) {
        product.setId(idCounter++);
        products.add(product);
    }

    @Override
    public void update(int id, ProductModel updatedProduct) {
        ProductModel existingProduct = getById(id);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setDescription(updatedProduct.getDescription());
        }
    }

    @Override
    public void delete(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}
