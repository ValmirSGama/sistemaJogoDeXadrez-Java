package boardGame;

public class Position {

	private int row;
	private int column;
	
	// Construtor referenciando os atributos "row" e "column".
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	// Métodos Getters e Setters para manipular os atributos.
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	// Método toString.
	@Override
	public String toString() {
		return row + ", " + column;
	}
}
