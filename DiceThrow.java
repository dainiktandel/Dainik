public class DiceThrow 
{
	public static int getDiceThrowValue(int diceThrow)
	{
		diceThrow = (int)(Math.random() * 6) + 1;			// Generate Random number from 1 to 6 and store in diceThrow array variable.
		return diceThrow;
	}
}