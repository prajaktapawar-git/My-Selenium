package Assignments;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenSecondURLOnNewTab {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demo.nopcommerce.com/");
		
		//driver.switchTo().newWindow(WindowType.TAB); //open new tab
		
		driver.switchTo().newWindow(WindowType.WINDOW); //open new window
		
		driver.get("https://www.google.com");

	}

}
