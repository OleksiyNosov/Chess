package Model;

import Model.ChessPieces.ChessPiece;

/**
 * Created by oleksiy on 4/8/17.
 */
public class Cell {

    private ChessPiece chessPiece;

    public void clear() {
        chessPiece = null;
    }

    public void place(ChessPiece chessPiece) {
        this.chessPiece = chessPiece;
    }

    public ChessPiece getChessPiece() {
        return chessPiece;
    }

    public void setChessPiece(ChessPiece chessPiece) {
        this.chessPiece = chessPiece;
    }
}
