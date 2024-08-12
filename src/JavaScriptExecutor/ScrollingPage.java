package JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//1.Scroll down page by pixel number
		//js.executeScript("window.scrollBy(0,1000)", "");
		//System.out.println(js.executeScript("return window.pageYOffset;")); //1000
		
		//2. scroll down page till the element is visible
		/*WebElement el = driver.findElement(By.xpath("//div//h2[normalize-space() ='Web Table']"));
		js.executeScript("arguments[0].scrollIntoView();", el);
		System.out.println(js.executeScript("return window.pageYOffset;")); //1409*/
		
		//3. Scroll page till end of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//scrolling upto intial possition
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		

	}

}
