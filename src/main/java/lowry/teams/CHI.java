package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class CHI extends Team implements Roster{

	public CHI()
	{
		this.teamName = "CHI";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public CHI(int weekNumber)
	{
		this.teamName = "CHI";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public CHI(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "CHI";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("CHI", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("CHI", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("CHI",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}

	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}
}
