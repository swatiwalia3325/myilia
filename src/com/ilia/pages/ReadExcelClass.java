package com.ilia.pages;

import java.awt.Window;
import java.lang.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadExcelClass {
	
	public static String url="https://staging.myilia.com";

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\QA_SIMSAW\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		Actions actions1 = new Actions(driver);
		
		// Load Chrome Browser
					Login_User.loadWebsite(driver, url);
					// Break after hit Url in browser
					
					// Click on login-page Button
					driver.findElement(By.xpath("//*[@id=\'home-slider-container\']/button")).click();
					Thread.sleep(2000);
					
		
			 Xls_Reader url = new Xls_Reader("C:\\Users\\QA_SIMSAW\\Desktop\\ilia_user.xlsx");
			 
			 for(int b=2; b<=2; b++)
			    {
			driver.get(url.getCellData("URL", "Url", b));
			Thread.sleep(2000);
			    }

	
	//==================================Login=============================

	for (int c=2;c <=5;c++)		
	{
		String regStatus = url.getCellData("Registration", "Status", c);
		System.out.println(regStatus);
		if (regStatus.equalsIgnoreCase("Pass"))
		{
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[1]/div/input")).sendKeys(url.getCellData("Registration", "Email" , c));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[2]/div/input")).sendKeys(url.getCellData("Registration", "Password" , c));	
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[3]/button/span[1]")).click();
			
		}
		else
		{
			System.out.println("status-------" + regStatus);
		}
	}


	}
}

	