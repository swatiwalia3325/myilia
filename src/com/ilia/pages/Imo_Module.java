package com.ilia.pages;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Imo_Module {

	public static String url = "https://staging.myilia.com";
	
	@Test(priority=1)
	public static void timeOut(WebDriver driver, Integer time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}
	
	@Test(priority=0)
	public static void loadWebsite(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test(priority=2)
	public static void clickOnelement(WebDriver driver, String xpath)
			throws IOException, NullPointerException, InterruptedException, NoSuchElementException {
		driver.findElement(By.xpath(xpath)).click();
}
	@Test(priority=3)
	public static void fillTextBox(WebDriver driver, String xpath, String input) {
		driver.findElement(By.xpath(xpath)).sendKeys(input);
	}
	public static void fillTextClear(WebDriver driver, String xpath, String input) {
		driver.findElement(By.xpath(xpath)).clear();
		}
	{
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\QA_SIMSAW\\Downloads\\chromedriver_win32\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();
			// Load Chrome Broser
			loadWebsite(driver, url);
			// Break after hit Url in browser
			timeOut(driver, 5);

			// Click on login page Button
			clickOnelement(driver, "//*[@id=\'home-slider-container\']/button");

			// Break after Load Login page in browser
			timeOut(driver, 5);
			
			//Click On forget password
			clickOnelement(driver, "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[4]/div/a");
			
			//Enter Email
		
			fillTextBox(driver, "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[1]/div/input, input","swati@simsaw.com");
			
			//Click On Reset Button
			clickOnelement(driver, "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[2]/button");
			
			// Break after Load Login page in browser
						timeOut(driver, 5);
			//Redirect back
		clickOnelement(driver, "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/a/");
			

			// Fill username and password.
			fillTextBox(driver, "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[1]/div/input",
					"imo129@simsaw.com");
			fillTextBox(driver, "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[2]/div/input",
					"Admin123!");

			// Click on Sign in Button
			clickOnelement(driver, "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[3]/button/span[1]");
			clickOnelement(driver, "//*[@id=\root\"]/div/div/div[1]/button/span[1]");

			// Break after Load Login page in browser
			timeOut(driver, 25);
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

			// Listing
			clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div[2]/div/div/div/div[2]/div");
			clickOnelement(driver, "//*[@id=\"menu-\"]/div[3]/ul/li[1]");

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			// Click On Edit Buton 
			clickOnelement(driver,
					"//*[@id=\"root\"]/div/main/div/div[2]/div/div/div/div[4]/div/table/tbody/tr[3]/td[9]/button[1]");
			Logger log = Logger.getLogger("Imo_Module");
			log.info("Edit bUtton");
			// Click On back button
			clickOnelement(driver, "//*[@id=\"root\"]/div/main/a");

			// Click On Delete Button
			clickOnelement(driver,"//*[@id=\"root\"]/div/main/div/div[2]/div/div/div/div[4]/div/table/tbody/tr[1]/td[9]/button[2]");
			// Click On cancel Button
			clickOnelement(driver, "/html/body/div[3]/div[3]/div/div[3]/button");
			// Search Text
			fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div[2]/div/div/div/div[3]/div/div/input", "agent401");

			for (int i = 0; i < 9; i++) {
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div/div/div/div[3]/div/div/input"))
						.sendKeys(Keys.BACK_SPACE);
			}

			// Go To setting

			clickOnelement(driver, "//*[@id=\"root\"]/div/div/header/div/div[2]/button[3]");

			// Click on my profile
			clickOnelement(driver, "//*[@id=\"menu-appbar\"]/div[3]/ul/li[1]");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().back();

			// Go To setting
			clickOnelement(driver, "//*[@id=\"root\"]/div/div/header/div/div[2]/button[3]");
			// Click On Logout Button
			clickOnelement(driver, "//*[@id=\"menu-appbar\"]/div[3]/ul/li[5]");
			driver.close();

			// Set up a simple configuration that logs on the console.

		} catch (Exception err) {

			System.out.println(err.toString());

		}
	}
}