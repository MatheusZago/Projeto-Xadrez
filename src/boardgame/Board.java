package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error Creating Board: It is necessary to have at least 1 row and column.");
		}
		
		this.rows = rows;
		this.columns = columns;
		//Instanciando a matriz peças no construtor tabuleiro
		pieces = new Piece[rows][columns];
	}

	public int getColumns() {
		return columns;
	}

	
	public int getRows() {
		return rows;
	}

	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board.");
		}
		
		return pieces[row][column];
	}
	
	//É uma sobregarga do de cima
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board.");
		}
		
		return pieces[position.getRow()][position.getColumn()];
	}


	public void placePiece(Piece piece, Position position) {
		if(thereIsaPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		
		//Esta pegando a matriz na posição dada e atribuindo a peça informada.
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on board.");
		}
		
		if(piece(position) == null) {
			return null;
		} 
		
		//Ele ta pegando a peça selecionada e colocando na AUX
		Piece aux = piece(position);
		aux.position = null; // Deixando AUX nulo
		pieces[position.getRow()][position.getColumn()] = null; //A posição onde a peça tava na matriz virou nulo
		return aux;
		
	}
	
	//Esse aqui vai ver se o valor ta dentro do tabuleiro 
	private boolean positionExists(int row, int column) {
		//Retorna V ou F, dependendo se a expressão for vdd
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	//Ta concedendo a outra os valores, e essa é publica
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	//Ele vai retornar V ou F, dependendo se a expressão for vdd
	public boolean thereIsaPiece(Position position) {		
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board.");
		}
		return piece(position) != null; 
	}
	

	
	

}
