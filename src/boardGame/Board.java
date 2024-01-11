package boardGame;

// Declarando a classe principal, mesa do tabuleiro.
public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
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
}
