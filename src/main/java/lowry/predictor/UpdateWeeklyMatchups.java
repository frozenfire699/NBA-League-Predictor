package lowry.predictor;

import java.util.HashMap;

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
import lowry.teams.UTA;
import lowry.teams.WAS;
import lowry.util.XLFunctions;

public class UpdateWeeklyMatchups {
	
	public static HashMap<String,String> hmLeagueWeeklyRosters = new HashMap<String,String>();

	public static void main(String[] args) {
		
		XLFunctions.init();
		int week = 16;
		
		ATL atl = new ATL(week);
		BKN bkn = new BKN(week);
		BOS bos = new BOS(week);
		CHA cha = new CHA(week);
		CHI chi = new CHI(week);
		CLE cle = new CLE(week);
		DAL dal = new DAL(week);
		DEN den = new DEN(week);
		DET det = new DET(week);
		GSW gsw = new GSW(week);
		HOU hou = new HOU(week);
		IND ind = new IND(week);
		LAC lac = new LAC(week);
		LAL lal = new LAL(week);
		MEM mem = new MEM(week);
		MIA mia = new MIA(week);
		MIN min = new MIN(week);
		MIL mil = new MIL(week);
		NOP nop = new NOP(week);
		NYK nyk = new NYK(week);
		OKC okc = new OKC(week);
		ORL orl = new ORL(week);
		PHI phi = new PHI(week);
		PHO pho = new PHO(week);
		POR por = new POR(week);
		SAC sac = new SAC(week);
		SAS sas = new SAS(week);
		TOR tor = new TOR(week);
		UTA uta = new UTA(week);
		WAS was = new WAS(week);
		
		System.out.println("Weekly matchups updated");
		
		
	}
	

}
