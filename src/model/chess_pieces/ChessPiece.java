package model.chess_pieces;

import model.Player;

public abstract class ChessPiece implements ChessPieceColor {

    private Player player;
    private int color;

    public ChessPiece(Player player, int color) {
        this.player = player;
        this.color = color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public int hashCode() {
        int result = 15;
        result = 33 * result + getClass().hashCode();
        result = 33 * result + getColor();
        result = 33 * result + result + player.getId();
        return result;
    }
}
