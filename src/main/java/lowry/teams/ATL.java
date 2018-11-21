package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class ATL extends Team implements Roster{

	public ATL()
	{
		this.teamName = "ATL";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public ATL(int weekNumber)
	{
		this.teamName = "ATL";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public ATL(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "ATL";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("ATL", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("ATL", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("ATL",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}
	
	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}

}
