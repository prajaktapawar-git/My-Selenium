package DropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropdown {

	public static void main(String[] args) throws InterruptedException {
		// also called dynamic dropdown
		//inspect-->go to selector hub-->Debugger-->pause-->then inspect any element
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//Login
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
		
		//PIM
		driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[2]")).click();
		
		//click on dropdown
		driver.findElement(By.xpath("(//div[@class='oxd-select-text--after'])[3]")).click();
		
		Thread.sleep(5000);
		//select single option
		//driver.findElement(By.xpath("(//div[@class='oxd-select-option'])[7]")).click();
		
		//list of all options
		List<WebElement> op = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		System.out.println("Size is:"+op.size());
		for(WebElement we : op)
		{
			System.out.println("Text is="+we.getText());
			
			if(we.equals("QA Engineer"))
			{
				we.click();
			}
	
		}
		
		

	}

}
