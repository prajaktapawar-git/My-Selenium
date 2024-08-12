package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autosuggestdropdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.bjs.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("tv");
		
		List<WebElement> op = driver.findElements(By.xpath("//div[@class='list-item border-0 list-group-item']"));
		
		for(int i=0; i<op.size(); i++)
		{
			System.out.println(op.get(i).getText());
			if(op.get(i).getText().equals("tv stands"));
			{
				op.get(i).click();
				break;
			}
		}
		

	}

}
