package model.chess_pieces;

import model.Board;
import model.BoardPosition;
import model.Player;

import java.util.List;

public class Pawn extends ChessPiece {

    public Pawn(Player player) {
        super(player);
    }

    @Override
    public List<BoardPosition> getAllPossibleMovements(Board board, BoardPosition place) {
        int direction = (getColor() == ChessPieceColor.BLACK)
                ? ChessPieceMovements.DOWN
                : ChessPieceMovements.UP;
        int max = (place.getY() == 1 || place.getY() == 6) ? 2 : 1;

        ChessPieceMovements movements = new ChessPieceMovements(board, place, max);

        movements.calcMovesForPawn(direction);

        return movements.getMoves();
    }
}
