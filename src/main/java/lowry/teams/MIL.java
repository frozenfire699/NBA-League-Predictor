package lowry.teams;

import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.predictor.UpdateSheets;
import lowry.teams.actions.TeamActions;


public class MIL extends Team implements Roster{

	public MIL()
	{
		this.teamName = "MIL";
		actions = new TeamActions();
		intializeRoster(this.mode);
		updateTeamSheet();
	}
	public MIL(int weekNumber)
	{
		this.teamName = "MIL";
		actions = new TeamActions();
		updateWeeklyMatch(weekNumber);
	}
	public MIL(String mode, HashMap<String,Double> hmSchedule)
	{
		this.teamName = "MIL";
		actions = new TeamActions();
		intializeRoster(mode);
		updateWeeklyTeamSheet(hmSchedule);
	}
	
	public void updateTeamSheet()
	{
		actions.updateTeamSheet("MIL", arrPlayers);
	}
	
	public void updateWeeklyTeamSheet(HashMap<String,Double> hmSchedule)
	{
		actions.updateWeeklyTeamSheet("MIL", arrPlayers, hmSchedule);
	}

	@Override
	public void intializeRoster(String mode) {
	
		arrPlayers = actions.getTeam("MIL",mode);
		this.teamValue = actions.getFinalTeamValue();
		UpdateSheets.hmLeagueRosters.add( this);
	}

	public void updateWeeklyMatch(int weekNo)
	{
		actions.updateWeekMatch(weekNo, this.teamName);
	}
}
