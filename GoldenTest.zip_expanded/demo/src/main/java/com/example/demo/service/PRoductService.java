package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;
@Service
public class PRoductService  implements ProductIService{
	@Autowired
	ProductRepo productRepo;
	@Override
	public String addProduct(Product product) {
		String check = "";
		try {
			Product a = productRepo.save(product);
			check = "Add Success";
		} catch (Exception e) {
			check = "Something not right";
		}
		
		
		return check;
	}
	@Override
	public List<Product> findAll() {
		return productRepo.findAll();
	}

}
