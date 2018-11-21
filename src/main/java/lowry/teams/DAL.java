package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class DAL extends Team implements Roster{

	public DAL()
	{
		this.teamName = "DAL";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public DAL(int weekNumber)
	{
		this.teamName = "DAL";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public DAL(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "DAL";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("DAL", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("DAL", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("DAL",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}
	
	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}

}
