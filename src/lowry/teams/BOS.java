package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class BOS extends Team implements Roster{

	public BOS()
	{
		this.teamName = "BOS";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public BOS(int weekNumber)
	{
		this.teamName = "BOS";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public BOS(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "BOS";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("BOS", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("BOS", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("BOS",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}

	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}
}
