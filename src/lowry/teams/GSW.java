package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class GSW extends Team implements Roster{

	public GSW()
	{
		this.teamName = "GSW";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public GSW(int weekNumber)
	{
		this.teamName = "GSW";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public GSW(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "GSW";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("GSW", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("GSW", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("GSW",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}

	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}
}
