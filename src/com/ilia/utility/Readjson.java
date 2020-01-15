package com.ilia.utility;

import java.io.IOException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Readjson {

    static WebDriver driver;
    String email,password;
    JSONParser parser=new JSONParser();
    
    public static String url = "https://staging.myilia.com";
    
    Logger log = Logger.getLogger("Readjson.class");
    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\QA_SIMSAW\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	
    	 driver = new ChromeDriver();
         driver.get(url);
         driver.manage().window().maximize();
         
         driver.findElement(By.xpath("//*[@id=\'home-slider-container\']/button")).click();
        
    }
    public void setup() throws FileNotFoundException, IOException, ParseException
    {
//    	System.setProperty("webdriver.chrome.driver","C:\\Users\\QA_SIMSAW\\Downloads\\chromedriver_win32\\chromedriver.exe");
        Object obj = parser.parse(new FileReader("C:\\Users\\QA_SIMSAW\\Desktop\\Users.json"));
        JSONObject jsonObject = (JSONObject) obj;
        email = (String) jsonObject.get("email");
        password = (String) jsonObject.get("password");
        
        log.debug("Read data fom json");
        log.info(" user login successfully");
       
    }
        
    
   
    
    public void testSearch() throws FileNotFoundException, IOException, ParseException {
   
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[1]/div/input")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[2]/div/input")).sendKeys(password);
//        driver.findElement(By.name("btnK")).click();
//        driver.findElement(By.linkText(linkText)).click();
       
//        String webTitle = driver.getTitle();
       
//        Assert.assertEquals(webTitle, linkText);
    }
   
    
    public void tearDown()
    {
        driver.close();
        driver.quit();

       }
}