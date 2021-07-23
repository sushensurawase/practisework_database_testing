package com.sushen.SmallProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.reflect.Reflection;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBusSearch {

	public static void main(String[] args) throws IOException {

		
		
		String from = "pune";
		String to = "mumbai";
		String expectedDay ="20";
		String expectedMonth = "jun";
		String expectedYear = "2021";
		ChromeOptions option=new ChromeOptions();
		//List list1=Arrays.asList("incognito","disable-popup-blocking","version","disable-infobars");
		option.addArguments("disable-infobars");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("http:\\www.redbus.in");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@class='db'])[1]")).sendKeys(from);
		List<WebElement> list = driver.findElements(By.xpath("(//ul[@class='autoFill'])[1]/li"));
		for (WebElement element : list) {
			if (element.getText().trim().equalsIgnoreCase(from)) {
				element.click();
				break;
			}
		}
		driver.findElement(By.xpath("(//input[@class='db'])[2]")).sendKeys(to);
		list = driver.findElements(By.xpath("(//ul[@class='autoFill'])[1]/li"));
		for (WebElement element : list) {
			if (element.getText().trim().equalsIgnoreCase(to)) {
				element.click();
				break;
			}
		}

		while (true) {
			WebElement cal = driver.findElement(By.xpath("//td[@class='monthTitle']"));
			String[] monthYear = cal.getText().split(" ");
			String month = monthYear[0];
			String year = monthYear[1];
			if (month.equalsIgnoreCase(expectedMonth) && year.equalsIgnoreCase(expectedYear)) {
				break;

			}
			driver.findElement(By.xpath("//td[@class='next']")).click();

		}
		list = driver.findElements(By.xpath("//*[@class='we day' or @class='current day' or @class='wd day']"));
		for (WebElement calender : list) {
			if (calender.getText().equals(expectedDay)) {
				calender.click();
				break;
			}

		}
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		
		
		
				

	}

}
