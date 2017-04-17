package model.chess_pieces;

import model.Board;
import model.BoardPosition;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ChessPieceMovements {
    private static final int LEFT = -1;
    private static final int RIGHT = 1;

    private static final int UP = -1;
    private static final int DOWN = 1;

    private static final int CENTER = 0;


    private static Board board;
    private static ChessPiece currentChessPiece;
    private static BoardPosition place;

    private ChessPieceMovements() {}

    public static List<BoardPosition> getAllMovesForSides(Board board, BoardPosition place, int max) {
        setFields(board, place);
        List<BoardPosition> moves = new LinkedList<>();

        moves.addAll(getAllPossibleMovesForLine(RIGHT,  CENTER, max));
        moves.addAll(getAllPossibleMovesForLine(CENTER, DOWN,   max));
        moves.addAll(getAllPossibleMovesForLine(LEFT,   CENTER, max));
        moves.addAll(getAllPossibleMovesForLine(CENTER, UP,     max));

        return moves;
    }

    public static List<BoardPosition> getAllMovesForDiagonals(Board board, BoardPosition place, int max) {
        setFields(board, place);
        List<BoardPosition> moves = new LinkedList<>();

        moves.addAll(getAllPossibleMovesForLine(RIGHT, DOWN, max));
        moves.addAll(getAllPossibleMovesForLine(RIGHT, UP,   max));
        moves.addAll(getAllPossibleMovesForLine(LEFT,  DOWN, max));
        moves.addAll(getAllPossibleMovesForLine(LEFT,  UP,   max));

        return moves;
    }

    public static List<BoardPosition> getAllMovesForKnight(Board board, BoardPosition place) {
        setFields(board, place);
        List<BoardPosition> moves = new LinkedList<>();

        moves.addAll(getAllPossibleMovesForLine(RIGHT * 2, DOWN, 1));
        moves.addAll(getAllPossibleMovesForLine(RIGHT * 2, UP,   1));
        moves.addAll(getAllPossibleMovesForLine(LEFT  * 2, DOWN, 1));
        moves.addAll(getAllPossibleMovesForLine(LEFT  * 2, UP,   1));

        moves.addAll(getAllPossibleMovesForLine(RIGHT,DOWN * 2, 1));
        moves.addAll(getAllPossibleMovesForLine(RIGHT,UP   * 2, 1));
        moves.addAll(getAllPossibleMovesForLine(LEFT, DOWN * 2, 1));
        moves.addAll(getAllPossibleMovesForLine(LEFT, UP   * 2, 1));

        return moves;
    }



    public static List<BoardPosition> getAllMovesForPawn(Board board, BoardPosition place, int max, int direction) {
        setFields(board, place);
        List<BoardPosition> moves = new LinkedList<>();

        moves.addAll(getOneOnlyForCombat(RIGHT, direction));
        moves.addAll(getOneOnlyForCombat(LEFT,  direction));

        moves.addAll(getOnlyForMove(CENTER, direction, max));

        return moves;
    }


    private static List<BoardPosition> getOneOnlyForCombat(int shiftByX, int shiftByY) {
        LinkedList<BoardPosition> moves = new LinkedList<>();
        BoardPosition tempPos = new BoardPosition(place.getX() + shiftByX, place.getY() + shiftByY);

        if (board.isOnBoard(tempPos) && ( ! board.getCellAt(tempPos).isEmpty()))
            if (board.getCellAt(tempPos).getChessPiece().isEnemyFor(currentChessPiece))
                moves.add(tempPos);

        return moves;
    }

    private static List<BoardPosition> getOnlyForMove(int shiftByX, int shiftByY, int max) {
        LinkedList<BoardPosition> moves = new LinkedList<>();

        for (int i = 1; i <= max; i++) {
            BoardPosition tempPos = new BoardPosition(place.getX() + shiftByX * i, place.getY() + shiftByY * i);
            if (board.isOnBoard(tempPos) && board.getCellAt(tempPos).isEmpty())
                moves.add(tempPos);
        }

        return moves;
    }

    private static LinkedList<BoardPosition> getAllPossibleMovesForLine(int shiftByX, int shiftByY, int max) {
        LinkedList<BoardPosition> moves = new LinkedList<>();

        for (int i = 1; i <= max; i++) {
            BoardPosition tempPos = new BoardPosition(place.getX() + shiftByX * i, place.getY() + shiftByY * i);
            if (board.isOnBoard(tempPos)) {
                if (board.getCellAt(tempPos).isEmpty()) {
                    moves.add(tempPos);
                } else if (board.getCellAt(tempPos).getChessPiece().isEnemyFor(currentChessPiece)) {
                    moves.add(tempPos);
                    return moves;
                } else  {
                    return moves;
                }
            } else {
                return moves;
            }
        }

        return moves;
    }

    private static void setFields(Board board, BoardPosition place) {
        ChessPieceMovements.board = board;
        ChessPieceMovements.currentChessPiece = board.getCellAt(place).getChessPiece();
        ChessPieceMovements.place = place;
    }
}
