package MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverActions {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demo-opencart.com/");
		driver.manage().window().maximize();
		
		//Desktop
		WebElement desktops = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		//mac
		WebElement mac = driver.findElement(By.xpath("//a[normalize-space()='Mac (2)']"));
		
		//create object of actions class
		//actions class contains a constructor that is expecting driver as a parameter
		Actions action = new Actions(driver);
		
		//mouse over on desktop element
		//mouse over on mac element
		action.moveToElement(desktops).moveToElement(mac).click().perform();
	}

}
