package lowry.teams.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import lowry.exceptions.NullCellException;
import lowry.exceptions.NullRowException;
import lowry.predictor.UpdateWeeklyMatchups;
import lowry.predictor.UpdateWeeklyRosters;
import lowry.util.Player;
import lowry.util.PlayerScoreCalculator;
import lowry.util.XLFunctions;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

public class TeamActions {
	
	double finalTeamValue = 0;
	double totalFGPlayers = 0;
	double totalFTPlayers = 0;
	
	/**
	 * This method will perform the following actions: 1. Open the workbook to
	 * the sheet of the team name that is passed 2. Read data from the sheet and
	 * prepare the Player Object 3. Fill the arrayList (Roster) with each player
	 * 4. Return the Roster
	 * 
	 * @param teamName
	 * @return
	 */

	public ArrayList<Player> getTeam(String teamName, String mode) {
	
		/* Check which mode is being used to calculate */
		if(mode.equalsIgnoreCase("Year"))
		{
			XLFunctions.changeSheetName("Master");
		}
		else if(mode.equalsIgnoreCase("Week"))
		{
			//XLFunctions.changeSheetName("Weekly");
			XLFunctions.changeSheetName("Master");
		}
		else
		{
			XLFunctions.changeSheetName("Master");
		}

		/* Create instance of the Roster to which every player will be added */
		ArrayList<Player> arrPlayers = new ArrayList<Player>();

		/* Start from row 2 in excel and read the next 15 players */
		for (int row = 1; row < 1000; row++) {
			Row nextRow = XLFunctions.firstSheet.getRow(row);
			/* Create an instance of the player which will be filled below */
			Player player = new Player();
			
			Cell tempCell = nextRow.getCell(1);
			
			String tempString;
			double tempDbl;
			
			tempString = tempCell.getStringCellValue();
			
			/* reset the value of player to be processed */
			PlayerScoreCalculator.resetValue();
			
			if(tempString.equalsIgnoreCase(teamName))
			{
				try
				{
					for (int cell = 0; cell < 14; cell++) {
						Cell nextCell = nextRow.getCell(cell);

						 /* Map the cell value to corresponding property in Player object */
						 
						switch (cell) {
						case 0:
							tempString = nextCell.getStringCellValue();
							player.setName(tempString);
							break;
						case 1:
							tempString = nextCell.getStringCellValue();
							player.setTeam(tempString);
							break;
						case 2:
							tempDbl = nextCell.getNumericCellValue();
							player.setFgs(tempDbl);
							PlayerScoreCalculator.updateScore(tempDbl, 1);
							if(tempDbl!=0)
							{
								totalFGPlayers++;
							}
							break;
						case 3:
							tempDbl = nextCell.getNumericCellValue();
							player.setFts(tempDbl);
							PlayerScoreCalculator.updateScore(tempDbl, 2);
							if(tempDbl!=0)
							{
								totalFTPlayers++;
							}
							break;
						case 4:
							tempDbl = nextCell.getNumericCellValue();
							player.setThrees(tempDbl);
							PlayerScoreCalculator.updateScore(tempDbl, 3);
							break;
						case 5:
							tempDbl = nextCell.getNumericCellValue();
							player.setPoints(tempDbl);
							PlayerScoreCalculator.updateScore(tempDbl, 4);
							break;
						case 6:
							tempDbl = nextCell.getNumericCellValue();
							player.setReb(tempDbl);
							PlayerScoreCalculator.updateScore(tempDbl, 5);
							break;
						case 7:
							tempDbl = nextCell.getNumericCellValue();
							player.setAst(tempDbl);
							PlayerScoreCalculator.updateScore(tempDbl, 6);
							break;
						case 8:
							tempDbl = nextCell.getNumericCellValue();
							player.setStl(tempDbl);
							PlayerScoreCalculator.updateScore(tempDbl, 7);
							break;
						case 9:
							tempDbl = nextCell.getNumericCellValue();
							player.setBlk(tempDbl);
							PlayerScoreCalculator.updateScore(tempDbl, 8);
							break;
						case 10:
							tempDbl = nextCell.getNumericCellValue();
							player.setTo(tempDbl);
							PlayerScoreCalculator.updateScore(tempDbl, 9);
							break;
						case 11:
							player.setValue(PlayerScoreCalculator.playerValue);
							break;
						case 13:
							tempDbl = nextCell.getNumericCellValue();
							player.setPlayerStatus(tempDbl);
						}
						
						
					}
					finalTeamValue = finalTeamValue + PlayerScoreCalculator.playerValue;
					PlayerScoreCalculator.resetValue();
				}
				 /* Check if there is an empty row in the worksheet, and skip it */
				catch (NullPointerException nex) {
						continue;
				}
				/* Add the player to the roster object */
				arrPlayers.add(player);
			}

		}

		/* Close the workbook, and reset the variables */
		//closeWorkBook();
		return arrPlayers;
	}
	
