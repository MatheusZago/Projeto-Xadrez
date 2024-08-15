package chess.pieces;

import boardgame.Board;
import boardgame.Position;
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
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		//Pode se mover se a casa estiver vazia OU se a cor for diferente
		return p == null || p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][ getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		//Para cima
		p.setValues(position.getRow()-1, position.getColumn());
		
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Para baixo
		p.setValues(position.getRow()+1, position.getColumn());
		
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Esquerda
		p.setValues(position.getRow(), position.getColumn()-1);
		
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Direita
		p.setValues(position.getRow(), position.getColumn()+1);
		
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Noroeste 
		p.setValues(position.getRow()-1, position.getColumn()-1);
		
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Nordeste
		p.setValues(position.getRow()-1, position.getColumn()+1);
		
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Sudoeste
		p.setValues(position.getRow()+1, position.getColumn()-1);
		
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Sudeste
		p.setValues(position.getRow()+1, position.getColumn()+1);
		
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
			
		return mat;
	}

}
