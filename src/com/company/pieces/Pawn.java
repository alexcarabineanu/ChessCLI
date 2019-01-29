package com.company.pieces;

import com.company.board.Board;
import com.company.enums.Color;


public class Pawn extends Piece{
    private MoveBehaviour behaviour;
    public Pawn(String name, Color color, MoveBehaviour behaviour) {
        super(name, color);
        this.behaviour = behaviour;
    }

    public MoveBehaviour getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(MoveBehaviour behaviour) {
        this.behaviour = behaviour;
    }

    @Override
    public boolean move(Board board,int x, int y, int newX, int newY) {
        return behaviour.pawnMove(board,x, y, newX,newY,this);
    }
}
