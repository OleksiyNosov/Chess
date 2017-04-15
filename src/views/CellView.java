package views;

import model.Cell;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class CellView extends JPanel {

    private Cell cell;

    private DataWorker dataWorker;

    public CellView(Cell cell, DataWorker dataWorker) {
        this.cell = cell;
        this.dataWorker = dataWorker;
    }

    public void update() {
        //repaint();

        BufferedImage image = dataWorker.getImage(cell.getChessPiece());

        if (image == null)
            repaint();
        else
            getGraphics().drawImage(image,
                (getPreferredSize().width - image.getWidth()) / 2,
                (getPreferredSize().height - image.getHeight()) / 2,
                null);

//        repaint();
//        validate();
//        removeAll();
    }
}
