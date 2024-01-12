package com.example.chessgame.ChessLogic;

import com.example.chessgame.Board.Board;
import com.example.chessgame.Move.Move;
import com.example.chessgame.Piece.Pawn;
import com.example.chessgame.Piece.Piece;
import com.example.chessgame.Piece.PieceColor;
import com.example.chessgame.Player.Player;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessLogic {
    private static final Player[] players = new Player[2];
    private static Player currentPlayer;
    private static Board chessBoard = null;
    private static final int[] startCoord = new int[2];
    private static Pane piecePane;
    private static Pane piecePaneNew;
    private static boolean flag = false;
    private static boolean flag1 = false;
    public ChessLogic(Board board, String playerWhite, String playerBlack) {
        players[0] = new Player(playerWhite, PieceColor.WHITE);
        players[1] = new Player(playerBlack, PieceColor.BLACK);
        currentPlayer = players[0];
        chessBoard = board;
    }
    public static void handleSquareClick(Rectangle[][] board, Rectangle square) {
        flag = false;
        Move move = new Move(startCoord[0], startCoord[1], GridPane.getRowIndex(square), GridPane.getColumnIndex(square));
        Piece p = chessBoard.getPiece(startCoord[0], startCoord[1]);
        if (!p.isValidMove(chessBoard, move)) {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if ((col + row) % 2 != 0) board[row][col].setFill(Color.rgb(68, 45, 37));
                    else board[row][col].setFill(Color.rgb( 177,149,118));
                    board[row][col].setOpacity(1);
                }
            }
            return;
        }
        Object data = chessBoard.getRect(startCoord[0], startCoord[1]).getUserData();
        chessBoard.removePiece(startCoord[0], startCoord[1], piecePane);
        if (flag1) {
            chessBoard.removePiece(GridPane.getRowIndex(square), GridPane.getColumnIndex(square), piecePaneNew);
        }
        chessBoard.addPiece(p, GridPane.getRowIndex(square), GridPane.getColumnIndex(square));
        chessBoard.getSquares()[GridPane.getRowIndex(square)][GridPane.getColumnIndex(square)].setUserData(data);
        if (isGameEnd()) {
            System.out.println("Вы выиграли!");
            return;
        }
        switchPlayers();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((col + row) % 2 != 0) board[row][col].setFill(Color.rgb(68, 45, 37));
                else board[row][col].setFill(Color.rgb( 177,149,118));
                board[row][col].setOpacity(1);
            }
        }
    }
    public static void handlePieceClick(Pane piecePane, Piece piece) {
        if (flag) {
            flag1 = true;
            piecePaneNew = piecePane;
            handleSquareClick(chessBoard.getSquares(), chessBoard.getSquares()[GridPane.getRowIndex(piecePane)][GridPane.getColumnIndex(piecePane)]);
            flag1 = false;
            return;
        }
        flag = true;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((col + row) % 2 != 0) chessBoard.getSquares()[row][col].setFill(Color.rgb(68, 45, 37));
                else chessBoard.getSquares()[row][col].setFill(Color.rgb( 177,149,118));
            }
        }
        if (piece.getColor() != currentPlayer.getColor()) return;

        piece.getValidMove(chessBoard, GridPane.getRowIndex(piecePane), GridPane.getColumnIndex(piecePane));
        startCoord[0] = GridPane.getRowIndex(piecePane);
        startCoord[1] = GridPane.getColumnIndex(piecePane);
        ChessLogic.piecePane = piecePane;
    }
    private static boolean isGameEnd() {
        return false;
    }
    private static void switchPlayers() {
        if (currentPlayer == players[0]) currentPlayer = players[1];
        else currentPlayer = players[0];
    }
}
