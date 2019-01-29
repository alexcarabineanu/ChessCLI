package com.company.games;

import com.company.board.Board;

public class CheckersGame extends Game{

    public void start(){
        Board gameBoard = getBoardFactory().getBoard("CHECKERS");
        gameBoard.setPieces();
        gameBoard.drawBoard();
        System.out.println("White moves");
    }
}
