package chess;

import boardgame.Position;

public class ChessPosition {
	
	private char column;
	private  int row;
	public ChessPosition(char column, int row) {
		
		if(column < 'a'  || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instanciating Chess Position: Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}
	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	//A linha da matriz é igual a 8 - linha do xadrez (pelo jeito q matriz funcionam)
	//Coluna a=0, b=1
	//Coluna do matriz = coluna do xadrez - a (usando o código unicode do a)
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		//Ta retornando a posição construida 
		return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
	}
	
	@Override 
	public String toString() {
		return "" + column + row;
	}
	

}
