package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class MEM extends Team implements Roster{

	public MEM()
	{
		this.teamName = "MEM";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public MEM(int weekNumber)
	{
		this.teamName = "MEM";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public MEM(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "MEM";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("MEM", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("MEM", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("MEM",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}
	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}

}
