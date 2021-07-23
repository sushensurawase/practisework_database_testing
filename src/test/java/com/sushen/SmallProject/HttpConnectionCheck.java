package com.sushen.SmallProject;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HttpConnectionCheck {
	
	
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String day="20";
		String month="Feb";
		String year="2022";
		
		driver.get("https://www.spicejet.com/");
		
		
		WebElement option=driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_originStation1']"));
		Actions action=new Actions(driver);
		action.moveToElement(option).click().perform();
		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", option);
		Thread.sleep(2000);
		/*
		List<WebElement> select=driver.findElements(By.xpath("//select[@id='ctl00_mainContent_ddl_originStation1']/option"));
		Iterator<WebElement> itr=select.iterator();
		while(itr.hasNext())
		{
		WebElement itrElement=itr.next();
		if(itrElement.getText().contains("Surat"))
		{
			itrElement.click();
			break;
		}
		}
		
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).click();
		List <WebElement> monthBlock=driver.findElements(By.xpath("//span[@class='ui-datepicker-month']"));
		List <WebElement> yearBlock=driver.findElements(By.xpath("//span[@class='ui-datepicker-year']"));
		
		
		
		int i=0;
		while(!(monthBlock.get(i).getText().contains(month)&&yearBlock.get(i).getText().contains(year)))
		{
		
			i++;
			if(!(monthBlock.get(i).getText().contains(month)&&yearBlock.get(i).getText().contains(year)))
			{
				driver.findElement(By.xpath("//a[@data-handler='next']")).click();	
				i--;
				monthBlock=driver.findElements(By.xpath("//span[@class='ui-datepicker-month']"));
				yearBlock=driver.findElements(By.xpath("//span[@class='ui-datepicker-year']"));
				
			}
			
		}
		List<WebElement> dateBlock=driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])["+(i+1)+"]//tr/td"));
		
		
		
		for(int j=0;j<dateBlock.size();j++)
		{
			if(dateBlock.get(j).getText().contains(day))
			{
				dateBlock.get(j).click();
				break;
			}
		}
		Thread.sleep(2000);
		//driver.close();
		
		*/
		
	}

}