	/**
	 * Method to save the old values before roster sheet is updated
	 * 
	 * @param hmOldValues
	 */
	public void readOldValues(HashMap<String,Double> hmOldValues)
	{
		for(int row =1; row <17 ; row++)
		{
			try
			{
				Row nextRow = XLFunctions.firstSheet.getRow(row);
				/* get the name */
				Cell nameCell = nextRow.getCell(0);
				String strName = nameCell.getStringCellValue();
				/* get the value */
				Cell valueCell = nextRow.getCell(11);
				double value = valueCell.getNumericCellValue();
				
				hmOldValues.put(strName,value);
			}
			 /* Check if there is an empty row in the worksheet, and skip it */
			catch (NullPointerException nex) {
					continue;
			}
		}
	}
	

	/**
	 *  Method to update the team sheet with Master details
	 * @param teamName
	 * @param arrPlayers
	 */
	public void updateTeamSheet(String teamName, ArrayList<Player> arrPlayers)
	{
		//System.out.println("Stating to update Team Sheet for " + teamName);
		
		XLFunctions.changeSheetName(teamName);
		
		/* get old values before clearing them  */
		HashMap<String,Double> hmOldValues = new HashMap<String, Double>();
		readOldValues(hmOldValues);
		/* Clear the rows */
		//System.out.println("Stating to clear Sheet" + teamName);
		XLFunctions.clearContents(1, 16,0,15);
		
		XLFunctions.changeSheetName(teamName);
		/* Update the sheet with the roster */
		int noOfPlayers = arrPlayers.size();
		
		String tempString;
		double tempDbl;
		
		/* Sort the players based on their values before writing them */
		Collections.sort(arrPlayers);
		
		for(int i =0; i<noOfPlayers ; i++)
		{
			Player player = arrPlayers.get(i);
			/* Start from second row */
			Row nextRow = XLFunctions.firstSheet.createRow(i+1);
			for (int cell = 0; cell < 13; cell++) 
			{
				Cell nextCell = nextRow.createCell(cell);
				 /* Map the cell value to corresponding property in Player object */
				 
				switch (cell) {
				case 0:
					tempString = player.getName();
					nextCell.setCellValue(tempString);
					break;
				case 1:
					tempString = player.getTeam();
					nextCell.setCellValue(tempString);
					break;
				case 2:
					tempDbl = player.getFgs();
					nextCell.setCellValue(tempDbl);
					break;
				case 3:
					tempDbl = player.getFts();
					nextCell.setCellValue(tempDbl);
					break;
				case 4:
					tempDbl = player.getThrees();
					nextCell.setCellValue(tempDbl);
					break;
				case 5:
					tempDbl = player.getPoints();
					nextCell.setCellValue(tempDbl);
					break;
				case 6:
					tempDbl = player.getReb();
					nextCell.setCellValue(tempDbl);
					break;
				case 7:
					tempDbl = player.getAst();
					nextCell.setCellValue(tempDbl);
					break;
				case 8:
					tempDbl = player.getStl();
					nextCell.setCellValue(tempDbl);
					break;
				case 9:
					tempDbl = player.getBlk();
					nextCell.setCellValue(tempDbl);
					break;
				case 10:
					tempDbl = player.getTo();
					nextCell.setCellValue(tempDbl);
					break;
				case 11:
					nextCell.setCellValue(player.getValue());
					break;
				case 12:
					String tempName = nextRow.getCell(0).getStringCellValue();
					double newValue = nextRow.getCell(11).getNumericCellValue();
					if(hmOldValues.keySet().contains(tempName))
					{
						nextCell.setCellValue(newValue - hmOldValues.get(tempName));
					}
					else
					{
						nextCell.setCellValue(0);
					}
					
				
				}
			}
			
		}
		
		Row nextRow = XLFunctions.firstSheet.createRow(16);
		Cell fgCell = nextRow.createCell(2);
		Cell ftCell = nextRow.createCell(3);
		fgCell.setCellValue(getTotalFGPlayers());
		ftCell.setCellValue(getTotalFTPlayers());

		
		XLFunctions.write();
		System.out.println("Sheet updated - " + teamName);
		
	}
	
	
	/**
	 *  Method to update the team sheet with Weekly details
	 * @param teamName
	 * @param arrPlayers
	 */
	public void updateWeeklyTeamSheet(String teamName, ArrayList<Player> arrPlayers,
			HashMap<String,Double> hmSchedule)
	{
		//System.out.println("Stating to update Team Sheet for " + teamName);
		
		XLFunctions.changeSheetName(teamName);
		
		/* get old values before clearing them  */
		//HashMap<String,Double> hmOldValues = new HashMap<String, Double>();
		//readOldValues(hmOldValues);
		/* Clear the rows */
		//System.out.println("Stating to clear Sheet" + teamName);
		XLFunctions.clearContents(20,38,0,15);
		
		XLFunctions.changeSheetName(teamName);
		/* Update the sheet with the roster */
		int noOfPlayers = arrPlayers.size();
		
		String tempString;
		double tempDbl;
		double games;
		/* Sort the players based on their values before writing them */
		Collections.sort(arrPlayers);
		
		for(int i =0; i<noOfPlayers ; i++)
		{
			Player player = arrPlayers.get(i);
			//System.out.println("Processing player " + player.getName());
			/* Start from second row */
			Row nextRow = XLFunctions.firstSheet.createRow(i+21);
			
			if(nextRow == null)
			{
				System.out.println("Got null row object. Skipping player");
				continue;
			}
			
			if(hmSchedule.containsKey(player.getTeam()))
			{
				games = hmSchedule.get(player.getTeam());
			}
			else
			{
				games = 0;
			}
			for (int cell = 0; cell < 13; cell++) 
			{
				Cell nextCell = nextRow.createCell(cell);
				 /* Map the cell value to corresponding property in Player object */
				 
				switch (cell) {
				case 0:
					tempString = player.getName();
					nextCell.setCellValue(tempString);
					break;
				case 1:
					tempString = player.getTeam();
					nextCell.setCellValue(tempString);
					break;
				case 2:
					tempDbl = player.getFgs()* player.getPlayerStatus();
					nextCell.setCellValue(tempDbl);
					break;
				case 3:
					tempDbl = player.getFts()* player.getPlayerStatus();
					nextCell.setCellValue(tempDbl);
					break;
				case 4:
					tempDbl = player.getThrees()* player.getPlayerStatus();
					tempDbl = tempDbl * games;
					nextCell.setCellValue(tempDbl);
					break;
				case 5:
					tempDbl = player.getPoints()* player.getPlayerStatus();
					tempDbl = tempDbl * games;
					nextCell.setCellValue(tempDbl);
					break;
				case 6:
					tempDbl = player.getReb()* player.getPlayerStatus();
					tempDbl = tempDbl * games;
					nextCell.setCellValue(tempDbl);
					break;
				case 7:
					tempDbl = player.getAst()* player.getPlayerStatus();
					tempDbl = tempDbl * games;
					nextCell.setCellValue(tempDbl);
					break;
				case 8:
					tempDbl = player.getStl()* player.getPlayerStatus();
					tempDbl = tempDbl * games;
					nextCell.setCellValue(tempDbl);
					break;
				case 9:
					tempDbl = player.getBlk()* player.getPlayerStatus();
					tempDbl = tempDbl * games;
					nextCell.setCellValue(tempDbl);
					break;
				case 10:
					tempDbl = player.getTo()* player.getPlayerStatus();
					tempDbl = tempDbl * games;
					nextCell.setCellValue(tempDbl);
					break;
				case 12:
					nextCell.setCellValue(games);
					break;
				
				}
			}
			
		}
		
		XLFunctions.write();
		System.out.println("Weekly Sheet updated - " + teamName);
		
	}
	
