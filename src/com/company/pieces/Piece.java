package com.company.pieces;

import com.company.board.Board;
import com.company.board.Square;
import com.company.enums.Color;
import com.company.enums.Pieces;

public abstract class Piece {
    private String name;
    private Color color;

    public Piece(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public abstract boolean move(Board board, int x, int y, int newX, int newY);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    boolean checkOutOfBoard(int newX, int newY) {
        return (newX > 7 || newX < 0 || newY > 7 || newY < 0);
    }

    void switchPieces(Square square1, Piece piece1, Square square2, Piece piece2) {
        square1.setPiece(piece1);
        square2.setPiece(piece2);
    }

    boolean checkDiagonalObstacles(Board board, int x, int y, int newX, int newY) {
        if (newX > x && newY > y) {
            for (int i = x; i <= newX; i++) {
                if (!board.getSquare(i, i).getPiece().getColor().equals(Color.EMPTY))
                    return false;
            }
        } else if (newX < x && newY > y) {
            for (int i = x; i >= newX; i--) {
                for (int j = y; j <= newY; j++) {
                    if (!board.getSquare(i, j).getPiece().getColor().equals(Color.EMPTY))
                        return false;
                }
            }
        } else if (newX > x && newY < y) {
            for (int i = x; i <= newX; i++) {
                for (int j = y; j >= newY; j--) {
                    if (!board.getSquare(i, j).getPiece().getColor().equals(Color.EMPTY))
                        return false;
                }
            }
        } else if (newX < x && newY < y) {
            for (int i = x; i >= newX; i--) {
                if (!board.getSquare(i, i).getPiece().getColor().equals(Color.EMPTY))
                    return false;
            }
        }
        return true;
    }

    boolean checkLinearObstacles(Board board, int x, int y, int newX, int newY) {
        if (newX > x && newY == y) {
            for (int i = x; i <= newX; i++) {
                if (!board.getSquare(i, y).getPiece().getColor().equals(Color.EMPTY))
                    return false;
            }
        } else if (newX < x && newY == y) {
            for (int i = x; i >= newX; i--) {
                if (!board.getSquare(i, y).getPiece().getColor().equals(Color.EMPTY))
                    return false;
            }
        } else if (newX == x && newY < y) {
            for (int j = y; j >= newY; j--) {
                if (!board.getSquare(x, j).getPiece().getColor().equals(Color.EMPTY))
                    return false;
            }
        } else if (newX == x && newY < y) {
            for (int j = y; j <= newY; j--) {
                if (!board.getSquare(x, j).getPiece().getColor().equals(Color.EMPTY))
                    return false;
            }
        }
        return true;
    }

    boolean checkDiagonalMove(int distX, int distY){
        return Math.abs(distX) != Math.abs(distY);
    }
    boolean checkLinearMove(int x, int y, int newX, int newY){
        return  newX != x && newY !=y;
    }

    public boolean movePiece(Piece thisPiece ,Piece availablePiece,Board board, int newX, int newY, int x, int y){
        if (availablePiece.getColor().equals(Color.EMPTY)) {
            switchPieces(board.getSquare(newX, newY), thisPiece, board.getSquare(x, y), availablePiece);
            return true;
        } else if (!availablePiece.getColor().equals(getColor())) {
            switchPieces(board.getSquare(newX, newY), thisPiece, board.getSquare(x, y), board.getPiece(Pieces.EMPTYPIECE));
            return true;
        } else
            return false;
    }
}
