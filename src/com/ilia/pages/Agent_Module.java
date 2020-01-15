package com.ilia.pages;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Agent_Module {

public static String url = "https://staging.myilia.com";


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
	 public static void fileupload(WebDriver driver,String xpath, String input) throws ElementNotVisibleException,InterruptedException{ 
		 driver.findElement(By.xpath(xpath)).sendKeys();
		 
		 
	 }
	 public static void main(String[] args) {

		try {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\QA_SIMSAW\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			// Load Chrome Broser
						loadWebsite(driver, url);
						// Break after hit Url in browser
						timeOut(driver, 5);
						
						// Click on login page Button
						clickOnelement(driver, "//*[@id=\'home-slider-container\']/button");

						// Break after Load Login page in browser
						timeOut(driver, 5);

						// Fill username and password.
						fillTextBox(driver, "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[1]/div/input",
								"agent@simsaw.com");
						fillTextBox(driver, "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[2]/div/input",
								"Agent123!");

						// Click on Sign in Button
						clickOnelement(driver, "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[3]/button/span[1]");

						// Break after Load Login page in browser
						timeOut(driver, 25);
						driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
						
						//Click On Create-Invitation Button
						clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/div[1]/div[1]/button");
						
						//Select From dropDown-List Invitation type
						clickOnelement(driver, "//*[@id=\"mui-component-select-select\"]");
						
						//Select Indiviual
						clickOnelement(driver, "//*[@id=\"menu-select\"]/div[3]/ul/li[1]");
						
						//Fill the Form For Invite Type Individual 
			            //Select strategy
						clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[4]/div[1]/div");
						
						//Select Trizen
						clickOnelement(driver, "//*[@id=\"menu-select\"]/div[3]/ul/li[2]");
						
						//Select lead-source
						clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[5]/div/div");
						clickOnelement(driver, "//*[@id=\"menu-select\"]/div[3]/ul/li[5]");
						
						//Enter Employee contribution
						fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[4]/div[2]/div/div/input", "50000");
						
						//Upload Logo 
						
						try {
							clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[6]/div/div/div/div");
							fileupload(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[6]/div/div/div/div", "C:\\Users\\QA_SIMSAW\\Desktop\\download (1).png");
							
							} catch (ElementNotVisibleException err) {
							
								System.out.println(err.toString());
							}
							
//						clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[6]/div/div/div/div");
//						fileupload(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[6]/div/div/div/div", "C:\\Users\\QA_SIMSAW\\Desktop\\download (1).png");
						 
						 //Fill Participant Contact
						fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[8]/div/div/input", "individual2020");
						fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[9]/div/div/input", "2020");
						clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[10]/div/div/input");
						fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[10]/div/div/input", "(415) 265-2020");
						fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[11]/div/div/input", "indiidual2020@simsaw.com");
						//Fill D-O-B
						clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[12]/div/div/input");
						fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[12]/div/div/input", "10/12/1996");
						
					    //Fill OCCUPATION
						fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[13]/div/div/input", "Banker");
						fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[14]/div/div/input", "150000");
						
						//Select Gender
						clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[16]/div/div");
						clickOnelement(driver, "//*[@id=\"menu-select\"]/div[3]/ul/li[3]");
						//Click On Send -Invitation Button
						clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[18]/button");
						
						// Break after Load Login page in browser
						timeOut(driver, 25);
						driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
						
						//Click On Create-Invitation Button
						clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/div[1]/div[1]/button");
  
						//select Group link 
						clickOnelement(driver, "//*[@id=\"mui-component-select-select\"]");
						clickOnelement(driver, "//*[@id=\"menu-select\"]/div[3]/ul/li[2]");
						
					    //Fill group-Link form
						//Enter Product name
						fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[4]/div[1]/div/input", "Group-sesa");
						//Select lead Source for Group-link
						clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[5]/div/div");
						
						clickOnelement(driver, "//*[@id=\"menu-select\"]/div[3]/ul/li[3]");
						//Fill group-link name
						fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[4]/div[2]/div/div/input", "group-sesa-link");
						Thread.sleep(3000);
						
						
						//Upload Csv 
						
					
//						   clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[6]/div");
//						   fileupload(driver, "MuiGrid-root-1877 MuiGrid-item-1879 MuiGrid-grid-xs-12-1923 MuiGrid-grid-sm-12-1937 MuiGrid-grid-md-12-1951", "csv2020.csv");
 
						//Group-link Primary Contact
						
						fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[8]/div/div/input", "group20");
						fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[9]/div/div/input", "20");
						clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[10]/div/div/input");
						fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[10]/div/div/input", "(415) 236-5220");
						fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[11]/div/div/input", "group2020@simsaw.com");

//						driver.navigate().back();
						//Click On Events 
//						clickOnelement(driver, "//*[@id=\"root\"]/div/div/nav/div/div/div/div/ul/div[2]/div[2]/span");
						//Click on Register- now button
//						clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/div/div[2]/a/button");
						
						driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
						
						//Click on client management
						clickOnelement(driver, "//*[@id=\"root\"]/div/div/nav/div/div/div/div/ul/div[1]/div[2]");
						
						//Pagination & listing
						clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/div[1]/div[2]/div");
						//Select individual
						clickOnelement(driver, "//*[@id=\"menu-\"]/div[3]/ul/li[1]");
						
						//Click On Reinvite Button
						clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/div[2]/div/table/tbody/tr[11]/td[6]/button[1]");
						//Click On Copy Address Button
						clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/div[2]/div/table/tbody/tr[11]/td[6]/button[2]");
						
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
						//select Multi-Life
//						clickOnelement(driver, "//*[@id=\"menu-\"]/div[3]/ul/li[2]");
						//Click on view button
//						clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/div[2]/div/table/tbody/tr[1]/td[6]/a/button");
//						driver.navigate().back();
						//Click on Delete Button
//						clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/div[2]/div/table/tbody/tr[4]/td[6]/button");
		}
		catch (Exception err) {

			System.out.println(err.toString());

		}

}}

		
