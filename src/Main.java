import model.ChessGame;
import model.ChessGameEvent;
import model.ChessGameListener;
import views.MainFrame;

public class Main {
    private static ChessGame chessGame;
    private static MainFrame mainFrame;

    public static void main(String[] args) {
        chessGame = new ChessGame();
        chessGame.addChessGameListener(new ChessGameListener() {
            public void chessGameEventOccurred(ChessGameEvent event) {
                chessGame.processCommand(event.getCommand());
                mainFrame.update(chessGame.getBoard());
            }
        });
        mainFrame = new MainFrame(chessGame);
    }

}
