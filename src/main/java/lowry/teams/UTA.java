package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class UTA extends Team implements Roster{

	public UTA()
	{
		this.teamName = "UTA";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public UTA(int weekNumber)
	{
		this.teamName = "UTA";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public UTA(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "UTA";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("UTA", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("UTA", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("UTA",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}
	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}

}
