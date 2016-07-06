/**
 * 
 */
package com.ee.mavenlearning.com.ee.gmail;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.http.util.Asserts;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import bsh.StringUtil;

/**
 * @author paresh
 *
 */
public class elements {
 WebDriver wd;
 String str=" The email and password that you entered don't match.";
 //error_elements ee = PageFactory.initElements(wd, error_elements.class);
 String path=null;
 public elements(WebDriver wd){
	 
	 this.wd=wd;
	 
	 
 }
 
  //element locators
 //signin elements
  @FindBy(xpath=".//*[@id='Email']")WebElement field_user;
  @FindBy(xpath=".//*[@id='next']")WebElement button_next;
  @FindBy(xpath=".//*[@id='Passwd']")WebElement field_pass;
  @FindBy(xpath=".//*[@id='signIn']")WebElement field_signin;
  @FindBy(xpath=".//*[@id=':j']/span")WebElement field_test1;
//sign in error elements
  @FindBy(xpath=".//*[@id='errormsg_0_Passwd']") WebElement error1;
  //logout elements
  @FindBy(xpath=".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")WebElement logout_click;
  @FindBy(xpath=".//*[@id='gb_71']")WebElement logout;	
//compose elements
  @FindBy(xpath="//*[@id=':j2']/div/div")WebElement compose_click;
  @FindBy(css=".vO")WebElement compose_to;
  @FindBy(css=".aoT")WebElement compose_subject;
  @FindBy(css=".Ar>[aria-label='Message Body']")WebElement compose_message;
  @FindBy(css=".a1")WebElement compose_attach;
  @FindBy(css="[aria-label='Send ‪(Ctrl-Enter)‬']")WebElement compose_send;
  @FindBy(id="link_vsm")WebElement compose_verify;
  //deleting sent mails elements
  @FindBy(css=".nU>.J-Ke[title='Sent Mail']")WebElement sent_click;
  @FindBy(xpath="//div[@class='nH']/div/div/div[@class='Cp']/div/table/tbody")WebElement delete_select_row;
  @FindBy(xpath="//div[@class='nH']/div/div/div[@class='Cp']/div/table/tbody/tr[2]/td[2]/div")WebElement delete_select_col;
  @FindBy(xpath=".//*[@class='aeH']/div[2]/div[1]/div[1]/div/div/div[2]/div[3]")WebElement delete1;
  
  //@FindBy(xpath=path)WebElement path1;
  //paths
  //div[@class='nH']/div/div/div[@class='Cp']/div/table/tbody/tr[2]/td[2]/div
  String start="//div[@class='nH']/div/div/div[@class='Cp']/div/table/tbody/tr";
  String end="]";
  
	public void sign(String user,String password){
		//wd.manage().deleteAllCookies();
		field_user.sendKeys(user);
		button_next.click();
		WebElement pass = new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOf(field_pass));
		pass.sendKeys(password);
		field_signin.click();
		
	}
	public void check_error(){
		WebElement get_text=new WebDriverWait(wd, 20).until(ExpectedConditions.visibilityOf(field_test1));
		String x =get_text.getText();
		System.out.println(x);
	    Assert.assertEquals(x,"Gmail");
	   // wd.manage().deleteAllCookies();
	}
	//sign in error function
		public boolean sign_error(String error){
			try{
				String x= error1.getText();
				System.out.println(x);
				return error1.equals(error);
			}catch(NoSuchElementException e){
			return false;
			}
}
		//logout
		public void logout(){
			
			
			logout_click.click();
			logout.click();
			
		}
		public void compose(String mail,String sub,String msg) throws IOException{
			WebElement compose_click2 = new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOf(compose_click));
			compose_click2.click();
			WebElement compose_to2 = new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOf(compose_to));
			compose_to2.sendKeys(mail);
			compose_subject.sendKeys(sub);
			compose_message.sendKeys(msg);
			compose_attach.click();
			Runtime.getRuntime().exec("C:/Users/paresh/Desktop/resume");
			compose_send.click();
			WebElement compose_verify2=new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOf(compose_verify));
			Assert.assertEquals("View message", compose_verify2.getText());
			
		}
		public void delete_sent() throws InterruptedException{
			WebElement sent_click2 = new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOf(sent_click));
			sent_click2.click();
			Thread.sleep(3000);
		//	WebElement delete_select_row2 = new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOf(delete_select_row));

		//	List<WebElement> row_count = delete_select_row2.findElements(By.cssSelector(">tr"));
		//	int r = row_count.size();
			//for(r=0;r<3;r++){
				
			//	delete_select_col.click();
	    /*   List<WebElement> options = delete_select_row.findElements(By.tagName("tr"));
	       java.util.Iterator<WebElement> i =options.iterator();
	       int j=0;
	       while(i.hasNext() && j<3){
	    	   
	    	   System.out.println(i);
	    	   
	    	   delete_select_col.click();
	    	   i.next();
	    	   j++;
	    	   
			
		}*/
			for(int i=1;i<5;i++){
				String path1="//div[@class='nH']/div/div/div[@class='Cp']/div/table/tbody/tr[";
				String path2="]/td[2]/div";
				path=path1+i+path2;
				wd.findElement(By.xpath(path)).click();
				//i++;
				System.out.println(i);
			}
			//}
			WebElement delete_wait=new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOf(delete1));
			//delete_wait.click();
			Actions action = new Actions(wd).contextClick(delete_select_col);
			action.build().perform();
			
			//Alert alert = wd.switchTo().alert();
			//WebDriverWait wait = new WebDriverWait(wd, 10);
			
		//	Alert element = wait.until(ExpectedConditions.alertIsPresent());
		
		//	System.out.println(alert.getText());
		//	element.accept();
			
			try {
				//Now once we hit AlertButton we get the alert
				Alert alert = wd.switchTo().alert();
				//Text displayed on Alert using getText() method of Alert class
			//	String AlertText = alert.getText();
				//accept() method of Alert Class is used for ok button
				alert.accept();
				//Verify Alert displayed correct message to user
				//assertEquals("this is alert box",AlertText);
				} catch (Exception e) {
				e.printStackTrace();
				}
		}
		
			
			
		}
		
		

