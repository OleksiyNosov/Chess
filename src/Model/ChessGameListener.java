package Model;

import java.util.EventListener;

/**
 * Created by oleksiy on 4/8/17.
 */
public interface ChessGameListener extends EventListener {
    public void chessGameEventOccurred(ChessGameEvent event);
}
