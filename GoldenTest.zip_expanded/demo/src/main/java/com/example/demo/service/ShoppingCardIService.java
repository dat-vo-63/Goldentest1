package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Item;


@Component
public interface ShoppingCardIService {
	/**
	 * Thêm mặt hàng vào giỏ hoặc tăng số lượng lên 1 nếu đã tồn tại
	
	 */
	Item add(long id);
	/**
	 * Xóa mặt hàng khỏi giỏ
	
	 */
	void remove(int id);
	/**
	 * Thay đổi số lượng lên của mặt hàng trong giỏ
	
	 */
	Item update(Integer id, int qty);
	/**
	 * Xóa sạch các mặt hàng trong giỏ
	 */
	void clear();
	/**
	 * Lấy tất cả các mặt hàng trong giỏ
	 */
	Collection<Item> getItems();
	/**
	 * Lấy tổng số lượng các mặt hàng trong giỏ
	 */
	int getCount();
	/**
	 * Lấy tổng số tiền tất cả các mặt hàng trong giỏ
	 */
	double getAmount();
	Item getItemById(int id);
}
