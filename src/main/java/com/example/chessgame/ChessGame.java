package com.example.chessgame;

import com.example.chessgame.Board.ClassicBoard;
import com.example.chessgame.ChessLogic.ChessLogic;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChessGame extends Application {
    int size = 100;
    ClassicBoard board = new ClassicBoard(size);
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chess Game");
        ChessLogic chessLogic = new ChessLogic(board,"Player1", "Player2");
        GridPane gridPane = board.createBoard();
        Scene scene = new Scene(gridPane, 8 * size, 8 * size);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
