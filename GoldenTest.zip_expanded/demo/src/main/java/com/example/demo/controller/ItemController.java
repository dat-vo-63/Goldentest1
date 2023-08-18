package com.example.demo.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Item;
import com.example.demo.service.ShoppingCardIService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/check")
public class ItemController {
	 private final static String CART_COOKIE_NAME = "cart";
	@Autowired
	ShoppingCardIService cardIService;

	@GetMapping("/seeDetails")
	public Collection<Item> getItem(HttpServletRequest request) {
		return cardIService.getItems();
	}

	@PostMapping("/addItem")
	public Item item(@RequestBody Map<String, Integer> map) {
		return cardIService.add(map.get("id"));
	}

	@PostMapping("/updateQuantity")
	public Item update(@RequestBody Map<String, Integer> map) {
		return cardIService.update(map.get("id"), map.get("quantity"));
	}
	@PostMapping("/clear")
	public String clear() {
		cardIService.clear();
		return "Success";
	}
	@PostMapping ("/delete")
	public String remove(@RequestBody Map<String, Integer> map)
	{
		cardIService.remove(map.get("id"));
		return "Success";
	}
	@GetMapping ("/getAllCost")
	public String getCost() {
		double a=  (cardIService.getAmount());
		String b =String.format("%.2f", cardIService.getAmount());
		return b;
	}
	@PostMapping("/getShoesById")
	public Item getItem(@RequestBody Map<String,Integer> map) {
		return cardIService.getItemById(map.get("id"));
	}
//	private List<Item> getCartFromCookie(HttpServletRequest request) {
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals(CART_COOKIE_NAME)) {
//                    // Parse cookie value to retrieve the cart items
//                	String cartJson = cookie.getValue();
//                    // Parse cartJson để tạo danh sách CartItem
//                    List<Item> cartItems = parseCartJson(cartJson);
//                    return cartItems;
//                }
//            }
//        }
//        return null;
    }
//	private void saveCartToCookie(List<Item> cart, HttpServletResponse response) {
//        // Convert cart items to JSON and save as a cookie
//        Cookie cookie = new Cookie(CART_COOKIE_NAME, cartJson);
//        cookie.setMaxAge(3600); // Set cookie expiration time (e.g., 1 hour)
//        response.addCookie(cookie);
//    }
//	private List<Item> parseCartJson(String cartJson) {
//        // Parse JSON để tạo danh sách CartItem
//        return cartItems;
//    }
