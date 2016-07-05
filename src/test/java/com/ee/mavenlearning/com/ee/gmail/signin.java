/**
 * 
 */
package com.ee.mavenlearning.com.ee.gmail;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author paresh
 *
 */
public class signin {
	
	WebDriver wd;
	drivers.BrowserType type=drivers.BrowserType.FIREFOX;
	elements we ;
	 	//String str="hjhjvhv";
	public String url="http://www.gmail.com";
	@BeforeTest
	public void setup() throws MalformedURLException{
		
		wd = drivers.Browser(type,true);
		wd.get("http://www.gmail.com");
		we= PageFactory.initElements(wd, elements.class);
		
	}
	@Test
	public void sign_in(){
		String str=null;
		we.sign(str);
         if(str != null && !str.isEmpty()){
	    	
	    	we.sign_error(str);
	    }else{
		    we.check_error();
	    }
		
	}
	
	
	@AfterTest
	public void close() throws InterruptedException{
		we.logout();
		Thread.sleep(1000);
		wd.quit();
		
	}
	
	
	

}
