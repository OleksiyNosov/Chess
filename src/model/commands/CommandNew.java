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

        board.getCellAt(0, 0).setChessPiece(new Rook   (player2, ChessPieceColor.BLACK));
        board.getCellAt(0, 1).setChessPiece(new Knight (player2, ChessPieceColor.BLACK));
        board.getCellAt(0, 2).setChessPiece(new Bishop (player2, ChessPieceColor.BLACK));
        board.getCellAt(0, 3).setChessPiece(new Queen  (player2, ChessPieceColor.BLACK));
        board.getCellAt(0, 4).setChessPiece(new King   (player2, ChessPieceColor.BLACK));
        board.getCellAt(0, 5).setChessPiece(new Bishop (player2, ChessPieceColor.BLACK));
        board.getCellAt(0, 6).setChessPiece(new Knight (player2, ChessPieceColor.BLACK));
        board.getCellAt(0, 7).setChessPiece(new Rook   (player2, ChessPieceColor.BLACK));

        for (int j = 0; j < board.getWidth(); j++)
            board.getCellAt(1, j).setChessPiece(new Pawn(player2, ChessPieceColor.BLACK));


        board.getCellAt(7, 0).setChessPiece(new Rook   (player1, ChessPieceColor.WHITE));
        board.getCellAt(7, 1).setChessPiece(new Knight (player1, ChessPieceColor.WHITE));
        board.getCellAt(7, 2).setChessPiece(new Bishop (player1, ChessPieceColor.WHITE));
        board.getCellAt(7, 3).setChessPiece(new Queen  (player1, ChessPieceColor.WHITE));
        board.getCellAt(7, 4).setChessPiece(new King   (player1, ChessPieceColor.WHITE));
        board.getCellAt(7, 5).setChessPiece(new Bishop (player1, ChessPieceColor.WHITE));
        board.getCellAt(7, 6).setChessPiece(new Knight (player1, ChessPieceColor.WHITE));
        board.getCellAt(7, 7).setChessPiece(new Rook   (player1, ChessPieceColor.WHITE));

        for (int j = 0; j < board.getWidth(); j++)
            board.getCellAt(6, j).setChessPiece(new Pawn(player1, ChessPieceColor.WHITE));
    }
}
