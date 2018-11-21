package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class DET extends Team implements Roster{

	public DET()
	{
		this.teamName = "DET";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public DET(int weekNumber)
	{
		this.teamName = "DET";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public DET(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "DET";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("DET", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("DET", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("DET",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}

	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}
}
