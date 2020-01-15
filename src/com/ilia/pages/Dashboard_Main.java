package com.ilia.pages;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.ilia.web.browsers;

public class Dashboard_Main {

	public static String url = "https://staging.myilia.com";

	public static Logger logger = Logger.getLogger("rootlogger");

	public static void main(String[] args) {

		try {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\QA_SIMSAW\\Downloads\\chromedriver_win32\\chromedriver.exe");

			PropertyConfigurator.configure(
					"C:\\Users\\QA_SIMSAW\\eclipse-workspace\\Myilia\\src\\com\\ilia\\pages\\log4j.properties");

//		    Create A Selenium WebDriver Instance "WebDriver is an interface 
//			and all the methods which are declared in Webdriver interface are implemented by respective driver class" 
//		    WebDriver is an interface, driver is a reference variable, 
//          FirefoxDriver() is a Constructor, new is a keyword, and new ChromeDriver() is an Object.

			WebDriver driver = new ChromeDriver();
            // Load Chrome Browser
			Login_User.loadWebsite(driver, url);
			// Break after hit Url in browser
			Login_User.timeOut(driver, 5);

			// Click on login page Button
			Login_User.clickOnelement(driver, "//*[@id=\'home-slider-container\']/button");

			// Break after Load Login page in browser
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			// Fill username and password.
			Login_User.fillTextBox(driver, "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[1]/div/input",
					"admin@simsaw.com");
			
			logger.info("email address is required");
			Login_User.fillTextBox(driver, "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[2]/div/input",
					"Admin123!");
			logger.info("password is required");
//			 String alertMessage = driver.switchTo().alert().getText();
//		        System.out.println(alertMessage);
//			if (alertMessage.equals("required")){
//	            System.out.println("Error displayed: Email is required");
//	            driver.switchTo().alert().dismiss();
//	        } else{
//	            System.out.println("Accepted");
//	        }
//			Login_User.fillTextBox(driver, "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[1]/div/input",
//					"");
//			Login_User.fillTextBox(driver, "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[2]/div/input",
//					"Admin123!");
//	         if (alertMessage.equals("username is blank")){
//	                System.out.println("required");
//	                driver.switchTo().alert().dismiss();
//	            } else{
//	                System.out.println("Accepted");
//	            }

			logger.info("Entered a valid Email Address.");

			// Click on Sign in Button
			Login_User.clickOnelement(driver,
					"//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[3]/button/span[1]");

			// Break after Load Login page in browser
			Login_User.timeOut(driver, 10);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			// Click On Add account Button
			Admin_Creation.ButtonOnclick(driver, "//*[@id='root']/div/main/div/div[1]/button");

			// Click On Admin from List for create admin
			Admin_Creation.ButtonOnclick(driver, "//*[@id=\"menu-list-grow\"]/ul/li[1]");

			// Load the page
			Admin_Creation.timeOut(driver, 10);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			// Fill The Form For Create Admin Account
			Admin_Creation.fillTextBox(driver, "//*[@id='root']/div/main/div/div/div/div/form/div/div[2]/div/div/input",
					"AdminQa416");
			Admin_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[3]/div/div/input", "qa416");

			// Click On Cell Number Field and fill value
			Admin_Creation.ButtonOnclick(driver,
					"//*[@id='root']/div/main/div/div/div/div/form/div/div[4]/div/div/input");
			Admin_Creation.fillTextBox(driver, "//*[@id='root']/div/main/div/div/div/div/form/div/div[4]/div/div/input",
					"(452) 632-5222");

			// Fill Email In Text Box
			Admin_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[5]/div/div/input",
					"adminqa416@simsaw.com");
			
			// Click On Create Acount-Button
			Admin_Creation.ButtonOnclick(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[7]/button");
			
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			boolean isDisplayed = driver.findElement(By.xpath("//*[@id=\"message-id\"]")).isDisplayed();
			if (isDisplayed) {

				System.out.println("Email already Exist");
			}
			
			Thread.sleep(2000);

			// Click On Back Button
//			Admin_Creation.ButtonOnclick(driver, "//*[@id=\"root\"]/div/main/a");

			// Click On Strategies

//			Admin_Creation.ButtonOnclick(driver, "//*[@id=\"root\"]/div/div/nav/div/div/div/div/ul/div[3]/div[2]/span");

			// Click On Edit Button
//			try {
//
//				Admin_Creation.ButtonOnclick(driver,"//*[@id=\"root\"]/div/main/div/div[2]/div/div/div/div/table/tbody/tr[1]/td[2]/button");
//			} catch (NoSuchElementException ex) {
//				
//				System.out.println("Element Not Exist");
//			}

//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			// Redirect To Back
//			Admin_Creation.ButtonOnclick(driver, "//*[@id=\"root\"]/div/main/a");

			// Click On Update Button
//			Admin_Creation.ButtonOnclick(driver,
//					"//*[@id=\"root\"]/div/main/div/div[2]/div/form/div/div[2]/div/button");
			
			
			// Click On account Management 
						Admin_Creation.ButtonOnclick(driver, "//*[@id=\"root\"]/div/div/nav/div/div/div/div/ul/div[1]/div[2]/span");

			//  Click on Add account

			Agent_Creation.ButtonOnclick(driver, "//*[@id='root']/div/main/div/div[1]/button");
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		

			// Click On Agent from List for create Agent
			Agent_Creation.ButtonOnclick(driver, "//*[@id=\"menu-list-grow\"]/ul/li[2]");

			// Load the page
			Admin_Creation.timeOut(driver, 50);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			// Click On radio Button for select One Option

			Agent_Creation.ButtonOnclick(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[2]/div/div/label[1]/span[1]/span[1]/input");
			Agent_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[2]/div/div/label[1]/span[1]/span[1]/input",
					"1");

			// Agent Creation Form
			Agent_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[3]/div/div/input", "Agent110");
			Agent_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[4]/div/div/input", "lastagent");
			// On click Cell Phone
			Agent_Creation.ButtonOnclick(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[5]/div/div/input");
			Agent_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[5]/div/div/input", "(122) 644-5222");
			// Fill email For Agent
			Agent_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[6]/div/div/input", "Agent110@simsaw.com");

			// Select From Drop Down *Agent*

			Agent_Creation.ButtonOnclick(driver, "//*[@id=\"mui-component-select-select\"]");
			Agent_Creation.ButtonOnclick(driver, "//*[@id=\"menu-select\"]/div[3]/ul/li[10]");
			
			//Click On create Account Button
			Agent_Creation.ButtonOnclick(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[9]/button");
			Thread.sleep(2000);
			
			boolean isDisplayed1 = driver.findElement(By.xpath("//*[@id=\"message-id\"]")).isDisplayed();
			if (isDisplayed1) {

				System.out.println("Email already Exist for agent");
			}
			// Click On Back Button To redirect To previous page

			driver.navigate().back();
			
			Thread.sleep(2000);

			// Create IMo on Click Add account
        
	        Imo_Creation.ButtonOnclick(driver, "//*[@id='root']/div/main/div/div[1]/button");
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Thread.sleep(2000);
			// Click On IMO from List for create IMO
			Imo_Creation.ButtonOnclick(driver, "//*[@id=\"menu-list-grow\"]/ul/li[3]");

			// Load the page
//			Imo_Creation.timeOut(driver, 10);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Imo_Creation.fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[3]/div/div/input",
					"imoqa");
			Imo_Creation.ButtonOnclick(driver,"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[4]/div/div/input");
					
			Imo_Creation.fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[4]/div/div/input",
					"(122) 544-5222");
			Imo_Creation.fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[5]/div/div/input",
					"imoqas11@simsaw.com");

			// click class drop down
			Imo_Creation.ButtonOnclick(driver, "//*[@id=\"mui-component-select-select\"]");
			// select class from drop-down
			Imo_Creation.ButtonOnclick(driver, "//*[@id=\"menu-select\"]/div[3]/ul/li[3]");
			
			//Select Region from Dropdown
			Imo_Creation.ButtonOnclick(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[7]/div/div");
			Imo_Creation.ButtonOnclick(driver, "//*[@id=\"menu-select\"]/div[3]/ul/li[3]");
			
			//Select Imo carrier from Drop down
			Imo_Creation.ButtonOnclick(driver,"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[8]/div[1]/div");
			
			Imo_Creation.ButtonOnclick(driver, "//*[@id=\"menu-select\"]/div[3]/ul/li[2]");

						// add primary info of Imo
			Imo_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[15]/div/div/input", "imo first");
			Imo_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[16]/div/div/input", "last imo ");
					
			//Enter Cell-Number
			
			Imo_Creation.ButtonOnclick(driver,"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[17]/div/div/input");
			
			Imo_Creation.fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[17]/div/div/input",
					"(122) 544-0022");
			Imo_Creation.fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[18]/div/div/input",
					"imoqas110@simsaw.com");

//			 Click On Plus Button
			Imo_Creation.ButtonOnclick(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[19]/div/div/button");

			// Select value from List
			Imo_Creation.ButtonOnclick(driver, "//*[@id=\"menu-list-grow\"]/ul/li[3]");

			// input the radio button for regional member type
			Imo_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[19]/div[1]/div/div[2]/div/div/div/label[2]/span[1]/span[1]/input",
					"1");

