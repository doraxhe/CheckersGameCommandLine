package com;
public abstract class Player {
	private String color;

	public Player(String color) {
		this.color = color;
	}	
	
	public abstract Move makeMove(Board board);

//	public String getColor() {return color;}
//	public void setColor(String color) {this.color = color;}
}