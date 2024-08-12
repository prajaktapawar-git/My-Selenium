package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class paginationtable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scrollBy (0,1700)");
		
		String text= (String) driver.findElement(By.xpath("//ul[@id='pagination']")).getText();
		System.out.println(text);
		int count = Integer.parseInt(text);
		
		for(int p=1; p<=count; p++)
		{
			if ( p>1)
			{
				WebElement el = driver.findElement(By.xpath("//ul[@id='pagination']//*[text()="+p+"]"));
				el.click();
			}
		}
			
			
	}

}
