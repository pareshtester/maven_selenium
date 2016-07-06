package com.ee.mavenlearning.com.ee.gmail;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class deleting_sentlist {
	WebDriver wd;
	//WebDriver wd;
	drivers.BrowserType type=drivers.BrowserType.CHROME;
	elements we ;
	 	//String str="hjhjvhv";
	public String url="http://www.gmail.com";
	@BeforeMethod
	public void setup() throws MalformedURLException{
		
		wd = drivers.Browser(type,true);
		wd.get("http://www.gmail.com");
		we= PageFactory.initElements(wd, elements.class);
	//	signin s = new signin();
	//	s.sign_in();
	
			String str=null;
		
			
		
	}
	@Test(dataProviderClass=dataprovider.class,dataProvider="info")
	public void delete(String user,String pass) throws InterruptedException{

		String str=null;
		we.sign(user,pass);
         if(str != null && !str.isEmpty()){
	    	
	    	we.sign_error(str);
	    }else{
		    we.check_error();
	    }
		we.delete_sent();
		
		
	}
	@AfterTest
	public void close() throws InterruptedException{
		we.logout();
		Thread.sleep(1000);
		wd.quit();
		
	}
	
	

}
