package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class PHO extends Team implements Roster{

	public PHO()
	{
		this.teamName = "PHO";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public PHO(int weekNumber)
	{
		this.teamName = "PHO";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public PHO(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "PHO";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("PHO", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("PHO", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("PHO",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}

	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}
}
