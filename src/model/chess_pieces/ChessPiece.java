package model.chess_pieces;

import model.Board;
import model.BoardPosition;
import model.Player;

import java.util.List;

public abstract class ChessPiece{

    private Player player;

    public ChessPiece(Player player) {
        this.player = player;
    }

    @Override
    public int hashCode() {
        int result = 15;
        result = 33 * result + getClass().hashCode();
        result = 33 * result + player.getColor();
        result = 33 * result + player.getId();
        return result;
    }

    public boolean isEnemyFor(ChessPiece chessPiece) {
        return chessPiece.getColor() != getColor();
    }

    public int getColor() {
        return player.getColor();
    }

    public boolean checkIfPossibleForMove(Board board, BoardPosition place, BoardPosition destination) {
        return getAllPossibleMovements(board, place).contains(destination);
    }

    public abstract List<BoardPosition> getAllPossibleMovements(Board board, BoardPosition place);
}
