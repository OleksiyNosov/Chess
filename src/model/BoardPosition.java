package model;

import java.awt.*;

public class BoardPosition extends Point {
    public BoardPosition(int x, int y) {
        super(x, y);
    }

    public static BoardPosition parse(String position) {
        return new BoardPosition(
                getLetterEquivalent(position.substring(0, 1)),
                Integer.parseInt(position.substring(1, 2)) * -1 + 8);
    }

    private static int getLetterEquivalent(String letter) {
        return letter.toCharArray()[0] - 'a';
    }
}
