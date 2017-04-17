package model.chess_pieces;

import model.Board;
import model.BoardPosition;
import model.Player;

import java.util.List;

public class Knight extends ChessPiece {
    public Knight(Player player) {
        super(player);
    }

    @Override
    public List<BoardPosition> getAllPossibleMovements(Board board, BoardPosition place) {
        return ChessPieceMovements.getAllMovesForKnight(board, place);
    }
}
