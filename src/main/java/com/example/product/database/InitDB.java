package com.example.product.database;

import com.example.product.model.Product;
import com.example.product.utils.IFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitDB implements CommandLineRunner {
    @Autowired
    private IFileReader fileReader;

    private final String PRODUCT_DATA_FILE = "Product.xlsx";

    @Override
    public void run(String... args) {
        ProductDB.productList = loadDataFromCSV(PRODUCT_DATA_FILE);
    }

    private List<Product> loadDataFromCSV(String fileName) {
        return fileReader.readFile(fileName);
    }
}
