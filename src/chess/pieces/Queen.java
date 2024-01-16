package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

//Declarando a classe: peça Rainha do xadrez.
public class Queen extends ChessPiece{

	// Construtor informando o tabuleiro e a cor da peça.
	public Queen(Board board, Color color) {
		super(board, color);
	}
	
	// Método toString para retornar a Rainha.
	@Override
	public String toString() {
		return "Q";
	}
	
	// Sobreposição e implementação do método possibleMoves da classe Piece.
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		// Above
		p.setValues(position.getRow() - 1, position.getColumn());
		while(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// Left
		p.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Right
		p.setValues(position.getRow(), position.getColumn() + 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// Below
		p.setValues(position.getRow() + 1, position.getColumn());
		while(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// northwest
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() - 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// Northeast
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// southeast
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() + 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
	
		// southwest
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() - 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
	return mat;
	}
}
