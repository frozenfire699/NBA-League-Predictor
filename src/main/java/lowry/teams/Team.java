package lowry.teams;

import java.util.ArrayList;

import lowry.teams.actions.TeamActions;
import lowry.util.Player;

public class Team implements Comparable<Team>{
	
	ArrayList<Player> arrPlayers;
	TeamActions actions ;
	double teamValue;
	String teamName;
	String mode = "Year"; //default value
	double totalFGplayers;
	double totalFTplayers;
	
	public double getTeamValue() {
		return teamValue;
	}
	public void setTeamValue(double teamValue) {
		this.teamValue = teamValue;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	@Override
	public int compareTo(Team o) {
		return Double.compare(o.teamValue, teamValue);
	}
	public double getTotalFGplayers() {
		return totalFGplayers;
	}
	public void setTotalFGplayers(double totalFGplayers) {
		this.totalFGplayers = totalFGplayers;
	}
	public double getTotalFTplayers() {
		return totalFTplayers;
	}
	public void setTotalFTplayers(double totalFTplayers) {
		this.totalFTplayers = totalFTplayers;
	}

}
