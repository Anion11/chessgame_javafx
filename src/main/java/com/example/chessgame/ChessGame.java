package com.example.chessgame;

import com.example.chessgame.Board.ClassicBoard;
import com.example.chessgame.ChessLogic.ChessLogic;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
        Label labelPlayer1 = new Label("Введите имя белых фигур:");
        TextField namePlayer1 = new TextField();
        Label labelPlayer2 = new Label("Введите имя черных фигур:");
        TextField namePlayer2 = new TextField();
        Button submitButton = new Button("Начать игру");
        submitButton.setOnAction(e -> {
            if (namePlayer1.getText().trim().isEmpty() || namePlayer2.getText().trim().isEmpty() ) {
                return;
            }
            primaryStage.close();
            ChessLogic chessLogic = new ChessLogic(board, namePlayer1.getText(),  namePlayer2.getText(), primaryStage);
            GridPane gridPane = board.createBoard();
            Scene scene = new Scene(gridPane, 8 * size, 8 * size);
            primaryStage.setScene(scene);
            primaryStage.show();
        });
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(labelPlayer1, namePlayer1);
        layout.getChildren().addAll(labelPlayer2, namePlayer2, submitButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
