package lowry.util;

public class PlayerScoreCalculator {
	
	public static double playerValue;
	
	public static void updateScore(double data, int cat)
	{
		switch(cat)
		{
		case 1:
			if(data<=0.38)
			{
				playerValue = playerValue - 3;
			}
			else if(data>=0.381 && data <=0.399)
			{
				playerValue = playerValue - 1;
			}
			else if(data>=0.4 && data <=0.449)
			{
				playerValue = playerValue + 1;
			}
			else if(data>=0.45 && data <=0.499)
			{
				playerValue = playerValue + 2;
			}
			else if(data>=0.5)
			{
				playerValue = playerValue + 4;
			}
			else
			{
				playerValue = playerValue + 0;
			}
			break;
		case 2:
			if(data<=0.7)
			{
				playerValue = playerValue - 3;
			}
			else if(data>=0.701 && data <=0.779)
			{
				playerValue = playerValue - 1;
			}
			else if(data>=0.78 && data <=0.819)
			{
				playerValue = playerValue + 1;
			}
			else if(data>=0.82 && data <=0.849)
			{
				playerValue = playerValue + 2;
			}
			else if(data>=0.85)
			{
				playerValue = playerValue + 4;
			}
			else
			{
				playerValue = playerValue + 0;
			}
			break;
		case 3:
			if(data<0)
			{
				playerValue = playerValue - 3;
			}
			else if(data>=0 && data <=0.99)
			{
				playerValue = playerValue - 1;
			}
			else if(data>=1 && data <=1.49)
			{
				playerValue = playerValue + 1;
			}
			else if(data>=1.5 && data <=1.99)
			{
				playerValue = playerValue + 2;
			}
			else if(data>=2)
			{
				playerValue = playerValue + 4;
			}
			else
			{
				playerValue = playerValue + 0;
			}
			break;
		case 4:
			if(data>=0 && data <=2.99)
			{
				playerValue = playerValue - 3;
			}
			else if(data>=3 && data <=7.99)
			{
				playerValue = playerValue - 1;
			}
			else if(data>=8 && data <=11.99)
			{
				playerValue = playerValue + 1;
			}
			else if(data>=12 && data <=19.99)
			{
				playerValue = playerValue + 2;
			}
			else if(data>=20)
			{
				playerValue = playerValue + 4;
			}
			else
			{
				playerValue = playerValue + 0;
			}
			break;
		case 5:
			if(data>=0 && data <=0.99)
			{
				playerValue = playerValue - 3;
			}
			else if(data>=1 && data <=2.99)
			{
				playerValue = playerValue - 1;
			}
			else if(data>=3 && data <=5.99)
			{
				playerValue = playerValue + 1;
			}
			else if(data>=6 && data <=9.99)
			{
				playerValue = playerValue + 2;
			}
			else if(data>=10)
			{
				playerValue = playerValue + 4;
			}
			else
			{
				playerValue = playerValue + 0;
			}
			break;
		case 6:
			if(data>=0 && data <=0.99)
			{
				playerValue = playerValue - 3;
			}
			else if(data>=1 && data <=2.99)
			{
				playerValue = playerValue - 1;
			}
			else if(data>=3 && data <=5.99)
			{
				playerValue = playerValue + 1;
			}
			else if(data>=6 && data <=9.99)
			{
				playerValue = playerValue + 2;
			}
			else if(data>=10)
			{
				playerValue = playerValue + 4;
			}
			else
			{
				playerValue = playerValue + 0;
			}
			break;
		case 7:
			if(data>=0 && data <=0.19)
			{
				playerValue = playerValue - 3;
			}
			else if(data>=0.2 && data <=0.49)
			{
				playerValue = playerValue - 1;
			}
			else if(data>=0.5 && data <=0.99)
			{
				playerValue = playerValue + 1;
			}
			else if(data>=1 && data <=1.99)
			{
				playerValue = playerValue + 2;
			}
			else if(data>=2)
			{
				playerValue = playerValue + 4;
			}
			else
			{
				playerValue = playerValue + 0;
			}
			break;
		case 8:
			if(data>=0 && data <=0.19)
			{
				playerValue = playerValue - 3;
			}
			else if(data>=0.2 && data <=0.49)
			{
				playerValue = playerValue - 1;
			}
			else if(data>=0.5 && data <=0.99)
			{
				playerValue = playerValue + 1;
			}
			else if(data>=1 && data <=1.99)
			{
				playerValue = playerValue + 2;
			}
			else if(data>=2)
			{
				playerValue = playerValue + 4;
			}
			else
			{
				playerValue = playerValue + 0;
			}
			break;
		case 9:
			if(data>=0 && data <=0.79)
			{
				playerValue = playerValue + 4;
			}
			else if(data>=0.8 && data <=1.19)
			{
				playerValue = playerValue + 2;
			}
			else if(data>=1.2 && data <=1.49)
			{
				playerValue = playerValue + 1; 
			}
			else if(data>=1.5 && data <=2.49)
			{
				playerValue = playerValue - 1;
			}
			else if(data>=2.5)
			{
				playerValue = playerValue - 3;
			}
			else
			{
				playerValue = playerValue + 0;
			}
			break;

		}
	}

	public static void resetValue()
	{
		playerValue = 0;
		
	}
	public double getPlayerValue() {
		return playerValue;
	}

	public void setPlayerValue(double playerValue) {
		this.playerValue = playerValue;
	}
	

}
