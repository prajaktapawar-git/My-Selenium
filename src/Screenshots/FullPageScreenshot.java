package Screenshots;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FullPageScreenshot {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		//Full Page Screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Sourcefile = ts.getScreenshotAs(OutputType.FILE);
		File targetFile = new File (System.getProperty("user.dir")+"\\Screenshot\\fullpage.png");
		
		//Copy sourcefile to target
		Sourcefile.renameTo(targetFile);

	}

}
