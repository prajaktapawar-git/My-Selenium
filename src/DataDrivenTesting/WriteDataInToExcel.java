package DataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataInToExcel {

	public static void main(String[] args) throws IOException {
		//Excel File --> Workbook --> Sheet --> Row -->Cell
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\FileWrite.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");
		
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Prajakta");
		row1.createCell(1).setCellValue("Vishal");
		row1.createCell(2).setCellValue("Vishal");
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File created successfully....");
	}

}
