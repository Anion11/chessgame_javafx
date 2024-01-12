package com.example.chessgame.Player;

import com.example.chessgame.Board.Board;
import com.example.chessgame.Move.Move;
import com.example.chessgame.Piece.PieceColor;

import java.util.Objects;

public class Player implements PlayerInterface {
    private final String name;
    private final PieceColor pieceColor;

    public String getName() {
        return name;
    }
    public PieceColor getColor() {
        return pieceColor;
    }

    public Player(String name, PieceColor pieceColor) {
        this.name = name;
        this.pieceColor = pieceColor;
    }

    public Move getMove(Board board) {
        return new Move(1, 1 ,1 ,1);
    }
    public void isValidMove(Board board, Move move) {

        int startX = move.getStartX();
        int startY = move.getStartY();
        int endX = move.getEndX();
        int endY = move.getEndY();

    }
}