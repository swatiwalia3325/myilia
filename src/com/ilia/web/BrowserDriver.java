package com.ilia.web;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserDriver {

	public static WebDriver driver;

 public static Logger logger = Logger.getLogger(BrowserDriver.class);

 
	public static WebDriver launchbrowser(String browserType) throws Exception {

		try {
			if (browserType.equals(browsers.FIREFOX.getValue())) {
				driver = launchFirefox();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			} else if (browserType.equals(browsers.CHROME.getValue())) {
				driver = launchChrome();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			} else if (browserType.equals(browsers.IEXPLORER.getValue())) {
				driver = launchIE();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			} else {
				throw new Exception("driver does not started");
			}
			driver.manage().window().maximize();
			logger.info(browserType + "driver ready for testing");

		} catch (Exception ex) {
			logger.info(browserType + "driver does not started");
			throw new Exception("driver does not started");
		}

		return driver;
	}

	public static WebDriver launchFirefox() {
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	public static WebDriver launchChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\QA_SIMSAW\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public static WebDriver launchIE() {
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/InternetExplorerdriver.exe");
		WebDriver driver = new InternetExplorerDriver();
		return driver;
	}


}
