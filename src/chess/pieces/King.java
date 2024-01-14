package chess.pieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.Color;

//Declarando a classe: peça Rei do xadrez.
public class King extends ChessPiece{

	// Construtor informando o tabuleiro e a cor da peça.
	public King(Board board, Color color) {
		super(board, color);
	}
	
	// Método toString para retornar o Rei.
	@Override
	public String toString() {
		return "K";
	}

	// Sobreposição e implementação do método possibleMoves da classe Piece.
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return mat;
	}
}
