package DropDown;

import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bootstrapdropdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://mdbootstrap.com/docs/standard/components/dropdowns/");
		driver.manage().window().maximize();
		//handle popup
		//driver.findElement(By.xpath("//span[@id='dpl-auth-modal']//div[@class='modal-content']"));
		WebElement button=driver.findElement(By.xpath("//button[@id='accept_cookies_btn']"));
		System.out.println("Element displayed="+button.isDisplayed());
		button.click();
		System.out.println("Button Clicked");
		
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,600)");
		
		//we don't see select tag for dropdown that is bootstarp dropdown
		
		driver.findElement(By.xpath("//div[@class='dropdown']//button[@id='dropdownMenuButton']")).click();
		//capture all option from dropdown and find size
		List<WebElement> alloptions=driver.findElements(By.xpath("//ul[@class='dropdown-menu show']//a"));
		alloptions.size();
		for(WebElement al:alloptions)
		{
			String text = al.getText();
			System.out.println(text);
//			if(text.equals("Action") || text.equals("Another action"))
//			{
//				al.click();
//			}
		}
		
		

	}

}
