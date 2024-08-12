package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
	//Excel File --> Workook --> Sheets --> Rows --> Cells
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\DataDrivenTestingData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int totalrowscount = sheet.getLastRowNum();
		
		int totalcellcount = sheet.getRow(1).getLastCellNum();
		
		System.out.println("Total Rows:"+totalrowscount);
		System.out.println("Total Cells:"+totalcellcount);
		
		for ( int r=0; r<=totalrowscount;r++)
		{
			XSSFRow currentrow = sheet.getRow(r);
			
			for(int c=0; c<totalcellcount ; c++)
			{
				XSSFCell cell = currentrow.getCell(c);
				System.out.print(cell.toString()+"\t");
			}
			System.out.println("\n");
		}
		
	workbook.close();
	file.close();

	}

}
