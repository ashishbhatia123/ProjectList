package com.cg.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Cart;
import com.cg.bean.Orders;
import com.cg.bean.Product;

@Repository("repo")
public class CapstoreDaoImpl implements ICapstoreDao {
	@PersistenceContext
	EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	Product product = new Product();
	Cart cart = new Cart();

	@Override
	@Transactional
	public List<Product> generateInvoice(String cartId, String orderId) {
		List<Product> orderProducts=new ArrayList<Product>();
		Cart cart = entityManager.find(Cart.class, cartId);
		double totalPrice=0;
		List<Orders> cartOrder = cart.getCartOrder();
		int i;
		for (i = 0; i < cartOrder.size(); i++) {
			if (cartOrder.get(i).getOrderId().equals(orderId)) {
				orderProducts = cartOrder.get(i).getOrdersProduct();
				break;
			}
		}
		
		
		return orderProducts;
	}

}
