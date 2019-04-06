package com.cg.service;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Product;
import com.cg.dao.ICapstoreDao;
@Transactional
@Service("service")
public class CapstoreServiceImpl implements ICapstoreService {
	@Autowired
	ICapstoreDao repo;

	@Override
	public List<Product> generateInvoice(String cart_id,String order_id) {
		return repo.generateInvoice(cart_id,order_id);
	}

}
