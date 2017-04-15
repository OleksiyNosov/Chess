package views;

import model.Board;

import java.awt.*;

public class BoardView extends Container {
    private Board board;

    private Dimension defaultCellSize;

    private CellView[][] cellViews;

    private DataWorker dataWorker;

    public BoardView(Board board, DataWorker dataWorker) {
        this.board = board;
        this.dataWorker = dataWorker;
      
        defaultCellSize = new Dimension(75,75);
        setPreferredSize(new Dimension(
                defaultCellSize.width * board.getWidth(),
                defaultCellSize.height * board.getHeight()));

        addBoardCells();
    }

    private void addBoardCells() {
        setLayout(new GridLayout(board.getHeight(), board.getWidth()));
        GridBagConstraints gbc = new GridBagConstraints();
        cellViews = new CellView[board.getHeight()][board.getWidth()];

        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                cellViews[i][j] = new CellView(board.getCellAt(i, j), dataWorker);

                cellViews[i][j].setPreferredSize(defaultCellSize);
                cellViews[i][j].setBackground(((j + (i % 2)) % 2 == 0) ? Color.white: Color.lightGray);

                add(cellViews[i][j], gbc);
            }
        }
    }

    public void update() {
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                cellViews[i][j].update();
            }
        }
    }
}
