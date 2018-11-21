package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class CLE extends Team implements Roster{

	public CLE()
	{
		this.teamName = "CLE";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public CLE(int weekNumber)
	{
		this.teamName = "CLE";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public CLE(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "CLE";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("CLE", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("CLE", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("CLE",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}

	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}
}
