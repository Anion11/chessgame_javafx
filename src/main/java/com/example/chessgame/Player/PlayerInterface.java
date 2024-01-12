package com.example.chessgame.Player;


import com.example.chessgame.Board.Board;
import com.example.chessgame.Move.Move;

public interface PlayerInterface {
    String getName();
    Move getMove(Board board);
}
