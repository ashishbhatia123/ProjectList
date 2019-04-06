package com.capgemini.Capstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Product;



@Controller
public class URIController {




	@PersistenceContext
	EntityManager em;


	@RequestMapping("/")
	public  String home(ModelMap map) {



		Query query=em.createQuery("select distinct p.prodCategory from Product p");
		
		List<String> categoryList=query.getResultList();

		for(String name:categoryList)
			System.out.println(name+"    category");
	
		Map<String,List<Product>> categoryMap = new HashMap<>();

		for(String prodCategory:categoryList) 
		{
				List<Product> productList = new ArrayList<>();
				query=em.createQuery("select p from Product p where p.prodCategory=:cat").setParameter("cat",prodCategory);
				productList=query.getResultList();
				
							
			


			for(Product product:productList)
				System.out.println(product.getName()+"   product");
			
			
			 categoryMap.put(prodCategory, productList);


		}
		map.addAttribute("map",categoryMap);

		
		
		map.addAttribute("map",categoryMap);

		return "/views/index.jsp";
	}
	
	@RequestMapping("/getLogin")
	public  String login() {

		return "/views/login.jsp";


	}
	
	/*
	@RequestMapping("/index")
	public  String index() {

		return "/views/index.jsp";


	}



	@RequestMapping("/registerAsCustomer")
	public  String registerCustomer() {

		return "/views/registerCustomer.jsp";


	}


	@RequestMapping("/getContact")
	public  String contact() {

		return "/views/contact.jsp";


	}



	@RequestMapping(value="/getProduct/{productId}")
	public ModelAndView getProductPage(@PathVariable int productId ) {
		System.out.println("consoler"+productId);

		RestTemplate restTemplate = new RestTemplate();
		Product displayProduct = restTemplate.getForObject("http://localhost:8099/product.json",Product.class);
		return new ModelAndView("/views/product.jsp","product",displayProduct);
	}

	@RequestMapping(value="/getCheckout")
	public String getCheckoutPage() {

		return "/views/checkout.jsp";
	}

	 */	}
