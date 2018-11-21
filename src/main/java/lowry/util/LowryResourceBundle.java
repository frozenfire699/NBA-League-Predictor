package lowry.util;
import java.util.ResourceBundle;

public class LowryResourceBundle {
	
	static ResourceBundle rb;
	
	public static ResourceBundle getBundleInstance()
	{
		if(rb==null)
		{
			
			rb = ResourceBundle.getBundle("team");
		}
		
		return rb;
		
	}
	
	public String getTeamName(String data) {
		
		String teamName = (String) this.rb.getObject(data);
	
		return teamName;
		
		}
}
