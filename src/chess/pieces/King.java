package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	public King(Board board, Color color) {
		super(board, color);
	}
	
	//A peça vai aparecer assim qnd for imprimida no tabuleiro.
	@Override
	public String toString() {
		return "K";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][ getBoard().getColumns()];
		return mat;
	}

}
