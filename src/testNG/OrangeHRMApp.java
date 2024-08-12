package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/* Open Application
   test logo presence
   Login
   Close
 */

public class OrangeHRMApp {
	
	WebDriver driver; //class object access in all methods.
	WebDriverWait some_element;
	
  @Test(priority=1)
  void OpenApp() {
	  
	  driver = new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
  }
  
  @Test(priority=2)
  void validateLogo() throws InterruptedException
  {
	 Thread.sleep(3000);
	 boolean Actual_Result = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']//img")).isDisplayed();
	 System.out.println("Logo displayed:"+Actual_Result);
	
  }
  
  @Test(priority=3)
  void LoginApp()
  {
	  driver.findElement(By.xpath("(//input[contains(text(),Username)])[2]")).sendKeys("Admin");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
  }
  
  @Test(priority=4)
  void CloseApp() throws Exception
  {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']/img[@alt='profile picture']")).click();
	  
	  
	  
  }
}
