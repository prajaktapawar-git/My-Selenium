package ExcelUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	public static int getRowCount(String xlFile, String xlSheet) throws IOException
	{
		fi = new FileInputStream(xlFile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlSheet);
		int rowcount = sheet.getLastRowNum();
		System.out.println("RowCount="+rowcount);
		workbook.close();
		fi.close();
		return rowcount;
	}
	
	public static int getCellCount (String xlFile, String xlSheet, int rownum) throws IOException
	{
		fi = new FileInputStream(xlFile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlSheet);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		System.out.println("CellCount ="+cellcount);
		return cellcount;
	}
	
	public static String getCellData (String xlFile, String xlSheet, int rownum, int colnum) throws IOException
	{
		fi = new FileInputStream(xlFile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlSheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		String data;
		
		try
		{
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell); //return formatted value of cell as string
		}catch (Exception e){
			data = "";
		}
		
		workbook.close();
		fi.close();
		return data;
	}
	
	//samesheet reading and writing the data
	
	public static void setCellCount (String xlFile, String xlSheet, int rownum, int colnum , String data) throws IOException 
	{
		fi = new FileInputStream(xlFile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlSheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlFile);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
	
	public static void fillGreenColor (String xlFile, String xlSheet, int rownum, int colnum ) throws IOException
	{
		fi = new FileInputStream(xlFile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlSheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo = new FileOutputStream(xlFile);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
	}
	
	public static void fillRedColor (String xlFile, String xlSheet, int rownum, int colnum ) throws IOException
	{
		fi = new FileInputStream(xlFile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlSheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo = new FileOutputStream(xlFile);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
	
	
}

