package WebTables;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_Static {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//find number of rows
		int count = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Size:"+count);
		
		//find number of col
		int countcol = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Size of col:"+countcol);
		
		//Read data from specific row and col
		String rowdata= driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println("Row data:"+rowdata);
		
		//read data from all rows and col
		/*for(int r=2; r<=count ; r++) //here 2 because 1st row contains header data
		{
			for(int c=1; c<=countcol; c++)
			{
				String data = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.println(data+"\t");
			}
		}*/
		
		//Print bookname whoes author is mukesh
		/*for(int r=2;r<=count;r++)
		{
			String authorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			if(authorName.equals("Mukesh"))
			{
				String bookname = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(bookname);
			}
		}*/
		
		//find total price of all groups
		int totalprice=0;
		for(int r=2;r<=count;r++)
		{
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			System.out.println(price);
			totalprice = totalprice+Integer.parseInt(price);  
			
		}
		System.out.println("Totalprice="+totalprice);
	}

}
