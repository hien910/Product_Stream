package com.example.product.database;

import com.example.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductDB {
    public static List<Product> productList;
}
