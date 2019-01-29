package com.company;

import com.company.board.BoardFactory;
import com.company.games.CheckersGame;
import com.company.games.ChessGame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BoardFactory boardFactory = new BoardFactory();
        CheckersGame checkersGame = new CheckersGame();
        ChessGame chessGame = new ChessGame();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        boolean goodCommand = false;
        while (!goodCommand) {
            showMenu();
            int response = getCommand(bufferedReader);
            if (response == 1){
                chessGame.start();
                goodCommand = true;
            }else if (response == 2){
                checkersGame.start();
                goodCommand = true;
            }else if (response == 3){
                System.out.println("Game Closed");
                goodCommand = true;
                System.exit(0);
            }else{
                System.out.println("Command invalid");
            }
        }
    }

    private static void showMenu(){
        System.out.println("Welcome to the game.Please select the game that you want to play \n" +
                "1.Chess\n" +
                "2.Checkers\n" +
                "3.Exit");
    }
    private static int getCommand(BufferedReader bufferedReader) throws IOException
    {
        try {
            return Integer.parseInt(bufferedReader.readLine());
        }catch(NumberFormatException e){
            System.out.println("Invalid chice");
            return 0;
        }
    }
}
