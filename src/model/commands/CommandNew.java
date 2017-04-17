package model.commands;

import controller.ChessGame;
import model.Board;
import model.Player;
import model.chess_pieces.*;

public class CommandNew implements Command {
    @Override
    public void execute(ChessGame chessGame) {
        chessGame.getBoard().clear();
        setChessPiecesForNewGame(chessGame.getBoard(), chessGame.getPlayer(0), chessGame.getPlayer(1));
    }

    private void setChessPiecesForNewGame(Board board, Player player1, Player player2) {

        setLineOfMainChessPieces(board,0, player2);
        setLineOfPawns(board, 1, player2);

        setLineOfPawns(board, 6, player1);
        setLineOfMainChessPieces(board, 7, player1);
    }

    private void setLineOfMainChessPieces(Board board, int row, Player player) {
        board.getCellAt(row, 0).setChessPiece(new Rook   (player));
        board.getCellAt(row, 1).setChessPiece(new Knight (player));
        board.getCellAt(row, 2).setChessPiece(new Bishop (player));
        board.getCellAt(row, 3).setChessPiece(new Queen  (player));
        board.getCellAt(row, 4).setChessPiece(new King   (player));
        board.getCellAt(row, 5).setChessPiece(new Bishop (player));
        board.getCellAt(row, 6).setChessPiece(new Knight (player));
        board.getCellAt(row, 7).setChessPiece(new Rook   (player));
    }

    private void setLineOfPawns(Board board, int row, Player player) {
        for (int j = 0; j < board.getWidth(); j++)
            board.getCellAt(row, j).setChessPiece(new Pawn(player));
    }
}
