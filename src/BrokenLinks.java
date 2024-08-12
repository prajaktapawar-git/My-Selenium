import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://www.deadlinkcity.com/");
		List <WebElement> links= driver.findElements(By.tagName("a"));
		System.out.println("Count of links:"+links.size());
		
		for(WebElement Totalcount:links)
		{
			String grefattribute = Totalcount.getAttribute("href");
			
			if(grefattribute==null || grefattribute.isEmpty())
			{
				System.out.println("Not possible to check");
				continue;
			}
			
			//hit url to server
			URL urllink = new URL (grefattribute); // converted grefattribute string from URL
			HttpURLConnection conn = (HttpURLConnection) urllink.openConnection(); // Open connectio to the server
			conn.connect(); //connect to server
			
			if(conn.getResponseCode() >=400)
			{
				System.out.println(grefattribute + "Broken link");
				
			}
			else
			{
				System.out.println(grefattribute + "Not Broken Link");
			}
		}
		
		Thread.sleep(5000);
		driver.quit();

	}

}
