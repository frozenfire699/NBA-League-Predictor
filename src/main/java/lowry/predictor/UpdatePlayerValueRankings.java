package lowry.predictor;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import lowry.teams.Team;
import lowry.util.XLFunctions;

public class UpdatePlayerValueRankings {
	
	public void updateRanks(ArrayList<Team> teams)
	{
		XLFunctions.changeSheetName("Ranking");
		XLFunctions.clearContents(1,40,0,2);
		
		/* Making the sheet ready to write to */
		XLFunctions.changeSheetName("Ranking");
		
		Collections.sort(teams);
		
		int noOfTeams = teams.size();
		String tempString;
		double tempDbl;
		
		for(int i =0; i< noOfTeams ; i++)
		{
			Team team = teams.get(i);
			//System.out.println(team.getTeamName() + " final value is : " + team.getTeamValue());
			
			Row nextRow = XLFunctions.firstSheet.getRow(i+1);
			for (int cell = 0; cell < 2; cell++) 
			{
				Cell nextCell = nextRow.createCell(cell);
				 /* Map the cell value to corresponding property in Player object */
				 
				switch (cell) {
				case 0:
					tempString = team.getTeamName();
					nextCell.setCellValue(tempString);
					//System.out.println("writing team number " + i + " to ranking sheet--->" + tempString);
					break;
				case 1:
					tempDbl = team.getTeamValue();
					nextCell.setCellValue(tempDbl);
					break;
				}
			}
			
		}

		XLFunctions.write();
		System.out.println("Ranking Sheet updated");
			
	}

}
