package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	//A peça vai aparecer assim qnd for imprimida no tabuleiro.
	@Override 
	public String toString() {
		return "R";
	}

}
