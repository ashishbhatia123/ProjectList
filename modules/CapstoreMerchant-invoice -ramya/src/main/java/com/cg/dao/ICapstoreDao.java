package com.cg.dao;

import java.util.List;

import com.cg.bean.Product;

public interface ICapstoreDao {

	public List<Product> generateInvoice(String cart_id,String order_id);
}
