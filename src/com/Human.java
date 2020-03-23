package com;
import java.util.*;

public class Human extends Player {	
	public Human(String color) {
		super(color);
	}

	public Move makeMove(Board board) {
		//example of Move object. Need to use get and set methods
		Move m1 = new Move(2,1,3,0);
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your move");
		String moveNumber = input.next();
		//Finish logic for this function
		board.movePiece(m1);
		return m1;
	}
     
	public String getColor() {return color;}	
	public void setColor(String color) {this.color = color;}		
	}
	// Prompt the human player to enter in the move they want to make


