package lowry.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadTeamProps {
	
	public static String getTeamName(String teamName)
	{
		String team = null;
		
		/* code to read the team.properties file */
		Properties props = new Properties();
		InputStream input = null;
		
		try
		{
			input = new FileInputStream("team.properties");
			props.load(input);
			
			team = props.getProperty(teamName);
		}
		catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return team;
	}

}
