package com.sushen.SmallProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.graphbuilder.struc.LinkedList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {
	private ChromeDriver driver;

	@BeforeTest
	public void launching() throws Exception
	{
		VideoRecorder_utlity.startRecord("GoogleTestRecording");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.monsterindia.com/");
	}
	@Test
	public void test() throws Exception
	{
		
		driver.findElement(By.xpath("//div[@class='or']/following-sibling::a")).click();
		WebElement element=driver.findElement(By.xpath("(//input[@id='file-upload'])[1]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);						
		Runtime.getRuntime().exec("C:\\Users\\sushe\\Downloads\\uploadbutton.exe");
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.close();
		VideoRecorder_utlity.stopRecord();
		 
		
		
		
		
		
		
	}
	
}
		
	

