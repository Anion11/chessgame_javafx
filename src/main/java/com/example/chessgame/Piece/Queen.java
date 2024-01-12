package com.example.chessgame.Piece;
import com.example.chessgame.Board.Board;
import com.example.chessgame.Move.Move;

public class Queen extends Piece {
    public Queen(PieceColor color, String ch) {
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

        // Проверяем, что между начальной и конечной позицией нет других фигур по горизонтали, вертикали
        if (startX == endX || startY == endY) {
            int dx = Integer.compare(endX, startX);
            int dy = Integer.compare(endY, startY);
            int x = startX + dx;
            int y = startY + dy;

            while (x != endX || y != endY) {
                if (board.getPiece(x, y) != null) {
                    return false;
                }
                x += dx;
                y += dy;
            }
        }
        else {
            // Проверяем, что начальная позиция и конечная позиция находятся на диагонали
            int deltaX = Math.abs(endX - startX);
            int deltaY = Math.abs(endY - startY);
            if (deltaX != deltaY) {
                return false;
            }

            // Проверяем, что между начальной и конечной позицией нет других фигур
            int xDirection = (endX > startX) ? 1 : -1;
            int yDirection = (endY > startY) ? 1 : -1;
            int currentX = startX + xDirection;
            int currentY = startY + yDirection;
            while (currentX != endX && currentY != endY) {
                if (board.getPiece(currentX, currentY) != null) {
                    return false;
                }
                currentX += xDirection;
                currentY += yDirection;
            }
        }
        // Проверяем, что в конечной точке либо пусто либо фигура противоположного цвета
        if (board.getPiece(endX, endY) != null && board.getPiece(endX, endY).getColor() == getColor()) return false;
        return true;
    }
}