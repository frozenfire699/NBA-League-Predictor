package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class BKN extends Team implements Roster{

	public BKN()
	{
		this.teamName = "BKN";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public BKN(int weekNumber)
	{
		this.teamName = "BKN";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public BKN(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "BKN";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("BKN", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("BKN", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("BKN",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}
	
	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}

}
