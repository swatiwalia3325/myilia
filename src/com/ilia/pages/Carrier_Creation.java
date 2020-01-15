package com.ilia.pages;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Carrier_Creation {

	public static void timeOut(WebDriver driver, Integer time) throws TimeoutException {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	public static void loadWebsite(WebDriver driver, String url) throws WebDriverException {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void clickElements(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void fillTextBox(WebDriver driver, String xpath, String input) {
		driver.findElement(By.xpath(xpath)).sendKeys(input);
	}

}
