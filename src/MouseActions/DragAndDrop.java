package MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html#google_vignette");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		
		WebElement Sourcerome = driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement DestinationItaly = driver.findElement(By.xpath("//div[@id='box106']"));
		
		action.dragAndDrop(Sourcerome, DestinationItaly);
		
		Thread.sleep(5000);
		
		driver.quit();

	}

}
