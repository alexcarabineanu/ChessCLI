package com.company.pieces;

import com.company.board.Board;
import com.company.enums.Color;
import com.company.enums.Pieces;

public class Rook extends Piece {

    public Rook(String name, Color color) {
        super(name, color);
    }

    @Override
    public boolean move(Board board, int x, int y, int newX, int newY) {
        Piece availablePiece = board.getSquare(newX, newY).getPiece();
        int distX = newX - x;
        int distY = newY - y;

        if (checkOutOfBoard(newX, newY) || checkLinearObstacles(board, x, y, newX, newY))
            return false;
        else if (checkLinearMove(x, y, newX, newY)) {
            return false;
        } else
            return movePiece(this,availablePiece,board, newX, newY, x, y);
    }
}
