package com.example.chessgame.Piece;
import com.example.chessgame.Board.Board;
import com.example.chessgame.Move.Move;

public class Rook extends Piece {
    public Rook(PieceColor color, String ch) {
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
        // Проверяем, что начальная позиция и конечная позиция находятся на одной вертикали или горизонтали
        if (startX != endX && startY != endY) {
            return false;
        }
        // Проверяем, что между начальной и конечной позицией нет других фигур
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
        // Проверяем, если фигура в конечной точке наша, то ход недоступен
        if (board.getPiece(endX, endY) != null && board.getPiece(endX, endY).getColor() == this.getColor()) return false;
        return true;
    }
}