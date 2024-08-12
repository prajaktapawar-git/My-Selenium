package Frames;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class handleiframe {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		//Frame 1
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1); //passed frame as webelement // Switch to Frame 1
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Frame1");
		driver.switchTo().defaultContent(); //switch to main page
		
		//Frame 2
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Frame2");
		driver.switchTo().defaultContent();
		
		//Frame 3
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Frame3");
		
		//inner iframe inisde the frame 3
		driver.switchTo().frame(0);//when there is only one frame then we can use index. and index=0
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,250)");
		driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']")).click();
		driver.findElement(By.xpath("//div[@id='i22']//div[@class='uHMk6b fsHoPb']")).click();
		JavascriptExecutor je1 = (JavascriptExecutor)driver;
		je1.executeScript("window.scrollBy(0,250)");
//		WebElement we= driver.findElement(By.xpath("//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R']"));
//		we.click();
//		Select s = new Select(we);
//		s.selectByValue("Yes");
		driver.switchTo().defaultContent();
		
		//Frame 5
		WebElement frame5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		JavascriptExecutor je2 = (JavascriptExecutor)driver;
		je2.executeScript("window.scrollBy(0,250)");
		driver.findElement(By.xpath("//a[@href='https://a9t9.com']")).click();
		
		
		
		
		//driver.quit();
	}

}
