package QAUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	static FileInputStream Read;
	static XSSFWorkbook ExcelBook;
	static XSSFSheet ExcelSheet;
	static Object[][] data;
	static XSSFRow  NoRows;
	static XSSFCell cellvalue;
	static DataFormatter formatdata;

	protected static XSSFSheet ReadSheet(String ExcelFilePath,String ExcelSheetName) throws IOException {

		try {
			Read =  new FileInputStream(ExcelFilePath);

			ExcelBook = new XSSFWorkbook(Read);

			ExcelSheet = ExcelBook.getSheet(ExcelSheetName);

		}catch(IOException e) {
			
			System.out.println(e);
			
		}
		return ExcelSheet;

	}

	
	public static Object[][] ReadData(String ExcelFilePath,String ExcelSheetName) throws IOException{

		ReadSheet(ExcelFilePath,ExcelSheetName);
		
		int NoOfRows = ExcelSheet.getPhysicalNumberOfRows();
		int NoOfCells = ExcelSheet.getRow(0).getLastCellNum();
		
		data = new Object[NoOfRows] [NoOfCells];
		
		for(int i=0;i<NoOfRows;i++) {
			
			NoRows = ExcelSheet.getRow(i);
			
			for(int j=0;j<NoOfCells;j++) {
				
			 cellvalue	= NoRows.getCell(j);
			 
			 formatdata = new DataFormatter();
			 
			 data[i][j] = formatdata.formatCellValue(cellvalue);
			 
			 System.out.print(data[i][j]+" | ");
			}
			System.out.println();
		}

		return data;

	}
	
	public static void main(String[] args) throws IOException {
		//ReadData();
	}




}
