package chess;

import boardgame.Board;

public class ChessMatch {
	
	//É o principal do sistema, onde tem as regras.
	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
	}
	
	//Esse método vai retornar uma matriz de peças para a partida
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getColumns()][board.getColumns()] ;
		
		for(int i=0; i<board.getRows();i++) {
			for(int j=0; j<board.getColumns(); j++) {
				//Pra cada peça ele ta pegando a Piece e transformando em ChessPiece
				mat[i][j] = (ChessPiece)board.piece(i, j);
			}
		}
		
		return mat;
	}

}
