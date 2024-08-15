package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	//É o principal do sistema, onde tem as regras.
	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
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
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1) );
		board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
		
	}

}
