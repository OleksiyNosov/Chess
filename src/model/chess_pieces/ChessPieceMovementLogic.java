package model.chess_pieces;

import model.Board;
import model.BoardPosition;

import java.util.List;

public interface ChessPieceMovementLogic {

    boolean checkIfPossible(Board board, BoardPosition place, BoardPosition destination);

    List<BoardPosition> getAllPossibleMovements(Board board, BoardPosition place);
}
