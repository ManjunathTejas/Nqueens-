import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.*;

public class Nqueens2 {
	static Scanner in = new Scanner(System.in);
	static int numDimension = in.nextInt();
	static boolean[][] queensBoard = new boolean[numDimension][numDimension];
	// static int tempX;
	static int tempX = in.nextInt()-1;
	static int tempY = in.nextInt()-1;
	static int n = 0;
	

	public static boolean isAttacking(int row, int col) {
		int p = row;
		int q = col;
		/**
		 * checks for horizontal
		 */
		for (int j = 0; j < queensBoard.length; j++) {
			if (queensBoard[j][col] == true) {
				return true;
			}
		}
		/**
		 * checks for vertical
		 */
		for (int w = 0; w < queensBoard.length; w++) {
			if (queensBoard[row][w] == true) {
				return true;
			}
		}
		/**
		 * Downward Diagonal Left
		 */
		while (p >= 0 && q >= 0) {
				if(queensBoard[p][q]==true){
					return true;
				}
			p--;
			q--;
		}
		p = row;
		q = col;
		/**
		 * Upward Diagonal Right
		 */
		while (p < queensBoard.length && q < queensBoard.length) {
				if(queensBoard[p][q]==true){
					return true;
				}
			p++;
			q++;
		}
		p = row;
		q = col;
		/**
		 * Downward Diagonal Right
		 */
		while (p < queensBoard.length && q >= 0) {
				if(queensBoard[p][q]==true){
					return true;
				}
			p++;
			q--;
		}
		p = row;
		q = col;
		/**
		 * Upward Diagonal Left
		 */
		while (p >= 0 && q < queensBoard.length) {
				if(queensBoard[p][q]==true){
					return true;
				}
			p--;
			q++;
		}

		return false;
	}

	public static boolean Nqueens(int n) {
		//printBoard();
		if (n >= queensBoard.length) {// base case- iterated through the entire array
			return true;
		} else {
			for(int j = 0; j< queensBoard.length; j++){//iterates through the column
				if(Nqueens2.presentQueen(n)== true){//checks if the current spot is okay by checking if the next spot tonight
					if(Nqueens(n+1)== true){
					return true;
					}
				}
				if (Nqueens2.isAttacking(j, n) == false) {// if the queen is not attacking any other queen
					queensBoard[j][n] = true;
					if(Nqueens(n+1)== true){
						return true;
					}else{
						queensBoard[j][n] = false;
					}
				}
				if(j == queensBoard.length -1){// Not a right spot since no queens can be placed anywhere on the column
					return false;
				}
			}
			//printBoard();
			//tempY = 0;
			Nqueens(n +1);
		}
		return false;
	}
	
	public static void main(String []args){
		setBoard();
		queensBoard[tempY][tempX]= true;
		if(Nqueens(0)== false){
			System.out.println("No Solution");
		}else{
			solutions();
		}
		
		try {
			BufferedWriter w = new BufferedWriter(new FileWriter("solution.txt"));
			for(int i = 0; i < queensBoard.length; i++){
				for(int j = 0; j < queensBoard.length; j++){
					if(queensBoard[i][j]==true){
						w.write((i + 1) + " "+ (j + 1));
						w.newLine();
					}
				}
			}
			if(Nqueens(0)==false){
				w.write("No Solution");
			}
			w.close();
		} catch (IOException e) {

			e.printStackTrace();

		}
	}
	
	public static void setBoard() {
		for (int i = 0; i < queensBoard.length; i++) {
			for (int j = 0; j < queensBoard.length; j++) {
				queensBoard[i][j] = false;
			}
		}
	}
	
	public static void printBoard() {
		//System.out.println("reached print");
		for (int i = queensBoard.length - 1; i >= 0; i--) {
			System.out.println();
			for (int j = 0; j < queensBoard.length; j++) {
				System.out.print(queensBoard[i][j] + " ");
			}
		}
	}

	public static boolean presentQueen( int col ){
		for(int i = 0; i < queensBoard.length; i++){
			if(queensBoard[i][col]==true){
				return true;
			}
		}
	return false;
	}
	
	public static void solutions(){
		for(int i = 0; i < queensBoard.length; i++){
			for(int j = 0; j < queensBoard.length; j++){
				if(queensBoard[i][j]==true){
					System.out.println((i + 1) + " "+ (j + 1));
				}
			}
		}
	}
}
