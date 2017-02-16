package lowry.exceptions;

public class NullCellException extends Throwable{
	
	String sheetName;
	int rowNumber;
	int cellNumber;
	
	/**
	 * Constructor
	 * @param sheetName
	 * @param rowNumber
	 */
	public NullCellException(String sheetName, int rowNumber, int cellNumber) {
		
		this.sheetName = sheetName;
		this.rowNumber = rowNumber;
		this.cellNumber = cellNumber;
		
	}
	
	public void printMessage()
	{
		System.out.println("Row number" + this.rowNumber + "Cell number" + this.cellNumber +
				" inside sheet name " + this.sheetName + "returned null");
	}
	
}
