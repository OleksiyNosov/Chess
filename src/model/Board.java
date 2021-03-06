package model;

public class Board {
    private final int HEIGHT = 8;
    private final int WIDTH = 8;

    private Cell[][] cells;

    public Board() {
        initCells();
    }

    private void initCells() {
        cells = new Cell[getHeight()][getWidth()];

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public int getHeight() {
        return HEIGHT;
    }

    public int getWidth() {
        return WIDTH;
    }

    public void clear() {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                cells[i][j].clear();
            }
        }
    }

    public Cell getCellAt(int i, int j) {
        return cells[i % getHeight()][j % getWidth()];
    }

    public Cell getCellAt(BoardPosition boardPosition) {
        return getCellAt(boardPosition.getY(), boardPosition.getX());
    }

    public boolean isOnBoard(BoardPosition boardPosition) {
        return  (boardPosition.getY() >= 0 && boardPosition.getY() < getHeight()) &&
                (boardPosition.getX() >= 0 && boardPosition.getX() < getWidth());

    }
}
