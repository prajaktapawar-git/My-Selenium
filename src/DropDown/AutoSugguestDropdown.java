package DropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSugguestDropdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Selenium");
		//common xpath for all list items
		List <WebElement> op = driver.findElements(By.xpath("//div[@role='presentation']//li//div[@role='option']"));
		
		for(int i=0; i<op.size();i++)
		{
			System.out.println(op.get(i).getText());
			if(op.get(i).getText().equals("selenium download"))
			{
				op.get(i).click();
				break;
			}
			
		}
		
		

	}

}
