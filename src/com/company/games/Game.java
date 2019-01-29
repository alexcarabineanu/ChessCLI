package com.company.games;

import com.company.board.Board;
import com.company.board.BoardFactory;
import com.company.enums.Color;
import com.company.pieces.Piece;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class Game {
    private HashMap<String,String> moveMap = new LinkedHashMap<>();
    private Color player = Color.WHITE;
    private boolean endGame = false;
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private BoardFactory boardFactory = new BoardFactory();

    void switchPlayer(){
        if (player.equals(Color.WHITE))
            player = Color.BLACK;
        else
            player = Color.WHITE;
    }

    void readCommand(BufferedReader bufferedReader){
    }

    boolean movePiece(Board board, int currentX, int currentY, int newX, int newY){
        Piece selectedPiece = board.getSquare(currentX,currentY).getPiece();
        if (selectedPiece.getColor().equals(player))
            return board.getSquare(currentX, currentY).getPiece().move(board, currentX, currentY, newX, newY);
        else
            return false;
    }

    void setMoveMap(){
        moveMap.put("A","0");
        moveMap.put("B","1");
        moveMap.put("C","2");
        moveMap.put("D","3");
        moveMap.put("E","4");
        moveMap.put("F","5");
        moveMap.put("G","6");
        moveMap.put("H","7");
    }

    public HashMap<String, String> getMoveMap() {
        return moveMap;
    }

    public void setMoveMap(HashMap<String, String> moveMap) {
        this.moveMap = moveMap;
    }

    public Color getPlayer() {
        return player;
    }

    public void setPlayer(Color player) {
        this.player = player;
    }

    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public BoardFactory getBoardFactory() {
        return boardFactory;
    }

    public void setBoardFactory(BoardFactory boardFactory) {
        this.boardFactory = boardFactory;
    }
}
