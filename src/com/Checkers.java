package com;
import java.util.*;

public class Checkers {
	private Board gameBoard = new Board();
	private Player playerOne;
	private Player playerTwo;

	public static void main(String[] args) {
		Checkers checkersGame = new Checkers();
	    checkersGame.setupByUser();
	    
	    Human playerOne = new Human("red");
	    Human playerTwo = new Human("black");

//	    while(checkersGame.isInProgress()) {   	
//	    	checkersGame.currentPlayerTakeTurn();
//	    	checkersGame.displayBoard();
//	    }
//	    
//	    checkersGame.displayEndOfGameMessage();
	}
	
	
	public Checkers() {
		this.gameBoard = gameBoard;
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}	
	
	public void setupByUser() {
		// display message to user
		Scanner input = new Scanner(System.in);
		System.out.println("Choose human or computer opponent:");
		System.out.println("Type 'h' to choose human or 'c' to choose computer");
		String chooseOpponent = input.next();
		
		// allow user to choose human or computer opponent
		switch (chooseOpponent) {
		case "h":
			// play with human opponent
			System.out.println("You are now playing with human opponent!");
			break;
		case "c":
			// play with computer opponent
			System.out.println("You are now playing with computer opponent!");
			break;
		}
		
		System.out.println();
		this.displayBoard();
	}
	
	
	public void displayBoard() {
		System.out.println(this.gameBoard);
	}
	

//	public boolean isInProgress() { // Returns true if there is no winner
//		return false;
//		//  No winner: 1). at least one side still has at least one piece remaining
//		//  No winner: 2). one or more checkers remaining can make legal moves
//		if (gameBoard.isMoveLegal())
//			return true;
//	}
//
//	public void currentPlayerTakeTurn() {
//		// The current player should make their move
//		// Make the next player the current player
//
//
//		if (gameBoard.isMoveLegal()) {
//			playerOne.makeMove(Board board);
//			playerOne.movePiece(Move move);
//			
//		}
//	}


//public void displayEndOfGameMessage() {
//		// Congratulate the player that won
//	}
}