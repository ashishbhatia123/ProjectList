package com.cg.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.bean.Product;
import com.cg.service.ICapstoreService;

@Controller
public class HomeController {
	@Autowired
	ICapstoreService service;
	
	@RequestMapping(value="/")
	public String display() {
		return "Cart";
	}
	 
	@RequestMapping(value="/Invoice")
	public String invoice(@RequestParam("cartId") String cart_id,@RequestParam("orderId") String order_id,Model model){
		List<Product> productList=service.generateInvoice(cart_id, order_id);
		double totalPrice=0;
		double discountPrice=0;
		for (int i = 0; i < productList.size(); i++) {

			if (productList.get(i).getProdDiscount() != 0) {
				double discountcal = productList.get(i).getProdDiscount();
				double price = productList.get(i).getPrice();
				discountPrice=price-(price*discountcal/100);
				totalPrice+=discountPrice;

			}
		}
		model.addAttribute("list",productList);
		model.addAttribute("totalPrice",totalPrice);
		return "Invoice";  
	}
	
}
