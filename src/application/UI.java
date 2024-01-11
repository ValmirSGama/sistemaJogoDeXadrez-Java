package application;

import chess.ChessPiece;

//Declarando a classe Interface do Usuário.
public class UI {

	// Método printBoard recebendo a matriz ChessPiece como argumento. 
	public static void printBoard(ChessPiece[][] pieces) {
		for(int i=0; i<pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for(int j=0; j<pieces.length; j++) {
				printPiece(pieces[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	// Método auxiliar para imprimir uma peça do xadrez.
	private static void printPiece(ChessPiece piece) {
		if(piece == null) {
			System.out.print("-");
		}
		else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}
}
