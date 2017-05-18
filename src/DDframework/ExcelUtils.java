package DDframework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream ExcelFile;
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   
	
	   String[][] tabArray = null;
	
	   try {
	
		   ExcelFile = new FileInputStream(FilePath);
		   ExcelWBook = new XSSFWorkbook(ExcelFile);
		   ExcelWSheet = ExcelWBook.getSheet(SheetName);
		   int startRow = 1;
		   int startCol = 0;
		   int ci,cj;
		   int totalRows = ExcelWSheet.getLastRowNum();
		   int totalCols = ExcelWSheet.getRow(0).getLastCellNum();
		   tabArray=new String[totalRows][totalCols];
		   ci=0;
		   for (int i=startRow;i<=totalRows;i++, ci++) {           	   
			  cj=0;
			   for (int j=startCol;j<totalCols;j++, cj++){
				   tabArray[ci][cj]=getCellData(i,j);
				}
			}
		}catch (FileNotFoundException e){
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}catch (IOException e){
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
	    ExcelWBook.close();
		return(tabArray);
	}
	
	
	@SuppressWarnings("finally")
	public static String[] getRowData(String FilePath, String SheetName, int RowNum) throws IOException{
		String[] RowArray= null;
		try{
			ExcelFile = new FileInputStream(FilePath);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet= ExcelWBook.getSheet(SheetName);
			Row=ExcelWSheet.getRow(RowNum);
			int totalCols = ExcelWSheet.getRow(RowNum).getLastCellNum();
			RowArray = new String[totalCols];
			for(int i= 0; i<totalCols; i++){
				RowArray[i]= getCellData(RowNum,i);
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			ExcelWBook.close();
			return RowArray;
		}
	}
	@SuppressWarnings("finally")
	public static String getCellData(String FilePath, String SheetName, int RowNum, int ColNum) throws Exception {
		String CellData=null; 
		try{
			ExcelFile = new FileInputStream(FilePath);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet= ExcelWBook.getSheet(SheetName);
			Row=ExcelWSheet.getRow(RowNum);
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			CellData = Cell.getStringCellValue().toString();
		}catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			return CellData;
		}
		
	}
	@SuppressWarnings("finally")
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		String CellData=null; 
		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			CellData = Cell.getStringCellValue().toString();
		}catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			return CellData;
		}
		
	}
	
	
	
	
}
