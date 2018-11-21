package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class IND extends Team implements Roster{

	public IND()
	{
		this.teamName = "IND";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public IND(int weekNumber)
	{
		this.teamName = "IND";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public IND(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "IND";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("IND", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("IND", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("IND",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}

	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}
}
