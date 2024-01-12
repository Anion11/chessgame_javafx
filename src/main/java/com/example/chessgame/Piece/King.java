package com.example.chessgame.Piece;
import com.example.chessgame.Board.Board;
import com.example.chessgame.Move.Move;

public class King extends Piece {
    public King(PieceColor color, String ch) {
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
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);
        if (deltaX > 1 && deltaY > 1) {
            return false;
        }
        // Проверяем, если фигура в конечной точке наша, то ход недоступен
        if (board.getPiece(endX, endY) != null && board.getPiece(endX, endY).getColor() == this.getColor()) {
            return false;
        }
        return true;
    }
}
