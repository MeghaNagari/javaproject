package com.niit.dao;



import java.util.List;
import com.niit.model.Address;
import com.niit.model.User;

public interface AddressDao
{
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	boolean deleteAddress(int id);
	public List<Address> getAddress(User user);

}
