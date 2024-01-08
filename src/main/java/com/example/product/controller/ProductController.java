package com.example.product.controller;

import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String getAll(Model model){
        model.addAttribute("products",productService.getAll());
        return "getAll";
    }
    @GetMapping("/product/{id}")
    public String getById(@PathVariable int id, Model model){
        model.addAttribute("product",productService.getById(id));
        return "getById";
    }

}
