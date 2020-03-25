package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\JayvirsinhJethwa\\Desktop\\IBM Upskill\\Selenium\\TestingData.xls"; 
		return new ApachePOIExcelRead().getExcelContent(fileName);    		// ApachePOI to be used when reading from .xlsx file
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:\\Users\\JayvirsinhJethwa\\Desktop\\IBM Upskill\\Selenium\\TestingData.xls", "Sheet1"); 
	}																		// ReadExcel to be used when reading from .xls file
	
	@DataProvider(name = "loginData")
	public Object[][] loginData(){
		//String fileName ="C:\\Users\\JayvirsinhJethwa\\Desktop\\IBM Upskill\\Selenium\\TestingData.xls"; 
		return new ReadExcel().getExcelData("C:\\Users\\JayvirsinhJethwa\\Desktop\\IBM Upskill\\Selenium\\TestingData.xls", "Sheet1");
		}
	
	@DataProvider(name = "TD61_StRegistration")
	public Object[][] TD61_StRegistration(){
		//String fileName ="C:\\Users\\JayvirsinhJethwa\\Desktop\\IBM Upskill\\Selenium\\TestingData.xls"; 
		return new ReadExcel().getExcelData("C:\\Users\\JayvirsinhJethwa\\Desktop\\IBM Upskill\\Project\\ELTD_061.xls", "Sheet1");
		}
}
