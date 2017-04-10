package Model.Commands;

import Model.Board;
import Model.StatusMessage;

public abstract class Command {
    public abstract void execute(Board board, StatusMessage statusMessage);
}