			// fill the form for regional member type

			Imo_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[19]/div[1]/div/div[3]/div/div/input",
					"imo regional");
			Imo_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[19]/div[1]/div/div[4]/div/div/input",
					"imo user");
			
			//Add cell Number
			Imo_Creation.ButtonOnclick(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[19]/div[1]/div/div[5]/div/div/input");
			Imo_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[19]/div[1]/div/div[5]/div/div/input","(121) 212-2222");
			Imo_Creation.fillTextBox(driver,"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[19]/div[1]/div/div[6]/div/div/input","imoregions@simsaw.com");
			
			//click on delete button
			
			Imo_Creation.ButtonOnclick(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[19]/div[1]/div/div[7]/div/button");

			// Click on Create Account Button
			Imo_Creation.ButtonOnclick(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[21]/button");
			
			Thread.sleep(2000);
			
			
			boolean isDisplayed2 = driver.findElement(By.xpath("//*[@id=\"message-id\"]")).isDisplayed();
			if (isDisplayed2) {

				System.out.println("Email already Exist for Imo");
			}
			// Click On Back Button
//			  Imo_Creation.ButtonOnclick(driver, "//*[@id=\"root\"]/div/main/a");
//            Imo_Creation.timeOut(driver, 20);
			
			driver.navigate().back();


			// Click on Add account
			Carrier_Creation.clickElements(driver, "//*[@id=\"root\"]/div/main/div/div[1]/button");

         	// Break after Load Login page in browser
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			// Click On carrier to Create Carrier Account
            Thread.sleep(1000);
			Carrier_Creation.clickElements(driver, "//*[@id=\"menu-list-grow\"]/ul/li[4]");

			// Fill the Form of Carrier
			Carrier_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[2]/div/div/input", "carrier qa");
			Carrier_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[3]/div/div/input", "qatest");
			//Input Phone Number
			Carrier_Creation.clickElements(driver, " //*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[4]/div/div/input");
			Carrier_Creation.fillTextBox(driver," //*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[4]/div/div/input","carrierqa412@simsaw.com");
			Carrier_Creation.fillTextBox(driver,"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[5]/div/div/input", "(232) 432-5435");

			// Click On dropdown
			Carrier_Creation.clickElements(driver, "//*[@id=\"mui-component-select-select\"]");

			// click and add value from drop down
			Carrier_Creation.clickElements(driver, "//*[@id=\"menu-select\"]/div[3]/ul/li[2]");

			// fill the Primary Contact form
			Carrier_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[14]/div/div/input", "primarycarrier");
			Carrier_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[15]/div/div/input", "lastnamecarrier");
			Carrier_Creation.clickElements(driver, "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[16]/div/div/input");
			Carrier_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[16]/div/div/input", "(856) 966-6666");
			Carrier_Creation.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[17]/div/div/input",
					"carrierqa412@simsaw.com");

			// Click On Button
			Carrier_Creation.clickElements(driver,
					"//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div[19]/button");
			
			boolean isDisplayed3 = driver.findElement(By.xpath("//*[@id=\"message-id\"]")).isDisplayed();
			if (isDisplayed3) {

				System.out.println("Email already Exist for Carrier");
			}
			
			Thread.sleep(2000);
			
			driver.navigate().back();
			
			driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			// Click On Setting Button
			
			boolean click;
			if(click=true)
			{
			    My_Account.clickOnelement(driver, "//*[@id=\"root\"]/div/div/header/div/div[2]/button[3]");
			    Thread.sleep(2000);
                      System.out.println("Click on my settings ");
			}
			

			// Click My Account From List
			My_Account.clickOnelement(driver, "//*[@id=\"menu-appbar\"]/div[3]/ul/li[1]");
			
			if (isDisplayed3) {

				System.out.println("Email already Exist for Carrier");
			}

			My_Account.clickOnelement(driver,
					"//*[@id=\"root\"]/div/main/div/div/div[2]/form/div/div[1]/div/div[1]/div/div/input");

			// Fill Form For Change Password

			My_Account.fillTextBox(driver,
					"//*[@id=\"root\"]/div/main/div/div/div[2]/form/div/div[1]/div/div[1]/div/div/input", "Admin1111");
			
			driver.navigate().back();
			// select carrier request
			Login_User.clickOnelement(driver, "//*[@id=\"root\"]/div/div/nav/div/div/div/div/ul/div[2]/div[2]/span");
			
			//Select Radio button for approved Request In carrier Request
		 try
		 {
			 Login_User.clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div[2]/div/div/form/div/div/table/tbody/tr[1]/td[5]/div/div/label[1]/span[1]/span[1]/input");
		 }
			 
			 catch(Exception e) {
				 logger.info("Exception Occured:", e);
			 }
	
		 
			 
		     driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
	          Login_User.fillTextBox(driver, "//*[@id=\"root\"]/div/main/div/div[2]/div/div/form/div/div/table/tbody/tr[1]/td[5]/div/div/label[1]/span[1]/span[1]/input", "1");
	            driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			
			//click on update button for Carrier request
	         Login_User.clickOnelement(driver, "//*[@id=\"root\"]/div/main/div/div[2]/div/div/form/div/div/table/tbody/tr[1]/td[5]/button/span[1]");
	         
	         //Status Message
	         
	         boolean isDisplayed4 = driver.findElement(By.xpath("//*[@id=\"message-id\"]")).isDisplayed();
				if (isDisplayed4) {

					System.out.println("Status Update successfully");
				}
	        
	         
			driver.navigate().back();
//            driver.close();
//        
		} 
		catch (Exception error) {
			System.out.println("error.toString())");
		}
	
}

}
