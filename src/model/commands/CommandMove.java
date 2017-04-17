package model.commands;


import controller.ChessGame;
import model.Board;
import model.BoardPosition;
import model.Cell;

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

        Cell placeCell = board.getCellAt(place);
        Cell destinationCell = board.getCellAt(destination);

        if (placeCell.getChessPiece().checkIfPossibleForMove(board, place, destination)) {
            destinationCell.setChessPiece(placeCell.getChessPiece());
            placeCell.clear();
        }
    }
}
