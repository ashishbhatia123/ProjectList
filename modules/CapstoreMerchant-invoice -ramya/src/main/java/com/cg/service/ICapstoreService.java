package com.cg.service;

import java.util.List;
import com.cg.bean.Product;

public interface ICapstoreService {
	public List<Product> generateInvoice(String cart_id,String order_id);
}
