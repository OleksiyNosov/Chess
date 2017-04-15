package views;

import controller.ChessGame;
import model.chess_pieces.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class DataWorker {

    private Hashtable<Integer, BufferedImage> imageSources;

    public DataWorker(ChessGame chessGame) {
        initHashWithImages(chessGame);
    }

    private void initHashWithImages(ChessGame chessGame) {
        String pathToImages = "src/views/images/";

        imageSources = new Hashtable<>();

        imageSources.put(new Rook   (chessGame.getPlayer(0), ChessPieceColor.WHITE).hashCode(), getImage(pathToImages + "chess_piece_2_white_rook.png"));
        imageSources.put(new Knight (chessGame.getPlayer(0), ChessPieceColor.WHITE).hashCode(), getImage(pathToImages + "chess_piece_2_white_knight.png"));
        imageSources.put(new Bishop (chessGame.getPlayer(0), ChessPieceColor.WHITE).hashCode(), getImage(pathToImages + "chess_piece_2_white_bishop.png"));
        imageSources.put(new Queen  (chessGame.getPlayer(0), ChessPieceColor.WHITE).hashCode(), getImage(pathToImages + "chess_piece_2_white_queen.png"));
        imageSources.put(new King   (chessGame.getPlayer(0), ChessPieceColor.WHITE).hashCode(), getImage(pathToImages + "chess_piece_2_white_king.png"));
        imageSources.put(new Pawn   (chessGame.getPlayer(0), ChessPieceColor.WHITE).hashCode(), getImage(pathToImages + "chess_piece_2_white_pawn.png"));

        imageSources.put(new Rook   (chessGame.getPlayer(1), ChessPieceColor.BLACK).hashCode(), getImage(pathToImages + "chess_piece_2_black_rook.png"));
        imageSources.put(new Knight (chessGame.getPlayer(1), ChessPieceColor.BLACK).hashCode(), getImage(pathToImages + "chess_piece_2_black_knight.png"));
        imageSources.put(new Bishop (chessGame.getPlayer(1), ChessPieceColor.BLACK).hashCode(), getImage(pathToImages + "chess_piece_2_black_bishop.png"));
        imageSources.put(new Queen  (chessGame.getPlayer(1), ChessPieceColor.BLACK).hashCode(), getImage(pathToImages + "chess_piece_2_black_queen.png"));
        imageSources.put(new King   (chessGame.getPlayer(1), ChessPieceColor.BLACK).hashCode(), getImage(pathToImages + "chess_piece_2_black_king.png"));
        imageSources.put(new Pawn   (chessGame.getPlayer(1), ChessPieceColor.BLACK).hashCode(), getImage(pathToImages + "chess_piece_2_black_pawn.png"));
    }

    public BufferedImage getImage(ChessPiece chessPiece) {
        if (chessPiece == null)
            return null;

        return imageSources.get(chessPiece.hashCode());
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
