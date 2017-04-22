package com.niit.dao;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.User;
import com.niit.dao.UserDao;
@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao
{
	SessionFactory sessionFactory;
	@Autowired
	public void setSessionFactpry(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	public boolean addUsers(User user)
	{
		try
		{
			System.out.println("entered in add user dao");
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	public User getUser(int id)
	{
		return sessionFactory.getCurrentSession().get(User.class,Integer.valueOf(id));
	}
	public boolean updateUser(User user)
	{
		System.out.println("user details in user dao imp::::::::::"+user);
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	public boolean deleteUser(int id)
	{
		return false;
	}
	@SuppressWarnings("deprecation")
	public User getUserByEmail(String email)
	{
		@SuppressWarnings("rawtypes")
		Query q=sessionFactory.getCurrentSession().createQuery("From User where email=:email",User.class);
	    q.setParameter("email", email);
	    try{
	    	Object o=q.getSingleResult();
	    	return(User) o;
	    	}
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    	return null;
	    }
	}
	@SuppressWarnings("deprecation")
	public User getUserByUsername(String name)
	{
		@SuppressWarnings("rawtypes")
		Query q=sessionFactory.getCurrentSession().createQuery("From User where email=:email");
	    q.setParameter("email",name);
	    User userDetails=(User)q.getSingleResult();
	    	return userDetails;
	    	
	}
}


