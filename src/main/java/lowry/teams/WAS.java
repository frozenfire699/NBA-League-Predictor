package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class WAS extends Team implements Roster{

	public WAS()
	{
		this.teamName = "WAS";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public WAS(int weekNumber)
	{
		this.teamName = "WAS";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public WAS(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "WAS";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("WAS", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("WAS", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("WAS",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}

	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}
}
