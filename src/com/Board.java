package com;
public class Board {
	private Square[][] squares = new Square[8][8];
//	private String whoseMove;
	
	Piece p1 = new Piece("red");
	Piece p2 = new Piece("black");
	
	Square s1 = new Square(p1);
	Square s2 = new Square(p2);
	Square s3 = new Square(); // no piece is present in this square
	
	public Board() {
		// columns labeled with letters
		// rows labeled with numbers
		
		// initialize the board with red and black pawns
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				// only the squares in the ((row+column)%2==1) positions are playable
				if ((i + j) % 2 == 1) {
					// populate the top half of the board with red pawns
					if (i < 3) {
						squares[i][j] = s1;
					}
					// populate the bottom half of the board with black pawns
					else if (i > 4) {
						squares[i][j] = s2;
					}
					// populate the middle of the board
					else squares[i][j] = s3;
				}
				// populate other squares in the ((row+column)%2==0) positions
				else squares[i][j] = s3;
			}
		}
	}
	
	
	@Override
	// should represent the board as a string in the console
	public String toString(){
		String columnLetter = "  A B C D E F G H\n";		
		String rowContent = "";
		
		for (int i = 0; i < 8; i++) {
			rowContent += (i + 1) + "|";
		    
		    for (int j = 0; j < 8; j++) {
		    	rowContent += this.squares[i][j] + "|";
		    }
		    rowContent += "\n";
		}
		return columnLetter + rowContent;
	}
	
	
	public boolean isMoveInBounds(Move move) {
		// all pieces should move within the range of (row 0-8 && column 0-8)
		if (0 <= move.getEndingXCoor() && move.getEndingXCoor() < 8 &&
				0 <= move.getEndingYCoor() && move.getEndingYCoor() < 8) {
			return true;
		}
		else return false;
	}
	
	
	public boolean isOtherPieceAhead(Move move) {
		boolean result = false;
		
		// another piece IS in the targeted diagonal direction
		if (squares[move.getEndingXCoor()][move.getEndingYCoor()] == s1 ||
				squares[move.getEndingXCoor()][move.getEndingYCoor()] == s2) {
			result = true;
		}
		// another piece ISN'T in the targeted diagonal direction
		else if (squares[move.getEndingXCoor()][move.getEndingYCoor()] == s3) {
			result = false;
		}
		return result;
	}	
	
	
	public boolean isMoveLegal(Move move) {
		Square initialPosition = squares[move.getInitialXCoor()][move.getInitialYCoor()];
		boolean result = false;
		
		// all pieces should move within the range of (row 0-8 && column 0-8)
		if (isMoveInBounds(move)) {
			// another piece ISN'T in the targeted diagonal direction
			if (isOtherPieceAhead(move) == false) {
				// r can move one step downward on Y and one step left or right on X
				if (initialPosition.getPiece().getColor().equals("r") &&
						move.getEndingYCoor() == move.getInitialYCoor() + 1 &&						
						(move.getEndingXCoor() == move.getInitialXCoor() - 1 ||	
						move.getEndingXCoor() == move.getInitialXCoor() + 1)) {
					result = true;
				}
				
				// b can move one step upward on Y and one step left or right on X
				else if (initialPosition.getPiece().getColor().equals("b") && 
						 move.getEndingYCoor() == move.getInitialYCoor() - 1 && 
						 (move.getEndingXCoor() == move.getInitialXCoor() - 1 ||
						 move.getEndingXCoor() == move.getInitialXCoor() + 1)) {
					result = true;
				}
				
				// R or B can move one step up or down on Y and one step left or right on X
				else if ((initialPosition.getPiece().getColor().equals("R") || 
						initialPosition.getPiece().getColor().equals("B")) && 
						(move.getEndingYCoor() == move.getInitialYCoor() + 1 || 
						move.getEndingYCoor() == move.getInitialYCoor() - 1) &&
						(move.getEndingXCoor() == move.getInitialXCoor() + 1 || 
						move.getEndingXCoor() == move.getInitialXCoor() - 1)) {
					result = true;
				}
			}
			
			// another piece IS in the targeted diagonal direction
			else if (isOtherPieceAhead(move) == true) {
				// r can move two steps down on Y and two steps left or right on X consecutively
				if (initialPosition.getPiece().getColor().equals("r") && 
						move.getEndingYCoor() == move.getInitialYCoor() + 2 &&						
						(move.getEndingXCoor() == move.getInitialXCoor() - 2 ||	
						move.getEndingXCoor() == move.getInitialXCoor() + 2)) {
					result = true;
				//	initialPosition = squares[move.getEndingXCoor()][move.getEndingYCoor()];
				}
				
				// b can move two steps up on Y and two steps left or right on X consecutively
				else if (initialPosition.getPiece().getColor().equals("b") &&
						move.getEndingYCoor() == move.getInitialYCoor() - 2 && 
						 (move.getEndingXCoor() == move.getInitialXCoor() - 2 ||
						 move.getEndingXCoor() == move.getInitialXCoor() + 2)) {
					result = true;
				//	initialPosition = squares[move.getEndingXCoor()][move.getEndingYCoor()];
				}
				
				// R or B can move two steps up or down on Y and two steps left or right on X consecutively
				else if ((initialPosition.getPiece().getColor().equals("R") || 
						initialPosition.getPiece().getColor().equals("B")) && 
						(move.getEndingYCoor() == move.getInitialYCoor() + 2 || 
						move.getEndingYCoor() == move.getInitialYCoor() - 2) &&
						(move.getEndingXCoor() == move.getInitialXCoor() + 2 || 
						move.getEndingXCoor() == move.getInitialXCoor() - 2)) {
					result = true;
				//	initialPosition = squares[move.getEndingXCoor()][move.getEndingYCoor()];
				}
			}
		}
		return result;
	}
	
	
	public void movePiece(Move move) {
		// should move the piece only if the move is legal
		
	}
	
	
	public static void main(String[] args) {
		Piece pp1 = new Piece("red");
		Piece pp2 = new Piece("black");		
		
		Square ss1 = new Square(pp1);
		Square ss2 = new Square(pp2);
		
		System.out.println(ss1);
		System.out.println(ss2);
		
		Board b = new Board();
		System.out.println(b);
	}
	

	

