package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class NYK extends Team implements Roster{

	public NYK()
	{
		this.teamName = "NYK";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public NYK(int weekNumber)
	{
		this.teamName = "NYK";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public NYK(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "NYK";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("NYK", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("NYK", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("NYK",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}
	
	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}

}
