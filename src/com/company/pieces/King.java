package com.company.pieces;

import com.company.board.Board;
import com.company.enums.Color;


public class King extends Piece {


    public King(String name, Color color) {
        super(name, color);
    }

    @Override
    public boolean move(Board board, int x, int y, int newX, int newY) {
        Piece availablePiece = board.getSquare(newX, newY).getPiece();
        int distX = newX - x;
        int distY = newY - y;

        if (checkOutOfBoard(newX, newY)) {
            return false;
        } else if ((Math.abs(distX) != 1 && Math.abs(distY) == 1) || (Math.abs(distX) == 1 && Math.abs(distY) != 1)) {
            return movePiece(this,availablePiece,board, newX, newY, x, y);
        } else
            return false;
    }
}