//
//	public void jumpPiece() {
//		
//	}




/*
//Should move the piece only if the move is legal
public void movePiece(Move move) {
	
	squares[move.getEndingYCoor()][move.getEndingXCoor()] = squares[move.getInitialYCoor()][move.getInitialXCoor()];
    squares[move.getInitialYCoor()][move.getInitialXCoor()] = sq3;
    if (move.getInitialYCoor() - move.getEndingYCoor() == 2 || move.getInitialYCoor() - move.getEndingYCoor() == -2) 
    	jumpPiece(move);
    	

//    if (move.getEndingYCoor() == 0 && squares[move.getEndingYCoor()][move.getEndingXCoor()] == sq2)
//       squares[move.getEndingYCoor()][move.getEndingXCoor()] =  sq2.p2.setRank("B");
//    if (move.getEndingYCoor() == 7 && squares[move.getEndingYCoor()][move.getEndingXCoor()] == sq1)
//       squares[move.getEndingYCoor()][move.getEndingXCoor()] = sq1.p1.setRank("R");

 }
 */
	
	
	

/*
public void jumpPiece(Move move) {

	 int jumpRow = (move.getInitialYCoor() + move.getEndingYCoor()) / 2;  // Row of the jumped piece.
     int jumpCol = (move.getInitialXCoor() + move.getEndingXCoor()) / 2;  // Column of the jumped piece.
     squares[jumpRow][jumpCol] = sq3;
	
}
*/
}