package com.company.board;

public class BoardFactory {

    public Board getBoard(String gameType){
        switch (gameType) {
            case "CHESS":
                return new ChessBoard();
            case "CHECKERS":
                return new CheckersBoard();
            default:
                return null;
        }
    }
}
