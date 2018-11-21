package lowry.exceptions;

public class NullRowException extends Throwable{
	
	String sheetName;
	int rowNumber;
	
	/**
	 * Constructor
	 * @param sheetName
	 * @param rowNumber
	 */
	public NullRowException(String sheetName, int rowNumber) {
		
		this.sheetName = sheetName;
		this.rowNumber = rowNumber;
	}
	
	public void printMessage()
	{
		System.out.println("Row number" + this.rowNumber + " inside sheet name " + this.sheetName + "returned null");
	}
	
}
