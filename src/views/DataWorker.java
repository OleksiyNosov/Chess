package views;

import controller.ChessGame;
import model.Player;
import model.chess_pieces.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class DataWorker {

    private Hashtable<Integer, BufferedImage> images;

    public DataWorker(ChessGame chessGame) {
        initHashWithImages(chessGame);
    }

    private void initHashWithImages(ChessGame chessGame) {
        String pathToImages = "src/views/images/chess_piece_2_";

        images = new Hashtable<>();
        Player player1 = chessGame.getPlayer(0);
        Player player2 = chessGame.getPlayer(1);

        images.put(new Rook   (player1).hashCode(), getImage(pathToImages + "white_rook.png"));
        images.put(new Knight (player1).hashCode(), getImage(pathToImages + "white_knight.png"));
        images.put(new Bishop (player1).hashCode(), getImage(pathToImages + "white_bishop.png"));
        images.put(new Queen  (player1).hashCode(), getImage(pathToImages + "white_queen.png"));
        images.put(new King   (player1).hashCode(), getImage(pathToImages + "white_king.png"));
        images.put(new Pawn   (player1).hashCode(), getImage(pathToImages + "white_pawn.png"));

        images.put(new Rook   (player2).hashCode(), getImage(pathToImages + "black_rook.png"));
        images.put(new Knight (player2).hashCode(), getImage(pathToImages + "black_knight.png"));
        images.put(new Bishop (player2).hashCode(), getImage(pathToImages + "black_bishop.png"));
        images.put(new Queen  (player2).hashCode(), getImage(pathToImages + "black_queen.png"));
        images.put(new King   (player2).hashCode(), getImage(pathToImages + "black_king.png"));
        images.put(new Pawn   (player2).hashCode(), getImage(pathToImages + "black_pawn.png"));
    }

    public BufferedImage getImage(ChessPiece chessPiece) {
        if (chessPiece == null)
            return null;

        return images.get(chessPiece.hashCode());
    }

    private BufferedImage getImage(String path) {

        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
