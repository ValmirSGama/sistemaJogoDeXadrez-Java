package chess;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;

// Declarando a classe peça de xadrez.
public abstract class ChessPiece extends Piece{

	private Color color; // Atributo do tipo enumerado "Color".
	private int moveCount;

	// Construtor referenciando o atributo local "color" e o "board" da super classe Piece. 
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}
	
	// Método que retorna uma peça no formato do xadrez.
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}

	// Métodos Getters para acessar os atributos.
	public Color getColor() {
		return color;
	}
	
	public int getMoveCount() {
		return moveCount; 
	}
	
	// Método para incrementar o movimento das peças.
	protected void increaseMoveCount() {
		moveCount++;
	}
	
	// Método para decrementar o movimento das peças.
	protected void decreaseMoveCount() {
		moveCount--;
	}
	
	// Método que verifica se há uma peça oponente.
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
}
