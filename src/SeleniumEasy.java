import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumEasy {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.seleniumeasy.com/");
		driver.manage().window().maximize();
		
		
		driver.close();
		
		

	}

}
