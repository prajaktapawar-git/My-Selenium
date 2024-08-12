package MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PriceRangeSlider {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		//Min Slider
		//capture min sider position
		WebElement min_slider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
		System.out.println("Default location of min slider before moving="+min_slider.getLocation()); //(59,250)
		
		//Increase the minsider by 100, keep y axis as it is
		Actions action = new Actions(driver);
		action.dragAndDropBy(min_slider, 100, 250).perform();
		System.out.println("Location of min slider after moving="+min_slider.getLocation()); //(161,250)
		
		//Max Slider
		WebElement max_slider1 = driver.findElement(By.xpath("//div[@class='price-range-block']//span[2]"));
		System.out.println("Default location of max slider before moving="+max_slider1.getLocation()); //((161, 250)
		
		//Increase the minsider by 100, keep y axis as it is
		action.dragAndDropBy(max_slider1,-100, 250).perform();
		System.out.println("Location of min slider after moving="+max_slider1.getLocation()); //(161,250)
		
		Thread.sleep(5000);
		driver.quit();
	}

}
