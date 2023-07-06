package Base;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;


public class BaseClass {
	

	
	public static WebDriver driver;
	
	
//////////Excel    COde   ///////////////////////
public static String getExcelDataUrl(String sheetName, int rowNum, int colNum) throws Throwable{
FileInputStream fis = new FileInputStream("C:\\Users\\Netmeds\\eclipse-workspace\\Monitor\\TestData\\TestData.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Row row = sh.getRow(rowNum);
String data = row.getCell(colNum).getStringCellValue();
wb.close();
return data;
}


// Row Count
public static int getRowCount(String sheetName) throws Throwable {
	FileInputStream fis = new FileInputStream("C:\\Users\\Netmeds\\eclipse-workspace\\Monitor\\TestData\\TestData.xlsx");
Workbook wb = WorkbookFactory.create(fis);
int rowIndex = wb.getSheet(sheetName).getLastRowNum();
return rowIndex;
}


//Cell Count

public static int getCellCount(String sheetName) throws Throwable {
	FileInputStream fis = new FileInputStream("C:\\Users\\Netmeds\\eclipse-workspace\\Monitor\\TestData\\TestData.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Row row = sh.getRow(0);
int cell = row.getLastCellNum();
return cell;
}


// Write Excel 
public static void writeData(String sheetName, int rowNum, int colNum,String data) throws Throwable{
	FileInputStream fis = new FileInputStream("C:\\Users\\Netmeds\\eclipse-workspace\\Monitor\\TestData\\TestData.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Row row = sh.getRow(rowNum);
Cell cel = row.createCell(colNum);
cel.setCellValue(data);
FileOutputStream fos = new FileOutputStream("C:\\Users\\Netmeds\\eclipse-workspace\\Monitor\\TestData\\TestData.xlsx");
	wb.write(fos);
	wb.close();

}
	
	
	
	

}
