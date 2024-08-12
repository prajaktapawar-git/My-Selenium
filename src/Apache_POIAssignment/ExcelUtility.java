package Apache_POIAssignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public static XSSFRow row;
	public static CellStyle style;
	
	public static int getRowCount(String xlFile, String xlSheet) throws IOException
	{
		fi = new FileInputStream(xlFile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlSheet);
		int rowcount = sheet.getLastRowNum();
		System.out.println("RowCount="+rowcount);
		return rowcount;
	}
	
	public static int getCellCount(String xlFile, String xlSheet, int rownum) throws IOException
	{
		fi = new FileInputStream(xlFile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlSheet);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		System.out.println("CellCount="+cellcount);
		return cellcount;
	}
	
	public static String getCellData(String xlFile, String xlSheet, int rownum, int cellnum) throws IOException
	{
		fi = new FileInputStream(xlFile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlSheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		
		String data;
		
		try {
		DataFormatter format = new DataFormatter();
		data = format.formatCellValue(cell);
		}catch(Exception e)
		{
			data ="";
		}
		workbook.close();
		fi.close();
		return data;
	}
	
	public static void setCellData(String xlFile, String xlSheet, int rownum, int cellnum, String data) throws IOException
	{
		fi = new FileInputStream(xlFile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlSheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		
		cell = row.createCell(cellnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlFile);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
	
}
