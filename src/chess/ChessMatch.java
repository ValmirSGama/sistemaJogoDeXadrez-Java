package chess;

import boardGame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

// Declarando a classe partida de xadrez.
public class ChessMatch {

	private Board board; // Atributo do tipo classe "Board".
	
	// Construtor que define a dimensão do tabuleiro de xadrex e recebe o método iniciar. 
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
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
	
	// Método que recebe as coordenadas do xadrez.
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	// Método responsável por iniciar a partida de xadrez.
	private void initialSetup() {
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('e', 1,new King(board, Color.WHITE));
	}
}