	/** 
	 * This method will calculate the weekly match up result for the team
	 * @param teamName
	 * @param opponentTeam
	 * @param currentTeamWeeklyTotals
	 * @param opponentTeamWeeklyTotals
	 */
	public void writeWeeklyTotalsToRow(String teamName, String opponentTeam, 
			Player currentTeamWeeklyTotals, Player opponentTeamWeeklyTotals)
	{

		XLFunctions.changeSheetName(teamName);
		
		//XLFunctions.clearContents(40,41,0,15);
		
		XLFunctions.changeSheetName(teamName);
		
		double count = 0;
		
			Row nextRow = XLFunctions.firstSheet.createRow(40);
			
			for (int cell = 0; cell < 13; cell++) 
			{
				Cell nextCell = nextRow.createCell(cell);
				 /* Map the cell value to corresponding property in Player object */
				 
				switch (cell) {
				case 0:
					nextCell.setCellValue(opponentTeam);
					break;
				case 1:
					break;
				case 2:
					nextCell.setCellValue(opponentTeamWeeklyTotals.getFgs());
					if(currentTeamWeeklyTotals.getFgs() > opponentTeamWeeklyTotals.getFgs())
						count++;
					else if(currentTeamWeeklyTotals.getFgs() == opponentTeamWeeklyTotals.getFgs())
						count = count + 0.5;
					break;
				case 3:
					nextCell.setCellValue(opponentTeamWeeklyTotals.getFts());
					if(currentTeamWeeklyTotals.getFts() > opponentTeamWeeklyTotals.getFts())
						count++;
					else if(currentTeamWeeklyTotals.getFts() == opponentTeamWeeklyTotals.getFts())
						count = count + 0.5;
					break;
				case 4:
					nextCell.setCellValue(opponentTeamWeeklyTotals.getThrees());
					if(currentTeamWeeklyTotals.getThrees() > opponentTeamWeeklyTotals.getThrees())
						count++;
					else if(currentTeamWeeklyTotals.getThrees() == opponentTeamWeeklyTotals.getThrees())
						count = count + 0.5;
					break;
				case 5:
					nextCell.setCellValue(opponentTeamWeeklyTotals.getPoints());
					if(currentTeamWeeklyTotals.getPoints() > opponentTeamWeeklyTotals.getPoints())
						count++;
					else if(currentTeamWeeklyTotals.getPoints() == opponentTeamWeeklyTotals.getPoints())
						count = count + 0.5;
					break;
				case 6:
					nextCell.setCellValue(opponentTeamWeeklyTotals.getReb());
					if(currentTeamWeeklyTotals.getReb() > opponentTeamWeeklyTotals.getReb())
						count++;
					else if(currentTeamWeeklyTotals.getReb() == opponentTeamWeeklyTotals.getReb())
						count = count + 0.5;
					break;
				case 7:
					nextCell.setCellValue(opponentTeamWeeklyTotals.getAst());
					if(currentTeamWeeklyTotals.getAst() > opponentTeamWeeklyTotals.getAst())
						count++;
					else if(currentTeamWeeklyTotals.getAst() == opponentTeamWeeklyTotals.getAst())
						count = count + 0.5;
					break;
				case 8:
					nextCell.setCellValue(opponentTeamWeeklyTotals.getStl());
					if(currentTeamWeeklyTotals.getStl() > opponentTeamWeeklyTotals.getStl())
						count++;
					else if(currentTeamWeeklyTotals.getStl() == opponentTeamWeeklyTotals.getStl())
						count = count + 0.5;
					break;
				case 9:
					nextCell.setCellValue(opponentTeamWeeklyTotals.getBlk());
					if(currentTeamWeeklyTotals.getBlk() > opponentTeamWeeklyTotals.getBlk())
						count++;
					else if(currentTeamWeeklyTotals.getBlk() == opponentTeamWeeklyTotals.getBlk())
						count = count + 0.5;
					break;
				case 10:
					nextCell.setCellValue(opponentTeamWeeklyTotals.getTo());
					if(currentTeamWeeklyTotals.getTo() < opponentTeamWeeklyTotals.getTo())
						count++;
					else if(currentTeamWeeklyTotals.getTo() == opponentTeamWeeklyTotals.getTo())
						count = count + 0.5;
					break;
				case 12:
					nextCell.setCellValue(count);
					break;
				
				}
			}
		
		XLFunctions.write();
		UpdateWeeklyMatchups.hmLeagueWeeklyRosters.put(teamName, count + "-" + (9-count));
		//System.out.println(teamName + "-" + opponentTeam + " : " + count + "-" + (9-count));
		updateNotes(teamName);
	}
	
