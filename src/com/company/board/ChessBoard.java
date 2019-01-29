package com.company.board;

import com.company.enums.Color;
import com.company.enums.Pieces;
import com.company.pieces.*;

public class ChessBoard extends Board{

    @Override
    public void setPieces(){
        for (int j=0;j<getSquares().length;j++){
            setSquare(new Square(getPiece(Pieces.WHITECHESSPAWN)),1,j);
            setSquare(new Square(getPiece(Pieces.BLACKCHESSPAWN)),6,j);
            for(int i=2;i<6;i++){
                setSquare(new Square(getPiece(Pieces.EMPTYPIECE)),i,j);

            }
        }
        setSquare(new Square(getPiece(Pieces.WHITEROOK)),0,0);
        setSquare(new Square(getPiece(Pieces.WHITEROOK)),0,7);
        setSquare(new Square(getPiece(Pieces.WHITEHORSE)),0,1);
        setSquare(new Square(getPiece(Pieces.WHITEHORSE)),0,6);
        setSquare(new Square(getPiece(Pieces.WHITEBISHOP)),0,2);
        setSquare(new Square(getPiece(Pieces.WHITEBISHOP)),0,5);
        setSquare(new Square(getPiece(Pieces.WHITEQUEEN)),0,3);
        setSquare(new Square(getPiece(Pieces.WHITEKING)),0,4);

        setSquare(new Square(getPiece(Pieces.BLACKROOK)),7,0);
        setSquare(new Square(getPiece(Pieces.BLACKROOK)),7,7);
        setSquare(new Square(getPiece(Pieces.BLACKHORSE)),7,1);
        setSquare(new Square(getPiece(Pieces.BLACKHORSE)),7,6);
        setSquare(new Square(getPiece(Pieces.BLACKBISHOP)),7,2);
        setSquare(new Square(getPiece(Pieces.BLACKBISHOP)),7,5);
        setSquare(new Square(getPiece(Pieces.BLACKQUEEN)),7,3);
        setSquare(new Square(getPiece(Pieces.BLACKKING)),7,4);
    }

    @Override
    public void initPieces() {
        getPieces().put(Pieces.WHITECHESSPAWN, new Pawn("P", Color.WHITE, new ChessPawnMove()));
        getPieces().put(Pieces.BLACKCHESSPAWN, new Pawn("p", Color.BLACK, new ChessPawnMove()));
        getPieces().put(Pieces.WHITEBISHOP, new Bishop("B", Color.WHITE));
        getPieces().put(Pieces.BLACKBISHOP, new Bishop("b", Color.BLACK));
        getPieces().put(Pieces.WHITEHORSE, new Horse("H", Color.WHITE));
        getPieces().put(Pieces.BLACKHORSE, new Horse("h", Color.BLACK));
        getPieces().put(Pieces.WHITEQUEEN, new Queen("Q", Color.WHITE));
        getPieces().put(Pieces.BLACKQUEEN, new Queen("q", Color.BLACK));
        getPieces().put(Pieces.WHITEKING, new King("K", Color.WHITE));
        getPieces().put(Pieces.BLACKKING, new King("k", Color.BLACK));
        getPieces().put(Pieces.WHITEROOK, new Rook("R", Color.WHITE));
        getPieces().put(Pieces.BLACKROOK, new Rook("r", Color.BLACK));
        getPieces().put(Pieces.EMPTYPIECE, new EmptySpace("#", Color.EMPTY));
    }


}
