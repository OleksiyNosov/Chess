package model.chess_pieces;

import model.Board;
import model.BoardPosition;

import java.util.LinkedList;
import java.util.List;

public class ChessPieceMovements {
    public static final int LEFT   = -1;
    public static final int RIGHT  =  1;
    public static final int UP     = -1;
    public static final int DOWN   =  1;
    public static final int CENTER =  0;

    private Board board;
    private BoardPosition place;
    private ChessPiece chessPiece;
    private int max;

    private List<BoardPosition> moves;

    public ChessPieceMovements(Board board, BoardPosition place, int max) {
        this.board = board;
        this.place = place;
        this.chessPiece = board.getCellAt(place).getChessPiece();
        this.max = max;
        this.moves = new LinkedList<>();
    }

    public List<BoardPosition> getMoves() {
        return moves;
    }

    public void calcMovesForSides() {
        calcMovesForLine(RIGHT,  CENTER);
        calcMovesForLine(CENTER, DOWN);
        calcMovesForLine(LEFT,   CENTER);
        calcMovesForLine(CENTER, UP);
    }

    public void calcMovesForDiagonals() {
        calcMovesForDiagonals(1, 1);
    }

    public void calcMovesForKnight() {
        calcMovesForDiagonals(2, 1);
        calcMovesForDiagonals(1, 2);
    }

    public void calcMovesForPawn(int direction) {
        calcOneOnlyForCombat(RIGHT, direction);
        calcOneOnlyForCombat(LEFT,  direction);

        calcOnlyForMove(CENTER, direction);
    }

    private void calcOneOnlyForCombat(int shiftByX, int shiftByY) {
        BoardPosition tempPos = new BoardPosition(place.getX() + shiftByX, place.getY() + shiftByY);

        if (board.isOnBoard(tempPos) && ( ! board.getCellAt(tempPos).isEmpty()))
            if (board.getCellAt(tempPos).getChessPiece().isEnemyFor(chessPiece))
                moves.add(tempPos);
    }

    private void calcOnlyForMove(int shiftByX, int shiftByY) {
        for (int i = 1; i <= max; i++) {
            BoardPosition tempPos = new BoardPosition(place.getX() + shiftByX * i, place.getY() + shiftByY * i);
            if (board.isOnBoard(tempPos) && board.getCellAt(tempPos).isEmpty())
                moves.add(tempPos);
        }
    }

    private void calcMovesForLine(int shiftByX, int shiftByY) {
        for (int i = 1; i <= max; i++) {
            BoardPosition tempPos = new BoardPosition(place.getX() + shiftByX * i, place.getY() + shiftByY * i);
            if (board.isOnBoard(tempPos)) {
                if (board.getCellAt(tempPos).isEmpty()) {
                    moves.add(tempPos);
                } else if (board.getCellAt(tempPos).getChessPiece().isEnemyFor(chessPiece)) {
                    moves.add(tempPos);
                    return;
                } else  {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private void calcMovesForDiagonals(int xMultiplier, int yMultiplier) {
        calcMovesForLine(xMultiplier * RIGHT, yMultiplier * DOWN);
        calcMovesForLine(xMultiplier * RIGHT, yMultiplier * UP);
        calcMovesForLine(xMultiplier * LEFT,  yMultiplier * DOWN);
        calcMovesForLine(xMultiplier * LEFT,  yMultiplier * UP);
    }
}
