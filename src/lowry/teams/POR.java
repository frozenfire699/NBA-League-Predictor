package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class POR extends Team implements Roster{

	public POR()
	{
		this.teamName = "POR";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public POR(int weekNumber)
	{
		this.teamName = "POR";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public POR(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "POR";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("POR", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("POR", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("POR",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}

	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}
}
