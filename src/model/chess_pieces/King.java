package model.chess_pieces;

import model.Board;
import model.BoardPosition;
import model.MovementManager;
import model.Player;

import java.util.LinkedList;
import java.util.List;

public class King extends ChessPiece {
    public King(Player player) {
        super(player);
    }

    @Override
    public List<BoardPosition> getAllPossibleMovements(Board board, BoardPosition place) {
        List<BoardPosition> moves = new LinkedList<>();

        moves.addAll(MovementManager.getAllForSides(    board, place, 1));
        moves.addAll(MovementManager.getAllForDiagonals(board, place, 1));

        return moves;
    }
}
