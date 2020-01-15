package com.ilia.pages;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.ilia.web.BrowserDriver;

public class Client_Module {

	public static String url = "https://staging.myilia.com";
	public static Logger logger = Logger.getLogger(Client_Module.class);

	@Test
	public void timeOut(WebDriver driver, Integer time) throws TimeoutException {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void loadWebsite(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().window().maximize();
//		log.debug("opening webiste");
	}

	@Test(priority = 1)
	public void clickOnelement(WebDriver driver, String xpath) throws ElementNotVisibleException {
		driver.findElement(By.xpath(xpath)).click();

	}

	@Test(priority = 2)
	public void fillTextBox(WebDriver driver, String xpath, String input) {
		driver.findElement(By.xpath(xpath)).sendKeys(input);
	}

	{
		try {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\QA_SIMSAW\\Downloads\\chromedriver_win32\\chromedriver.exe");

			// Here we need to create logger instance so we need to pass Class name for
			// which we want to create log file in my case Google is classname
			// configure log4j properties file
			PropertyConfigurator.configure(
					"C:\\Users\\QA_SIMSAW\\eclipse-workspace\\Myilia\\src\\com\\ilia\\pages\\log4j.properties");

//		    Create A Selenium WebDriver Instance "WebDriver is an interface 
//			and all the methods which are declared in Webdriver interface are implemented by respective driver class" 
//		    WebDriver is an interface, driver is a reference variable, 
//          FirefoxDriver() is a Constructor, new is a keyword, and new ChromeDriver() is an Object.
			WebDriver driver = new ChromeDriver();
            // Load Chrome Browser
			loadWebsite(driver, url);
			// Break after hit Url in browser
			timeOut(driver, 5);
			logger.debug("opening webiste");
            // Click on login page Button
			clickOnelement(driver, "//*[@id=\'home-slider-container\']/button");
            // Break after Load Login page in browser
			timeOut(driver, 15);
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
            // Fill username and password.
			fillTextBox(driver, "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[1]/div/input",
					"client408@simsaw.com");
			fillTextBox(driver, "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[2]/div/input",
					"Client123!");
            // Click on Sign in Button
			clickOnelement(driver, "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[3]/button/span[1]");
            // Break after Load Login page in browser
			timeOut(driver, 10);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            // click on other Element
			clickOnelement(driver, "//*[@id=\"root\"]/div/div/nav/div/div/div/div/ul[1]/div/div[2]/div/span");
            // click on View all button
			clickOnelement(driver,
					"//*[@id=\"root\"]/div/main/div[1]/div[3]/div/div/div/div[3]/div/div/button[1]/span[1]");
            // click on graph view
			clickOnelement(driver, "/html/body/div[3]/div[3]/div/div/div[1]");
			timeOut(driver, 10);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            // click on bottom arrow button for move to previous page
			clickOnelement(driver, "/html/body/div[3]/div[3]/div/div/div[2]/div[2]/div/button");
			// click on financial Solution
			clickOnelement(driver, "//*[@id=\"root\"]/div/div/nav/div/div/div/div/ul[1]/div/div[3]/div");
			// click on product
			clickOnelement(driver, "//*[@id='root']/div/div/nav/div/div/div/div/ul[1]/div/div[5]/div[1]/div");
			// click on leverage
			clickOnelement(driver, "//*[@id=\"root\"]/div/div/nav/div/div/div/div/ul[1]/div/div[5]/div[2]/div");
			// scroll the page withelement
			for (int i = 0; i < 4; i++) {
				clickOnelement(driver, "//*[@id=\"root\"]/div/main/div[2]/div/div/div");
				Thread.sleep(100);
			}
			// scroll down the page
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
			// click on Minimize-risk
			clickOnelement(driver, "//*[@id=\"root\"]/div/div/nav/div/div/div/div/ul[1]/div/div[5]/div[3]/div");
			// scroll the page withelement with for loop statement
			for (int i = 0; i < 2; i++) {
				clickOnelement(driver, "//*[@id=\"root\"]/div/main/div[2]/div/div/div");
				Thread.sleep(1000);
			}
			timeOut(driver, 30);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Click On Plan Details
			clickOnelement(driver, "//*[@id=\"root\"]/div/div/nav/div/div/div/div/ul[1]/div/div[6]/div");
			timeOut(driver, 50);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Click On Participants sayning
			clickOnelement(driver, "//*[@id=\"root\"]/div/div/nav/div/div/div/div/ul[1]/div/div[7]/div");
			timeOut(driver, 30);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Click On FAQ
			clickOnelement(driver, "//*[@id=\"root\"]/div/div/nav/div/div/div/div/ul[1]/div/div[8]/div");
			timeOut(driver, 50);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// click On Enroll now Button
			clickOnelement(driver, "//*[@id=\"root\"]/div/div/nav/div/div/div/div/ul[2]/li[1]/button");
			Thread.sleep(1000);
			driver.getWindowHandle();
			// To click on the 'Cancel' button of the alert.
			driver.switchTo().alert().dismiss();
			clickOnelement(driver, "/html/body/div[3]/div[3]/div/div[2]/div[1]/button/span[1]");
			// click on cancel button
			clickOnelement(driver, "/html/body/div[3]/div[3]/div/div[2]/div[2]/button");
			// click on chat icon
			clickOnelement(driver, "//*[@id='root']/div/main/div/div/div[3]/button");
			// filltext
			fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div[3]/div/div[2]/form/div[1]/textarea[1]",
					"text user");
			// click on send button
			clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div[3]/div/div[2]/form/div[2]/button");
			// click on cross button to close the chat window
			clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div[3]/div/div[1]/button");
			// click on setting icon
			clickOnelement(driver, "//*[@id=\"root\"]/div/div/header/div/div[2]/button[3]");
			// click on logout
			clickOnelement(driver, "//*[@id=\"menu-appbar\"]/div[3]/ul/li[4]");
			// close the browser
			driver.close();
		} catch (Exception error) {
			System.out.println("error.toString())");
		}
	}
}
