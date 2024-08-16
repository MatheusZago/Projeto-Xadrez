package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{

	public Pawn(Board board, Color color) {
		super(board, color);
	}
	
	//A peça vai aparecer assim qnd for imprimida no tabuleiro.
	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
	boolean[][] mat = new boolean[getBoard().getRows()][ getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		//Essa é a lógica do peão branco, tem que ser separado pq ele sobe no tabuleiro.
		if(getColor() == Color.WHITE) {
			p.setValues(position.getRow()-1,position.getColumn());
			//Se existir o espaço ele pode pode andar pra fente.
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;	
			}
			//Essa é a lógica pro peão andar 2 posições no turno 1.
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, p.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//Lógica das diagonias para captura
			p.setValues(position.getRow()-1,position.getColumn()-1);
			//Se existir o espaço ele pode pode andar pra fente,essa só fica ativada SE tiver uma pessoa oponente.
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;	
			}
			p.setValues(position.getRow()-1,position.getColumn()+1);
			//Se existir o espaço ele pode pode andar pra fente.
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;	
			}
		} else { //Essa é a lógica do peão preto.
			p.setValues(position.getRow()+1,position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;	
			}
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, p.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow()+1,position.getColumn()-1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;	
			}
			p.setValues(position.getRow()+1,position.getColumn()+1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;	
			}
		}
		
		return mat;
	}

}
