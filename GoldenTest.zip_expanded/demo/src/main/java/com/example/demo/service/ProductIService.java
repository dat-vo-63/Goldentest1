package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;
@Component
public interface ProductIService {
	public String addProduct(Product product);
	public  List<Product> findAll ();

}
