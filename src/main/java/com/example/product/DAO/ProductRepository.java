package com.example.product.DAO;

import com.example.product.database.ProductDB;
import com.example.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepository implements ProductInterface{

    @Override
    public Product getById(int id){
        return ProductDB.productList.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Product> sortDESC() {
        return ProductDB.productList.stream()
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                .toList();
    }

    @Override
    public List<Product> sortASC() {
        return ProductDB.productList.stream()
                .sorted(Comparator.comparing(Product:: getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getAll() {
        return ProductDB.productList.stream().toList();
    }
}
