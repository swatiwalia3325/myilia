package com.ilia.pages;

import java.util.concurrent.TimeUnit;

import javax.naming.NameNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

public class Admin_Creation {
	
	public static void  ButtonOnclick(WebDriver driver, String xpath) throws ElementNotVisibleException {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static boolean fillTextBox(WebDriver driver, String xpath, String input) {
		driver.findElement(By.xpath(xpath)).sendKeys(input);
		return false;
		
	}
	public static void timeOut(WebDriver driver, Integer time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}
	
	
	public static void dropdown(WebDriver driver, String xpath, String input) {
		driver.findElement(By.xpath(xpath)).sendKeys(input);
	}

}
