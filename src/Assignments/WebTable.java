package Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class WebTable {

	public static void main(String[] args) {
		//go to https://blazedemo.com/
		//select value from dropdown click on button
		//capture all prices into array
		//sort element
		//1st value will be lowest value and click on button
		//add all data
		//validate message
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		//click on dropdown
		WebElement firstdropdown=driver.findElement(By.xpath("(//select[@class='form-inline'])[1]"));
		firstdropdown.click();
		
		Select se = new Select(firstdropdown);
		se.selectByIndex(3);
		
		//2nd dropdown
		WebElement seconddropdown = driver.findElement(By.xpath("(//select[@class='form-inline'])[2]"));
		seconddropdown.click();
		Select se2 = new Select(seconddropdown);
		se2.selectByVisibleText("Dublin");
		
		//click on button
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		System.out.println("Button clicked");
		
		String expectedstring = "Flights from Portland to Dublin:";
		String actualtext=driver.findElement(By.xpath("(//div[@class='container'])[2]//h3")).getText();
		if(expectedstring.equals(actualtext))
		{
			System.out.println("Page is correct");
		}
		
		//Store price into array
		int rowcount= driver.findElements(By.xpath("//table[@class='table']//tr")).size();
		int colcount = driver.findElements(By.xpath("//table[@class='table']//th")).size();
		int s = 0;
		for(int r=1; r<=rowcount; r++)
		{
			for(int c=6; c<=colcount; c++)
			{
				String el = driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//td["+c+"]")).getText();
				//String arr = allvalues.addAll(el);//System.out.println(total);
				ArrayList<String> allvalues = new ArrayList<el>();
				Arrays.sort(arr);
				
			}
		}
		List<String> allvalues = new ArrayList<>();
		for(int i=0; i<el.size(); i++)
		ArrayList<String> price = new ArrayList<String>();
		
		//driver.findElements(By.xpath("//table[@class='table']//tr[3]//td[6]"));
		/*ArrayList<String> price = new ArrayList<String>();
		for (int i=1; i<=s ; i++)
		{
			price.add(total);
		}
		*/

	}

}
