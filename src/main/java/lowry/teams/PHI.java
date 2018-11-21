package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class PHI extends Team implements Roster{

	public PHI()
	{
		this.teamName = "PHI";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public PHI(int weekNumber)
	{
		this.teamName = "PHI";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public PHI(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "PHI";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("PHI", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("PHI", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("PHI",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}

	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}
}
