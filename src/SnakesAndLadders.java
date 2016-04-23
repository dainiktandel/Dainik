import java.util.*;
import org.apache.log4j.Logger;
public class SnakesAndLadders 
{
	public static Logger logger = Logger.getLogger(SnakesAndLaddersStart.class);
	public static String mainMethod(String playGame,int[] snakeDetails,int[] ladderDetails)
	{
		boolean flagStartGame = false;			
		int userPossition = 0;														//Variable for user Position store user current position on the board. 
		int diceThrow = 0;															//Variable for Dice 
		int userRoll = 1;															//Variable for the User roll .
		String playAgain = "Y";
		Scanner choice = new Scanner(System.in);		
		
		DiceThrow diceValue = new DiceThrow();										//Create an object for DiceThrow class.
		SnakesAndLaddersHeadTails snakesHeadTails = new SnakesAndLaddersHeadTails();  // Create an object for SnakesAndLaddersHeadTails class.
		while(flagStartGame==false)
		{
			userRoll = diceValue.getDiceThrowValue(diceThrow);	
			logger.info("\n\tUser Rolled : " + userRoll + "\n");
			if(userRoll != 6)
			{
				logger.info("\n\tTry again until you get 6 : ");
				playAgain = choice.nextLine();
			}
			else 
			{
				flagStartGame = true;
				logger.info("\n\tNow you are Eligble to play Game.\n");
				logger.info("\n\tDo you want to play again Y or N : "); 			// Ask for play again game ? 
				playAgain = choice.nextLine();
			}
		}
		while(playAgain.toUpperCase().equals ("Y"))
		{
			userRoll = diceValue.getDiceThrowValue(diceThrow); 						// Call getDiceThrowValue method of DiceThrow			
			logger.info("\n\tUser Rolled    : " + userRoll + "\n"); 				// Print User Dice throw value
			userPossition = userPossition + userRoll;								// get new User position
			userPossition = snakesHeadTails.userPossitioncheck(userPossition,userRoll,snakeDetails,ladderDetails);
			logger.info("\n\tUser possition : " + userPossition + "\n");			//Print User Current Position.
			if(userPossition == 100)												//Check User current position is 100.  
			{
				userPossition = 1 ;													//if user position is 100 then it set user position to 1.
				logger.info("\n\tDo you want to play again Y or N : "); 			// Ask for play again game ? 
				playAgain = choice.nextLine();					
				logger.info("\n\n");			
			}
			else																	// if true is not match then false part execute.
			{
				logger.info("\n\tDo you want to play again Y or N : ");
				playAgain = choice.nextLine();	
			}
		}
		return playAgain;
	}
}