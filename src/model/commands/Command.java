package model.commands;

import model.Board;
import model.StatusMessage;

public abstract class Command {
    public abstract void execute(Board board, StatusMessage statusMessage);
}
