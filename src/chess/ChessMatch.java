package chess;

import boardGame.Board;

// Declarando a classe partida de xadrez.
public class ChessMatch {

	private Board board; // Atributo do tipo classe "Board".
	
	// Construtor que define a dimensão do tabuleiro de xadrex. 
	public ChessMatch() {
		board = new Board(8, 8);
	}
	
	// Método que retorna a matriz de peças da partida de xadrez.
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i=0; i<board.getRows(); i++) {
			for(int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
}
