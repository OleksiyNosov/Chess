package model;

public class Board {
    private final int height = 8;
    private final int width = 8;

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
        return height;
    }

    public int getWidth() {
        return width;
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

    public Cell getCellAt(BoardPosition place) {
        return getCellAt(place.y, place.x);
    }
}
