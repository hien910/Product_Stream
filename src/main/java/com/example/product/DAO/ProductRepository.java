package com.example.product.DAO;

import com.example.product.database.ProductDB;
import com.example.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductInterface{

    @Override
    public Product getById(int id){
        return ProductDB.productList.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }
    @Override
    public List<Product> getAll() {
        return ProductDB.productList.stream().toList();
    }
}