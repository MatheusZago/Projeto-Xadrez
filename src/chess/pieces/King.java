package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	// O rei tem que ter associação da partida para saber se ele está em check
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	// A peça vai aparecer assim qnd for imprimida no tabuleiro.
	@Override
	public String toString() {
		return "K";
	}

	private boolean testeRookCastling(Position positino) {
		ChessPiece p = (ChessPiece) getBoard().piece(positino);
		// Ta se tudo isso der V significa que tem uma torre e ela está apta fazer o
		// Roque
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		// Pode se mover se a casa estiver vazia OU se a cor for diferente
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// Para cima
		p.setValues(position.getRow() - 1, position.getColumn());

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Para baixo
		p.setValues(position.getRow() + 1, position.getColumn());

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Direita
		p.setValues(position.getRow(), position.getColumn() + 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Noroeste
		p.setValues(position.getRow() - 1, position.getColumn() - 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Nordeste
		p.setValues(position.getRow() - 1, position.getColumn() + 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Sudoeste
		p.setValues(position.getRow() + 1, position.getColumn() - 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Sudeste
		p.setValues(position.getRow() + 1, position.getColumn() + 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// #MOVIMENTO ESPECIAL DE CASTELO/ROQUE
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			// Castelo pequeno / direita
			// Está testando se tem uma torre apta a fazer castelo no espaço da direita
			Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
			if (testeRookCastling(posT1)) {
				// Ta vendo se as posições entre o rei e a torre tão vazias
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getColumn() +2] = true;
				}
			}
			// Aqui vai testar o Castelo grande /esquerda
			Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
			if (testeRookCastling(posT2)) {
				// Ta vendo se as posições entre o rei e a torre tão vazias
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[position.getRow()][position.getColumn() -2] = true;
				}
			}

		}

		return mat;
	}

}
