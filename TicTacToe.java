/*
 * TicTacToe.java
 *
 * --Aimee Hong--
 *
 * uses Board object to play TicTacToe
 */

import java.util.Scanner;

public class TicTacToe
{
	public static void printRules()
	{
		System.out.println("\nPlay alternates between X and O.");
		System.out.println("X goes first.");
		System.out.println("Rows and columns go from 1 to 3.\n");
	}

	public static void main (String [] args)
	{
		printRules();
		Board b = new Board();
		System.out.println(b.toString());
		Scanner input = new Scanner(System.in);

		int turn_counter = 1;
		while (turn_counter < 10)
		{
			char symbol = 'X';
			int row = 0;
			int column = 0;
			if (turn_counter % 2 == 1)
			{
				System.out.println("Player X's turn");
				symbol = 'X';
				System.out.print("Row: ");
				row = input.nextInt();
				System.out.print("column: ");
				column = input.nextInt();
			}
			if (turn_counter % 2 == 0)
			{
				System.out.println("Player O's turn");
				symbol = 'O';
				System.out.print("Row: ");
				row = input.nextInt();
				System.out.print("column: ");
				column = input.nextInt();
			}
			if (b.isValidMove(row, column) == true && b.isEmpty(row, column) == true)
			{
				b.makeMove(symbol, row, column);
				System.out.println(b);
				turn_counter++;
				if (b.gameWon() == false)
				{
					continue;
				}
				else
				{
					System.out.println("Player " + symbol + " won");
					System.exit(0);
				}
			}
			else
			{
				System.out.println("Invalid move");
				continue;
			}
		}
		System.out.println("Tie game");
	}
}
