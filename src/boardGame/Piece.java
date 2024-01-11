package boardGame;

//Declarando a classe principal, peça do tabuleiro.
public class Piece {

	protected Position position;
	private Board board;
	
	// Construtor referenciando o atributo board. 
	public Piece(Board board) {
		this.board = board;
	}

	// Método Getter para acessar o atributo board.
	protected Board getBoard() {
		return board;
	}
}
