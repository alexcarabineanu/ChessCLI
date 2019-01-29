package com.company.pieces;


import com.company.board.Board;
import com.company.enums.Color;

public class EmptySpace extends Piece {

    public EmptySpace(String name, Color color) {
        super(name, color);
    }

    @Override
    public boolean move(Board board, int x, int y, int newX, int newY) {
        return false;
    }
}
