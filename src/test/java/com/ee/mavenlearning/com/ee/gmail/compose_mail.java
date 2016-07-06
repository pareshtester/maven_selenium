package com.ee.mavenlearning.com.ee.gmail;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class compose_mail {
	
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
	
		
			
		
	}
	
	@Test(dataProviderClass=dataprovider.class,dataProvider="compse_msg")
	public void compose(String user,String pass,String mail,String sub,String msg) throws IOException{
		String str=null;
		we.sign(user,pass);
         if(str != null && !str.isEmpty()){
	    	
	    	we.sign_error(str);
	    }else{
		    we.check_error();
	    }
		we.compose(mail,sub,msg);
		
		
	}
	@AfterMethod
	public void close() throws InterruptedException{
		//we.logout();
		Thread.sleep(1000);
		//wd.quit();
		
	}
}
