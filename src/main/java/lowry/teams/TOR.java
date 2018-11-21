package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class TOR extends Team implements Roster{

	public TOR()
	{
		this.teamName = "TOR";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public TOR(int weekNumber)
	{
		this.teamName = "TOR";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public TOR(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "TOR";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("TOR", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("TOR", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("TOR",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}

	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}
}
