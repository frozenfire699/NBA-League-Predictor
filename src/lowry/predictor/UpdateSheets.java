package lowry.predictor;

import java.util.ArrayList;
import java.util.HashMap;

import lowry.interfaces.Roster;
import lowry.teams.ATL;
import lowry.teams.BKN;
import lowry.teams.BOS;
import lowry.teams.CHA;
import lowry.teams.CHI;
import lowry.teams.CLE;
import lowry.teams.DAL;
import lowry.teams.DEN;
import lowry.teams.DET;
import lowry.teams.GSW;
import lowry.teams.HOU;
import lowry.teams.IND;
import lowry.teams.LAC;
import lowry.teams.LAL;
import lowry.teams.MEM;
import lowry.teams.MIA;
import lowry.teams.MIL;
import lowry.teams.MIN;
import lowry.teams.NOP;
import lowry.teams.NYK;
import lowry.teams.OKC;
import lowry.teams.ORL;
import lowry.teams.PHI;
import lowry.teams.PHO;
import lowry.teams.POR;
import lowry.teams.SAC;
import lowry.teams.SAS;
import lowry.teams.TOR;
import lowry.teams.Team;
import lowry.teams.UTA;
import lowry.teams.WAS;

import lowry.util.Player;
import lowry.util.XLFunctions;

public class UpdateSheets {
	
	public static ArrayList<Team> hmLeagueRosters = new ArrayList<Team>();
	
	public static void main(String[] args) {
		
		XLFunctions.init();
		
		//XLFunctions.takeBackup();
		
		ATL atl = new ATL();
		BKN bkn = new BKN();
		BOS bos = new BOS();
		CHA cha = new CHA();
		CHI chi = new CHI();
		CLE cle = new CLE();
		DAL dal = new DAL();
		DEN den = new DEN();
		DET det = new DET();
		GSW gsw = new GSW();
		HOU hou = new HOU();
		IND ind = new IND();
		LAC lac = new LAC();
		LAL lal = new LAL();
		MEM mem = new MEM();
		MIA mia = new MIA();
		MIN min = new MIN();
		MIL mil = new MIL();
		NOP nop = new NOP();
		NYK nyk = new NYK();
		OKC okc = new OKC();
		ORL orl = new ORL();
		PHI phi = new PHI();
		PHO pho = new PHO();
		POR por = new POR();
		SAC sac = new SAC();
		SAS sas = new SAS();
		TOR tor = new TOR();
		UTA uta = new UTA();
		WAS was = new WAS();
		
		UpdatePlayerValueRankings updateRankSheet = new UpdatePlayerValueRankings();
	    updateRankSheet.updateRanks(hmLeagueRosters);
		
		System.out.println("Rosters and Player Rankings are updated");
		}

}
