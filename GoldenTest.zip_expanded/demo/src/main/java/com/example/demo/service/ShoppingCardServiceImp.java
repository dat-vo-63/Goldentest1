package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;


@Service
public class ShoppingCardServiceImp implements ShoppingCardIService{
	private Map<Integer,Item> items = new HashMap<>();
	@Autowired
	ProductRepo productRepo;
	@Override
	public Item add(long item) {
		Product product = productRepo.getById(item);
		Item item2 = items.get((int)item);
		if(item2==null) {
			
			item2 = new Item();
			item2.setId(product.getProductId());
			item2.setPrice(product.getProductPrice());
			item2.setDescription(product.getDescription());
			item2.setImage(product.getImage());
			item2.setName(product.getProductName());
			item2.setQuantity(1);
			item2.setPrice(product.getProductPrice());
			items.put((int)item,item2);
		}
		else {
			item2.setQuantity(item2.getQuantity()+1);
		}
		
		
		return item2;
	}

	@Override
	public void remove(int index) {
		items.remove(index);
		
	}

	@Override
	public Item update(Integer id, int qty) {
		Item item = items.get(id);
		item.setQuantity(item.getQuantity()+qty);
		if(item.getQuantity()==0)
		{
			items.remove(id);
		}
		return item;
	}

	@Override
	public void clear() {
		items.clear();
		
	}

	@Override
	public List<Item> getItems() {
		List<Item> list = new ArrayList<>();
		// TODO Auto-generated method stub
		Collection<Item> collection= items.values();
		 for (Item item : collection) {
			list.add(item);
		}
		 return list;
	}

	@Override
	public int getCount() {
		return items.values().stream()
				.mapToInt(item -> item.getQuantity())
				.sum();
	}

	@Override
	public double getAmount() {
		return items.values().stream()
				.mapToDouble(item -> item.getPrice()*item.getQuantity())
				.sum();
	}

	@Override
	public Item getItemById(int id) {
		
		return items.get(id);
	}

	
	
	
}
