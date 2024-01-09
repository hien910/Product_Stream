package com.example.product.DAO;

import com.example.product.database.ProductDB;
import com.example.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
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
    public List<Product> sortDESC() {
        return ProductDB.productList.stream()
               .sorted(Comparator.comparing(Product:: getPrice).reversed()).toList();
    }

    @Override
    public List<Product> sortASC() {
        return ProductDB.productList.stream()
                .sorted(Comparator.comparing(Product:: getPrice))
                .toList();
    }

    @Override
    public List<Product> getAll() {
        return ProductDB.productList.stream().toList();
    }
}
