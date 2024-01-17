package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// Declarando e instanciando um objeto partida de xadrez.
		ChessMatch chessMatch = new ChessMatch();
		// Declarando e instanciando uma lista ChessPiece.
		List<ChessPiece> captured = new ArrayList<>();

		while (!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				// Matriz booleana para possíveis movimentos.
				boolean[][] possibleMovies = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMovies);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
	
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				// Condição para adicionar a peça capturada na lista de "captured".
				if(capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
				// Condição para testar se uma peça foi promovida.
				if(chessMatch.getPromoted() != null) {
					System.out.print("Enter piece for promotion (R/C/B/Q): ");
					String type = sc.nextLine();
					// Converte a string para maiúsculas.
					type = type.toUpperCase();
					chessMatch.replacePromotedPiece(type);
				}
			}
			catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);

	}

}
