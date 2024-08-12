package MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();
		
		//button xpath
		WebElement doubleclickbutton = driver.findElement(By.xpath("//button[normalize-space()='Double-Click Me To See Alert']"));
		
		Actions action = new Actions(driver);
		action.doubleClick(doubleclickbutton).perform();
		
		Thread.sleep(5000);
		
		driver.switchTo().alert().accept();
		driver.quit();
		
	}

}
