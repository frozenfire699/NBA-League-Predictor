package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class LAL extends Team implements Roster{

	public LAL()
	{
		this.teamName = "LAL";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public LAL(int weekNumber)
	{
		this.teamName = "LAL";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public LAL(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "LAL";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("LAL", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("LAL", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("LAL",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}
	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}

}
