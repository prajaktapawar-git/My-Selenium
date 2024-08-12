package WebTables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dynamictableswithpaginations {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		
		//Login
		WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
		username.clear();
		username.sendKeys("demo");
		WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
		password.clear();
		password.sendKeys("demo");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		//home page
		// explicit wait - to wait for the compose button to be click-able
		//WebDriverWait wait = new WebDriverWait(driver,30);
		driver.findElement(By.xpath("//li[@id='menu-customer']//a[@class='parent collapsed']")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
		
		//Showing 1 to 10 of 1633 (164 Pages)
		String s= driver.findElement(By.xpath("//div[contains(text(),'Pages')]")).getText();
		int total_count =Integer.parseInt(s.substring(s.indexOf("(")+1, s.indexOf("Pages")-1));
		System.out.println(total_count);
		//Repeating pages
		for(int p=1; p<=total_count; p++)
		{
			if(p>1)
			{
				WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(active_page));				//System.out.println(active_page);
				active_page.click();
			}
			//reading data from the page
			
		}
		


		
	}

}
