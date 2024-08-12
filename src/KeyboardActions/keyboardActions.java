package KeyboardActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class keyboardActions {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Hello, Prajakta Pawar");
		
		Actions action = new Actions(driver);
		//Ctrl+A -->Select all text from 1st textbox
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		//Ctrl+C -->Copy text from 1st box
		action.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		//Tab -->Move cursor focus to 2nd box
		action.keyDown(Keys.TAB).keyUp(Keys.TAB);
		
		//Ctrl+V -->Paste text to 2nd box
		action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
		driver.quit();

	}

}
