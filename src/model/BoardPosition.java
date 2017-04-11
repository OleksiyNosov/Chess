package model;

public class BoardPosition {

    private int x;
    private int y;

    public BoardPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static BoardPosition parse(String position) {
        return new BoardPosition(
                getLetterEquivalent(position.substring(0, 1)),
                Integer.parseInt(position.substring(1, 2)) * -1 + 8);
    }

    private static int getLetterEquivalent(String letter) {
        return letter.toCharArray()[0] - 'a';
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
