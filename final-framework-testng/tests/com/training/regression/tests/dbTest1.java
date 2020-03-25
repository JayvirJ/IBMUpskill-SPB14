package com.training.regression.tests;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.StRegisterBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

public class dbTest1 {

	public static void main(String args[]) throws IOException {
	        List<StRegisterBean> list = getdata();
	        
	        Object[][] result = new Object[list.size()][]; 
	        int count = 0; 
	        for(StRegisterBean temp : list){
	            Object[]  obj = new Object[8]; 
	            obj[0] = temp.getFirstName();
	            obj[1] = temp.getLastName();
	            obj[2] = temp.getEmail();
	            obj[3] = temp.getUserName();
	            obj[4] = temp.getPassword();
	            obj[5] = temp.getConfirmPassword();
	            obj[6] = temp.getPhone();
	            obj[7] = temp.getLanguage();
	            
	            result[count ++] = obj; 
	        }
	        System.out.println(result);
	        for(Object[] a:result)
	        {
	        	for(Object b: a)
	        		System.out.println(b);
	        }
	    }
	        
	        
	    static List<StRegisterBean> getdata() throws IOException {
	    Properties properties = new Properties();
	    FileInputStream inStream = new FileInputStream("./resources/sql.properties");
	    properties.load(inStream);
	    String sql = properties.getProperty("get.StRegister"); 
	    
	    GetConnection gc  = new GetConnection(); 
	    List<StRegisterBean> list = null;
	    try {
	        gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
	        list = new ArrayList<StRegisterBean>(); 
	        
	        gc.rs1 = gc.ps1.executeQuery(); 
	        
	        while(gc.rs1.next()) {
	        
	        	StRegisterBean temp = new StRegisterBean();
	        	temp.setFirstName(gc.rs1.getString(1));
	        	temp.setLastName(gc.rs1.getString(2));
	        	temp.setEmail(gc.rs1.getString(3));
	            temp.setUserName(gc.rs1.getString(4));
	            temp.setPassword(gc.rs1.getString(5));
	            temp.setConfirmPassword(gc.rs1.getString(6));
	            temp.setPhone(gc.rs1.getString(7));
	            temp.setLanguage(gc.rs1.getString(8));
	        
	list.add(temp); 
	            
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return list; 
	    }


}
