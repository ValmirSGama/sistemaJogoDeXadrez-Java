package boardGame;

// Classe que, opcionalmente, trata uma exceção ao extends RuntimeException.
public class BoardException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public BoardException(String msg) {
		super(msg);
	}
}
