package lowry.util;

import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class LoadWeekSchedule {
	
	public HashMap<String,Double> getSchedule()
	{
		HashMap<String,Double> hmSchedule = new HashMap<String, Double>();
		
		XLFunctions.changeSheetName("Games");
		
		for (int row = 0; row < 30; row++) {
			{
				Row nextRow = XLFunctions.firstSheet.getRow(row);
				for (int cell = 0; cell < 12; cell++)
				{
					Cell teamCell = nextRow.getCell(0);
					String team = teamCell.getStringCellValue();
					
					Cell gamesCell = nextRow.getCell(1);
					double games = gamesCell.getNumericCellValue();
					
					hmSchedule.put(team, games);
				}
			}
		
		}
		System.out.println("Weekly Schedule is loaded");
		return hmSchedule;
	}

}
