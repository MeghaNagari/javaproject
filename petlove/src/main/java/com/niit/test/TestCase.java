package com.niit.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.config.ApplicationContextConfig;
import com.niit.dao.AddressDao;
import com.niit.dao.CartDao;
import com.niit.dao.CartItemDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.UserDao;
import com.niit.model.Address;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.User;


public class TestCase {

	public static void main(String[] args)
	{
		 @SuppressWarnings("unused")//it'll not give anytype of errors/warnings
	        AbstractApplicationContext context=new AnnotationConfigApplicationContext(ApplicationContextConfig.class);//to instantiate,configure and assemble the objects
		   
		 
	/*	UserDao userDao=(UserDao)context.getBean("userDao");//to get the bean of userdao
				 User userobj=new User();
				 userobj.setEmail("megha@gmail.com");
				 userobj.setMobileNo("4564645444");
				 userobj.setPassword("passowrd");
				 userobj.setuName("MeghaNagari");
				 userobj.setIs_Active(true);
				 userDao.addUsers(userobj);
     */
		/*
		 CategoryDao categoryDao=(CategoryDao)context.getBean("categoryDao");
		 Category cate=new Category();
		 cate.setCategoryName("Large Breed");
		 categoryDao.newCategory(cate);*/
		 
		
	/*	 CategoryDao categoryDao=(CategoryDao)context.getBean("categoryDao");
		  ProductDao productdao=(ProductDao)context.getBean("productDao");
		 Product prod=new Product();
		 prod.setProdName("GSD");
		 prod.setProdDesc("Usually aggressive");
		 prod.setProdPrice(13000);
		 prod.setQuantity(1);
		 prod.setStatus(true);
		 prod.setCategory(categoryDao.getCategory(1));
	     productdao.addProduct(prod);
		 
	*/	 
		 
	   /*  UserDao userDao=(UserDao)context.getBean("userDao");
		 AddressDao addressDao=(AddressDao)context.getBean("addressDao");
		 Address addr=new Address();
		 addr.setHouseNo("5-8-47");
		 addr.setStreet("abids");
		 addr.setCity("hyd");
		 addr.setState("TG");
		 addr.setCountry("INDIA");
		 addr.setPin("500001");
		 addr.setUsers(userDao.getUserByEmail("megha@gmail.com"));
		 addressDao.addAddress(addr);
		 */
		 
		 /*UserDao userDao=(UserDao)context.getBean("userDao");
		 AddressDao addressDao=(AddressDao)context.getBean("addressDao");
		 Address addr=new Address();
		 addr.setHouseNo("1-2/c");
		 addr.setStreet("nallakunt");
		 addr.setCity("HYD");
		 addr.setState("TG");
		 addr.setCountry("INDIA");
		 addr.setPin("500010");
		 addr.setUsers(userDao.getUser(8));
		 addressDao.addAddress(addr);*/
		 
		 
		//cart and cartitem test case
		 
	/*	 UserDao userDao=(UserDao)context.getBean("userDao");		
		 ProductDao productdao=(ProductDao)context.getBean("productDao");
			CartItemDao cartItemDao=(CartItemDao)context.getBean("cartItemDao");
			CartDao cartDao=(CartDao)context.getBean("cartDao");
			
			Cart cart=new Cart();
			cart.setId(1);
			cart.setUsers(userDao.getUser(1));
			CartItem cartItem=new CartItem();
			cartItem.setCart(cart);
			cartItem.setQuantity(2);
			Product product=productdao.get(1);
			cartItem.setProduct(product);
			cartItem.setGrandTotal(cartItem.getQuantity()*product.getProdPrice());
			List<CartItem> cartItems=new ArrayList<>();
			cartItems.add(cartItem);
			cart.setCartItems(cartItems);
			cart.setGrandTotal(cartItem.getGrandTotal()+product.getProdPrice());
			cart.setQuantity(cart.getQuantity()+cartItem.getQuantity());
			cartDao.addCart(cart);
		*/	

		   	}

}