	/** This method will update the Notes sheet with the team result
	 * 
	 * @param teamName
	 */
	public void updateNotes(String teamName)
	{
		// Change the sheet name to Notes
		XLFunctions.changeSheetName("Notes");
		int row;
		// Start from row number 3
		for(row = 2; row < 32 ; row ++)
		{
			Row nextRow = XLFunctions.firstSheet.getRow(row);
	
			Cell nextCell = nextRow.getCell(3);
			// This will be true in case of E column is clear
			if(nextCell == null)
			{
				nextCell = nextRow.createCell(3);
			}
			
			String tempString = nextCell.getStringCellValue();
			if(tempString.equalsIgnoreCase(teamName))
			{
				break;
			}
				
		}
		
		Row targetRow = XLFunctions.firstSheet.getRow(row);
		Cell targetCell = targetRow.getCell(4);
		
		targetCell.setCellValue(UpdateWeeklyMatchups.hmLeagueWeeklyRosters.get(teamName));
		
		XLFunctions.write();
		
		//System.out.println(teamName + " result updated in Notes Sheet");
		
	}

	/**
	 * This method will update the weekly match up details of a team
	 * 
	 * @param weekNo
	 * @param teamName
	 */
	public void updateWeekMatch(int weekNo, String teamName)
	{
		Player currentTeamWeeklyTotals;
		Player opponentTeamWeeklyTotals;
		String opponentTeam;
	
		try 
		{
			XLFunctions.changeSheetName(teamName);
			getTotals();
			XLFunctions.changeSheetName(teamName);
			currentTeamWeeklyTotals = readTotals();
			
			opponentTeam = getOpponentForWeek(teamName,weekNo);
			if(opponentTeam == null)
			{
				XLFunctions.write();
				return;
			}
			
			XLFunctions.changeSheetName(opponentTeam);
			getTotals();
			XLFunctions.changeSheetName(opponentTeam);
			opponentTeamWeeklyTotals = readTotals();
			
			
			writeWeeklyTotalsToRow(teamName, opponentTeam, currentTeamWeeklyTotals, opponentTeamWeeklyTotals);
			
		} catch (NullRowException e) {
			e.getMessage();
			e.printStackTrace();
		} catch (NullCellException e) {
			e.getMessage();
		}
		
	}
	
