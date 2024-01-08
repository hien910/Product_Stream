package com.example.product.utils;

import com.example.product.model.Product;

import java.util.List;

public interface IFileReader {
    List<Product> readFile(String fileName);
}
