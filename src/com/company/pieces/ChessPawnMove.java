package com.company.pieces;

import com.company.board.Board;
import com.company.enums.Color;
import com.company.enums.Pieces;

public class ChessPawnMove implements MoveBehaviour {

    @Override
    public boolean pawnMove(Board board, int x, int y, int newX, int newY, Piece pawn) {
        Piece availablePiece = board.getSquare(newX, newY).getPiece();

        if (pawn.checkOutOfBoard(newX, newY))
            return false;
        else if ((availablePiece.getColor().equals(Color.EMPTY) && Math.abs(newY - y) == 0))
            return capturePiece(board, x, y, newX, newY, pawn);
        else if ((Math.abs(newY - y) == 1 && !availablePiece.getColor().equals(pawn.getColor())) && !availablePiece.getColor().equals(Color.EMPTY))
            return capturePiece(board, x, y, newX, newY, pawn);
        else
            return false;
    }

    private boolean capturePiece(Board board, int x, int y, int newX, int newY, Piece pawn) {
        if (((newX - x) == 1 && pawn.getColor().equals(Color.WHITE))
                || ((newX - x) == -1 && pawn.getColor().equals(Color.BLACK))) {
            board.getSquare(newX, newY).setPiece(pawn);
            board.getSquare(x, y).setPiece(board.getPiece(Pieces.EMPTYPIECE));
            return true;
        } else
            return false;
    }
}
