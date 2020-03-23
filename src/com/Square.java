package com;
public class Square {
	private Piece piece;
		
	public Square(Piece piece) {
		this.piece = piece;
	}
	
	// no piece is present in this square
	public Square() {
		this(null);
	}
	
	public Piece getPiece() {
		return this.piece;
	}
	
	@Override
	public String toString() {
		if (this.getPiece() == null) {
			return "_";
		}
		else return this.getPiece().getColor();
	}
	
	public static void main(String[] args) {
		Piece r1 = new Piece("red");
		Square s1 = new Square(r1);
		System.out.println(s1);
		
//		Piece r2 = new Piece("red");
//		r2.kingPiece();
//		Square s2 = new Square(r2);
//		System.out.println(s2);
//		
		Piece b1 = new Piece("black");
		Square s3 = new Square(b1);
		System.out.println(s3);
//		
//		Piece b2 = new Piece("black");
//		b2.kingPiece();
//		Square s4 = new Square(b2);
//		System.out.println(s4);
	}
}