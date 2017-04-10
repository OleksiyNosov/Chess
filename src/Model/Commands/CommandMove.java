package Model.Commands;

import Model.Board;
import Model.BoardPosition;
import Model.StatusMessage;

public class CommandMove extends Command {
    private BoardPosition place;
    private BoardPosition destination;

    public CommandMove(String place, String destination) {
        this.place = BoardPosition.parse(place);
        this.destination = BoardPosition.parse(destination);
    }

    @Override
    public void execute(Board board, StatusMessage statusMessage) {
        board.getCellAt(destination).setChessPiece(board.getCellAt(place).getChessPiece());
        board.getCellAt(place).clear();

    }
}
