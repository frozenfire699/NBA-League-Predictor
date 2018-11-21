package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class CHA extends Team implements Roster{

	public CHA()
	{
		this.teamName = "CHA";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public CHA(int weekNumber)
	{
		this.teamName = "CHA";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public CHA(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "CHA";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("CHA", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("CHA", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("CHA",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}
	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}

}
