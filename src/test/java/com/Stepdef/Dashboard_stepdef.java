package com.Stepdef;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Dashboard_stepdef {
	
	public WebDriver driver;
	   @Before
		public void setup() {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("file:///D:/Selenium_study/Offline%20Website/index.html");
		}
	   @After
	   public void teardown() {
		   driver.quit();
	   }
		/*@Given("user should be on login page1")
		public void user_should_be_on_login_page() {
			Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");

		}*/
	
	@When("User enter valid username and Password")
	public void user_enter_valid_username_and_password(DataTable Cred) {
		List<String> data=Cred.row(0);
		driver.findElement(By.id("email")).sendKeys(data.get(0));
		driver.findElement(By.id("password")).sendKeys(data.get(1));
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	    
	}
	@Then("User should be on Dashboard page")
	public void user_should_be_on_dashboard_page() {
	       Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	@Then("User click on User link and User page should open")
	public void user_click_on_user_link_and_user_page_should_open() {
	   driver.findElement(By.xpath("//span[contains(text(),'Users')]")).click();
	 
	}
	@Then("User enter user details")
	public void user_enter_user_details(DataTable userdata) throws Exception {
		driver.findElement(By.xpath("//button[contains(text(),'Add User')]")).click();
		Thread.sleep(2000);
	       List<String> usersData = userdata.row(0);
	       driver.findElement(By.id("username")).sendKeys(usersData.get(0));
	       driver.findElement(By.id("mobile")).sendKeys(usersData.get(1));
	       driver.findElement(By.id("email")).sendKeys(usersData.get(2));
	       driver.findElement(By.id("course")).sendKeys(usersData.get(3));
	       driver.findElement(By.xpath("//input[contains(@type,'radio')]")).click();
	       Select d = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
	       d.selectByVisibleText("HP");
	       driver.findElement(By.id("password")).sendKeys(usersData.get(4));
	       driver.findElement(By.xpath("//input[contains(@placeholder,'FriendMobile')]")).sendKeys(usersData.get(5));
	       driver.findElement(By.id("submit")).click();
	       Alert p = driver.switchTo().alert();
	       Thread.sleep(2000);
	      p.accept();
	}
	@Then("User click on Submit button")
	public void user_click_on_submit_button() {
	  
	}
	@Then("User click on UserFul links  and User page should open")
	public void user_click_on_user_ful_links_and_user_page_should_open() throws Exception {
		driver.findElement(By.xpath("//span[contains(text(),'Useful Links')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Go !')]")).click();
		  Set<String> handles = driver.getWindowHandles();
		  Iterator<String> it =handles.iterator();
		   String ParentID = it.next();
		   System.out.println("parent window id :"+ParentID);
		   String ChildID = it.next();
		   System.out.println("Child Window id:" +ChildID);
		   driver.switchTo().window(ParentID);
		   driver.findElement(By.xpath("//span[contains(text(),'Talk to our Expert')]")).click();
		
	   
	}
	/*@Then("User Click on GO button and page should open")
	public void user_click_on_go_button_and_page_should_open() {
	  driver.findElement(By.xpath("//span[contains(text(),'Go !')]")).click();
	  Set<String> handles = driver.getWindowHandles();
	  Iterator<String> it =handles.iterator();
	   String ParentID = it.next();
	   System.out.println("parent window id :"+ParentID);
	   String ChildID = it.next();
	   System.out.println("Child Window id:" +ChildID);
	   driver.switchTo().window(ParentID);
	   driver.findElement(By.xpath("//span[contains(text(),'Talk to our Expert')]")).click();
  	}*/

}
