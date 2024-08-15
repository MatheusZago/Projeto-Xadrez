package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		//Instanciando a matriz peças no construtor tabuleiro
		pieces = new Piece[rows][columns];
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public int getRows() {
		return rows;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}

	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	//É uma sobregarga do de cima
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}


	public void placePiece(Piece piece, Position position) {
		//Esta pegando a matriz na posição dada e atribuindo a peça informada.
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	
	
	

}
