package com.ilia.pages;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Login_User {

	public static void timeOut(WebDriver driver, Integer time) throws TimeoutException {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

@Test(priority=0)
	public static void loadWebsite(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().window().maximize();

	}

	public static void clickOnelement(WebDriver driver, String xpath) throws Exception {
		driver.findElement(By.xpath(xpath)).click();

	}

	public static void fillTextBox(WebDriver driver, String xpath, String input) {
		driver.findElement(By.xpath(xpath)).sendKeys(input);
	}

}
