import Model.ChessGame;
import Model.ChessGameEvent;
import Model.ChessGameListener;
import Model.ChessPieces.Black.BlackKnight;
import Views.MainFrame;

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

        System.out.println(BlackKnight.class);
    }

}
