package Model.Commands;

import Model.Board;
import Model.StatusMessage;

/**
 * Created by oleksiy on 4/10/17.
 */
public class CommandClear extends Command {

    @Override
    public void execute(Board board, StatusMessage statusMessage) {
        board.clear();
    }
}
