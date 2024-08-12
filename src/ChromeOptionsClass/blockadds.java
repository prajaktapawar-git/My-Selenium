package ChromeOptionsClass;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class blockadds {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		
		File file = new File("C:\\Users\\Prajakta_Pawar\\Documents\\Demo\\SBlock-Super-Ad-Blocker-Chrome-Web-Store.crx");
		options.addExtensions(file);
		
		WebDriver driver = new ChromeDriver(options);
	
		driver.get("https://text-compare.com/");
		

	}

}