	/**
	 * This method will read the weekly totals of a team
	 * @return
	 * @throws NullRowException
	 * @throws NullCellException
	 */
	public void getTotals() throws NullRowException, NullCellException
	{
		

		// Write the current team total in row409
		Row nextRow = XLFunctions.firstSheet.getRow(39);
		
		if(nextRow == null)
		{
			throw new NullRowException(XLFunctions.firstSheet.getSheetName(), 40);
		}
		for (int cell = 0; cell < 11; cell++) 
		{
			Cell nextCell = nextRow.getCell(cell);
			if(nextCell == null)
			{
				continue;
			}
			switch (cell) 
			{
			case 0:
				break;
			case 1:
				break;
			case 2:
				nextCell.setCellFormula("SUM(C21:C35)/C17");
				//weekTotals.setFgs(nextCell.getNumericCellValue());
				break;
			case 3:
				nextCell.setCellFormula("SUM(D21:D35)/D17");
				//weekTotals.setFts(nextCell.getNumericCellValue());
				break;
			case 4:
				nextCell.setCellFormula("SUM(E21:E35)");
				//weekTotals.setThrees(nextCell.getNumericCellValue());
				break;
			case 5:
				nextCell.setCellFormula("SUM(F21:F35)");
				//weekTotals.setPoints(nextCell.getNumericCellValue());
				break;
			case 6:
				nextCell.setCellFormula("SUM(G21:G35)");
				//weekTotals.setReb(nextCell.getNumericCellValue());
				break;
			case 7:
				nextCell.setCellFormula("SUM(H21:H35)");
				//weekTotals.setAst(nextCell.getNumericCellValue());
				break;
			case 8:
				nextCell.setCellFormula("SUM(I21:I35)");
				//weekTotals.setStl(nextCell.getNumericCellValue());
				break;
			case 9:
				nextCell.setCellFormula("SUM(J21:J35)");
				//weekTotals.setBlk(nextCell.getNumericCellValue());
				break;
			case 10:
				nextCell.setCellFormula("SUM(K21:K35)");
				//weekTotals.setTo(nextCell.getNumericCellValue());
				break;
			}
		}

		XLFunctions.write();
		
	}
	
