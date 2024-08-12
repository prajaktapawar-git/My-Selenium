package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		driver.get("https://dummy-tickets.com/");
		driver.manage().window().maximize();
		
		//From
		driver.findElement(By.xpath("(//input[@class='suggestion-input required mb-2'])[1]")).sendKeys("Mumbai");
		List<WebElement> el = driver.findElements(By.xpath("//div[@class='suggestion-block']"));
		//System.out.println(el.size());
		for(int i=0; i<el.size();i++)
		{
			System.out.println(el.get(i).getText());
			
			if(el.get(i).getText().equals("Mumbai"));
			{
				el.get(i).click();
			}
		}
		
		//To
		driver.findElement(By.xpath("(//input[@class='suggestion-input required mb-2'])[2]")).sendKeys("Pune");
		List<WebElement> el2 = driver.findElements(By.xpath("(//div[@class='suggestion-block'])[2]"));
		//System.out.println(el.size());
		for(int i=0; i<el2.size();i++)
		{
			System.out.println(el2.get(i).getText());
			
			if(el2.get(i).getText().equals("Pune"));
			{
				el2.get(i).click();
			}
		}
		
		//calender
		String month ="Oct";
		String year = "2025";
		
		driver.findElement(By.xpath("(//input[@class='departure required mb-2 hasDatepicker'])[1]")).click();
		
		while (true)
		{
		String Currentmonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).getText();
		String Currentyear = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")).getText();
		
		if(Currentmonth.equals(month) && Currentyear.equals(year))
		{
			break;
		}
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		driver.quit();
	}


}
