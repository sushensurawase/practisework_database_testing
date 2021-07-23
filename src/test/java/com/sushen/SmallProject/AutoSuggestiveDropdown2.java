package com.sushen.SmallProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestiveDropdown2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
		element.sendKeys("radhe mem");
		List<WebElement> drpElement = driver.findElements(By.xpath("//ul[@class='erkvQe']/li[@data-view-type='1']"));
		System.out.println("Number of element is " + drpElement.size());
		for (int i = 0; i < drpElement.size(); i++) {
			System.out.println(drpElement.get(i).getText());
		}
		for (WebElement option : drpElement) {
			if (option.getText().contains("memes")) {
				option.click();
				break;
			}

		}

	}

}