	public Player readTotals() throws NullRowException, NullCellException
	{

		Player weekTotals = new Player();
		FormulaEvaluator evaluator = XLFunctions.workbook.getCreationHelper().createFormulaEvaluator();

		// Write the current team total in row409
		Row nextRow = XLFunctions.firstSheet.getRow(39);
		
		if(nextRow == null)
		{
			throw new NullRowException(XLFunctions.firstSheet.getSheetName(), 40);
		}
		for (int cell = 0; cell < 11; cell++) 
		{
			Cell nextCell = nextRow.getCell(cell);
			if(nextCell == null)
			{
				continue;
			}
			switch (cell) 
			{
			case 0:
				break;
			case 1:
				break;
			case 2:
				weekTotals.setFgs(evaluator.evaluate(nextCell).getNumberValue());
				break;
			case 3:
				//nextCell.setCellFormula("SUM(D21:D35)/D17");
				weekTotals.setFts(evaluator.evaluate(nextCell).getNumberValue());
				break;
			case 4:
				//nextCell.setCellFormula("SUM(E21:E35)");
				weekTotals.setThrees(evaluator.evaluate(nextCell).getNumberValue());
				break;
			case 5:
				//nextCell.setCellFormula("SUM(F21:F35)/C17");
				weekTotals.setPoints(evaluator.evaluate(nextCell).getNumberValue());
				break;
			case 6:
				//nextCell.setCellFormula("SUM(G21:G35)/C17");
				weekTotals.setReb(evaluator.evaluate(nextCell).getNumberValue());
				break;
			case 7:
				//nextCell.setCellFormula("SUM(H21:H35)/C17");
				weekTotals.setAst(evaluator.evaluate(nextCell).getNumberValue());
				break;
			case 8:
				//nextCell.setCellFormula("SUM(I21:I35)/C17");
				weekTotals.setStl(evaluator.evaluate(nextCell).getNumberValue());
				break;
			case 9:
				//nextCell.setCellFormula("SUM(J21:C35)/J17");
				weekTotals.setBlk(evaluator.evaluate(nextCell).getNumberValue());
				break;
			case 10:
				//nextCell.setCellFormula("SUM(K21:C35)/K17");
				weekTotals.setTo(evaluator.evaluate(nextCell).getNumberValue());
				break;
			}
		}

		//XLFunctions.write();
		return weekTotals;
		
	
	}
	
	/**
	 * This function will find out the opponent for the team name that is passed for the week number that
	 * is passed as an argument from the Schedule sheet
	 * @param teamName
	 * @param weekNo
	 * @return
	 */
	public String getOpponentForWeek(String teamName, int weekNo)
	{
		
		String opponent = null;
		XLFunctions.changeSheetName("Schedule");
		
		Row teamRow = XLFunctions.firstSheet.getRow(0);
		if(teamRow == null)
		{
			System.out.println("Got null row object for Team row in Schedule sheet");
			return opponent;
		}
		
		int colNo = 0;
		
		// identify the column number of the team
		for (int cell =0; cell < 31; cell ++)
		{
			Cell nextCell = teamRow.getCell(cell);
			if (nextCell != null)
			{
				if(nextCell.getStringCellValue().equalsIgnoreCase(teamName))
				{
					break;
				}
				else
				{
					colNo ++;
				}
			}
		}
			
			Row opponentRow =  XLFunctions.firstSheet.getRow(weekNo);
			Cell opponentCell = opponentRow.getCell(colNo);
			
			if(opponentCell !=null)
			{
				opponent = opponentCell.getStringCellValue();
			}
		
		System.out.println("Opponent for " + teamName + " is " + opponent);
		
		return opponent;
		
	}


	public double getFinalTeamValue() {
		return finalTeamValue;
	}



	public void setFinalTeamValue(double finalTeamValue) {
		this.finalTeamValue = finalTeamValue;
	}

	public double getTotalFGPlayers() {
		if(this.totalFGPlayers > 12)
		return 12;
		else
		return this.totalFGPlayers;
	}

	public void setTotalFGPlayers(double totalFGPlayers) {
		this.totalFGPlayers = totalFGPlayers;
	}

	public double getTotalFTPlayers() {
		if(this.totalFTPlayers > 12)
			return 12;
			else
			return this.totalFTPlayers;
	}

	public void setTotalFTPlayers(double totalFTPlayers) {
		this.totalFTPlayers = totalFTPlayers;
	}
	

}
