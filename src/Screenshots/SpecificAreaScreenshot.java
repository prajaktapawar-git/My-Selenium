package Screenshots;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpecificAreaScreenshot {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		
		WebElement section = driver.findElement(By.xpath("//div[@class='k1zIA kKvsb']"));
		File SourceFile = section.getScreenshotAs(OutputType.FILE);
		File TargetFile = new File (System.getProperty("user.dir")+"\\Screenshot\\perticalarelement.png");
		SourceFile.renameTo(TargetFile);
		
		driver.quit();

	}

}
