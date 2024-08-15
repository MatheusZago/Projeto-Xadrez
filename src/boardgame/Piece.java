package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	//O construtor é assim pq uma peça recem criada ainda nn tem posição no tabuleiro
	public Piece(Board board) {
		this.board = board;
		this.position = null;
	}

	protected Board getBoard() {
		return board;
	}
	
	
	
	
	

}
