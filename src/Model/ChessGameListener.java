package Model;

import java.util.EventListener;

public interface ChessGameListener extends EventListener {
    void chessGameEventOccurred(ChessGameEvent event);
}
