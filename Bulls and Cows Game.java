/*
 * Bulls and Cows
 *
 * Aimee Hong
 *
 * implements a deductive logic game for guessing a sequence of n unique digits
 */

import java.util.Scanner;
import java.lang.*;

public class BullsAndCows
{
	public static final int DIGITS = 4;
	public static final int TURNS = 10;

	/*
	 * explains how the game works
	 */

	public static void printRules()
	{
		System.out.println("\nGuess the " + DIGITS + " digit number; " +
			"all digits are unique.");
		System.out.println("A cow means right digit, wrong position.");
		System.out.println("A bull means right digit, right position.");
		System.out.println("You have " + TURNS + " turns.");
		System.out.println("Enter 'q' to quit at any time.");
		System.out.println("Good luck!");
	}

	/*
	 * returns true if the character is contained in the string
	 */

	public static boolean contains(String s, char c)
	{
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == c)
			{
				return true;
			}
		}
		return false;
	}

	/*
	 * returns a string of unique randomly-chosen digits
	 */

	public static String pickNumber()
	{
		String code = "";
		while (code.length() != DIGITS)
		{
			int random = (int) (Math.random() * 10);
			char c = (char) (random + '0');

			if (contains(code, c) == false)
			{
				code = code + c;
			}
		}
		return code;
	}

	/*
	 *  compares the user's guess to the random sequence and returns the
	 *  number of bulls and cows
	 */

	public static int [] tallyResults (String number, String guess)
	{

		int tallies [] = new int[2];
		tallies[0] = 0;
		tallies[1] = 0;
		for (int j = 0; j < DIGITS; j++)
		{
			if (number.charAt(j) == guess.charAt(j))
			{
				tallies[0]++;
			}

			for (int k = 0; k < DIGITS; k++)
			{	
				if (number.charAt(k) != guess.charAt(k))
				{
					if (number.charAt(j) == guess.charAt(k))
					{
						tallies[1]++;
					}

				}
			}
		}
		return tallies;
	}

	/*
	 * returns true if the string contains a duplicate character
	 */

	public static boolean hasDuplicates (String s)
	{
		for (int i = 0; i < DIGITS; i++)
		{
			for (int j = i + 1; j < DIGITS; j++)
			{
				if (s.charAt(i) == s.charAt(j))
				{
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * returns true if the string contains a non-digit
	 */

	public static boolean hasNonDigits (String s)
	{
		for (int i = 0; i < DIGITS; i++)
		{
			char c = s.charAt(i);
			if (Character.isDigit(c) == false)
			{
				return true;	
			}
		}
		return false;
	}

	/*
	 * gets the user's guess and displays the bulls and cows until game over
	 */

	public static void playGame()
	{
		int turns = 1;
		String code = pickNumber();
		Scanner input = new Scanner(System.in);

		outerLoop:
		while (turns <= TURNS)
		{
			System.out.println("Turn " + turns);
			System.out.print("Enter a guess: ");
			String guess = input.nextLine();

			if (guess.charAt(0) == 'q')
			{
				break outerLoop;
			}

			// Reprompts user for valid guess if wrong length, contains duplicates or has nondigits
			while (guess.length() != DIGITS || hasDuplicates(guess) == true || hasNonDigits(guess) == true)
			{
				System.out.println("Must contain " + DIGITS + " unique digits");
				System.out.print("Enter a guess: ");
				guess = input.nextLine();
				if (guess.charAt(0) == 'q')
				{
					break outerLoop;
				}
			}
			int tallies [] = tallyResults(code, guess);


			// Use ternary operator for singular cases to print out the number of cows and bulls
			System.out.print(tallies[0]);
			System.out.print(tallies[0] == 1 ? " bull " : " bulls ");

			System.out.print(tallies[1]);
			System.out.println(tallies[1] == 1 ? " cow" : " cows");
			turns++;
			
			if (tallies[0] == DIGITS)
			{
				System.out.println("You got it!");
				System.exit(0);
			}
		}
		System.out.println("The number was " + code);
	}

	public static void main (String [] args)
	{
		printRules();
		playGame();
	}
}
