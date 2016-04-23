import org.apache.log4j.Logger;
public class SnakesAndLaddersBoard 
{
	public static Logger logger = Logger.getLogger(SnakesAndLaddersStart.class);	
	public static void board()
	{
		int counter = 100, moves = -1;
		logger.debug("\n\n\t\t\tWelcome Snakes and Ladders");
		System.out.println("\n\t\tPlayer can start only he/she throw Dice and get 6.");
		System.out.println("\t\t\tAt 100 Player Won the Game\n");
		System.out.println("**************************************************************************\n");
		while(counter > 0)		//check counter value until 0.
		{
			if(counter%10 == 0 && counter != 100)
			{
				if(moves == -1)
				{
					counter = counter - 9;
					moves = 1; 
				}
				else
				{
					System.out.print(counter + "\t");
					counter = counter - 10;
					moves = -1;
				}
				if(counter != 0)
				{
					System.out.print("\n\n" + counter + "\t");
				}
			}
			else
			{
				System.out.print(counter + "\t");
			}
			counter = counter + moves;
		}
		System.out.println("\n\n**************************************************************************\n");
	}
}