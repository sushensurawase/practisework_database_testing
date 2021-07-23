package com.sushen.SmallProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class DatabaseDemo {
	@Test(dataProvider = "getData")
	public void databaseTest(String fName,String lName,String mail,String phone,String pass,String cPass) throws SQLException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/opencart/upload/");
		driver.findElement(By.xpath("//ul[@class='list-inline']/li[@class='dropdown']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		//entering f name
		driver.findElement(By.xpath("//*[@id='input-firstname']")).sendKeys(fName);
		//entering last name
		driver.findElement(By.xpath("//*[@id='input-lastname']")).sendKeys(lName);
		//mail
		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys(mail);
		//phone number
		driver.findElement(By.xpath("//*[@id='input-telephone']")).sendKeys(phone);
		//password
		driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys(pass);
		//confirm pass
		driver.findElement(By.xpath("//*[@id='input-confirm']")).sendKeys(cPass);
		driver.findElement(By.xpath("//*[@id='content']/form/div/div/input[1]")).click();
		driver.findElement(By.xpath("//*[@id='content']/form/div/div/input[2]")).click();
		Connection con=	DriverManager.getConnection("jdbc:mysql://localhost:3325/openshop","root","");
		Statement st=con.createStatement();
		
		ResultSet result=st.executeQuery("SELECT firstname,lastname,email,telephone FROM `oc_customer`;");
		boolean b=false;
		while(result.next())
		{
			String firstName=result.getString("firstname");
			String lastName=result.getString("lastname");
			String email=result.getString("email");
			String telephone=result.getString("telephone");
			
			System.out.println(firstName+"---"+lastName+"---"+email+"---"+telephone);
			if(firstName.equals(fName)&&lastName.equals(lName)&&email.equals(mail)&&telephone.equals(phone))
			{
				System.out.println("record found");
				b=true;
				break;
			}
		}
		if(b==false)
		{
			System.out.println("record not found");
		}
		
	
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=new Object[1][6];
		obj[0][0]="sgfkushen";
		obj[0][1]="sur";
		obj[0][2]="su17452s@gmail.com";
		obj[0][3]="9326520082";
		obj[0][4]="sushen74558";
		obj[0][5]="sushen74558";
		return obj;
		
	}
	
	

}
