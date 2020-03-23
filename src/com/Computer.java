package com;
<<<<<<< HEAD
public class Computer extends Player {
	public Computer() {
	}
	
	public void Move makeMove(Board board);
	// Use a custom AI logic to make a move
=======

import java.util.*;


public class Computer extends Player {
	private String color;
	
	public Computer() {
	}

	public Computer(String color) {
		super(color);
	}
	
	public void Move makeMove(Board board) {
		// Use a custom AI logic to make a move
	}	
}
>>>>>>> 0d7993dbd1bd5fbd241d4ca608e1a0b625a065c4
//If using the optional Computer class we could use 
//Player two = new Computer();
//
//We would use utilize the Random function if use the optional Computer class. 
//could Google game strategies to help us if we are using the 
//optional Computer class.