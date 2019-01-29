package com.company.pieces;

import com.company.board.Board;


public class CheckersPawnMove implements MoveBehaviour {
    @Override
    public boolean pawnMove(Board board, int x, int y, int newX, int newY, Piece pawn) {
        return false;
    }
}
