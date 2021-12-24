package Fnptest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetData 
{
	//.HSSF
	//.XSSF (later than 2007)
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	

	
	public GetData(String Retrieve) throws IOException
	{
		File fi = new File(Retrieve);
		FileInputStream fis = new FileInputStream(fi);
		wb = new XSSFWorkbook(fis);		
	}
	
	
	public int getRowNum(int sheetindex)
	{
		int row = wb.getSheetAt(sheetindex).getLastRowNum();
		row++;			
		return row;		
	}
	
	public String getDataSheet(int sheetno, int row, int col) 
	{
		String data = wb.getSheetAt(sheetno).getRow(row).getCell(col).getStringCellValue();		
		return data;
	}

}

//sivashankar12291@gmail.com	sivashankar123
//rubberdingyrapidsbruv@gmail.com	rockpaperrepeat123
