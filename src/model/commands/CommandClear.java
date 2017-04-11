package model.commands;

import model.Board;
import model.StatusMessage;

public class CommandClear extends Command {

    @Override
    public void execute(Board board, StatusMessage statusMessage) {
        board.clear();
    }
}
