package com.company.pieces;

import com.company.board.Board;


public interface MoveBehaviour {

    boolean pawnMove(Board board, int x, int y, int newX, int newY, Piece pawn);
}
