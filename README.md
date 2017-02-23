# predictor-tool
Tool to predict weekly matchup results and final season standings in my 30 team NBA dynasty league

# Motivation
Playing Fantasy sports is one of my personal life passion. I am inovled in multiple leagues, one of which mimics the real life NBA setup
of 30 teams.
Teams makes trades among each other, but there was no yardstick available to measure the winner of looser of that trade, specifc to the
league settings. I thought to myself, what if there is a tool which can quantify these actions in terms of numbers.
If i have such a utility with me, i can evaluate player values and make trades that are to my advantage, or if a trade is offered to me,
quantify it in terms of whether i will be a winner or a looser in that transaction. 
While i was working on it, i saw the potentinal of using that framework to do other things like predicting a weekly matchup, 
and eventually used the weekly results and extrapolate them to season wise results.

# What does it do?
1) It evaluates the the trade between 2 parties to give a perspective in terms of numbers to tell who won and lost a trade
2) It predicts the winner of a particular matchup based upon the player stats and number of games in the week
3) It predicts the final season ending stats based on the current roster setup and the schedule in terms of opponents for entire season

# How to run it?
#Locally
1) Download the project
2) Set it up as a Java project in eclipse ( JDK 1.5 or above )
3) Use the Lowry.xls file inside test folder and copy it anywhere on your system
4) Use the downloaded location path and update the value of excelFilePath and excelOutFilePath variable inside XLFunctions.java
5) Run UpdateSheets - This will update all 30 teams rosters based on the master sheet in the excel file
6) Run UpdateWeeklyRosters - This will load the weekly schdule of teams from Games sheet and generate a section of weekly stats
7) Run UpdateWeeklyMatchups - This will predict weekly results for each team based on thier opponent for that week into the Notes sheet

#Distributed environment (Dockers)
coming soon.....

# Future Enhacements
1) Convert this project into a standalone utility with a desktop UI
2) Configurations to be done through the UI
3) Update the excel sheet automatically through code instead of updating the sheets manually by integrating with the league website
4) Exposing it as a web service to allow easy access to results
