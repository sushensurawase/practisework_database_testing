package com.sushen.SmallProject;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestScript {
	public static WebDriver driver;
	public static TakesScreenshot screenshot;
	public static LocalDateTime timestamp;
	@BeforeClass 
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test
	public void login() throws IOException
	{
		 
		
		driver.get("http:\\amazon.in");
		timestamp=LocalDateTime.now();
		String s=timestamp.toString();
		String str=s.replace(":", "_").replace("T","_").replace(" ", "_").replace("-", "_");
		File file=new File("./screenshot//"+str+".jpg");
		screenshot=(TakesScreenshot)driver;
		AShot shot=new AShot();
		Screenshot sc=shot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(sc.getImage(), "jpg", file);
		
		
		
		
		
	}
		 
	

}
