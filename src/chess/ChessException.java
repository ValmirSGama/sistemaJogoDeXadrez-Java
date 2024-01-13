package chess;

import boardGame.BoardException;

//Classe que, opcionalmente, trata uma exceção ao extends RuntimeException.
public class ChessException extends BoardException{
	private static final long serialVersionUID = 1L;

	public ChessException(String msg) {
		super(msg);
	}
}
