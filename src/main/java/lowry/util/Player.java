package lowry.util;

public class Player implements Comparable<Player>{
	
	String name;
	String team;
	double fgs;
	double fts;
	double threes;
	double points;
	double reb;
	double ast;
	double stl;
	double blk;
	double to;
	double value;
	String status;
	double playerStatus;  // 0 = Injured, 1 = Not Injured
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		if(this.name!=null)
		{
			String[] strNameArr = this.name.split("- ");
			this.team = strNameArr[1];
			if(this.team.trim().equalsIgnoreCase("GS"))
			{
				this.team = "GSW";
			}
			else if(this.team.trim().equalsIgnoreCase("SA"))
			{
				this.team = "SAS";
			}
			else if(this.team.trim().equalsIgnoreCase("NY"))
			{
				this.team = "NYK";
			}
			else if(this.team.trim().equalsIgnoreCase("NO"))
			{
				this.team = "NOP";
			}
		}
		
	}
	public double getFgs() {
		return fgs;
	}
	public void setFgs(double fgs) {
		this.fgs = fgs;
	}
	public double getFts() {
		return fts;
	}
	public void setFts(double fts) {
		this.fts = fts;
	}
	public double getThrees() {
		return threes;
	}
	public void setThrees(double threes) {
		this.threes = threes;
	}
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	public double getReb() {
		return reb;
	}
	public void setReb(double reb) {
		this.reb = reb;
	}
	public double getAst() {
		return ast;
	}
	public void setAst(double ast) {
		this.ast = ast;
	}
	public double getStl() {
		return stl;
	}
	public void setStl(double stl) {
		this.stl = stl;
	}
	public double getBlk() {
		return blk;
	}
	public void setBlk(double blk) {
		this.blk = blk;
	}
	public double getTo() {
		return to;
	}
	public void setTo(double to) {
		this.to = to;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int compareTo(Player o) {
		return Double.compare(o.value,this.value);
		
	}
	public double getPlayerStatus() {
		return playerStatus;
	}
	public void setPlayerStatus(double playerStatus) {
		this.playerStatus = playerStatus;
	}
	

}
