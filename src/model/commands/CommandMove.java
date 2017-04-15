package model.commands;


import controller.ChessGame;
import model.Board;
import model.BoardPosition;
import model.StatusMessage;

public class CommandMove implements Command {

    private BoardPosition place;
    private BoardPosition destination;

    public CommandMove(String place, String destination) {
        this.place = BoardPosition.parse(place);
        this.destination = BoardPosition.parse(destination);
    }

    @Override
    public void execute(ChessGame chessGame) {
        Board board = chessGame.getBoard();
  
        board.getCellAt(destination).setChessPiece(board.getCellAt(place).getChessPiece());
        board.getCellAt(place).clear();
    }
}
