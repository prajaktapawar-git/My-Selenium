package Screenshots;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshotofWebElement {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath("//span[@class='CdXeWb z1asCe Fp7My']"));
		File SourceFile = element.getScreenshotAs(OutputType.FILE);
		File TargetFile = new File (System.getProperty("user.dir")+"\\Screenshot\\element.png");
		SourceFile.renameTo(TargetFile);
		
		driver.quit();
	}

}
