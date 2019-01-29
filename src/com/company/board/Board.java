package com.company.board;

import com.company.enums.Color;
import com.company.enums.Pieces;
import com.company.pieces.*;

import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class Board {
    private Square[][] squares = new Square[8][8];

    public HashMap<Pieces, Piece> getPieces() {
        return pieces;
    }

    private HashMap<Pieces, Piece> pieces = new LinkedHashMap<Pieces, Piece>();

    public Board() {
        initPieces();
    }

    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    public Square getSquare(int x, int y) {
        return squares[x][y];
    }

    public void drawBoard() {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                System.out.print(getSquare(i, j).getPiece().getName());
            }
            System.out.println();
        }
    }

    public void setSquare(Square square, int x, int y) {
        this.squares[x][y] = square;
    }

    public abstract void setPieces();

    public abstract void initPieces();

    public Piece getPiece(Pieces piece) {
        return pieces.get(piece);
    }
}

