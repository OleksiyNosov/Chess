package Views;

import Model.ChessPieces.Black.*;
import Model.ChessPieces.ChessPiece;
import Model.ChessPieces.White.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by oleksiy on 4/9/17.
 */
public class DataWorker {

    private static Hashtable<String, String> imageSources;

    static {
        imageSources = new Hashtable<String, String>();

        String pathToImages = "src/Views/Images/";

        imageSources.put(BlackRook.class.toString(),    pathToImages + "chess_piece_2_black_rook.png");
        imageSources.put(BlackKnight.class.toString(),  pathToImages + "chess_piece_2_black_knight.png");
        imageSources.put(BlackBishop.class.toString(),  pathToImages + "chess_piece_2_black_bishop.png");
        imageSources.put(BlackQueen.class.toString(),   pathToImages + "chess_piece_2_black_queen.png");
        imageSources.put(BlackKing.class.toString(),    pathToImages + "chess_piece_2_black_king.png");
        imageSources.put(BlackPawn.class.toString(),    pathToImages + "chess_piece_2_black_pawn.png");

        imageSources.put(WhiteRook.class.toString(),    pathToImages + "chess_piece_2_white_rook.png");
        imageSources.put(WhiteKnight.class.toString(),  pathToImages + "chess_piece_2_white_knight.png");
        imageSources.put(WhiteBishop.class.toString(),  pathToImages + "chess_piece_2_white_bishop.png");
        imageSources.put(WhiteQueen.class.toString(),   pathToImages + "chess_piece_2_white_queen.png");
        imageSources.put(WhiteKing.class.toString(),    pathToImages + "chess_piece_2_white_king.png");
        imageSources.put(WhitePawn.class.toString(),    pathToImages + "chess_piece_2_white_pawn.png");

    }

    public static BufferedImage getImage(ChessPiece chessPiece) {
        if (chessPiece == null)
            return null;

        return getImage(imageSources.get(chessPiece.getClass().toString()));
    }

    private static BufferedImage getImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
