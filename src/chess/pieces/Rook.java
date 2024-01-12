package chess.pieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.Color;

//Declarando a classe: peça Torre de xadrez.
public class Rook extends ChessPiece{

	// Construtor informando o tabuleiro e a cor da peça.
	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	// Método toString para retornar a Torre.
	@Override
	public String toString() {
		return "R";
	}

}
