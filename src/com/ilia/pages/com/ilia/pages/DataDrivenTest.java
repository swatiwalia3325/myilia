package com.ilia.pages.com.ilia.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*** @author Admin **/

public class DataDrivenTest {

	WebDriver driver;
	WebDriverWait wait;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	HSSFCell cell;
	HSSFRow row;

	@BeforeTest
	public void TestSetup()

	{
		// Set the path of the Firefox driver.

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\QA_SIMSAW\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		// Enter url.
		driver.get("https://staging.myilia.com");
		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, 30);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void ReadData() throws IOException

	{

		// Click on login page Button

		driver.findElement(By.xpath("//*[@id=\'home-slider-container\']/button")).click();
		

		// Break after Load Login page in browser

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Import excel sheet.
		File src = new File("C:\\Users\\QA_SIMSAW\\Documents\\ilia_user.xls");

		// Load the file.

		FileInputStream finput = new FileInputStream(src);

		// Load the workbook.

		workbook = new HSSFWorkbook(finput);

		// Load the sheet in which data is stored.
		sheet = workbook.getSheetAt(0);
		int totalRows = sheet.getLastRowNum();
		for (int i = 1; i <= totalRows; i++) {

			// Import data for Email.

			cell = sheet.getRow(i).getCell(1);

			cell.setCellType(Cell.CELL_TYPE_STRING);

			driver.findElement(By.id("//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[1]/div/input"))
					.sendKeys(cell.getStringCellValue());
			// Import data for password.
			cell = sheet.getRow(i).getCell(2);

			cell.setCellType(Cell.CELL_TYPE_STRING);

			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[2]/div/input"))
					.sendKeys(cell.getStringCellValue());
		}

		// Read the Sheet
		for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = workbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// Read the Row
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {

				}

			}

			// Import data for Email.

			int i = 0;

			cell = sheet.getRow(i).getCell(1);
			cell.setCellType(Cell.CELL_TYPE_STRING);

			driver.findElement(
					By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[1]/div/input\",\r\n"
							+ "					"))
					.sendKeys(cell.getStringCellValue());
			// Import data for password.

			cell = sheet.getRow(i).getCell(2);

			cell.setCellType(Cell.CELL_TYPE_STRING);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div/div[1]/form/div[2]/div/input"))
					.sendKeys(cell.getStringCellValue());

			// Write data in the excel.

			// Specify the message needs to be written.
			String message = "Data Imported Successfully.";
			// Create cell where data needs to be written.
			sheet.getRow(i).createCell(3).setCellValue(message);

			// Specify the file in which data needs to be written.

			FileOutputStream fileOutput = new FileOutputStream(src);
			// finally write content

			workbook.write(fileOutput);

			// close the file
			fileOutput.close();

		}
	}
}
