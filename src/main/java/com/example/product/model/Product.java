package com.example.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
   private int id ;
   private String name ;
   private String description ;
   private String thumbnail;
   private int price;
   private double rating;
   private int priceDiscount;
}
