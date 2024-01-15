package chess;

import boardGame.Position;

//Declarando a classe: posição do xadrex.
public class ChessPosition {

	private char column;
	private int row;
	
	// Construtor posição do xadrex recebendo os argumentos correspondentes.
	public ChessPosition(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) { // Condição defensiva.
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}

	// Métodos Getters para acessar os atributos.
	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	// Método que converte as linhas do xadrez para as linhas da matriz.
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	// Método que converte uma posição da matriz para uma posição do xadrez.
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
	}
	
	// Método toString da posição.
	@Override
	public String toString() {
		return "" + column + row;
	}
}
