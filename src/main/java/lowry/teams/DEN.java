package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class DEN extends Team implements Roster{

	public DEN()
	{
		this.teamName = "DEN";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public DEN(int weekNumber)
	{
		this.teamName = "DEN";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public DEN(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "DEN";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("DEN", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("DEN", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("DEN",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}
	
	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}

}
