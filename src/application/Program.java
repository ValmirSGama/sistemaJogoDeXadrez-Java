package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		
		 // Declarando e instanciando um objeto partida de xadrez.
		ChessMatch chessmatch = new ChessMatch(); 
		UI.printBoard(chessmatch.getPieces());

	}

}
