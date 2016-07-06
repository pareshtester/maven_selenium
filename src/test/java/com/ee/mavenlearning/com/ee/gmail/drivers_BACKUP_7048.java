package com.ee.mavenlearning.com.ee.gmail;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class drivers {
	 
  
   
  
   public enum BrowserType{
	   
	  FIREFOX,
	  CHROME,	  
	  IE;
	   String value;
	 /* BrowserType(String value){
		  this.value=value;
	  }
	  public String getbrowsername(){
		  return this.value;
		  
	  }*/
	   
	    }
   
  // @SuppressWarnings("null")
public static WebDriver Browser(BrowserType type,boolean isgrid) throws MalformedURLException{
	    WebDriver wd=null;
	    /*
if(isgrid){
		   
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setBrowserName("firefox");
		dc.setPlatform(Platform.WIN10);
		return new RemoteWebDriver(new URL("http://192.168.0.4:1234/wd/hub"),dc);
		
		   
<<<<<<< HEAD
	   }
	   */
=======
	   }*/
	   
>>>>>>> 45eaf6949b78bc6d22aff8dee99b506a0a8ecf7e
	   
	   
	   switch(type){
	   
	   case FIREFOX:
		     wd =  new FirefoxDriver();
		    // return wd;
	  // case CHROME:
	  break;
		  // break;
	case CHROME:
		System.setProperty("webdriver.chrome.driver","C:/Users/paresh/Desktop/selenium/chromedriver_win32/chromedriver.exe");
	    wd = new ChromeDriver();	
	    break;
	case IE:
		
		break;
	default:
	 
	break;
	   
	   
	   }
  return wd;
	   
	   
   }/*
public static BrowserType getbrowsertypeproperty(){
	
	BrowserType type=null;
	//String browser_name=PropertyManager.getPropert();
	
}*/
	
	
}
