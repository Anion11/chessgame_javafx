package com.example.chessgame.Piece;
import com.example.chessgame.Board.Board;
import com.example.chessgame.Move.Move;

public class Knight extends Piece {
    public Knight(PieceColor color, String ch) {
        super(color, ch);
    }
    @Override
    public void getValidMove(Board board, int startX, int startY) {

    }
    @Override
    public boolean isValidMove(Board board, Move move) {
        int startX = move.getStartX();
        int endX = move.getEndX();
        int endY = move.getEndY();
        int startY = move.getStartY();
        // Проверяем, что начальная позиция не совпадает с конечной позицией
        if (startX == endX && startY == endY) {
            return false;
        }

        // Проверяем, что ход коня является допустимым
        int diffX = Math.abs(startX - endX);
        int diffY = Math.abs(startY - endY);
        if (!(diffX == 2 && diffY == 1)) {
            return false;
        }
        // Проверяем, что в конечной точке либо пусто либо фигура противоположного цвета
        if (board.getPiece(endX, endY) != null && board.getPiece(endX, endY).getColor() == getColor()) return false;
        return true;
    }
}