package com.niit.dao;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao
{
	
	@Autowired
	SessionFactory sessionFactory;

	
	
	public boolean newCategory(Category category) {
		// TODO Auto-generated method stub
		System.out.println("entered into new category");
		Session s=sessionFactory.openSession();
	Transaction t=s.beginTransaction();
		s.save(category);
		t.commit();
			
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Category> allCategories() {
		// TODO Auto-generated method stub
		 System.out.println("entered in all categories");
		return sessionFactory.getCurrentSession().createQuery("FROM Category").getResultList();
	}
	
	
	@Transactional
	public boolean deleteCategory(int id) {
		
		System.out.println("testing");
		try{
		 Query q= sessionFactory.getCurrentSession().createQuery("DELETE Category WHERE id = :ID");
		 q.setParameter("ID", id);
		 q.executeUpdate();
	 System.out.println("category deleted");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	 return true;
		 
	}
	
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(category);
			
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
		
		
		
		
	}

	
	public Category getCategory(int id) {
		// TODO Auto-generatedmethod stub
		System.out.println("category");
		try{
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
		
	}

	@Override
	public Map<Integer, String> getCatForPro() {
		try {
		List<Category> list=	sessionFactory.getCurrentSession().createQuery("From Category",Category.class).getResultList();
		Iterator<Category> it=list.iterator();
		Map<Integer,String> map=new HashMap<>();
		 while(it.hasNext())
		 {
			 Category c=it.next();
			 map.put(c.getId(), c.getCategoryName());
			 
		 }
		 return map;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}

}
