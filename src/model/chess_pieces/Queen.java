package model.chess_pieces;

import model.Board;
import model.BoardPosition;
import model.Player;

import java.util.LinkedList;
import java.util.List;

public class Queen extends ChessPiece {
    public Queen(Player player) {
        super(player);
    }

    @Override
    public List<BoardPosition> getAllPossibleMovements(Board board, BoardPosition place) {
        List<BoardPosition> moves = new LinkedList<>();

        moves.addAll(ChessPieceMovements.getAllForSides(board, place, Integer.MAX_VALUE));
        moves.addAll(ChessPieceMovements.getAllForDiagonals(board, place, Integer.MAX_VALUE));

        return moves;
    }
}
