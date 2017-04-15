package model.commands;

import controller.ChessGame;
import model.Board;
import model.StatusMessage;

public interface Command {
    void execute(ChessGame chessGame);
}
