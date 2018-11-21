package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class MIN extends Team implements Roster{

	public MIN()
	{
		this.teamName = "MIN";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public MIN(int weekNumber)
	{
		this.teamName = "MIN";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public MIN(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "MIN";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("MIN", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("MIN", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("MIN",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}
	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}

}
