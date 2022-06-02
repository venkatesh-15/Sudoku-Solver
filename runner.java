package ll;
import java.util.*;

import java.lang.*;

import java.io.*;

public class runner {
	public static boolean checkRow(int board[][],int row, int number) {
		for(int i=0;i<9;i++) {
			if(board[row][i]==number) {
				return false;
			}
		}
		return true;
	}
	public static boolean checkCol(int board[][],int col, int number) {
		for(int i=0;i<9;i++) {
			if(board[i][col]==number) {
				return false;
			}
		}
		return true;
	}
	public static boolean checkBox(int board[][],int row, int col, int number) {
		int rowCord=row-row%3;
		int colCord=col-col%3;
		for(int i=rowCord;i<rowCord+3;i++) {
			for(int j=colCord;j<colCord+3;j++) {
				if(board[i][j]==number) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean valid(int board[][],int row,int col,int number) {
		if(checkRow(board,row, number) && checkCol(board, col, number) && checkBox(board, row, col,number)) {
			return true;
		}
		return false;
	}
	public static boolean solver(int board[][]) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[i][j]==0) {
					for(int k=1;k<=9;k++) {
						if(valid(board,i,j,k)) {
							board[i][j]=k;
							if(solver(board)) {
								return true;
							}
							else {
								board[i][j]=0;
							}
						}
						
					}
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int board[][]= {{5,3,0,0,7,0,0,0,0},
				        {6,0,0,1,9,5,0,0,0},
				        {0,9,8,0,0,0,0,6,0},
				        {8,0,0,0,6,0,0,0,3},
				        {4,0,0,8,0,3,0,0,1},
				        {7,0,0,0,2,0,0,0,6},
				        {0,6,0,0,0,0,2,8,0},
				        {0,0,0,4,1,9,0,0,5},
				        {0,0,0,0,8,0,0,7,9}};
		solver(board);
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
}}
