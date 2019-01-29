package com.company.games;

import com.company.board.Board;

import java.io.BufferedReader;
import java.io.IOException;

public class ChessGame extends Game{
    private int currentPosX = 0;
    private int currentPosY = 0;
    private int newPosX = 0;
    private int newPosY = 0;

    public void start(){
        Board gameBoard = getBoardFactory().getBoard("CHESS");
        setMoveMap();
        gameBoard.setPieces();
        gameBoard.drawBoard();
        while(!isEndGame()){
            System.out.println(getPlayer().getColor() + " moves");
            readCommand(getBufferedReader());
            if (movePiece(gameBoard,currentPosX,currentPosY,newPosX,newPosY)){
                gameBoard.drawBoard();
                switchPlayer();
            }else{
                System.out.println("Invalid move");
            }
        }
    }

    @Override
    void readCommand(BufferedReader bufferedReader){
        try{
            char[] command = bufferedReader.readLine().toCharArray();
            if (command.length == 4) {
                currentPosX = Character.getNumericValue(command[0]) - 1;
                currentPosY = Integer.valueOf(getMoveMap().get((String.valueOf(command[1])).toUpperCase()));
                newPosX = Character.getNumericValue(command[2]) - 1;
                newPosY = Integer.valueOf(getMoveMap().get((String.valueOf(command[3])).toUpperCase()));
            }
            else{
                System.out.println("Invalid Command Length");
                readCommand(bufferedReader);
            }
        }catch (IOException |NumberFormatException e){
            System.out.println("Invalid Command");
            readCommand(bufferedReader);
        }
    }

    public int getCurrentPosX() {
        return currentPosX;
    }

    public void setCurrentPosX(int currentPosX) {
        this.currentPosX = currentPosX;
    }

    public int getCurrentPosY() {
        return currentPosY;
    }

    public void setCurrentPosY(int currentPosY) {
        this.currentPosY = currentPosY;
    }

    public int getNewPosX() {
        return newPosX;
    }

    public void setNewPosX(int newPosX) {
        this.newPosX = newPosX;
    }

    public int getNewPosY() {
        return newPosY;
    }

    public void setNewPosY(int newPosY) {
        this.newPosY = newPosY;
    }
}
