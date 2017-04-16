package model;

import model.chess_pieces.ChessPiece;

import java.util.LinkedList;
import java.util.List;

public class MovementManager {
    private static Board board;
    private static ChessPiece chessPiece;
    private static BoardPosition place;

    private MovementManager() {}

    public static List<BoardPosition> getAllForSides(Board board, BoardPosition place, int max) {
        setFields(board, place);
        List<BoardPosition> moves = new LinkedList<>();

        moves.addAll(getAllPossibleMovesForLine( 1, 0, max));
        moves.addAll(getAllPossibleMovesForLine(-1, 0, max));
        moves.addAll(getAllPossibleMovesForLine( 0, 1, max));
        moves.addAll(getAllPossibleMovesForLine( 0,-1, max));

        return moves;
    }

    public static List<BoardPosition> getAllForDiagonals(Board board, BoardPosition place, int max) {
        setFields(board, place);
        List<BoardPosition> moves = new LinkedList<>();

        moves.addAll(getAllPossibleMovesForLine(-1,-1, max));
        moves.addAll(getAllPossibleMovesForLine(-1, 1, max));
        moves.addAll(getAllPossibleMovesForLine( 1,-1, max));
        moves.addAll(getAllPossibleMovesForLine( 1, 1, max));

        return moves;
    }

    public static List<BoardPosition> getAllForKnight(Board board, BoardPosition place) {
        setFields(board, place);
        List<BoardPosition> moves = new LinkedList<>();

        moves.addAll(getAllPossibleMovesForLine(+2,+1, 1));
        moves.addAll(getAllPossibleMovesForLine(+2,-1, 1));
        moves.addAll(getAllPossibleMovesForLine(-2,+1, 1));
        moves.addAll(getAllPossibleMovesForLine(-2,-1, 1));

        moves.addAll(getAllPossibleMovesForLine(+1,+2, 1));
        moves.addAll(getAllPossibleMovesForLine(-1,+2, 1));
        moves.addAll(getAllPossibleMovesForLine(+1,-2, 1));
        moves.addAll(getAllPossibleMovesForLine(-1,-2, 1));

        return moves;
    }

    public static List<BoardPosition> getAllForPawn(Board board, BoardPosition place, int max, int direction) {
        setFields(board, place);
        List<BoardPosition> moves = new LinkedList<>();

        moves.addAll(getOneOnlyForCombat(+1, direction));
        moves.addAll(getOneOnlyForCombat(-1, direction));

        moves.addAll(getOnlyForMove(0, direction, max));

        return moves;
    }


    private static List<BoardPosition> getOneOnlyForCombat(int shiftByX, int shiftByY) {
        LinkedList<BoardPosition> moves = new LinkedList<>();
        BoardPosition tempPos = new BoardPosition(place.getX() + shiftByX, place.getY() + shiftByY);

        if (board.isOnBoard(tempPos) && ( ! board.getCellAt(tempPos).isEmpty()))
            if (board.getCellAt(tempPos).getChessPiece().isEnemyFor(chessPiece))
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
                } else if (board.getCellAt(tempPos).getChessPiece().isEnemyFor(chessPiece)) {
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
        MovementManager.board = board;
        MovementManager.chessPiece = board.getCellAt(place).getChessPiece();
        MovementManager.place = place;
    }
}
