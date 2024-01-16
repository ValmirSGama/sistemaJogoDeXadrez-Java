package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Rook;

// Declarando a classe partida de xadrez.
public class ChessMatch {

	private int turn;
	private Color currentPlayer;
	private Board board; // Atributo do tipo classe "Board".
	private boolean check;
	private boolean checkMate;

	// Instanciação de listas para peças no tabuleiro e peças capturadas respectivamente.
	private List<Piece> piecesOnTheBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();
	
	// Construtor que define a dimensão do tabuleiro de xadrex e recebe o método iniciar. 
	public ChessMatch() {
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE;
		initialSetup();
	}
	
	// Métodos Getters para acessar os atributos turn, currentPlayer, check e checkMate;
	public int getTurn() {
		return turn;
	}
	
	public Color getCurrentPlayer() {
		return currentPlayer;
	}
	
	public boolean getCheck() {
		return check;
	}
	
	public boolean getCheckMate() {
		return checkMate;
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
	
	// Método que opera movimentos possíveis dado uma posição. 
	public boolean[][] possibleMoves(ChessPosition sourcePosition){
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	// Método para mover uma peça.
	public ChessPiece performChessMove(ChessPosition soursePosition, ChessPosition targetPosition) {
		Position source = soursePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		
		// Condição verificando se colou a si mesmo em cheque.
		if(testCheck(currentPlayer)) {
			undoMove(source, target, capturedPiece);
			throw new ChessException("You can't put yourself in check");
		}
		
		// Expressão ternária para dizer se está ou não em cheque.
		check = (testCheck(opponent(currentPlayer)))? true : false;
		
		// Condição que testa se está em chequemate.
		if(testCheckMate(opponent(currentPlayer))) {
			checkMate = true;
		}
		else {
			nextTurn();
		}
		
		return (ChessPiece)capturedPiece;
		
	}
	
	// Método para fazer o movimento.
	private Piece makeMove(Position source, Position target) {
		ChessPiece p = (ChessPiece)board.removePiece(source);
		p.increaseMoveCount();
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		
		if(capturedPiece != null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
		}
		
		return capturedPiece;
	}
	
	// Método para desfazer o movimento caso a peça se coloque em cheque.
	public void undoMove(Position source, Position target, Piece capturedPiece) {
		ChessPiece p = (ChessPiece)board.removePiece(target);
		p.decreaseMoveCount();
		board.placePiece(p, source);
		
		if(capturedPiece != null) {
			board.placePiece(capturedPiece, target);
			capturedPieces.remove(capturedPiece);
			piecesOnTheBoard.add(capturedPiece);
		}
	}
	
	// Método para validar a posição de origem.
	private void validateSourcePosition(Position position) {
		if(!board.thereIsPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
		if(currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
			throw new ChessException("The chosen piece is not yours");
		}
		if(!board.piece(position).isThereAnyPossibleMovie()) {
			throw new ChessException("There is no possible moves for the piece");
		}
	}
	
	// Método para validar a posição de destino.
	private void validateTargetPosition(Position source, Position target) {
		if(!board.piece(source).possibleMoves(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	
	private void nextTurn() {
		turn++;
		// Variável "currentPlayer" recebendo uma expressão conticional ternária.
		currentPlayer = (currentPlayer == Color.WHITE)? Color.YELLOW : Color.WHITE;
	}
	
	// Método para identificar o oponente.
	private Color opponent(Color color) {
		return (color == Color.WHITE)? Color.YELLOW : Color.WHITE;
	}
	
	// Método para identificar a cor do Rei.
	private ChessPiece king(Color color) {
		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList());
		for(Piece p : list) {
			if(p instanceof King) {
				return (ChessPiece)p;
			}
		}
		throw new IllegalStateException("There is no " + color + "King on the board");
	}
	
	// Método que verifica se o rei está em cheque.
	private boolean testCheck(Color color) {
		Position kingPosition = king(color).getChessPosition().toPosition();
		List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == opponent(color)).collect(Collectors.toList());
		for (Piece p : opponentPieces) {
			boolean[][] mat = p.possibleMoves();
			if (mat[kingPosition.getRow()][kingPosition.getColumn()]) {
				return true;
			}
		}
		return false;
	}
	
	// Método que verifica se o rei está em chequemate.
	private boolean testCheckMate(Color color) {
		if (!testCheck(color)) {
			return false;
		}
		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList());
		for (Piece p : list) {
			boolean[][] mat = p.possibleMoves();
			for (int i=0; i<board.getRows(); i++) {
				for (int j=0; j<board.getColumns(); j++) {
					if (mat[i][j]) {
						Position source = ((ChessPiece)p).getChessPosition().toPosition();
						Position target = new Position(i, j);
						Piece capturedPiece = makeMove(source, target);
						boolean testCheck = testCheck(color);
						undoMove(source, target, capturedPiece);
						if (!testCheck) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	// Método que recebe as coordenadas do xadrez.
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
	}

	// Método responsável por iniciar a partida de xadrez.
	private void initialSetup() {
		placeNewPiece('a', 1, new Rook(board, Color.WHITE));
		placeNewPiece('b', 1, new Knight(board, Color.WHITE));
		placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
		placeNewPiece('e', 1, new King(board, Color.WHITE));
		placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
		placeNewPiece('g', 1, new Knight(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
        placeNewPiece('a', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('b', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('c', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('d', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('e', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('f', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('g', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('h', 2, new Pawn(board, Color.WHITE));

        placeNewPiece('a', 8, new Rook(board, Color.YELLOW));
        placeNewPiece('b', 8, new Knight(board, Color.YELLOW));
        placeNewPiece('c', 8, new Bishop(board, Color.YELLOW));
        placeNewPiece('e', 8, new King(board, Color.YELLOW));
        placeNewPiece('f', 8, new Bishop(board, Color.YELLOW));
        placeNewPiece('g', 8, new Knight(board, Color.YELLOW));
        placeNewPiece('h', 8, new Rook(board, Color.YELLOW));
        placeNewPiece('a', 7, new Pawn(board, Color.YELLOW));
        placeNewPiece('b', 7, new Pawn(board, Color.YELLOW));
        placeNewPiece('c', 7, new Pawn(board, Color.YELLOW));
        placeNewPiece('d', 7, new Pawn(board, Color.YELLOW));
        placeNewPiece('e', 7, new Pawn(board, Color.YELLOW));
        placeNewPiece('f', 7, new Pawn(board, Color.YELLOW));
        placeNewPiece('g', 7, new Pawn(board, Color.YELLOW));
        placeNewPiece('h', 7, new Pawn(board, Color.YELLOW));
	}
}
