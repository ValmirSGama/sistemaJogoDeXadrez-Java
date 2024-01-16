package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{

	// Construtor recebendo como argumentos "board" e "color". 
	public Pawn(Board board, Color color) {
		super(board, color);
		
	}

	// Sobreposição do método possibleMoves da classe Piece.
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		if(getColor() == Color.WHITE) {
			// Teste da regra de movimentação de uma linha à frente.
			p.setValues(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			// Teste da regra de movimentação de duas linhas à frente.
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn()); 
			if(getBoard().positionExists(p) && !getBoard().thereIsPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			// Teste da regra de movimentação para diagonal à esquerda.
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			// Teste da regra de movimentação para diagonal à direita.
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		else { // Então cor preta.
			// Teste da regra de movimentação de uma linha à frente.
			p.setValues(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			// Teste da regra de movimentação de duas linhas à frente.
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn()); 
			if(getBoard().positionExists(p) && !getBoard().thereIsPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			// Teste da regra de movimentação para diagonal à esquerda.
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			// Teste da regra de movimentação para diagonal à direita.
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		
		return mat;
	}
	// Sobreposição método toString.
	@Override
	public String toString() {
		return "P";
	}

}
