package com.niit.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CartDao;
import com.niit.dao.CartItemDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.UserDao;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Product;
import com.niit.model.User;

@Controller
public class HomeController 
{
	@Autowired
	UserDao userDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CartItemDao cartItemDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping({"/","/home"})
	public String home(Principal principal,ModelMap model)
	{User userobj=null;
	if(principal!=null)
	{
		userobj=userDao.getUserByEmail(principal.getName());
		if(userobj.getRole().equals("ROLE_ADMIN"))
		{
			return "redirect:/adminpage";
		}
		else
		{
			System.out.println("entered");
			System.out.println(categoryDao.allCategories());
			System.out.println(userobj);
			System.out.println(userobj.getCart());
			System.out.println(userobj.getCart().getId());
			System.out.println(userobj.getCart().getQuantity());
			session.setAttribute("cartcount",userobj.getCart().getQuantity());
			model.addAttribute("catlist",categoryDao.allCategories());
			return "index";
		}
	}
	else
	{
		model.addAttribute("catlist",categoryDao.allCategories());
			
		return "index";
	}
		
	
	}	
	
	@RequestMapping("/adminpage")
	public ModelAndView AdminPage()
	{
		return new ModelAndView("AdminHome");
	}
	@GetMapping("/login")
	public String Login(@RequestParam(value="error",required=false)String error,ModelMap model)
	{
		System.out.println(error);
		if(error!=null)
		{
			model.addAttribute("error","Authentication Failed");
			return "loginform";
		}
		model.addAttribute("title","Login");
		model.addAttribute("loginform",true);
		return "loginform";
	}
	@RequestMapping("/aboutus")
	public ModelAndView AboutUs()
	{
		return new ModelAndView("aboutus");
	}
	@RequestMapping("/contactus")
	public ModelAndView ContactUs()
	{
		return new ModelAndView("contact");
	}
	
	@RequestMapping("cat/{id}/products")
	public String getProducts(@PathVariable Integer id,ModelMap model)
	{
		System.out.println("im in getproducts of home controller");
		model.addAttribute("id",id);
		model.addAttribute("products",productDao.allProducts());
		return "Products";
	}
	
	@RequestMapping("/{id}/catproducts")
	public @ResponseBody List<Product> allProducts(@PathVariable Integer id)
	{
		
		return productDao.getCatProducts(id);
	}
	
	@RequestMapping("/{id}/viewproduct")
	public String viewProduct(@PathVariable Integer id,ModelMap model)
	{
		model.addAttribute("product",productDao.get(id));
		
		
		return "CustViewProduct";
	}
	
	
	@RequestMapping("customer/{id}/addcart")
	public String addCart(@PathVariable Integer id,Principal principal)
	{
		Integer catid=0;
		if(principal!=null)
		{
		 User user=userDao.getUserByEmail(principal.getName());
		Cart cart= user.getCart();
		CartItem cartItem =cartItemDao.getExistingCartItemCount(id, cart.getId());
		System.out.println("cartItem item object"+cartItem);
		Product product=productDao.get(id);
		if(cartItem==null)
		{
		  cartItem=new CartItem();
		  cartItem.setQuantity(1);
		  cartItem.setProduct(product);
		  cartItem.setGrandTotal(product.getProdPrice());
		  cartItem.setCart(cart);
		  cartItemDao.addCartItem(cartItem);
		  cart.setGrandTotal(cart.getGrandTotal()+product.getProdPrice());
		  cart.setQuantity(cart.getQuantity()+1);
		  cartDao.updateCart(cart);
		}else
		{
			cartItem.setQuantity(cartItem.getQuantity()+1);
			cartItem.setGrandTotal(cartItem.getGrandTotal()+product.getProdPrice());
			cart.setGrandTotal(cart.getGrandTotal()+product.getProdPrice());
			  cart.setQuantity(cart.getQuantity()+1);
			  
			  
			  cartDao.updateCart(cart);
			  cartItemDao.updateCartItem(cartItem);
		}
		
		 session.setAttribute("cartcount",cart.getQuantity());  
		}
		
		return "redirect:/cat/"+catid+"/products";
	}
	
	

}
