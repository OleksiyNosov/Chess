package model;

import java.util.EventObject;

public class ChessGameEvent extends EventObject {

    private String command;

    public ChessGameEvent(Object sourse, String command) {
        super(sourse);

        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
