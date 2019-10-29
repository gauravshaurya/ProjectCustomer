package com.iris.dao;

import com.iris.model.Customer;

public interface CustomerDao {
	
	public boolean registerCustomer(Customer cust) throws Exception;
	public boolean validateCustomer(String name,String pass) throws Exception;

}
