package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class SAC extends Team implements Roster{

	public SAC()
	{
		this.teamName = "SAC";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public SAC(int weekNumber)
	{
		this.teamName = "SAC";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public SAC(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "SAC";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("SAC", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("SAC", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("SAC",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}

	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}
}
