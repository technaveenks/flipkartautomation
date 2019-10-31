package com.muralitechnologies.ecommerce.flipkartautomation.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	private static WebDriver driver;
	
	@BeforeClass
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Sel_oct\\flipkartautomation\\src\\test\\java\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.flipkart.com");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	}
	
	public WebDriver getDriver(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Sel_oct\\flipkartautomation\\src\\test\\java\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.flipkart.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click(); 
		return driver;
	}
	
	public static void getscreenshot(String MethodName) throws Exception {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\Hp\\Sel_oct\\flipkartautomation\\Screenshots\\"+MethodName+"-"+System.currentTimeMillis()+".png"));
		FileUtils.copyFile(scrFile, new File("C:\\Users\\Hp\\Sel_oct\\flipkartautomation\\Screenshots\\"+MethodName+".png"));
	}
	
	@AfterClass
	public void teardown(){
		driver.quit();
	}

}
