package dataprovider.io.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.util.testdata.TestDataUtilityClass;

public class DataproviderCheck {
	
	WebDriver driver;
	
	static
	{
		System.setProperty("webdriver.chrome.driver", "/home/qapitol/chromedriver");
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.get("http://localhost:8080");
		
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
	Object[][] data = TestDataUtilityClass.getTestData("Login")	;
	return data;
	}
	
	
	@Test(dataProvider="getTestData")
	public void login(String UserName, String Password) throws InterruptedException
	{
		driver.findElement(By.id("j_username")).sendKeys(UserName);
		driver.findElement(By.name("j_password")).clear();
		driver.findElement(By.name("j_password")).sendKeys(Password);
		driver.findElement(By.name("Submit")).click();
		
	}
	
	@AfterMethod()
	public void tearDown()
	{
		driver.close();
	}
	

}
