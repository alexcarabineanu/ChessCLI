package com.company.board;

import com.company.enums.Color;
import com.company.enums.Pieces;
import com.company.pieces.*;

public class CheckersBoard extends Board{
    @Override
    public void setPieces(){
        for(int j=1; j<=7; j+=2) {
            setSquare(new Square(getPiece(Pieces.WHITECHECKERSPAWN)),0,j);
            setSquare(new Square(getPiece(Pieces.WHITECHECKERSPAWN)),2,j);
            setSquare(new Square(getPiece(Pieces.BLACKCHECKERSPAWN)),6,j);
            setSquare(new Square(getPiece(Pieces.EMPTYPIECE)),1,j);
            setSquare(new Square(getPiece(Pieces.EMPTYPIECE)),5,j);
            setSquare(new Square(getPiece(Pieces.EMPTYPIECE)),7,j);
        }
        for(int j=0; j<=6; j+=2) {
            setSquare(new Square(getPiece(Pieces.WHITECHECKERSPAWN)),1,j);
            setSquare(new Square(getPiece(Pieces.BLACKCHECKERSPAWN)),5,j);
            setSquare(new Square(getPiece(Pieces.BLACKCHECKERSPAWN)),7,j);
            setSquare(new Square(getPiece(Pieces.EMPTYPIECE)),0,j);
            setSquare(new Square(getPiece(Pieces.EMPTYPIECE)),2,j);
            setSquare(new Square(getPiece(Pieces.EMPTYPIECE)),6,j);
        }
        for (int j=0;j<getSquares().length;j++){
            for (int i=3;i<5;i++){
                setSquare(new Square(getPiece(Pieces.EMPTYPIECE)),i,j);
            }
        }
    }

    @Override
    public void initPieces(){
        getPieces().put(Pieces.EMPTYPIECE, new EmptySpace("#", Color.EMPTY));
        getPieces().put(Pieces.WHITECHECKERSPAWN, new Pawn("P", Color.WHITE, new CheckersPawnMove()));
        getPieces().put(Pieces.BLACKCHECKERSPAWN, new Pawn("P", Color.BLACK, new CheckersPawnMove()));

    }
}
