package boardGame;

// Declarando a classe principal, mesa do tabuleiro.
public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces; // Declarando uma matriz do tipo classe "Piece". 
	
	// Construtor referenciando os atributos rows e columns; 
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		// Intanciando uma matriz de peças.
		pieces = new Piece[rows][columns];
	}

	// Métodos Getters e Setters para manipular os atributos.
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	// Método para retornar uma peça dado uma linha e uma coluna.
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	// Sobrecarga do método "Piece" recebendo o tipo classe "Position" como argumento.
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	// Método para posicionar uma peça no tabuleiro.
	public void placePiece(Piece piece, Position position) {
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
}
