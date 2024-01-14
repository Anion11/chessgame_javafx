package com.example.chessgame.Piece;
import com.example.chessgame.Board.Board;
import com.example.chessgame.Move.Move;
import javafx.scene.paint.Color;

public class Rook extends Piece {
    public Rook(PieceColor color, String ch) {
        super(color, ch);
    }
    @Override
    public void getValidMove(Board board, int startX, int startY) {
        int tempX = 1;
        int tempY = 0;
        int currentX;
        int currentY;
        for (int i = 0; i < 4; i++) {
            currentX = startX;
            currentY = startY;
            if (i == 1) {
                tempX = -1;
                tempY = 0;
            }
            if (i == 2) {
                tempX = 0;
                tempY = 1;
            }
            if (i == 3) {
                tempX = 0;
                tempY = -1;
            }
            while (currentX >= 0 && currentX < 8 && currentY >= 0 && currentY < 8) {
                if (!(currentX == startX && currentY == startY)) {
                    if (board.getPiece(currentX, currentY) != null) {
                        if (board.getPiece(currentX, currentY).getColor() == this.getColor()) {
                            break;
                        }
                        board.getSquares()[currentX][currentY].setFill(Color.RED);
                        break;
                    }
                    board.getSquares()[currentX][currentY].setFill(Color.rgb(255, 202, 134));
                }
                currentX += tempX;
                currentY += tempY;
            }
        }
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