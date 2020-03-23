package com;
public class Piece {
	private String color ;// a piece is either red or black 
	private String rank ; // rank is either pawn or king
	
	public Piece(String color) {
		  this.color = color;
		  this.rank = "pawn";
	}
	
	public String getColor() {
		String result = "";
		switch(this.color) {
		case "red": result = "r"; break;
		case "black": result = "b"; break;
		case "RED": result = "R"; break;
		case "BLACK": result = "B"; break;
		}
		return result;
	}
	
	// turn pawns into kings
	public void kingPiece() {
		if (this.color.equals("red")) {
			this.color = "RED";
			this.rank = "king";
		}
		else if (this.color.equals("black")) {
			this.color = "BLACK";
			this.rank = "king";
		}
	}
		
	@Override
	public String toString() {
		return getColor();
	}
	
	public static void main(String[] args) {
		Piece r1 = new Piece("red");
		System.out.println(r1.getColor());
		
		Piece b1 = new Piece("black");
		System.out.println(b1.getColor());
		
		r1.kingPiece();
		System.out.println(r1.getColor());
		b1.kingPiece();
		System.out.println(b1.getColor());
	}
}