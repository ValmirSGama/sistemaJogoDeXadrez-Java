package boardGame;

//Declarando a classe principal, peça do tabuleiro.
public class Piece {

	protected Position position; // Atributo do tipo classe "Position".
	private Board board; // Atributo do tipo classe "Board".
	
	// Construtor referenciando o atributo board. 
	public Piece(Board board) {
		this.board = board;
	}

	// Método Getter para acessar o atributo board.
	protected Board getBoard() {
		return board;
	}
}
