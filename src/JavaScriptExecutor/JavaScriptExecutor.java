package JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		WebElement inputboxname = driver.findElement(By.xpath("//input[@id='name']"));
		//Alternatives of Sendkeys method
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','Prajakta')", inputboxname);
		
		WebElement radiobutton = driver.findElement(By.xpath("//input[@id='male']"));
		//Alternatives of select Radio button 
		js.executeScript("arguments[0].click()", radiobutton);
		

	}

}
