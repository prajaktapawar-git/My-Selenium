package testNG_DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvide_Parameterization {
	
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(dataProvider="pp")
	void loigntest(String username, String password) throws InterruptedException
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("(//input[contains(text(),Username)])[2]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		boolean status = driver.findElement(By.xpath("//div[@class='oxd-brand-banner']//img")).isDisplayed();
		if(status == true)
		{
			
			Assert.assertTrue(true); //Passed
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']/img[@alt='profile picture']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
			Thread.sleep(500); 
		}
		else
		{
			Assert.fail(); //Failed
		}
	}
	
	@AfterClass
	void teardown()
	{
		driver.quit();
	}
	
	//creation and returning data
	//Object can hold any type of data
	@DataProvider(name="pp")
	Object [][] loginData()
	{
		Object data[][]= {{"abc", "1234"},
				{"pqr", "3456"},
				{"Admin", "admin123"},
				{"5678", "iopkj"},
				};
		return data;
	}

}
