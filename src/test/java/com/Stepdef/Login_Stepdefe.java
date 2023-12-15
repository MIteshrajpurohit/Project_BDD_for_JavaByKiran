package com.Stepdef;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Login_Stepdefe {
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
	@Given("user should be on login page")
	public void user_should_be_on_login_page() {
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");

	}

	@Then("User should see Header txt on login page")
	public void user_should_see_header_txt_on_login_page() {
		String headerTXT= driver.findElement(By.xpath("//b[contains(text(),'Java By Kiran')]")).getText();
		Assert.assertEquals(headerTXT, "Java By Kiran");

	}
	@When("Click on Register a new membership link")
	public void click_on_register_a_new_membership_link() {
		WebElement txtname = driver.findElement(By.xpath("//a[contains(text(),'Register a new membership')]"));
	  String linkname = txtname.getText();
	  Assert.assertEquals(linkname, "Register a new membership");
	//  txtname.click();
	 
	}
	@Then("User should be on Register page")
	public void user_should_be_on_register_page() {
		WebElement txtname = driver.findElement(By.xpath("//a[contains(text(),'Register a new membership')]"));
		txtname.click();
		Assert.assertEquals(driver.getTitle(),"JavaByKiran | Registration Page"); 
	}
	@Then("user enter regitration details")
	public void user_enter_regitration_details(DataTable tablevalue) {
                 List<String> data = tablevalue.row(0);	   
                 System.out.println(data.get(0));
      driver.findElement(By.id("name")).sendKeys(data.get(0));
      driver.findElement(By.id("mobile")).sendKeys(data.get(1));
      driver.findElement(By.id("email")).sendKeys(data.get(2));
      driver.findElement(By.id("password")).sendKeys(data.get(3));
      
	}
	@Then("Click on Sign button")
	public void click_on_sign_button() throws Exception {
	    driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
	    Alert popup = driver.switchTo().alert();
	     String txt_popup = popup.getText();
	     Assert.assertEquals(txt_popup, "User registered successfully.");
	     Thread.sleep(2000);
	     popup.accept();
	    
	}

}
