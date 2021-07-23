package com.sushen.SmallProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptMethods {

	public static void main(String[] args) throws IOException {
		//WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String s="Belagavi (IXG)";
		WebElement element=driver.findElement(By.xpath("(//input[@class='select_CTXT'])[1]"));
		datePicker(driver,element,s);
//		findWebElement("//input[@id='email']", driver).sendKeys("sushenkumar");
//		findWebElement("//input[@id='pass']", driver).sendKeys("sushenkk");
//
//		clickByJavaScript(By.xpath("//button[@name='login']"), driver);
		System.out.println(driver.getTitle());

	}

	private static void datePicker(WebDriver driver, WebElement element, String s) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value', '"+s+"');", element);
		
	}

	private static WebElement findWebElement(String string, WebDriver driver) {
		return driver.findElement(By.xpath(string));

	}

	private static void clickByJavaScript(By xpath, WebDriver driver) {
		WebElement element = driver.findElement(xpath);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

}
