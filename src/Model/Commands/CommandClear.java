package Model.Commands;

import Model.Board;
import Model.StatusMessage;

public class CommandClear extends Command {

    @Override
    public void execute(Board board, StatusMessage statusMessage) {
        board.clear();
    }
}
