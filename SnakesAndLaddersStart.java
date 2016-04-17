import java.io.IOException;
import java.util.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class SnakesAndLaddersStart 
{
	public static Logger logger = Logger.getLogger(SnakesAndLaddersStart.class);
	public static void  main(String[] args) throws IOException 
	{		
		PropertyConfigurator.configure("log4j.properties");
		SnakesAndLaddersBoard gameBoard = new SnakesAndLaddersBoard(); // Create an object gameBoard of SnakesAndLaddersBoard.
		gameBoard.board();												// Call board method of SnakesAndLaddersBoard class.
		
		SnakesAndLaddersHeadTails snakesHeadTails = new SnakesAndLaddersHeadTails();  // Create an object for SnakesAndLaddersHeadTails class.	
		int[] snakeDetails = snakesHeadTails.randomSnakesLaddersArray(5,"Snake");
		int[] ladderDetails = snakesHeadTails.randomSnakesLaddersArray(6,"Ladder");
		String playGame;
		Scanner choice = new Scanner(System.in);
		logger.info("\n\t"
				+ "Do you want to play Game Y or N. : ");
		playGame = choice.nextLine();	
		SnakesAndLadders myMethod = new SnakesAndLadders();  // Create an object myMethod of SnakesLadersMethod class.

		if(playGame.toUpperCase().equals ("Y"))
		{
			playGame = myMethod.mainMethod(playGame,snakeDetails,ladderDetails);			// Call mainMethod method of SnakesAndLadders class
		}
		else
		{
			logger.info("\n\t\tThank you for Play Game.");
		}
	}
}