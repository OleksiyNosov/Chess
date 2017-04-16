package model.chess_pieces;

import model.Board;
import model.BoardPosition;
import model.MovementManager;
import model.Player;

import java.util.List;

public class Rook extends ChessPiece {
    public Rook(Player player) {
        super(player);
    }

    @Override
    public List<BoardPosition> getAllPossibleMovements(Board board, BoardPosition place) {
        return MovementManager.getAllForSides(board, place, Integer.MAX_VALUE);
    }
}
