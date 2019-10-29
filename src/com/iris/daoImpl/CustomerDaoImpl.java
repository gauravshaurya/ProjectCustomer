package com.iris.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.iris.dao.CustomerDao;
import com.iris.model.Customer;
import com.iris.utility.ConnectionProvider;

public class CustomerDaoImpl implements CustomerDao {
	
	static Connection conn = ConnectionProvider.getConn();

	@Override
	public boolean registerCustomer(Customer custm) throws Exception {

		PreparedStatement ps = conn.prepareStatement("insert into CustomerRegister values(?,?,?,?,?,?)");
		ps.setInt(1, custm. getCustomerId());
		ps.setString(2,custm.getCustomerName());
		ps.setString(3, custm.getEmail());
		ps.setString(4, custm.getGender() );
		ps.setString(5, custm.getCity() );
		ps.setString(6, custm.getPassword() );
		
		int i = ps.executeUpdate();
		if(i!=0)
		return true;
		return false;
		
	}

	@Override
	public boolean validateCustomer(String name,String pass) throws Exception {
		PreparedStatement ps = conn.prepareStatement("select * from CustomerRegister where customerName=? and password=?");
		ps.setString(1,name);
		ps.setString(2,pass);
		
		int i = ps.executeUpdate();
		if(i!=0)
		return true;
		return false;
		
	}

	
}
