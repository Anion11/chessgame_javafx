package com.example.chessgame.Board;

import com.example.chessgame.Piece.Piece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public abstract class Board {
    Rectangle[][] squares;
    public final int SQUARE_SIZE;
    public Board(int SQUARE_SIZE) {
        this.SQUARE_SIZE = SQUARE_SIZE;
    }
    public abstract GridPane createBoard();
    public Rectangle[][] getSquares() {
        return squares;
    }
    public Rectangle getRect(int x, int y) {
        return squares[x][y];
    }
    public Piece getPiece(int endX, int endY) {
        return (Piece) squares[endX][endY].getUserData();
    }

    public abstract void addPiece(Piece piece, int row, int col);

    public abstract void removePiece(int row, int col, Pane piecePane);

}
