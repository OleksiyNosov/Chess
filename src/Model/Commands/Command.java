package Model.Commands;

import Model.Board;
import Model.StatusMessage;

/**
 * Created by oleksiy on 4/8/17.
 */
public abstract class Command {
    public abstract void execute(Board board, StatusMessage statusMessage);
}
