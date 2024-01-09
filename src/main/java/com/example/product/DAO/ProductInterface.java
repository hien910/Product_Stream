package com.example.product.DAO;

import com.example.product.model.Product;

import java.util.List;

public interface ProductInterface {
    List<Product> getAll();
    Product getById(int id);
    List<Product> sortASC();
    List<Product> sortDESC();
}
