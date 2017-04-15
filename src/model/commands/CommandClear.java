package model.commands;

import controller.ChessGame;
import model.Board;
import model.StatusMessage;

public class CommandClear implements Command {

    @Override
    public void execute(ChessGame chessGame) {
        chessGame.getBoard().clear();
    }
}
