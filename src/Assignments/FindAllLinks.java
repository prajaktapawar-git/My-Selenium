package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindAllLinks {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ebay.com/?msockid=29829c30200b6746342b88a5216b6666");
		driver.manage().window().maximize();
		
		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		System.out.println("count of links:"+linklist.size());
		
		for(int i=0; i<linklist.size(); i++)
		{
			System.out.println(linklist.get(i).getText());
		}
		
	}

}
