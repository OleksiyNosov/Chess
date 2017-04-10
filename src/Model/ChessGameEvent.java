package Model;

import java.awt.*;
import java.util.EventObject;

/**
 * Created by oleksiy on 4/8/17.
 */
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
