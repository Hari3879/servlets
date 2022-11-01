package com.pms.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtility {
	public static Connection getconncetion (){
		Connection  con =null;
		try {
			File path = new File("C:\\Users\\ho22078\\OneDrive - Ojas Innovative Technologies Pvt Lt\\CoreJava\\crudop\\src\\main\\resources\\db.properties");
			FileInputStream fis=new FileInputStream(path);
			Properties p = new Properties();
			p.load(fis);
			Class.forName(p.getProperty("driver"));
			con = DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"), p.getProperty("password"));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                                                                                                                                       
		
		return con;
	}

}
