package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class MIA extends Team implements Roster{

	public MIA()
	{
		this.teamName = "MIA";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public MIA(int weekNumber)
	{
		this.teamName = "MIA";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public MIA(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "MIA";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("MIA", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("MIA", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("MIA",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}
	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}

}
