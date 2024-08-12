package Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		WebElement registerlink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(registerlink).keyUp(Keys.CONTROL).perform();
		
		//switch two the next page - Regestration page
		
		List<String> ids = new ArrayList(driver.getWindowHandles());
		
		driver.switchTo().window(ids.get(1));
		
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Prajakta");
		
		//Switch to homepage
		driver.switchTo().window(ids.get(0));
		

	}

}
