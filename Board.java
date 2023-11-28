/*
 * class for a Board object
 *
 * --Aimee Hong--
 */

public class Board
{
	public static final int SIZE = 3;

	private char [][] board = new char[SIZE][SIZE];

	/*
	 * initializes board by placing a dot in each cell
	 */

	public Board()
	{
		for (int row = 0; row < SIZE; row++)
		{
			for (int column = 0; column < SIZE; column++)
			{
				board[row][column] = '.';
			}
		}
	}

	/*
	 * places player's symbol on specified row and column
	 */

	public void makeMove(char p, int r, int c)
	{
		board[r - 1][c - 1] = p;
	}

	/*
	 * returns true if row and column are within board 
	 */

	public boolean isValidMove(int r, int c)
	{
		if (r >= 1 && r <= 3)
		{
			if (c >= 1 && c <= 3)
			{
				return true;
			}
		}
		return false;
	}

	/*
	 * returns true if space is unfilled
	 */

	public boolean isEmpty(int r, int c)
	{
		if (board[r - 1][c - 1] == '.')
		{
			return true;
		}
		return false; 
	}

	/*
	 * returns true if any row, column, or diagonal is filled with
	 * one player's symbol
	 */

	public boolean gameWon()
	{
		for (int row = 0; row < SIZE; row++)
		{
			for (int column = 0; column < SIZE; column++)
			{
				// Find all column wins
				if (board[0][column] == board[1][column] && board[0][column]== board[2][column] && board[0][column] != '.')
				{
					return true;
				}
				// Find all row wins
				else if (board[row][0] == board[row][1] && board[row][0] == board[row][2] && board[row][0] != '.')
				{
					return true;
				}
				// Finds down diagonal win
				else if (board[0][0] == board[1][1] && board[2][2] == board[0][0] && board[0][0] != '.')
				{
					return true;
				}
				// Finds up diagonal win
				else if (board[2][0] == board[1][1] && board[0][2] == board[2][0] && board[2][0] != '.')
				{
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * returns string representation of board
	 *
	 * | X O X |
	 * | . O . |
	 * | . . . |
	 */

	public String toString()
	{
		String s = "| ";
		for (int row = 0; row < SIZE; row++)
		{
			for (int column = 0; column < SIZE; column++)
			{
				s += (board[row][column] + " ");
				if (column == SIZE - 1 && row != SIZE - 1)
				{
					s += "|\n| ";
				}
				else if (column == SIZE - 1 && row == SIZE - 1)
				{
					s += "|";
				}
			}
		}
		s += "\n";
		return s;
	}
}
