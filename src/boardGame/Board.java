package boardGame;

// Declarando a classe principal, mesa do tabuleiro.
public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces; // Declarando uma matriz do tipo classe "Piece". 
	
	// Construtor referenciando os atributos rows e columns; 
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) { // Condição defensiva.
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		// Intanciando uma matriz de peças.
		pieces = new Piece[rows][columns];
	}

	// Métodos Getters para acessar os atributos.
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	// Método para retornar uma peça dado uma linha e uma coluna.
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {// Condição defensiva.
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	// Sobrecarga do método "Piece" recebendo o tipo classe "Position" como argumento.
	public Piece piece(Position position) {
		if(!positionExists(position)) {// Condição defensiva.
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	// Método para posicionar uma peça no tabuleiro.
	public void placePiece(Piece piece, Position position) {
		if(thereIsPiece(position)) {// Condição defensiva.
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	// Método para remover uma peça.
	public Piece removePiece(Position position) {
		if(!positionExists(position)) { // Condição defensiva.
			throw new BoardException("Position not on the board");
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	// Método que aucilia verificar se há posição.
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column < columns;
	}
	
	// Método que verifica se há posição.
	private boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	// Método que verifica se há uma peça na posição.
	public boolean thereIsPiece(Position position) {
		if(!positionExists(position)) {// Condição defensiva.
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
}
