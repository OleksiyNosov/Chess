package views;

import model.Cell;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class CellView extends JPanel {

    private Cell cell;

    public CellView(Cell cell) {
        this.cell = cell;
    }

    public void update() {
        //repaint();

        BufferedImage image = DataWorker.getImage(cell.getChessPiece());

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
