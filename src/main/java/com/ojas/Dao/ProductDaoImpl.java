package com.ojas.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ojas.model.Products;
import com.pms.db.DBUtility;

public class ProductDaoImpl implements ProductDao {
	public static Connection con=DBUtility.getconncetion();
	PreparedStatement ps = null;
	List Products=null;
	ResultSet rs = null;
	//Products product = null;
	String message = null;
	int n = 0;

	@Override
	public String createProduct(Products product) {
		
			try {
				ps = con.prepareStatement("INSERT INTO products VALUES(?,?,?,?)");
				ps.setInt(1, product.getPid());
				ps.setString(2, product.getPname());
				ps.setInt(3,product.getQty());
				ps.setDouble(4, product.getPrice());
				n=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(n);
			if(n!=0) {
				message = "Successfully Product Inserted....";
			}else {
				message = "Please check once again....";
			}
		
		return message;
	}

	@Override
	public Products viewProduct(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> viewAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateProduct(int pid, Products updateProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProduct(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

}
