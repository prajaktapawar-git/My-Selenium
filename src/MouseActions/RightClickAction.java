package MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement rightclickme = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		
		Actions actions = new Actions(driver);
		//perform rightclick
		actions.contextClick(rightclickme).perform();
		
		//click on copy
		driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
		
		Thread.sleep(5000);
		
		//close alert box
		driver.switchTo().alert().accept();
		
		//driver.quit();

	}

}
