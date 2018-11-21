package lowry.predictor;

import java.util.ArrayList;
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
import lowry.teams.Team;
import lowry.teams.UTA;
import lowry.teams.WAS;
import lowry.util.LoadWeekSchedule;
import lowry.util.Player;
import lowry.util.XLFunctions;

public class UpdateWeeklyRosters {


	public static void main(String[] args) {
		
		XLFunctions.init();
		
		/* get the weekly schedule from the excel sheet */
		LoadWeekSchedule schedule = new LoadWeekSchedule();
		HashMap<String,Double> hmSchedule = schedule.getSchedule();
		
		ATL atl = new ATL("Week",hmSchedule);
		BKN bkn = new BKN("Week",hmSchedule);
		BOS bos = new BOS("Week",hmSchedule);
		CHA cha = new CHA("Week",hmSchedule);
		CHI chi = new CHI("Week",hmSchedule);
		CLE cle = new CLE("Week",hmSchedule);
		DAL dal = new DAL("Week",hmSchedule);
		DEN den = new DEN("Week",hmSchedule);
		DET det = new DET("Week",hmSchedule);
		GSW gsw = new GSW("Week",hmSchedule);
		HOU hou = new HOU("Week",hmSchedule);
		IND ind = new IND("Week",hmSchedule);
		LAC lac = new LAC("Week",hmSchedule);
		LAL lal = new LAL("Week",hmSchedule);
		MEM mem = new MEM("Week",hmSchedule);
		MIA mia = new MIA("Week",hmSchedule);
		MIN min = new MIN("Week",hmSchedule);
		MIL mil = new MIL("Week",hmSchedule);
		NOP nop = new NOP("Week",hmSchedule);
		NYK nyk = new NYK("Week",hmSchedule);
		OKC okc = new OKC("Week",hmSchedule);
		ORL orl = new ORL("Week",hmSchedule);
		PHI phi = new PHI("Week",hmSchedule);
		PHO pho = new PHO("Week",hmSchedule);
		POR por = new POR("Week",hmSchedule);
		SAC sac = new SAC("Week",hmSchedule);
		SAS sas = new SAS("Week",hmSchedule);
		TOR tor = new TOR("Week",hmSchedule);
		UTA uta = new UTA("Week",hmSchedule);
		WAS was = new WAS("Week",hmSchedule);
		

		System.out.println("Weekly rosters updated");
		}



}
