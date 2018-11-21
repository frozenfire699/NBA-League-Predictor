package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class LAC extends Team implements Roster{

	public LAC()
	{
		this.teamName = "LAC";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public LAC(int weekNumber)
	{
		this.teamName = "LAC";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public LAC(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "LAC";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("LAC", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("LAC", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("LAC",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}

	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}
}
