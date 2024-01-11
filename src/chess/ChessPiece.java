package chess;

import boardGame.Board;
import boardGame.Piece;

// Declarando a classe peça de xadrez.
public class ChessPiece extends Piece{

	private Color color; // Atributo do tipo enumerado "Color".

	// Construtor referenciando o atributo local "color" e o "board" da super classe Piece. 
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	// Método Getter para acessar o atributo color.
	public Color getColor() {
		return color;
	}
}