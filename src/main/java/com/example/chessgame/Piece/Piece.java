package com.example.chessgame.Piece;
import com.example.chessgame.Board.Board;
import com.example.chessgame.Move.Move;

public abstract class Piece {
    private final PieceColor color;
    private final String image;
    public Piece(PieceColor color, String image) {
        this.color = color;
        this.image = image;
    }
    public PieceColor getColor() {
        return color;
    }
    public String getImage() {
        return image;
    }

    public abstract void getValidMove(Board board, int startX, int startY);

    public abstract boolean isValidMove(Board chessBoard, Move move);
}