package com.example.product.service;

import com.example.product.DAO.ProductRepository;
import com.example.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }
    public Product getById(int id){
        return productRepository.getById(id);
    }
    public List<Product> sortASC(){
        return productRepository.sortASC();
    }
    public List<Product> sortDESC(){
        return productRepository.sortDESC();
    }
}
