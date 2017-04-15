package model.chess_pieces;

public interface ChessPieceColor {
    int WHITE = 2;
    int BLACK = 3;

    void setColor(int color);
    int getColor();
}
