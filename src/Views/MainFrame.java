package Views;

import Model.Board;
import Model.ChessGame;
import Model.ChessGameEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {

    private ChessGame chessGame;

    private BoardView boardView;

    public MainFrame(ChessGame chessGame) {
        super("ChessForLearning");

        this.chessGame = chessGame;

        setPreferredSize(new Dimension(900, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        addViews();

        pack();
        setVisible(true);
    }

    private void addViews() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;


        addBoardView(gbc);
        addMessageView(gbc);
        addCommandLineView(gbc);
    }


    private void addBoardView(GridBagConstraints gbc) {
        gbc.weightx = 1.0;
        gbc.gridheight = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;

        boardView = new BoardView(chessGame.getBoard());

        getContentPane().add(boardView, gbc);
    }

    private void addMessageView(GridBagConstraints gbc) {
        gbc.weightx = (getPreferredSize().width - (double)getPreferredSize().height) / getPreferredSize().height;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.gridx = 1;
        gbc.gridy = 0;

        MessageView messageView = new MessageView(chessGame.getStatusMessage());

        getContentPane().add(messageView, gbc);
    }

    private void addCommandLineView(GridBagConstraints gbc) {
        gbc.weightx = (getPreferredSize().width - getPreferredSize().height) / getPreferredSize().height;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        gbc.weighty = 0.05;
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;

        final CommandLineView commandLineView = new CommandLineView();

        int condition = JComponent.WHEN_FOCUSED;
        InputMap iMap = commandLineView.getInputMap(condition);
        ActionMap aMap = commandLineView.getActionMap();

        String enter = "enter";
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), enter);
        aMap.put(enter, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                chessGame.fireChessGameEvent(new ChessGameEvent(commandLineView, commandLineView.getText()));
                commandLineView.setText("");
            }
        });

        getContentPane().add(commandLineView, gbc);
    }

    public void update(Board board) {
        boardView.update();
    }
}
