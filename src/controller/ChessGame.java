package controller;

import model.Board;
import model.Player;
import model.StatusMessage;
import model.commands.Command;
import model.commands.CommandFactory;

import javax.swing.event.EventListenerList;

public class ChessGame {

    private EventListenerList listenerList = new EventListenerList();

    private Board board;
    private Command command;
    private StatusMessage statusMessage;

    private Player players[];

    public ChessGame() {
        board = new Board();
        statusMessage = new StatusMessage();

        players = new Player[]{ new Player(), new Player()};
    }

    public Board getBoard() {
        return board;
    }

    public StatusMessage getStatusMessage() {
        return statusMessage;
    }

    public void fireChessGameEvent(ChessGameEvent event) {
        Object[] listeners = listenerList.getListenerList();

        for (int i = 0; i < listeners.length; i+= 2) {
            if (listeners[i] == ChessGameListener.class) {
                ((ChessGameListener)listeners[i + 1]).chessGameEventOccurred(event);
            }
        }
    }

    public void addChessGameListener(ChessGameListener listener) {
        listenerList.add(ChessGameListener.class, listener);
    }

    public void removeChessGameListener(ChessGameListener listener) {
        listenerList.remove(ChessGameListener.class, listener);
    }

    public void processCommand(String rawCommand) {
        command = CommandFactory.create(rawCommand);
        command.execute(this);
    }

    public Player getPlayer(int index) {
        return players[index];
    }
}
