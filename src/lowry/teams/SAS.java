package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class SAS extends Team implements Roster{

	public SAS()
	{
		this.teamName = "SAS";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public SAS(int weekNumber)
	{
		this.teamName = "SAS";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public SAS(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "SAS";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("SAS", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("SAS", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("SAS",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}
	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}

}
