package com.ee.mavenlearning.com.ee.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class demo {
	
	WebDriver wd;
	@Test
	public void open(){
	//	System.setProperty(webdriver.driver.cohrome, value)
		System.setProperty("webdriver.chrome.driver","C:/Users/paresh/Desktop/selenium/chromedriver_win32/chromedriver.exe");
		wd= new ChromeDriver();
		wd.get("http://www.gmail.com");
		
	}

}
