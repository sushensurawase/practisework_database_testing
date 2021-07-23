package com.sushen.SmallProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTest {
	public static WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://freecrm.com/");
		
		
	}
	
	@Test(dataProvider = "getData")
	public void loginTest(String username,String password)
	{
		driver.findElement(By.xpath("//div[@class='rd-navbar-panel']/following-sibling::a")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="vickysurawase@gmail.com";
		obj[0][1]="Vicky@3984";
		obj[1][0]="vicky12surawase@gmail.com";
		obj[1][1]="Vicky@3984";
		obj[2][0]="vickysurawase@gmail.com";
		obj[2][1]="Vicky@33984";
		return obj;
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
