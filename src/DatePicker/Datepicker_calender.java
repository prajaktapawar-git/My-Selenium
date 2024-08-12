package DatePicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datepicker_calender {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0); //switch to iframe
		
		String year = "2025";
		String month = "October";
		String date = "20";
		
		//xpath of textbox
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		//select month & year
		while(true)
		{
			String currentmonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(currentmonth.equals(month) && currentyear.equals(year))
			{
				break;
			}
			//click on next icon button
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		//select the date
		//1.capture all dates
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//a"));
		
		for(WebElement d : alldates)
		{
			if(d.getText().equals(date))
			{
				d.click();
				break;
			}
		}
		
		
	}

}
