/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver;
import java.io.IOException; 
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author KyleTran
 */
public class SudokuSolver {

	public static void main(String[] args) throws FileNotFoundException {
           /* Sudoku s = new Sudoku();
            {
            Scanner in = new Scanner (new FileReader ("p096_sudoku.txt"));
		while (in.hasNextLine()){
                    int s = in.nextInt ();
                    //Sudoku s = new Sudoku();
        }}*/
                
                int[][] a = {{0,0,3,0,2,0,6,0,0},
                             {9,0,0,3,0,5,0,0,1},
                             {0,0,1,8,0,6,4,0,0},
                             {0,0,8,1,0,2,9,0,0},
                             {7,0,0,0,0,0,0,0,8},
                             {0,0,6,7,0,8,2,0,0},
                             {0,0,2,6,0,9,5,0,0},
                             {8,0,0,2,0,3,0,0,9},
                             {0,0,5,0,1,0,3,0,0},
                };
                Sudoku s = new Sudoku(a); // you can also pass incomplete sudoku as a parameter
		s.displaySudoku();
		
		if(s.solveSudoku())
		{
			s.displaySudoku();
		}
		else
		{
			System.out.println("Unsuccessful");
		}

	}}




class Sudoku
{
	private int[][] sudoku;
	private static final int UNASSIGNED = 0;
	
	public Sudoku()
	{
		sudoku = new int[9][9];
	}
	
	public Sudoku(int sudoku[][])
	{
                
		this.sudoku= sudoku;

	}
	
	public boolean solveSudoku()
	{
		for(int row=0;row<9;row++)
		{
			for(int col=0;col<9;col++)
			{
				if(sudoku[row][col]==UNASSIGNED)
				{
					for(int number=1;number<=9;number++)
					{
						if(isAllowed(row, col, number))
						{
							sudoku[row][col] = number;
							if(solveSudoku())
							{
								return true;
							}
							else
							{
								sudoku[row][col] = UNASSIGNED;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean containsInRow(int row,int number)
	{
		for(int i=0;i<9;i++)
		{
			if(sudoku[row][i]==number)
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean containsInCol(int col,int number)
	{
		for(int i=0;i<9;i++)
		{
			if(sudoku[i][col]==number)
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean containsInBox(int row, int col,int number)
	{
		int r = row - row%3;
		int c = col - col%3;
		for(int i=r;i<r+3;i++)
		{
			for(int j=c;j<c+3;j++)
			{
				if(sudoku[i][j]==number)
				{
					return true;
				}
			}
			
		}
		return false;
	}
	
	private boolean isAllowed(int row, int col,int number)
	{
		return !(containsInRow(row, number) || containsInCol(col, number) || containsInBox(row, col, number));
	}
	
	public void displaySudoku()
	{
		for(int i=0;i<9;i++)
		{
			if(i%3==0 && i!=0)
			{
				System.out.println("----------------------------------\n");
			}
			for(int j=0;j<9;j++)
			{
				if(j%3==0 && j!=0)
				{
					System.out.print(" | ");
				}
				System.out.print(" " + sudoku[i][j] + " ");
				
			}
			
			System.out.println();
		}
		System.out.println("\n\n__________________________________________\n\n");
	}
	
}
