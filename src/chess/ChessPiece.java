package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

//Essa é a peça no tabuleiro, tem até as cores.
public abstract class ChessPiece extends Piece{
	
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public ChessPosition getChessPosition() {
		//Transformando posição da peça para ler
		return ChessPosition.fromPosition(position);
	}
	

	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		//Ta vendo se tem peça de outra cor no lugar escolhido.
		return p != null && p.getColor() != color;
	}
	
}
