package com.ilia.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class My_Account {

	
	public static void timeOut(WebDriver driver, Integer time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	public static void loadWebsite(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void clickOnelement(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	

	public static void fillTextBox(WebDriver driver, String xpath, String input) {
		driver.findElement(By.xpath(xpath)).sendKeys(input);
	}
}
