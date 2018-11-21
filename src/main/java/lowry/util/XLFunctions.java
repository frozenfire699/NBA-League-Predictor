package lowry.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLFunctions {

	public static FileInputStream inputStream;
	public static  FileOutputStream outputStream;
	static String excelFilePath = "C:\\Users\\rohit.x.gupta\\Desktop\\Lowry.xlsx";
	//static String excelFilePath = "H:\\Lowry.xlsm";
	//static String excelOutFilePath = "H:\\Lowry.xlsm";
	static String excelOutFilePath = "C:\\Users\\rohit.x.gupta\\Desktop\\Lowry.xlsx";
	//static String backUpFilePath = "H:\\Lowry\\Lowry.xlsm";
	public static Workbook workbook;
	public static Sheet firstSheet;

	public static void initReadStream() {

		try {
			if(inputStream == null)
			{
				inputStream = new FileInputStream(new File(excelFilePath));
				initWorkBook();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void initWriteStream() 
	{
		try 
		{
			if(outputStream == null)
			{
				outputStream = new FileOutputStream(new File(excelOutFilePath));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void init()
	{
		initReadStream();
		initWriteStream();
	}
	public static void initWorkBook()
	{
		if(workbook == null)
		{
			try {
				workbook = new XSSFWorkbook(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
public static void write(){
		
		try 
		{
				init();
				workbook.write(outputStream);
				closeWorkBook();
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void changeSheetName(String teamName)
	{
		init();
		firstSheet = workbook.getSheet(teamName);
	}

	public static void closeWorkBook() {
		

		try {
			//workbook.close();
			inputStream.close();
			outputStream.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		inputStream = null;
		outputStream = null;
		workbook = null;
		firstSheet = null;
	}
	
	public FileInputStream getInputStream() {
		return inputStream;
	}

	public FileOutputStream getOutputStream() {
		return outputStream;
	}
	
	
	/**
	 * 
	 * @param startRow : Starting row number
	 * @param endRow: Ending row number
	 * @param startRow : Stating cell number
	 * @param endRow: Ending cell number
	 */
	public static void clearContents(int startRow, int endRow, int startCell, int endCell)
	{
		for(int row =startRow; row<endRow; row++)
		{
			Row nextRow = XLFunctions.firstSheet.getRow(row);
			for (int cell = startCell; cell < endCell; cell++)
			{
				try
				{
					Cell nextCell = nextRow.getCell(cell);
					if(nextCell.getCellType() != nextCell.CELL_TYPE_BLANK)
					{
						nextCell.setCellType(nextCell.CELL_TYPE_BLANK);
						//System.out.println( String.valueOf(row+1) + "," + String.valueOf(cell+1) + "cleared" );
					}
					else
					{
						//System.out.println( String.valueOf(row+1) + "," + String.valueOf(cell+1) + "is already blank" );
					}
				}
				/* Check if there is an empty cell in the worksheet, and skip it */
				catch (NullPointerException nex) {
						continue;
				}
				
			}
		}
		
		//System.out.println("Contents cleared");
		XLFunctions.write();
	}

	
}
