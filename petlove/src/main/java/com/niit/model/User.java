package com.niit.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Table //creates a table with name User(same as class name)
@Entity  //auto generate tables in h2 database. marks this class as an entity bean
public class User implements Serializable
{
	@Id  //marks a field as a primary key field
	@GeneratedValue/*value will be automatically generated for that field*/(strategy=GenerationType.IDENTITY)//generated values are unique only per type hierarchy.
	private int uId;
	@Size(min=6,message="minimum of 6 characters")//constraints applied on uName
	private String uName;
	@Size(min=6,message="minimum of 6 characters")
	private String password;
	@Column(unique=true)//this column values has to be unique
	private String email;
	@Column(unique=true)
	@Size(min=10,max=10,message="minimum of 10 characters")
    private String mobileNo;
	private String role;
	private boolean is_Active;
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="users")//Cascade:if changes r made in one then it should be done in the dependent entity also
	private Cart cart;//fetch specifies whether the collection should be retrieved lazily or eagerly
	@OneToMany(cascade=CascadeType.ALL,mappedBy="users")
	private List<Address> address=new ArrayList<Address>();
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isIs_Active() {
		return is_Active;
	}
	public void setIs_Active(boolean is_Active) {
		this.is_Active = is_Active;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
}
