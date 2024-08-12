package JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		//single file upload
		/*driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Users\\Prajakta_Pawar\\Documents\\Demo\\New Text Document.txt");
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("New Text Document.txt"))
		{
			System.out.println("File is matching");
		}
		else
		{
			System.out.println("Incorrect file uploaded");
		}*/
		
		//Multiple Files
		
		String file1 =  "C:\\Users\\Prajakta_Pawar\\Documents\\Demo\\New Text Document.txt";
		String file2 =  "C:\\Users\\Prajakta_Pawar\\Documents\\Demo\\New Text Document (2).txt";
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
		
		//file validation - file number
		int numberoffiles = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		if(numberoffiles ==2)
		{
			System.out.println("All files are uploaded");
		}
		else
		{
			System.out.println("files are not uploaded or incorrect file uploaded");
		}
		
		//validate file name
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("New Text Document.txt") 
				&& driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("New Text Document (2).txt"))
		{
			System.out.println("file name matching");
		}
		else
		{
			System.out.println("File names are mismatch");
		}
		Thread.sleep(2000);
		driver.quit();

	}

}
