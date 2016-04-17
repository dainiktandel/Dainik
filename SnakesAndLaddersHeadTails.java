import org.apache.log4j.Logger;
public class SnakesAndLaddersHeadTails 
{
	public static Logger logger = Logger.getLogger(SnakesAndLaddersStart.class);
	public static int[] randomSnakesLaddersArray(int j, String value) 
	{
		int[] snakeladderHead = new int[j];
		int snakeladderLength = j, snakeladderTail = 0, i; 							//length of snake head.
		for(i = 0; i < snakeladderLength; i++)   									//Find Snake and Ladder head and tail.
		{	
			switch (value) 
			{
			case "Snake" : 
				snakeladderHead[i] = ((int)(Math.random() * (99-30)) + 1)+30;	// Generate Random number from 30 to 99 and store in snakeHead array variable.
				snakeladderTail = snakeladderHead[i] - ((i*2)+19); 			// calculate Snake tail point.
				System.out.println("Snakes Head : " + snakeladderHead[i]+ ", Snakes Tail : " + snakeladderTail );
				break;
			case "Ladder":
				snakeladderHead[i] = ((int)(Math.random() * (65-1)) + 1)+1;		// Generate Random number from 1 to 65 and store in snakeHead array variable.
				snakeladderTail = snakeladderHead[i] + ((i*2)+22);			// calculate Ladder tail point.
				System.out.println("Ladder Head : " + snakeladderHead[i] + ", Ladder Tail : " + snakeladderTail);
				break;
			}			
		}
		return snakeladderHead;
	}		
	public static int userPossitioncheck(int userPossition,int userRoll,int[] snakeDetails,int[] ladderDetails)
	{	 
		for(int i=0; i <snakeDetails.length;i++)
		{			
			if(userPossition == snakeDetails[i])												// Check User Position with snake Head.
			{
				logger.info("\n\tUser possition : " + userPossition + "\n");
				userPossition = userPossition - ((i*2)+19);										// if user position matched then snake tail minus from current position.
				logger.info("\n\t You got bit by Snake, Go down.\n");      						// Print message bit by snake.
			}
		}
		for(int i=0; i <ladderDetails.length;i++)
		{
			if(userPossition == ladderDetails[i])												// Check User Position with snakeHead.
			{
				logger.info("\n\tUser possition : " + userPossition + "\n");
				userPossition = userPossition + ((i*2)+22);
				logger.info("\n\t You Got A Ladder!! GO UP!!\n");      							// Print message bit by snake.
			}
		}
		if(userPossition < 0 || userPossition > 106) 											//Check user Position is < 0 or  > 106
		{
			logger.warn("\n\t Some error occurs. Please Reset your Game.\n");
		}
		else if(userPossition > 100) 															//Check user Position  > 100.
		{
			userPossition = userPossition - userRoll;											// Minus current user roll value from current user position
			logger.warn("\n\t Your possition goes more then 100. Dice throw again.\n");
		}
		else if(userPossition == 100)															// check if user position is 100 that is wining point
		{
			logger.info("\n\t Congratulation You won Game.\n");
		}
		return userPossition;
	}
}