package DropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy, 0,250");
		WebElement we = driver.findElement(By.xpath("//select[@id='country']"));
		we.click();
		
		Select se = new Select(we);
		//Select options from dropdown --> Selectbyvsisbletext(), selectbyvalue(), selectbyIndex()
		//se.selectByIndex(4);
		se.selectByVisibleText("Japan");
		//se.selectByValue("canada");
		
		//capture options from the dropdown.
		List<WebElement> options = se.getOptions();
		System.out.println("Number of options in a dropdown"+options.size());
		
		//printing the options
		for(WebElement op:options)
		{
			System.out.println(op.getText());
		}
		
		

	}

}
