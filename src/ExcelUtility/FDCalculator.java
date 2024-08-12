package ExcelUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,450)");
		
		//filepath
		String filepath = System.getProperty("user.dir")+("//TestData//CalData.xlsx");
		
		//calulate rows --> call getRowCount method from ExcelUtil
		//2. Pass parameter (Filepath , sheetname)
		int rows = ExcelUtil.getRowCount(filepath, "Sheet1");
		
		//Reading the data from excel sheet
		for (int i=1; i<=rows; i++)
		{
			//read data from excel
			String principle = ExcelUtil.getCellData(filepath, "Sheet1", i, 0); //0=1st cell
			String rateofinterest = ExcelUtil.getCellData(filepath, "Sheet1", i, 1);
			String Period1 = ExcelUtil.getCellData(filepath, "Sheet1", i, 2);
			String Period2 = ExcelUtil.getCellData(filepath, "Sheet1", i, 3);
			String frequency = ExcelUtil.getCellData(filepath, "Sheet1", i, 4);
			String exp_maturity_value = ExcelUtil.getCellData(filepath, "Sheet1", i, 5);
			
			//pass above data to application
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principle);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateofinterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(Period1);
			
			WebElement el = driver.findElement(By.xpath("//select[@id='tenurePeriod']")); //dropdown
			Select select = new Select(el);
			select.selectByVisibleText(Period2);
			
			WebElement we = driver.findElement(By.xpath("//select[@id='frequency']")); //dropdown
			Select select1 = new Select(we);
			select1.selectByVisibleText(frequency);
			
			WebElement button = driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")); // click on Calculate button
			je.executeScript("arguments[0].click()", button);
			
			//validation
			
			String act_maturity_value = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			//here both exp_maturity_value & act_maturity_value both are in string format we cannot compare those
			//we have to convert those values into double format
			
			if(Double.parseDouble(exp_maturity_value)==Double.parseDouble(act_maturity_value))
			{
				System.out.println("Test Pass");
				ExcelUtil.setCellCount(filepath, "Sheet1", rows, 7, "Passed"); //7 is cell number
				ExcelUtil.fillGreenColor(filepath, "Sheet1", rows, 7);
			}
			else
			{
				System.out.println("Test Failed");
				ExcelUtil.setCellCount(filepath, "Sheet1", rows, 7, "Failed"); //7 is cell number
				ExcelUtil.fillRedColor(filepath, "Sheet1", rows, 7);
				
			}
			Thread.sleep(3000);
			WebElement clearbutton = driver.findElement(By.xpath("//img[@class='PL5']")); //clear a data
			je.executeScript("arguments[0].click()", clearbutton);
		}
		
		driver.quit();

	}

}
