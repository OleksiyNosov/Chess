package Model.Commands;

import Model.Board;
import Model.ChessPieces.Black.*;
import Model.ChessPieces.White.*;
import Model.StatusMessage;

/**
 * Created by oleksiy on 4/8/17.
 */
public class CommandNew extends Command {
    @Override
    public void execute(Board board, StatusMessage statusMessage) {
        board.clear();
        placePiecesForNewGame(board);
    }

    private void placePiecesForNewGame(Board board) {
        board.getCellAt(0, 0).place(new BlackRook());
        board.getCellAt(0, 1).place(new BlackKnight());
        board.getCellAt(0, 2).place(new BlackBishop());
        board.getCellAt(0, 3).place(new BlackQueen());
        board.getCellAt(0, 4).place(new BlackKing());
        board.getCellAt(0, 5).place(new BlackBishop());
        board.getCellAt(0, 6).place(new BlackKnight());
        board.getCellAt(0, 7).place(new BlackRook());

        for (int j = 0; j < board.getWidth(); j++)
            board.getCellAt(1, j).place(new BlackPawn());

        board.getCellAt(7, 0).place(new WhiteRook());
        board.getCellAt(7, 1).place(new WhiteKnight());
        board.getCellAt(7, 2).place(new WhiteBishop());
        board.getCellAt(7, 3).place(new WhiteQueen());
        board.getCellAt(7, 4).place(new WhiteKing());
        board.getCellAt(7, 5).place(new WhiteBishop());
        board.getCellAt(7, 6).place(new WhiteKnight());
        board.getCellAt(7, 7).place(new WhiteRook());

        for (int j = 0; j < board.getWidth(); j++)
            board.getCellAt(6, j).place(new WhitePawn());
    }
}
