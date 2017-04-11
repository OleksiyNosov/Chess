package model;

import model.chess_pieces.ChessPiece;

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
