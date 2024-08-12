package Apache_POIAssignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calculator {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,450)");
		
		//filepath
		
		String file = System.getProperty("user.dir")+"//TestData//CalData_Cit.xlsx";
		
		//calulate rows --> call getRowCount method from ExcelUtil
		//2. Pass parameter (Filepath , sheetname)
		int rows = ExcelUtility.getRowCount(file, "Sheet1");
		
		//Reading the data from excel sheet
		for(int i =1; i<=rows; i++)
		{
			String Initial_DA = ExcelUtility.getCellData(file, "Sheet1", i, 0);
			String Length_of_CD = ExcelUtility.getCellData(file, "Sheet1", i, 1);
			String Interest_Rate = ExcelUtility.getCellData(file, "Sheet1", i, 2);
			String Compounding = ExcelUtility.getCellData(file, "Sheet1", i, 3);
			String CD_value = ExcelUtility.getCellData(file, "Sheet1", i, 4);

			//pass above data to application
			WebElement first = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
			first.clear();
			first.sendKeys(Initial_DA);
			
			WebElement second = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
			second.clear();
			second.sendKeys(Length_of_CD);
			
			WebElement third = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
			third.clear();
			third.sendKeys(Interest_Rate);
			
			System.out.println("------------------------------------"+Compounding);
			WebElement forth = driver.findElement(By.xpath("//span[text()='" + Compounding + "']" ));
			forth.click();
			System.out.println("Button clicked");
			
			WebElement button = driver.findElement(By.xpath("//button[@id='CIT-chart-submit']"));
			je.executeScript("arguments[0].click()", button);
			
			//Validation
			String act_CD_value = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
			
			if(Double.parseDouble(CD_value)==Double.parseDouble(act_CD_value))
			{
				System.out.println("Test Pass");
				ExcelUtility.setCellData(file, "Sheet1", rows, 5, "Pass");
			}
			else
			{
				System.out.println("Test Fail");
				ExcelUtility.setCellData(file, "Sheet1", rows, 5, "Fail");
			}
			Thread.sleep(3000);
		}
	}
		

}
