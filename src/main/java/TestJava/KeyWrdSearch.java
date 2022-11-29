package TestJava;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class KeyWrdSearch {
	
	WebDriver driver = null; 
	String CSVPath;// = System.getProperty("user.dir")+"\\src\\main\\resources\\TestData.csv";
	String[] csvCell;
	CSVReader csvReader = null;// = new CSVReader(new FileReader(CSVPath));
	@BeforeTest
	public void SetUp() throws FileNotFoundException {
		
		
		System.setProperty("webdriver.chrome.driver", "\\src\\main\\resources\\chromedriver.exe");
	    driver = new ChromeDriver();
	    CSVPath = System.getProperty("user.dir")+"\\src\\main\\resources\\TestData.csv";
	    csvReader = new CSVReader(new FileReader(CSVPath));
		
	}
	
	@Test
    public void Search() throws CsvValidationException, IOException  {
		
		
		csvCell = csvReader.readNext();
	    //implicit wait
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    //URL launch
	    driver.get("https://www.google.com/");
	    //implicit wait
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    //identify element
	    WebElement q= driver.findElement(By.id("L2AGLb"));
	    q.click();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    WebElement r = driver.findElement(By.name("q"));
	    r.sendKeys(csvCell[0]);
	    // press ENTER
	    r.sendKeys(Keys.RETURN);
	    
	}
	
	@AfterTest
  
    public void Close() {
		
		
		driver.close();
		
		driver.quit();
		
		System.out.println("Test Completed Successfully");
	}

}
