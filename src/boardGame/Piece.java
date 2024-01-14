package boardGame;

//Declarando a classe principal, peça do tabuleiro.
public abstract class Piece {

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
	
	// Método para possíveis movimentos.
	public abstract boolean[][]possibleMoves();
	
	// Método para verificar se é possível efetuar o movimento.
	public boolean possibleMoves(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	// Método para verificar se há ao menos um movimento possível.
	public boolean isThereAnyPossibleMovie() {
		boolean[][] mat = possibleMoves();
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
			
		}
		return false;
	}
}
